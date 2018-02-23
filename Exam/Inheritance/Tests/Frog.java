
/**
 * Write a description of class Frog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Frog extends Animal
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Frog
     */
    public Frog(String breed)
    {
       super(breed);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String noise()
    {
        return ("Ribbit!");
    }
    
    public boolean isAlive(){
        return true;
    }
    
    public boolean isHungry(){
        return false;
    }
}
