import java.awt.Color;

/**
 * DrawingCanvas specializes the general-purpose Canvas class from the BlueJ Web 
 * site, so that only one DrawingCanvas object is created and shared by all objects
 * that draw on it.
 * 
 * @author D.L. Bailey, SCE, Carleton University
 * @version 1.1 January 9, 2008
 */ 
/*  Change log:
 *   0.1 September 13, 2005 dlb Original implementation
 *   0.2 September 17, 2006 dlb Documentation cleanup. Replace singleton method
 *                              with public variable canvas.
 *   1.0 January 7, 2007    dlb setForegroundColour() doesn't change the foreground
 *                              colour if it's argument is invalid.  
 *   1.1 January 9, 2008    dlb added drawLine(), made setForegroundColour private.
 */
public class DrawingCanvas extends Canvas    
{
    public static DrawingCanvas canvas = new DrawingCanvas("Pen Demo", 300, 300, 
                                         Color.white);
    /* Instead of using a public variable, it would be better programming style to implement 
     * the singleton pattern (declare the variable private and provide a public method to 
     * create and return the sole instance). The approach used here keeps things a bit simpler
     * for educational purposes. 
     */
    
    /**
     * Creates a DrawingCanvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background colour of the canvas
     */
    private DrawingCanvas(String title, int width, int height, Color bgColour)
    {
        super(title, width, height, bgColour);
        super.setVisible(true);
    } 

    /**
     * Changes the foreground colour of this drawing canvas to the specified colour.
     * 
     * @param newColour The new colour for the foreground of this canvas. 
     *                  Valid colors are "red", "black", "blue", "yellow", 
     *                  "green", "magenta" and "white". If an invalid colour
     *                  is specified, the foreground colour doesn't change.
     */    
    private void setForegroundColour(String newColour)
    {
        /* Map the name of the colour to the equivalent constant from class
         * Color, then invoke the superclass' method to do the real work.
         */
        if (newColour.equals("red"))
            super.setForegroundColour(Color.red);
        else if (newColour.equals("black"))
            super.setForegroundColour(Color.black);
        else if (newColour.equals("blue"))
            super.setForegroundColour(Color.blue);
        else if( newColour.equals("yellow"))
            super.setForegroundColour(Color.yellow);
        else if (newColour.equals("green"))
            super.setForegroundColour(Color.green);
        else if (newColour.equals("magenta"))
            super.setForegroundColour(Color.magenta);
        else if (newColour.equals("white"))
            super.setForegroundColour(Color.white);
    } 

    /** Draws a straight line with the specified colour on the canvas between points (x1,y1) and (x2,y2) */
    public void drawLine(int x1, int y1, int x2, int y2, int width, String colour)
    {
        this.setForegroundColour(colour);
        super.drawLine(x1, y1, x2, y2, width);
    }
    
    /**
     * Returns the width of this drawing canvas.
     * @return The current with of this canvas.
     */
    public int getWidth() {
        return super.getSize().width;
    }

    /**
     * Returns the height of this drawing canvas.
     * @return The current with of this canvas.
     */    
    public int getHeight() {
        return super.getSize().height;
    }
}
