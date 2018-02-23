
/**
 * Beamer item, can be used to transport the player to the room charged.
 * must be charged before fired.
 *
 * @author (Abhiram Santhosh)
 * @version (12/11/17)
 */
public class Beamer extends Item
{
    // is the beamer charged
    private boolean charged;

    /**
     * Constructor for beamer
     * 
     * @param String description, description of the object. Double weight, weight of the object
     */
    public Beamer(String description, double weight)
    {
        super(description,weight);
    }
    
    /**
     * Charge the beamer
     * 
     */
    public void charge(){  

        charged = true;
    }
    
    /**
     * Fire the beamer
     * 
     */    
    public void fired(){  

        charged = false;
    }
    
    /**
     * Check if the beamer is charged
     * 
     * @return boolean, charged returns true if the beamer is charged
     */
    public boolean isCharged()
    {
        // return true if the beamer is charged
        return charged;
    }
}
