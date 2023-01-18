package Blackjack.Glenn;

public class Kaarten {
	
	//Onderstaande is een String array waar alle kaarten in komen.
	static String[] deck = new String[52];
	
	static void schudKaarten() { //neemt het deck kaarten en schud ze
		System.out.println("\nKaarten worden geschud.");
	}
	
	public static void main(String[] args) {
		System.out.println("Welkom bij Blackjack!");
		schudKaarten();

	}

}
