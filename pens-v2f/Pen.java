/**
 * A Pen is a tool for drawing straight lines on a canvas. Pens are constrained
 * to move in four directions: North, South, East, and West.
 * This class is loosely based on the Smalltalk Pen class and various 
 * Turtle Graphics packages that are available for different languages.
 * 
 * @author  L.S. Marshall
 *          Department of Systems and Computer Engineering,
 *          Carleton University
 * @version 1.11, September 15, 2012.
 */
 /* Change Log:
  * 1.11 drawSquare (version 5) uses drawRectangle
  * 1.10 drawRectangle added
  * 1.09 drawSquare (version 4) uses moveBy and turnClockwise 
  * 1.08 drawSquare (version 3) uses drawLineOnCanvas, not 
  *      Canvas.drawingCanvas.drawLine
  * 1.07 drawSquare (version 2) with parameter
  * 1.06 drawSquare (version 1) added
  * 1.05 Minor changes to some of the comments.
  *      Renamed move() to move20() to more accurately reflect what it does.
  *      Rewrote moveBy() - now easier to understand?
  *      Refactored moveBy(), moving the code that uses the DrawingCanvas.canvas
  *      object into private method drawLineOnCanvas().
  *      Constructor now calls canvasWidth() and canvasHeight(), instead of
  *      directly calling methods on the DrawingCanvas.canvas object.
  */ 
public class Pen  
{
    /** Position of the pen along the x-axis. */
    private int xPosition;
    
    /** Position of the pen along the y-axis. */
    private int yPosition;
    
    /**
     * The direction in which the pen will move. Valid values are
     * NORTH, SOUTH, EAST and WEST (see below).
     */
    private int direction;
    
    /* See turnClockwise() and turnCounterClockwise() before changing the 
     * values of the following constants.
     */
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    
    /** 
     * True means that the pen is "down" on the canvas and will draw when it 
     * is moved. 
     */ 
    private boolean down;    
    
    /** The pen's colour. */
    private String colour;
    
    /** The width of the line drawn by the pen. */
    private int width;
      
    /**
     * Constructs a new blue Pen in the down position, placed in the
     * center of the canvas, and pointing East (i.e., by default,
     * it will move horizontally towards the right of the canvas).
     * The pen will draw lines 3 pixels wide.
     */
    public Pen()
    {
        direction = EAST;
        down = true;
        colour = "blue";
        width = 3; 
    
        /* Place the pen in the center of the canvas. */
        xPosition = canvasWidth() / 2;
        yPosition = canvasHeight() / 2;       
    }

    /**
     * Lowers this pen down onto the canvas. If the pen was already down, 
     * invoking this method does not change the pen's state.
     */
    public void down()
    {
        down = true;
    }
  
    /** 
     * Determines if this pen is in the down position.
     * 
     * @return true if the pen is on the canvas, false otherwise.
     */
    public boolean isDown()
    {
        return down;
    }
   
    /**
     * Lifts this pen up from the canvas. If the pen was already up, 
     * invoking this method does not change the state of the pen.
     */
    public void up()
    {
        down = false;
    }
    
    /** 
     * Determines if this pen is in the up position.
     * 
     * @return true if the pen is not on the canvas, false otherwise.
     */
    public boolean isUp()
    {
        return !down;
    }  
    
    /** 
     * Turns this pen clockwise by 90 degrees: N -> E -> S -> W -> N.
     */
    public void turnClockwise()
    {
        direction = (direction + 1) % 4;
    }
    
    /** 
     * Turns this pen counterclockwise by 90 degrees: N -> W -> S -> E -> N.
     */
    public void turnCounterClockwise()
    {
        if (direction == NORTH)
            direction = WEST;
        else
            direction--;
    } 
 
    /**
     * Returns this pen's current direction.
     * 
     * @return The direction in which the pen will move.
     */
    public int direction()
    {
        return direction;
    }
    
