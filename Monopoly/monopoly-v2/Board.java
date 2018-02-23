/**
 * The game board for a simulated game of Monopoly.
 * 
 * @author D.L. Bailey, SCE, Carleton University 
 * @version 1.20 January 6, 2007
 */
public class Board
{
    /** 
     * The number of squares in the board.  
     */
    private static final int SIZE = 40; 
    
    /** The squares on the board. */
    private Square[] squares;

    /** 
     * The location of the square where all players are located
     * at the start of the game.
     */
    private final int GO_SQUARE = 0;    

    /**
     * Constructs a new Board, populating it with squares.
     */
    public Board()
    {
        squares = new Square[SIZE];
        buildSquares();
    }
    
    /**
     * Populates the board with squares numbered 1, 2, 3, ..., SIZE.
     * The square numbered "n" is stored in squares[n-1].
     */
    private void buildSquares()
    {
        for (int i = GO_SQUARE; i < squares.length; i++) {
            squares[i] = new Square(i + 1);
        }
    }
 
    /**
     * Returns the square located "distance" squares after aSquare.
     */
    public Square nextSquare(Square aSquare, int distance)
    {
        /* Assumes that squares are numbered consecutively, starting
         * from 1, and that the square numbered "n" is stored
         * in squares[n-1]. See buildSquares().
         */
        int i = (aSquare.number() - 1 + distance) % squares.length;
        return squares[i]; 
    } 
 
    /**
     * Returns the square where all players are located at the start of the game.
     */
    public Square startingSquare()
    {
        return squares[GO_SQUARE];
    }      
}

   