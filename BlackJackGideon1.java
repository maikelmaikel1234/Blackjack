package Blackjack;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

class BlackjackBlackJackGideon1 {
	public static void main(String[] args) {
		    Game game = new Game();				// hier wordt een new instance gemaakt van het object class Game
		    int playerWins = 0;
		    int dealerWins = 0;

		   game.Intro();
		    
		    for (int i = 1; i <= 5; i++) {		// hier wordt een loop gemaakt met rondes
		        System.out.println("Round " + i);
		        ArrayList<Integer> playerHand = new ArrayList<Integer>(); // hier worden twee nieuwe arrayList gemaakt voor player en dealer 
		        ArrayList<Integer> dealerHand = new ArrayList<Integer>();

		        // Kaarten delen
		        playerHand.add(game.dealKaart());
		        dealerHand.add(game.dealKaart());
		        playerHand.add(game.dealKaart());
		        dealerHand.add(game.dealKaart());

		        // Kijken of iemand 21 heeft
		        if (game.instandBlackjack(playerHand)) {
		            System.out.println("Player wins with a blackjack!");
		            playerWins++;
		        } else if (game.instandBlackjack(dealerHand)) {
		            System.out.println("Dealer wins with a blackjack");
		            dealerWins++;
		        } else {
		            // Player's beurt
		            while (game.getHandWaarde(playerHand) < 21) {
		            	System.out.println("Dealer's hand: " + dealerHand.get(0) + " and [hidden card]");
		            	System.out.println("");
		                System.out.println("Player's hand: " + playerHand + " (Total = " + game.getHandWaarde(playerHand) + ")");
		                System.out.println("Do you want to draw a card? yes or no");
		                Scanner sc = new Scanner(System.in);
		                String keuze = sc.nextLine();
		                if (keuze.equals("yes")) {
		                    playerHand.add(game.dealKaart());
		                } else {
		                    break;
		                }
		            }
		            
		            // Dealer's beurt
		            while (game.getHandWaarde(dealerHand) < 17) {   // wannneer de waardes onder 17 blijft krijgt dealer een extra kaart
		                dealerHand.add(game.dealKaart());
		            }

		            // Winner bepalen
		            System.out.println("Player's hand: " + playerHand + " (Total = " + game.getHandWaarde(playerHand) + ")");
		            System.out.println("Dealer's hand: " + dealerHand + " (Total = " + game.getHandWaarde(dealerHand) + ")");
		            String winner = game.determineWinner(playerHand, dealerHand);
		            System.out.println(winner);
		            if (winner.equals("Player wins")) {
		                playerWins++;
		            } else if (winner.equals("Dealer wins")) {
		                dealerWins++;
		            }
		            	System.out.println("");
		        }
		    }

		    System.out.println("Player wins: " + playerWins + " Dealer wins: " + dealerWins);
		    if (playerWins > dealerWins) {
		        System.out.println("Player wins best out of 5");
		    } else {
		        System.out.println("Dealer wins the best out of 5");
		    }
		    	System.out.println("");
		}
	}

	
