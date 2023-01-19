package Blackjack.Glenn;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class Kaarten {
	static Scanner input = new Scanner(System.in);
	
	

	
	public static void main(String[] args) {
		Deck d1 = new Deck();
		d1.printDeck();
		d1.schudDeck();
		d1.printDeck();
		d1.schudDeck();
		d1.printDeck();
		d1.schudDeck();
		d1.printDeck();
		

	}

}

class Deck{
	{System.out.println("Er wordt een nieuw deck gemaakt.");}
	//Onderstaande is een String array waar alle kaarten in zitten.
	String[] kaarten = new String[] {"HA","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK",
			 						 "SA","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK",
			 						 "DA","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK",
			 						 "CA","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK",};
	
	void schudDeck() { 
		//neemt het deck kaarten en schud ze
		List<String> deckList = Arrays.asList(this.kaarten);
		Collections.shuffle(deckList);
		deckList.toArray(this.kaarten);
		System.out.println("\nKaarten zijn geschud.");
	}
	
	void printDeck() {
		//Print alle kaarten van het deck uit, met een lege line na elke 13 kaarten.
		System.out.println("Kaarten worden geprint.");
		for (int a = 0; a < this.kaarten.length; a++) {
			if(a % 13 == 0) {
				System.out.println();
				System.out.print(this.kaarten[a]);
			} else {
				System.out.print(", ");
				System.out.print(this.kaarten[a]);
			}
		}
		System.out.println();
	}
}