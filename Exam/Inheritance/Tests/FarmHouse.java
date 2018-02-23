import java.util.*;
/**
 * Write a description of class FarmHouse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FarmHouse
{
    // instance variables - replace the example below with your own
    private ArrayList list;
    private Dog billy;
    private Frog jilly;
    private Dog hull;
    /**
     * Constructor for objects of class FarmHouse
     */
    public FarmHouse()
    {
        // initialise instance variables
        list = new ArrayList<Animal>();
        jilly = new Frog("rib");
        billy = new GermanShep("GermanShep","Brown");
        hull = new GermanShep("asdas","black");
        billy = hull;
        list.add(jilly);
        list.add(billy);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ArrayList returnMembers()
    {
        return list;
    }
    
    public boolean sellAnimal(){
        
        if(hull == billy ){
            return true;
        }
        return false;
    
    }
}
