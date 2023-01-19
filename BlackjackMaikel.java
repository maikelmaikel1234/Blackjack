package Blackjack;

import java.util.Random;
import java.util.Scanner;

public class BlackjackMaikel {
	
	static String[] kaartenSoort = {"Harten", "Ruiten", "Schoppen", "Klaver"};
	static int kaartWaarde1;
	static int kaartWaarde2;
	static int kaartWaarde3;
	static int kaartWaarde4;
	static int kaartWaarde5;
	
	
	
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welkom bij de blackjack van maikel");
		System.out.println("De uitleg komt hier onder te staan:");
		System.out.println("Je zal 2 kaarten krijgen met een waarde die je kan optellen");
		System.out.println("Ook de dealer zal 2 kaarten krijgen waarvan er maar 1 te zien is");
		System.out.println("");
		System.out.println("wil je beginnen: (yes) or (no)");
		String antwoord = sc.nextLine();
		
		if (antwoord.equals("yes")){ 
		
		/*4 verschillende waardes voor elke kaart die wordt getrokken (2 voor speler 
		 *en 2 voor Dealer. elke waarde een random waarde tussen de 1 en de 11y)
		 */
		kaartWaarde1 = rand.nextInt(11)+1;
		kaartWaarde2 = rand.nextInt(11)+1;
		kaartWaarde3 = rand.nextInt(11)+1;
		kaartWaarde4 = rand.nextInt(11)+1;
		kaartWaarde5 = rand.nextInt(11)+1;
		
		int TotaalSpeler = kaartWaarde1+kaartWaarde2;
		int TotaalDealer = kaartWaarde3+kaartWaarde4;
		
		System.out.println("jij hebt kaart "+kaartWaarde1+" en "+kaartWaarde2);
		System.out.println("dit is samen "+TotaalSpeler);
		
		System.out.println("");
		
		System.out.println("De dealer heeft "+kaartWaarde3+" en "+kaartWaarde4);
		System.out.println("dit is samen "+TotaalDealer);
		
		System.out.println("wil je nog een kaart pakken (yes), (no)");
		String doorSpelen = sc.nextLine();
			
			
			if (doorSpelen.equals("yes")) {
				System.out.println("De kaart die u heeft getrokken is: "+kaartWaarde5);
				int TotaalSpeler1 = TotaalSpeler + kaartWaarde5;
				System.out.println("Uw totaal is nu: " +TotaalSpeler1);
				
				System.out.println("totaal wordt nu opgeteld en vergeleken: ");
				System.out.println("u heeft "+TotaalSpeler1+" punten");
				System.out.println("de dealer heeft "+TotaalDealer+" punten");
				if (TotaalSpeler1 >21) {
					System.out.println("te veel u heeft verloren");
				} else if (TotaalSpeler1 >TotaalDealer){
					System.out.println("lekker gewerkt, je hebt gewonnen");
				} else if (TotaalSpeler1 == TotaalDealer) {
					System.out.println("het is gelijkspel");
				} else {
					System.out.println("helaas de dealer heeft gewonnen");
				}
	
			} else { 
				System.out.println("totaal wordt nu opgeteld en vergeleken: ");
				System.out.println("u heeft "+TotaalSpeler+" punten");
				System.out.println("de dealer heeft "+TotaalDealer+" punten");
				if (TotaalSpeler >21) {
					System.out.println("te veel u heeft verloren");
				} else if (TotaalSpeler >TotaalDealer){
					System.out.println("lekker gewerkt, je hebt gewonnen");
				} else if (TotaalSpeler == TotaalDealer) {
					System.out.println("het is gelijkspel");
				} else {
					System.out.println("helaas de dealer heeft gewonnen");
				}
			}
		
		
		} else {
			System.out.println("oke doei");
		}
	}
	
	}

/* BlackJack, ook wel 21-en genoemd.

Uitleg BlackJack
De Black Jack wordt in de commandline gemaakt.
Het zal een werkend spel moeten zijn bij oplevering.
Doordat het een commandline spel is mag je natuurlijk creatief zijn in de interactie met de
gebruiker. H4 kan een harten 4 zijn. Zolang de onderliggende techniek maar werkt.
Op de wikipedia pagina zie je dat er heel veel regels, uitbreidingen en varianten zijn voor
een compleet BlackJack spel.
De kunst is als programmeur om deze op te knippen en met kleine doelstellingen te
beginnen.
Dat werk heb ik al een beetje voor je gedaan. Hou daarom als leidraad de volgende
doelstellingen aan:

Doelstelling 1
Elke Black Jack begint met het tonen van de geschudde kaarten.
De Black Jack spelen we met 1 spel van 52 kaarten. Alle kaarten zitten dus 1 keer in het
overzicht, en als het spel opnieuw gestart wordt is de volgorde in een random nieuwe
volgorde.

Doelstelling 2
Een speler kan meedoen met het spel. De speler kan door een 'k' in te voeren om een kaart
vragen. Een speler kan altijd met heel het spel stoppen door 'q' in te voeren. De speler mag
ook 'p' invoeren om te passen.
Als een speler een kaart vraagt krijgt hij de bovenste kaart van de stapel. Het totaal aantal
punten wordt getoont.
De speler mag met 0 kaarten starten. De aas mag als een fixed 11 punten kaart beschouwd
worden.
Als de speler past, worden alle kaarten getoont die hij heeft met het totaal aantal punten van
de kaarten.
De punten per kaart zijn: De waarde van het getal bij de 2, 3, 4, 5, 6, 7, 8, 9, 10. De Boer,
Vrouw, Heer zijn 10 punten. De aas is zoals gezegd 11 punten.

Doelstelling 3

Vanaf hier wordt het spannender. Het is vanaf deze doelstelling verplicht om met kaarten als
objecten te werken. Kaart kaart = new Kaart(). De vorige doelstellingen konden prima op
andere wijzen volbracht worden, vanaf hier is Object Georiënteerd programmeren een
vereiste.
De speler krijgt twee kaarten toebedeeld of je wil je wanneer hij start, zoals bij de werkelijke
regels. Ook kan de Aas 1 of 11 punten waard zijn. Dat is afhankelijk van het gegeven of hij
anders boven de 21 punten uit komt.
Als een speler niet op tijd past, is de speler af.
Er mag geen invoer zijn die het programma doet vastlopen.
Mocht je tijd over hebben dan kun je je bezig gaan houden met meerdere spelers, een bank
of zelfs gokken en inzetten.*/