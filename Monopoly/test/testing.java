import java.util.*;
/**
 * Write a description of class testing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testing
{
    // instance variables - replace the example below with your own
    private ArrayList<Integer> numbers;

    /**
     * Constructor for objects of class testing
     */
    public testing()
    {
        numbers = new ArrayList<Integer>(3);
        
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void remove (int index)
    {
        // put your code here
        numbers.remove(index);
    }
}
