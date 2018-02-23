/**
 * A square on the Monopoly game board.
 * 
 * @author D.L. Bailey, SCE, Carleton University 
 * @version 1.12 January 20, 2007
 */
public class Square
{   
    /**
     * The square's number.
     */
    private int number;    
 
    /**
     * Constructs a new Square with the specified number.
     *
     * @param number This square's number.
     */
    public Square(int number)
    {
        this.number = number;
    }

    /**
     * Returns this square's number.
     *
     * @return This square's number.
     */
    public int number()
    {
        return number;
    } 
    
    /**
     * Returns a description of this square.
     *
     * @return A String that describes this square.
     */
    public String description()
    {
        return "Square " + number;
    }
}
