/*
 * Author:   Amanda Martel
 * Date:     11/17/2020
 *
 * Filename: CardDeckApp.java 
 * Program will display card deck, a shuffled deck, and a hand of two cards.
 * 
*/
import java.util.Arrays; //import Arrays class

public class CardDeckApp { //create CardDeckApp class 

    public static void main(String[] args) { //create main method 
        System.out.println("DECK"); //print statement 
        String[] deck = getDeck(); //set deck array to call getDeck method 
        displayCards(deck); //call displayCards pass deck parameters 

        System.out.println("SHUFFLED DECK"); //print statement 
        shuffleDeck(deck); //call shuffleDeck pass deck parameters 
        displayCards(deck); //call displayCards pass deck parameters 

        int count = 2; //set count variable to 2 
        System.out.println("HAND OF " + count + " CARDS"); //print statement 
        String[] hand = dealCards(deck, count); //set hand array to call dealCards with deck and count parameters 
        displayCards(hand); //call displayCards with hand parameter 
    }

    private static String[] getDeck() { //create getDeck method 
        //create deck array pass 52 parameter 
        String[] deck = new String[52];
        //create suits array 
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        //create ranks array
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
            "Jack", "Queen", "King"};
        //for loop 
        int i = 0; //initialize i variable
        //nested for loop 
        for (String suit : suits) { //set string suit 
            for (String rank : ranks) { //set string rank 
                deck[i] = rank + " of " + suit;
                i++; //increment through loop 
            }
        }
        //return statement 
        return deck;
    }

    private static void displayCards(String[] cards) { //create displayCards pass cards array parameter 
        // prints cards in the array that is passed 
        System.out.print("|"); 
        for (String card : cards) { //set card array to cards 
           System.out.print(card + "|"); //print card  
        }
        System.out.println(); //print blank line 
    }

    private static void shuffleDeck(String[] deck) { //create shuffleDeck
        //shuffle the deck 
      //for loop to continue for length of deck
        for (int i =0; i < deck.length; i++) {
           String savedCard = deck[i]; //set savedCard to deck array item 
           int randomIndex = (int) (Math.random() * deck.length-1);
           deck[i] = deck[randomIndex]; //generate random card 
           deck[randomIndex] = savedCard;  //set random card variable to savedCard 
        }  
    }

    private static String[] dealCards(String[] deck, int count) {
        //String[] hand = new String[count];
        String[] hand = Arrays.copyOfRange(deck, 0, count); //create hand array pass deck, 0, count parameters 
        return hand;
    }
}