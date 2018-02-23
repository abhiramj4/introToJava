import java.util.ArrayList;

/**
 * Hand models a hand of cards held by a player.
 * 
 * @author Lynn Marshall 
 * @version 1.1 October 11, 2012
 *
 */
public class Hand
{
    /** 
     * The cards are stored in a linked-list implementation of the
     * List collection.
     */
    
    private ArrayList<Card> cards;

    /**
     * Constructs a new, empty hand.
     */
    public Hand()
    {   
        cards = new ArrayList<Card>();
    }
    
    /**
     * Adds the specified card to this hand.
     */
    public void addCard(Card aCard)
    {
        cards.add(aCard);
    }
     
   /**
     * Removes a card from this hand. Cards are removed in the order in
     * which they were added to the hand.
     */
    public Card playCard()
    {
        
        return cards.remove(0);
    }

    /**
     * Returns the number of cards that are currently in this hand.
     */    
    public int size()
    {
        return cards.size();
    }

    /**
     * Determines if this hand is empty.
     */    
    public boolean isEmpty()
    {
        return (cards.size() == 0);
    }

    /**
     * Returns a String that lists the ranks (but not the suits) of all the 
     * cards in this hand, starting with the first card and finishing with
     * the last card. For example, if the first card is the two of hearts, 
     * the second card is the five of diamonds, and the last card is the
     * queen of clubs, the String returned by this method will be: "2 5 12".
     */
    public String toString()
    {
        String returnString = "";
        if(cards.size() == 0){
        
            return returnString;
        }
        
        if(cards.size()==1){
        
            return returnString += (cards.get(0)).rank();
        }
        
        for(int i = 0; i<cards.size()-1;i++){
        
            returnString += (cards.get(i)).rank() + " ";
        }
        
        returnString += (cards.get(cards.size()-1)).rank();
        
        return returnString;
    }
}
