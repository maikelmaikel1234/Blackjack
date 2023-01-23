package Blackjack;
import java.util.ArrayList;
import java.util.Collections;

class Game {

	private ArrayList<Integer> deck;

   
	public void Intro() {
		System.out.println("Welcome to Blackjack '21'");
		System.out.println("");
		System.out.println("De regels:");
		System.out.println("De dealer krijgt 2 kaarten waarvan je 1 waardes ziet");
		System.out.println("De player krijgt 2 kaarten waarvan je waardes wel ziet");
		System.out.println("Er worden 5 rondes gespeeld de gene die de meeste uit 5 wint heeft gewonnen");
		System.out.println("");
	}
	
	
	public Game() {
        // deck creeren van kaarten
        deck = new ArrayList<Integer>(); 			// Hier wordt een array list gemaakt met intergers om een deck te creeren
        for (int i = 1; i <= 13; i++) {				// een loop wordt hier gemaakt om kaarten tot bepaalde getal te maken
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);					// HIer wordt deck geshuffled
    }

    public int dealKaart() {
        
        if (deck.size() > 0) {						// Hier wordt de deck de deelt
            return deck.remove(0);
        } else {
            return -1;
        }
    }

    public int getHandWaarde(ArrayList<Integer> hand) {
        // Totale waarde van handen
        int waarde = 0;
        int numAces = 0;
        for (int i : hand) {						// Hier wordt de waarde bepaald
            waarde += Math.min(i, 10);
            if (i == 1) {
                numAces++;
            }
        }
        while (waarde < 11 && numAces > 0) {		// hier worden de waardes bepaald
            waarde += 10;
            numAces--;
        }
        return waarde;
    }

    public boolean instandBlackjack(ArrayList<Integer> hand) {
        // Waarde wordt gechecked of iemand direct 21 heeft
        return (hand.size() == 2 && getHandWaarde(hand) == 21); 	
    }

    public String determineWinner(ArrayList<Integer> playerHand, ArrayList<Integer> dealerHand) {
        // Winner bepalen
        int playerWaarde = getHandWaarde(playerHand);
        int dealerWaarde = getHandWaarde(dealerHand);
        if (playerWaarde > 21) {						// winaar bepalen met if en else if statements
            return "Player busts";
        } else if (dealerWaarde > 21) {
            return "Player wins";
        } else if (playerWaarde > dealerWaarde) {
            return "Player wins";
        } else if (playerWaarde < dealerWaarde) {
            return "Dealer wins";
        } else {
            return "Tie";
        }
    }
    }