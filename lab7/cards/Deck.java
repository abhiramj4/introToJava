import java.util.ArrayList;
import java.util.Random;
import java.util.*;

/**
 * Deck models a deck of 52 Anglo-American playing cards.
 * 
 * @author Abhiram Santhosh
 * @version 1.2 October 19, 2017
 *
 */
public class Deck
{
    /** 
     * The cards are stored in a linked-list implementation of the
     * List collection.
     */
    private ArrayList<Card> cards;
    
    /** Lowest ranking card (the ace). */
    private static final int ACE = 1;
    
    /** Highest ranking card (the king). */
    private static final int KING = 13;
    
    /** 
     * Total number cards in the deck (4 suits, each with 13 cards of 
     * different ranks).
     */ 
    private static final int TOTAL_CARDS = 52;
    
    /** 
     * Some constants that define the Strings for the various suits.
     */ 
    private static final String HEARTS = "hearts";
    private static final String DIAMONDS = "diamonds";
    private static final String CLUBS = "clubs";
    private static final String SPADES = "spades";

    /**
     * Constructs a new, unshuffled deck containing 52 playing cards.
     */
    public Deck()
    {  
        cards = new ArrayList<Card>(TOTAL_CARDS);
        buildSuit(HEARTS);
        buildSuit(DIAMONDS);
        buildSuit(CLUBS);
        buildSuit(SPADES);
    }
    
    /**
     * Creates the 13 cards for the specified suit, and adds them
     * to this deck.
     */
    private void buildSuit(String suit)
    {
        int rank = 1;
        while(rank < 14){
            
                Card c1 = new Card(suit,rank);
                cards.add(c1);
                rank++;
        }
        
    }
 
    /**
     * Shuffles this deck of cards.
     */
    public void shuffle()
    {   
        Random r = new Random();
        int repeat = 0;
        int n = r.nextInt(TOTAL_CARDS);
        int n1 = r.nextInt(TOTAL_CARDS);
        //get a random index, and switch it with the
        //next index
        //random index (or card) between 1 and 52
        //this gives me a random
        
        while(repeat <= 10000){
            
            Card temp = cards.get(n);
            //random card has been obtained
            Card temp2 = cards.get(n1);
            //next random card has been obtained
            cards.set(n, temp2);
            //set the next random card to the orig random index
            cards.set(n1,temp);
            repeat++;
            
        }
        
        
    }
 
    /**
     * Removes a card from this deck.
     */
    public Card dealCard()
    {
        
        Card tempCard = cards.get(0);
        
        
        
        return cards.remove(0);
    }
 
    /**
     * Determines if this deck is empty.
     */
    public boolean isEmpty()
    {
        
        return (cards.size() == 0);
    }
  
    /**
     * Returns the number of cards that are currently in the deck.
     */
    public int size()
    {
        return cards.size();
    }
}
