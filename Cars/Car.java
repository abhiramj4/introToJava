import java.util.*;
/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car
{
    // instance variables - replace the example below with your own
    private String name;
    private String comp;
    private int stock;


    /**
     * Constructor for objects of class Car
     */
    public Car(String name, String comp, int stock)
    {
        this.name = name;
        this.comp = comp;
        this.stock = stock;

        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getComp()
    {
        return comp;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getStock()
    {
        return stock;
    }
   
    public void addStock()
    {
        stock++;
    }
    
    public boolean removeStock(){
    
        if(getStock() <= 0){
        
            return false;
        } else {
            stock--;
            return true;
        
        }
        
    }
    

    
}
