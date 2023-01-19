package Blackjack;
import java.util.Scanner;
import java.util.*;

class BlackjackBlackJackGideon1 {
	public static void main(String[] args) {
	
	System.out.println("Welkom bij Black Jack '21'");
	
		String nogEenKaart, playAgain = "y";
		int playerKaart1, playerKaart2;
		int dealerKaart1, dealerKaart2;
		int playerTotaal = 0, dealerTotaal = 0;
	
		Scanner invoer = new Scanner(System.in);
		Random random = new Random();
		
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
		System.out.println("Jij hebt totaal: " + playerTotaal);
		
	}
	
}


