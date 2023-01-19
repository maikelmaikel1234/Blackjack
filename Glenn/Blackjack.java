package Blackjack.Glenn;
import java.util.*;

public class Blackjack {
	static Scanner input = new Scanner(System.in);
	//ArrayList spelers = new ArrayList();
	static boolean doorgaanSpel = true;
	
	public static void main(String[] args) {

		Deck d1 = new Deck();
		d1.schudDeck();
		d1.printDeck();
		
		System.out.println();
		System.out.println(d1.trekKaart());
		d1.printDeck();
		System.out.println();
		System.out.println(d1.trekKaart());
		
		System.out.println("Welkom bij Blackjack!");
		Speler player1 = new Speler();
		
		
		//De main game loop, stopt wanneer in de beurt van de speler hij q invoert.
		while(doorgaanSpel) {
			player1.beurtSpeler(d1);
		}

	}

}

class Speler {
	 static Scanner input = new Scanner(System.in);
	 private String naam;
	 int totaalVanKaarten;
	 
	 Speler() {
		 this.geefNaam();
	 }
	 
	 void geefNaam(){
		 //Vraagt speler om naam en slaat deze op 
		 System.out.println("\nWat is je naam?");
		 this.naam = input.next();
	 }
	 void geefNaam(String naam) {
		 this.naam = naam;
	 }
	 
	 String krijgNaam() {
		 //Haalt naam van de speler op
		 return this.naam;
	 }
	 
	void beurtSpeler(Deck spelerDeck) {
		//Geeft speler 3 keuzes, kaart trekken, passen of spel afsluiten.
		boolean eindeBeurt = false;
		System.out.println("\nk = kaart trekken\nq = spel afsluiten\np = passen");
		do {
			System.out.println("\nWat wil je doen?");
			String antwoord = input.next();
			switch(antwoord) {
			case "k":
				System.out.println(spelerDeck.trekKaart());
				break;
			case "q":
				Blackjack.doorgaanSpel = false;
				eindeBeurt = true;
				break;
			case "p":
				System.out.println("\nJe passed.");
				eindeBeurt = true;
				break;
			default:
				System.out.println("Ongeldige keuze.");
			}
		} while(!eindeBeurt);
	}
 }
