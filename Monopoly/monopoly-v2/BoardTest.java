/**
 * The test class BoardTest.
 *
 * @author  D.L. Bailey
 * @version 1.01 January 7, 2007
 */
public class BoardTest extends junit.framework.TestCase
{
    private Board board;
    
    /**
     * Default constructor for test class BoardTest
     */
    public BoardTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
        board = new Board();      
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

    /* Verify that the starting square of a newly created game board is
     * Square 1.
     */
    public void testCreateBoard()
    {
        assertEquals(1, board.startingSquare().number());
    }
  
    /* Verifies that that 40 squares on the board are numbered consecutively,
     * starting from Square 1. For this test case to pass, nextSquare() must
     * return the correct square when the value passed to its "distance" 
     * parameter is 1.
     */
    public void testSquareNumbers()
    {
        Square loc = board.startingSquare(); 
        
        for(int i = 1; i <= 39; i++) {
            loc = board.nextSquare(loc, 1);
            assertEquals(i + 1, loc.number()); 
        }
    }
 
    /* Verifies that nextSquare() works for all distances between 2 and 12.
     */
    public void testNextSquare()
    {
        /* Rolling a pair of dice always yields a value between 2 and 12. */
        for (int i = 2; i <= 12; i++) {
            Board board = new Board();
            Square loc = board.startingSquare();            
            loc = board.nextSquare(loc, i);
            assertEquals(i + 1, loc.number());
        }
    }
    
    public void testWrapAround()
    {
        Square loc = board.startingSquare(); 
        
        /* Move 39 squares. This should move us to square 40. */
        loc = board.nextSquare(loc, 39);
        assertEquals(40, loc.number());         
        
        /* Move 2 squares. We should now be back at square 2. */
        loc = board.nextSquare(loc, 2);
        assertEquals(2, loc.number());  
    }
}
