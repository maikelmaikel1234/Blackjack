package Blackjack;
import java.util.ArrayList;
import java.util.Collections;

class Game {

	private ArrayList<Integer> deck;

    public Game() {
        // deck creeren van kaarten
        deck = new ArrayList<Integer>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);
    }

    public int dealKaart() {
        
        if (deck.size() > 0) {
            return deck.remove(0);
        } else {
            return -1;
        }
    }

    public int getHandWaarde(ArrayList<Integer> hand) {
        // Totale waarde van handen
        int waarde = 0;
        int numAces = 0;
        for (int i : hand) {
            waarde += Math.min(i, 10);
            if (i == 1) {
                numAces++;
            }
        }
        while (waarde < 12 && numAces > 0) {
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
        if (playerWaarde > 21) {
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