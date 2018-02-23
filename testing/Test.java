import java.util.*;
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    private ArrayList<Cake> list;
    private Cake cake;

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        list = new ArrayList<Cake>();
        
    }

    public void bakeCake(String description){
        
        cake = new Cake(description);
        list.add(cake);
    
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void iterator()
    {
        Iterator<Cake> it = list.iterator();
        
        while(it.hasNext()){
        
            Cake c = it.next();
            c.description();
        
        }
    }
    
    
}
