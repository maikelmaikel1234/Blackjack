package Blackjack.Glenn;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Speler {
	 static Scanner input = new Scanner(System.in);
	 private String naam;
	 private int totaalPunten;
	 ArrayList<Kaart> getrokkenKaarten = new ArrayList<Kaart>();
	 private boolean eindeBeurt = false;
	 boolean eersteBeurt = true;
	 boolean heeftBlackjack = false;
	 private boolean buitenTimer;
	 
	 Speler() { //Default constructor, vraagt speler om invoer naam.
		 this.geefNaam();
	 }
	 Speler(String naam) { //Constructor voor dealer
		 this.naam = naam;
	 }
	 
	 void geefNaam(){
//		 input.nextLine();
		 //Vraagt speler om naam en vraagt of het klopt
		 //Slaat deze vervolgens op in String naam. 
		 boolean naamCorrect = false;
		 while(!naamCorrect) {
			 boolean invoerCorrect = false;
			 System.out.println("Wat is je naam?");
			 this.naam = input.nextLine();
			 while(!invoerCorrect) {
				 System.out.println("\nJe hebt " + this.naam + " ingevoerd, klopt dit? (ja/nee)");
				 switch(input.next().toLowerCase()) {
				 case "j": case "ja":
					 naamCorrect = true;
					 invoerCorrect = true;
					 input.nextLine();
					 break;
				 case "n": case "nee":
					 System.out.println();
					 invoerCorrect = true;
					 break;
				 default:
					System.out.println("\nOngeldige invoer. Vul a.u.b. ja of nee in.");
				 }
			 }
		 }
	}
	 
	void zetTotaalWaarde(int waardeKaart) { //Voegt de waarde van de laatst getrokken kaart toe aan aan het totaal van de speler.
		this.totaalPunten += waardeKaart;
		if (!this.eersteBeurt) {
			System.out.println(this.krijgNaam() + " heeft nu in totaal " + totaalPunten + " punten.");
		}
	}
	
	int haalTotaal() { //Geeft de totale waarde van de getrokken kaarten terug.
		return this.totaalPunten;
	}
	
	 
	String krijgNaam() { //Haalt naam van de speler op
		return this.naam;
	}
	
	void eerste2Kaarten() { //Eerste 2 kaarten voor elke speler wanneer het spel start
		getrokkenKaarten.add(Blackjack.deck.krijgKaart(this)); //This voert de Speler in waar deze beurt van is
		this.zetTotaalWaarde(getrokkenKaarten.get(getrokkenKaarten.size()-1).waardeKaart);
		getrokkenKaarten.add(Blackjack.deck.krijgKaart(this));
		this.zetTotaalWaarde(getrokkenKaarten.get(getrokkenKaarten.size()-1).waardeKaart);
		this.eersteBeurt = false;
	}
	
	void beurtSpeler() {
		this.buitenTimer = false;
		System.out.println("\nHet is de beurt van: " + this.krijgNaam());
		System.out.println("Je hebt " + this.haalTotaal() + " punten.");
		System.out.println("Als je niet binnen " + Blackjack.haalTimerTijd() + " seconden antwoord, ben je af.");
		while(!this.eindeBeurt) { //
			if (this.haalTotaal() < 21) {
				//Geeft speler 3 keuzes, kaart trekken, passen of spel afsluiten.
				System.out.println("\nk = kaart trekken\nq = spel afsluiten\np = passen");
				System.out.println("\nWat wil je doen?");
				LocalTime beginTimer = LocalTime.now(); //Eerste timestamp
				String antwoord = input.next();
				LocalTime eindTimer = LocalTime.now(); //Tweede timestamp
				if(this.buitenTimer(beginTimer, eindTimer)) { //Roept 
					antwoord = "p";
					this.buitenTimer = true;
				}
				switch(antwoord) {
				case "k": //Speler trekt kaart
					getrokkenKaarten.add(Blackjack.deck.krijgKaart(this)); //This voert de Speler in waar deze beurt van is
					this.zetTotaalWaarde(getrokkenKaarten.get(getrokkenKaarten.size()-1).waardeKaart);
					break;
				case "q": //Speler stopt het spel
					Blackjack.beeindigSpel();
					this.eindeBeurt = true;
					break;
				case "p": //Speler passed
					StringBuilder kaartenSB = new StringBuilder();
					if(buitenTimer) {
						System.out.println("\nJe hebt niet snel genoeg geantwoord en bent daardoor af.");
					} else {
						System.out.println("\nJe passed.");
					}
					System.out.println("Je hebt " + this.haalTotaal() + " punten.\nDit zijn je kaarten:");
					//Onderstaande loop voegt elke kaart in ArrayList getrokkenKaarten toe aan de StringBuilder kaartenSB met een ", " er achter.
					for (Kaart e : getrokkenKaarten) {
						kaartenSB.append(e.kaart + ", ");
					}
					//Print de kaarten StringBuilder uit minus de laatste ", "
					System.out.println(kaartenSB.delete(kaartenSB.length()-2, kaartenSB.length()));
					Blackjack.spelerPass();
					this.eindeBeurt = true;
					break;
				default:
					System.out.println("Ongeldige keuze.");
				}
			} else if (this.haalTotaal() > 21) {
				System.out.println("\nHelaas! Je hebt verloren.");
				Blackjack.spelerPass();
				this.eindeBeurt = true;
				break;
			} else if (this.haalTotaal() == 21) {
				System.out.println("\nGefeliciteerd! Je hebt precies 21!");
				Blackjack.spelerPass();
				this.heeftBlackjack = true;
				this.eindeBeurt = true;
				break;
			}
		}
	}
	
	void eersteKaartDealer() {
		getrokkenKaarten.add(Blackjack.deck.krijgKaart(this)); //This voert de Speler in waar deze beurt van is
		this.zetTotaalWaarde(getrokkenKaarten.get(getrokkenKaarten.size()-1).waardeKaart);
		System.out.println("\nDealer heeft de volgende kaart getrokken: \n" + this.getrokkenKaarten.get(0).kaart);
		this.eersteBeurt = false;
	}
	
	void beurtDealer() {
		System.out.println("\nHet is de beurt van de Dealer.");
		while(!this.eindeBeurt) { //
			if (this.haalTotaal() < 17) { //Trekt kaarten zolang de dealer minder dan 17 punten heeft.
				getrokkenKaarten.add(Blackjack.deck.krijgKaart(this)); //This voert de Speler in waar deze beurt van is
				this.zetTotaalWaarde(getrokkenKaarten.get(getrokkenKaarten.size()-1).waardeKaart);
			} else if (this.haalTotaal() > 21) {
				System.out.println("\nDealer heeft meer dan 21 punten.");
				this.eindeBeurt = true;
			} else if (this.haalTotaal() == 21) {
				System.out.println("\nDealer heeft Blackjack.");
				this.heeftBlackjack = true;
				this.eindeBeurt = true;
			} else { //Tussen 17 en 21, eindig beurt
				System.out.println("\nDe dealer stopt met kaarten trekken.");
				this.eindeBeurt = true;
			}
		}
	}
	
	boolean buitenTimer(LocalTime begin, LocalTime eind) {
		if (ChronoUnit.SECONDS.between(begin, eind) > Blackjack.haalTimerTijd()) {
			return true;
		} else {
			return false;
		}
	}
}