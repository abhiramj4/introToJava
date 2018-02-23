import java.util.*;
/**
 * Write a description of class Farm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Farm
{
    // instance variables - replace the example below with your own
    private Farmer joe;
    private FarmHouse farm;
    /**
     * Constructor for objects of class Farm
     */
    public Farm()
    {
        joe = new Farmer();
        farm = new FarmHouse();
    }
    
    public String doSomething(){
        
        return joe.checkFarm(farm.returnMembers());
    }

}
