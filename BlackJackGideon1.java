package Blackjack;
import java.util.Scanner;
import java.util.*;

class BlackjackBlackJackGideon1 {
	public static void main(String[] args) {
	
	System.out.println("Welkom bij Black Jack '21'");
	
		String nogEenKaart, playAgain = "yes", ctn = null;
		int playerKaart1, playerKaart2;
		int dealerKaart1, dealerKaart2;
		int volgendeKaart;
		int playerTotaal = 0, dealerTotaal = 0;
	
		Scanner invoer = new Scanner(System.in);
		Random random = new Random();
		
		
		while ("yes".equals(playAgain)) {
		
		// Dealer random kaarten
		dealerKaart1 = random.nextInt(10) + 1;
		dealerKaart2 = random.nextInt(10) + 1;
		
		// Player random kaarten en totaal kaarten
		playerKaart1 = random.nextInt(10) + 1;
		playerKaart2 = random.nextInt(10) + 1;
		playerTotaal = playerKaart1 + playerKaart2;
		
		// Dealer beide kaarten
		dealerTotaal = dealerKaart1 + dealerKaart2;
		System.out.println("De eerste kaart van de dealer is: " + dealerKaart1);
		//System.out.println("De tweede kaart van de dealer is: " + dealerKaart2);
		//System.out.println("Dealer totaal heeft: " + dealerTotaal);
		
		//
		System.out.println("");
		//
		
		// Player beide kaarten
		System.out.println("De eerste kaarten van jouw zijn: " + playerKaart1 + ", " + playerKaart2);
		System.out.println("Je kaarten totaal zijn: " + playerTotaal);
		
		System.out.println("Wil je nog een kaart? yes or no ");
		nogEenKaart = invoer.nextLine();
		
		while ("yes".equals(nogEenKaart)) {
			volgendeKaart = random.nextInt(10) + 1;
			playerTotaal += volgendeKaart;
			System.out.println("Kaart: " + volgendeKaart);
			System.out.println("Totaal: " + playerTotaal);
			
			if (playerTotaal > 21) {
				System.out.println("Je hebt teveel punten, Dealer wins");
				System.out.println("Wil je nog een keer spelen yes or no?");
				playAgain = invoer.nextLine();
			} 
			
			if (playerTotaal < 21)
				System.out.println("Wil je nog een kaart? yes of no: ");
				
			nogEenKaart = invoer.nextLine();
					
			if ("no".equals(nogEenKaart))
						System.out.println("Dealer had: " + dealerTotaal);
						
			System.out.println("Jij had: " + playerTotaal);
						
			while ("no".equals(nogEenKaart)) {
				if (dealerTotaal < playerTotaal && playerTotaal < 21) {
					System.out.println("Je hebt gewonnen!");
					System.out.println("Play again? yes or no");
					playAgain = invoer.nextLine();
				
					if (playAgain.equalsIgnoreCase("yes"))
					playAgain = "yes";
				
					if (dealerTotaal > playerTotaal && dealerTotaal < 21)
					System.out.println("Je hebt verloren!");
					
					playAgain = invoer.nextLine();
				
					
				}
			}
		}
		}
	}
}