    /**
     * Changes this pen's colour to the specified colour.
     * 
     * @param newColour The pen's new colour. Valid colors are "red", "black", 
     *                  "blue", "yellow", "green", "magenta" and "white".
     *                  If an invalid colour is specified, the pen's
     *                  colour doesn't change.
     * 
     */
    public void changeColour(String newColour)
    {
        if (newColour.equals("red") ||
            newColour.equals("black") ||
            newColour.equals("blue") ||            
            newColour.equals("yellow") ||
            newColour.equals("green") ||
            newColour.equals("magenta") ||
            newColour.equals("white")) {              
                colour = newColour;
        }
    } 
    
    /**
     * Returns this pen's colour.
     * 
     * @return The colour of the lines that the pen draws.
     */
    public String colour()
    {
        return colour;
    }
    
    /** 
     * Places this pen at the specified coordinates. No line is drawn,
     * regardless of whether the pen is up or down.
     * 
     * @param newX The x coordinate of the pen's new location.
     * @param newY The y coordinate of the pen's new location. 
     */ 
    public void place(int newX, int newY)
    {
        xPosition = newX;
        yPosition = newY;
    } 
 
    /** 
     * Returns the x-coordinate of this pen's location on the canvas.
     * 
     * @return The x-coordinate of the pen's location.
     */
    public int xLocation()
    {
        return xPosition;
    }

    /** 
     * Returns the y-coordinate of this pen's location on the canvas.
     * 
     * @return the y-coordinate of the pen's location.
     */
    public int yLocation()
    {
        return yPosition;
    }
  
     /**
     * Moves this pen by 20 pixels in the current direction.
     * If the pen is down, draws a straight line between the old and new pen
     * locations.
     */
    public void move20()
    {
        moveBy(20);
    }

    /** 
     * Moves this pen by the specified number of pixels in the current direction.
     * If the pen is down, draws a straight line between the old and new pen 
     * locations. The pen is not moved if the specified distance is <= 0. 
     * 
     * @param distance The distance the pen will be moved from its
     *                 current location.
     */
    public void moveBy(int distance)
    {
        if (distance <= 0)
            return;
        
        /* Save the current location for when we draw the line on the canvas. */
        int oldX = xPosition;
        int oldY = yPosition;
  
        /* Place the pen at its new location. */
        if (direction == NORTH) {
            place(xPosition, yPosition - distance);
        } else if (direction == EAST) {
            place(xPosition + distance, yPosition);
        } else if (direction == SOUTH) {
            place(xPosition, yPosition + distance);
        } else if (direction == WEST) { 
            place(xPosition - distance, yPosition);
        }  else { 
            /* 
             * The Pen's direction is invalid, so return without moving the pen.
             * This should never happen, because we don't have a method that
             * allows us to set the pen's direction to an arbitrary value.
             */
            return;
        }
        
        /* If the pen is on the canvas, draw a line connecting the pen's 
         * previous location and new locations.
         */
        if (down)
            drawLineOnCanvas(oldX, oldY, xPosition, yPosition);
    } 
 
    /** 
     * Draws a square length x length pixels with the current location
     * at the upper left hand corner of the square. 
     * 
     * @param length The length in pixels of each side of the square.
     */
    public void drawSquare(int length)
    {
        drawRectangle(length,length);
    } 

    /** 
     * Draws a rectangle width x height pixels with the current location
     * at the upper left hand corner of the rectangle. 
     * 
     * @param width The width in pixels of the rectangle.
     * @param height The height in pixels of the rectangle.
     */
    public void drawRectangle(int width, int height)
    {
        int oldDirection = direction;
        
        direction = EAST;
        moveBy(width);
        turnClockwise();
        moveBy(height);
        turnClockwise();
        moveBy(width);
        turnClockwise();
        moveBy(height);
        
        // Ensure that the pen's direction is the same as it was when the method
        // was invoked.
        direction = oldDirection;
    } 

    
    /* Draws a straight line on the canvas between points (x1,y1) and (x2,y2) */
    private void drawLineOnCanvas(int x1, int y1, int x2, int y2)
    {
        DrawingCanvas.canvas.drawLine(x1, y1, x2, y2, width, colour);
    }
 
    /* Returns the width of the canvas, in pixels. */
    private int canvasWidth()
    {
        return DrawingCanvas.canvas.getWidth();
    }
 
    /* Returns the height of the canvas, in pixels. */
    private int canvasHeight()
    {
        return DrawingCanvas.canvas.getHeight();
    }
    
}
