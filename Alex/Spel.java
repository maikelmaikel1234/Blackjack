package Blackjack.Alex;

import java.util.*;

public class Spel {

	public static void main(String[] arg) {

		Scanner invoeg = new Scanner(System.in);

		Random generator = new Random();
		// declaration score en tegenstander
		int score, tegenstander;

		System.out.println("Welkom dit is Blackjack");

		score = speler(invoeg, generator);
		System.out.println("Jou eind score = " + score);

		tegenstander = spelTegenstander(generator);
		System.out.println("De score van Tegenstander = " + tegenstander);

		printWinnaar(score, tegenstander);

	}

	static int speler(Scanner invoeg, Random generator) {
		// declaration hit
		boolean hit = true;
		int numkaart = 0;
		int score = 0;

		while (hit) {

			int enkelkaart = 0;

			while (numkaart < 2 || enkelkaart < 1) {

				int keuze = Math.abs(generator.nextInt())%13;

				if (keuze == 0) {
					score = score + pakAas(invoeg);

				}

				else if (keuze == 0) {
					System.out.println("Jou kaart waarde = " + (keuze + 1));
					score = score + keuze + 1;
				} else {
					System.out.println("Jou kaart waarde = 10");
					score = score + 10;
				}

				enkelkaart++;
				numkaart++;
			}

			System.out.println("Op dit moment is jou score = " + score);
			if (score <= 21) {

				System.out.println("wil je nog een kaart?");
				char ant = (invoeg.next()).charAt(0);

				if (ant != 'y' && ant != 'Y')
					hit = false;
			} else {
				hit = false;
			}

		}

		return score;

	}

	public static int pakAas(Scanner invoeg) {

		System.out.println("jij hebt een Aas, wil je dat het als 1 telt of als 11.");
		int aasscore = invoeg.nextInt();

		while (aasscore != 11 && aasscore != 1) {

			System.out.println("sorry dit is geen juiste invoer, voer 1 of 11 voor de score van jou aas.");
			aasscore = invoeg.nextInt();

		}

		return aasscore;

	}

	public static int spelTegenstander(Random generator) {

		int tegenstanderscore = 0;

		while (tegenstanderscore < 17) {

			int keuze = Math.abs(generator.nextInt()) % 13;
			int kaartwaarde;

			if (keuze == 0) {

				if (tegenstanderscore < 11)
					kaartwaarde = 11;
				else
					kaartwaarde = 1;
			}

			else if (keuze < 10)
				kaartwaarde = keuze + 1;
			else
				kaartwaarde = 10;

			tegenstanderscore = tegenstanderscore + kaartwaarde;
			System.out.println("tegenstander kaar waarde = " + kaartwaarde);
		}

		return tegenstanderscore;
	}

	public static void printWinnaar(int score, int tegenstander) {

		if (score > 21 && tegenstander > 21)
			System.out.println("gelijk spel");
		else if (score > 21)
			System.out.println("jij hebt verloren. Tegenstander wint!");
		else if (tegenstander > 21)
			System.out.println("tegenstander heeft verloren. jij wint!");
		else {

			if (score > tegenstander)
				System.out.println("Jij wint!!!");
			else if (score < tegenstander)
				System.out.println("tegenstander heeft jou verslage. jij verliest");
			else
				System.out.println("gelijk spel");
		}

	}

}
