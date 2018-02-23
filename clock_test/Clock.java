
/**
 * Write a description of class Clock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Clock
{
    // instance variables - replace the example below with your own
    private Digit hours_tens;
    private Digit hours_ones;
    private Digit min_tens;
    private Digit min_ones;

    /**
     * Constructor for objects of class Clock
     */
    public Clock()
    {
        hours_tens = new Digit(2);
        hours_ones = new Digit(9);
        min_tens = new Digit(5);
        min_ones = new Digit(9);
    }

}
