
/**
 * Write a description of class Dog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dog extends Animal implements Mammal
{
    // instance variables - replace the example below with your own
    private String breed;
    private String color;
    
    /**
     * Constructor for objects of class Dog
     */
    public Dog(String breed,String color)
    {
        // initialise instance variables
        super(breed);
    }

    /**
     * Make a noise!
     */
    public String noise()
    {
       return ("Woof!");
    }
    
    public boolean hasEgg(){
        return false;
    }
    
    public void task(){
        System.out.println("Live the life");
    }
    
    public boolean isAlive(){
        return true;
    }
}
