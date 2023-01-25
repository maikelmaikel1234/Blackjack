package Blackjack;
import java.util.*;

public class BlackjackMaikel {

	public static void main(String[] args) {
		Kaarten[] cards = new Kaarten[52];
		
		Kaarten k = new Kaarten();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welkom bij blackjack.....");
		System.out.println("Wilt u spelen (ja) (nee)");
		String Antwoord = sc.nextLine();
		if (Antwoord.equals("ja")) {
		System.out.println("type ''schudden'' om kaarten te schudden");
		String schud = sc.nextLine();
		
		if (schud.equals("schudden")) {
		k.kaartSchudden();
		} else {
			System.out.println("dan niet");
			System.exit(0);
		}
		k.deckSpeler();
		k.deckDealer();
		System.out.println("");
		System.out.println("wilt u nog een extra kaart pakken. extra kaart(k), stoppen(q)");
		String door = sc.next();
			while (door.equals("k")) {
				k.extraKaart();
			}
		
		}
		
			


			
		
		
	}

}
