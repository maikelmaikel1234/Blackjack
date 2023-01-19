package Blackjack.Glenn;

import java.util.*;

class Deck {
	{System.out.println("Er wordt een nieuw deck gemaakt.");}	
	//Onderstaande is een String array waar alle kaarten van een deck in zitten.
	private String[] kaarten = new String[] {"HA","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK",
			 						 "SA","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK",
			 						 "DA","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK",
			 						 "CA","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK",};
	
	//Onderstaande maakt een aanpasbare ArrayList van het bovenstaande array kaarten.
	ArrayList<String> deck = new ArrayList<String>(Arrays.asList(kaarten));
	
	//default constructor, print voor nu het deck voor en na het geschud is.
	Deck() {
		this.printDeck();
		this.schudDeck();
		this.printDeck();
	}
	
	void schudDeck() { 
		//Gebruikt methode shuffle uit class Collections om de ArrayList deck te randomizen.
		Collections.shuffle(this.deck);
		System.out.println("\nKaarten zijn geschud.");
	}
	
	void printDeck() {
		//Print alle kaarten van het deck uit d.m.v. een loop, met een lege line na elke 13 kaarten.
		for (int a = 0; a < this.deck.size(); a++) {
			if(a % 13 == 0) {
				System.out.println();
				System.out.print(this.deck.get(a));
			} else {
				System.out.print(", ");
				System.out.print(this.deck.get(a));
			}
		}
		System.out.println();
	}
		
	String trekKaart() {
		//Haalt de eerst volgende kaart op uit ArrayList deck en slaat deze op in string getrokkenKaart.
		//Verwijderd vervolgens de getrokken kaart van de ArrayList en geeft de getrokkenKaart terug.
		String getrokkenKaart = this.deck.get(0);
		this.deck.remove(0);
		return getrokkenKaart;
	}
}