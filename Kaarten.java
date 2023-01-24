package BlackjackMaikel;
import java.util.*;


public class Kaarten {
	Random rand = new Random();
	

	String[] Kaart = {
			"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HB", "HQ", "HK",
			"RA", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "RB", "RQ", "RK",
			"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SB", "SQ", "SK",
			"KA", "K2", "K3", "K4", "K5", "K6", "K7", "K8", "K9", "K10", "KB", "KQ", "KK"};
	
	int[] nr = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
			,11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
			,11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
			,11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	ArrayList<String> deck = new ArrayList<String>(Arrays.asList(Kaart));
	
	
	
	void kaartSchudden(){
		Collections.shuffle(deck);
		
		System.out.println("de kaarten zijn geschud");
	
	}
	
	
	void deckSpeler() {
		System.out.println("Uw eerste kaart is "+deck.get(0));
		System.out.println("uw 2e kaart is "+deck.get(1));
		
		
		
		
	}
	void deckDealer() {
		System.out.println("Dealers eerste kaart is "+deck.get(2));
		System.out.println("Dealers 2e kaart is "+deck.get(3));
		System.out.println("totaal is: ");
	}
	void extraKaart() {
		System.out.println("U heeft als extra kaart "+deck.get(4+1)+" getrokken");
		
	}
	
	
	void checkWaarde() {
		
		
		System.out.println(Arrays.toString(Kaart));
	}
}