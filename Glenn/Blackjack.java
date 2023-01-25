package Blackjack.Glenn;

import java.util.*;

public class Blackjack {
	static Deck deck = new Deck();
	static Scanner input = new Scanner(System.in);
	static ArrayList<Speler> spelers = new ArrayList<Speler>();
	static boolean doorgaanSpel = true;
	private static int aantalPasses = 0;
	private static int aantalSpelers;
	static Speler dealer = new Speler("Dealer");
	private static int timerDuratie;
	
	public static void main(String[] args) {		
		System.out.println("\nWelkom bij Blackjack!");
		vraagTimerTijd();
		vraagAantalSpelers();
		maakAantalSpelers(aantalSpelers);
		if(aantalSpelers > 1) { //Print alle spelers uit als er meer dan 1 speler is
			printSpelers();
		}
		for (Speler p : spelers) { //Geeft elke speler in ArrayList spelers 2 kaarten
			System.out.println("\nDealer geeft " + p.krijgNaam() + " de volgende 2 kaarten:");
			p.eerste2Kaarten();
			System.out.println(p.getrokkenKaarten.get(0).kaart + " & " + p.getrokkenKaarten.get(1).kaart);
		}
		dealer.eersteKaartDealer(); //Geeft de dealer een eerste kaart
		enterPrompt();
		
		//De main game loop, stopt wanneer in de beurt van de speler hij q invoert.
		while(doorgaanSpel) {
			for (Speler p : spelers) { //Geeft elke speler in de ArrayList spelers een beurt mits deze minder dan 21 punten heeft.
				if(p.haalTotaal() < 21) {
					p.beurtSpeler();
					enterPrompt();
				}
			}
			if(aantalSpelers == aantalPasses) { //Doet de beurt van de Dealer nadat alle spelers hebben gepassed.
				dealer.beurtDealer();
				checkScore(); //Vergelijkt de scores van de spelers met de dealer en vertelt ze of ze hebben gewonnen
				beeindigSpel();
			}
		}

	}
	
	static void spelerPass() { //Word uitgevoerd na de beurt van een speler, increment de aantalPasses counter.
		aantalPasses++;
//		System.out.println("Aantal passes: " + aantalPasses);
	}

	static void vraagAantalSpelers() { //Vraagt hoeveel spelers mee doen aan het spel
		do {
			System.out.println("Hoeveel spelers zijn er?");
			try {
				aantalSpelers = input.nextInt();
			} catch(InputMismatchException IME) {
				System.out.println("\nDaar ging iets mis, voer een heel getal in a.u.b.");
				input.nextLine();
			}
			if(aantalSpelers < 1) {
				System.out.println("\nVoer een getal boven de 0 in.");
			}
		} while(aantalSpelers <= 0);
	}
	
	static void maakAantalSpelers(int aantal) {
		for (int a = 0; a < aantal; a++) { //Maakt zoveel spelers als is opgegeven.
			System.out.println("\nSpeler " + (a+1));
			Speler player = new Speler();
			spelers.add(player);
		}
	}
	
	static void printSpelers() {
		System.out.println("\nDit zijn alle spelers:");
		for (int p = 0; p < spelers.size(); p++) {
			Speler x = spelers.get(p);
			System.out.println(x.krijgNaam());
		}
	}
	
	static void vraagTimerTijd() { //Vraagt hoeveel seconde alle spelers moeten krijgen voor hun beurt
		boolean loop = true;
		System.out.println("Spelers moeten in hun beurt binnen de tijd antwoord geven.");
		System.out.println("Binnen hoeveel seconde moeten ze antwoord geven voordat ze af zijn?");
		while(loop) {
			try {
				timerDuratie = input.nextInt();
				loop = false;
			} catch(InputMismatchException IME) {
				System.out.println("\nDaar ging iets mis, voer een heel getal in a.u.b.");
				input.nextLine();
			}
			if(timerDuratie < 5) {
				System.out.println("\nDat is wel erg weinig tijd, geef ze op z'n minst 5 seconde.");
				loop = true;
			} else {
				System.out.println("\nSpelers hebben " + timerDuratie + " seconde de tijd om te antwoorden, klopt dit? (ja/nee)");
				String antwoord = input.next();
				switch(antwoord) {
				case "j":
				case "ja":
					System.out.println();
					break;
				case "n":
				case "nee":
					System.out.println("\nHoeveel seconde dan?");
					loop = true;
					break;
				default:
					System.out.println("\nOngeldige invoer");
					loop = true;
				}
			}
		}
	}
	
	static int haalTimerTijd() {
		return timerDuratie;
	}
	
	static void checkScore() {
		enterPrompt();
		for (Speler p : spelers) { //Loop die elke speler af gaat.
			System.out.println();
			if (p.haalTotaal() > 21) { 
				//Voert dit uit als speler meer dan 21 punten heeft.
				System.out.println("Helaas " + p.krijgNaam() + ", je hebt helaas verloren omdat je meer dan 21 punten hebt.");
				System.out.println("Je eindscore: " + p.haalTotaal() + " punten.");
			} else if (dealer.haalTotaal() > 21) {
				//Voert dit uit als dealer meer dan 21 punten heeft.
				System.out.println("Gefeliciteerd " + p.krijgNaam() + "!\nJe hebt gewonnen omdat de dealer meer heeft dan 21 punten.");
				System.out.println("Je eindscore: " + p.haalTotaal() + " punten.");
			} else if (p.haalTotaal() < dealer.haalTotaal()) {
				//Voert dit uit als speler minder heeft dan dealer.
				System.out.println("Helaas " + p.krijgNaam() + ", je hebt verloren van de dealer.");
				System.out.println("Je eindscore: " + p.haalTotaal() + " punten.");
			} else if (p.haalTotaal() > dealer.haalTotaal() && p.haalTotaal() < 21) {
				//Voert dit uit als speler meer heeft dan dealer.
				System.out.println("Gefeliciteerd " + p.krijgNaam() + ", je hebt gewonnen van de dealer.");
				System.out.println("Je eindscore: " + p.haalTotaal() + " punten.");
			} else if (p.haalTotaal() == dealer.haalTotaal()) {
				//Voert dit uit als de scores gelijk zijn.
				System.out.println(p.krijgNaam() + ", je hebt gelijk gespeeld met de dealer.");
				System.out.println("Je eindscore: " + p.haalTotaal() + " punten.");
			} else if (p.heeftBlackjack) {
				//Voert dit uit als de speler Blackjack heeft en de dealer niet.
				System.out.println("Gefeliciteerd " + p.krijgNaam() + ", je hebt gewonnen met een Blackjack.");
			} 
		}
	}
	
	static void beeindigSpel() {
		System.out.println("\nHet was leuk met je/jullie te spelen!");
		System.out.println("\n----EINDE PROGRAMMA----");
		System.exit(0);
	}
	
	static void enterPrompt() { //Maakt een nieuwe scanner aan en vraagt om input waar niets mee gebeurd.
		Scanner enter = new Scanner(System.in);
		System.out.println("\nDruk op enter om door te gaan.");
		enter.nextLine();
	}
}
