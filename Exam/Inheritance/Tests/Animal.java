
/**
 * Abstract class Animal - write a description of the class here
 *
 * @author (Abhiram Santhosh)
 * @version (version number or date here)
 */
public abstract class Animal 
{
    // instance variables - replace the example below with your own
    private String name;
    
    
    public Animal(String name){
    
        this.name = name;
    }

    /**
     * Make a noise
     *
     */
    abstract String noise();
    
    
    private String getName(){
        return name;
    }
    
    
}
