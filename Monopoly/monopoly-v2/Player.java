/**
 * Models a player in a siumulated game of Monopoly.
 * 
 * @author D.L. Bailey, SCE, Carleton University 
 * @version 1.21 January 20, 2007
 */
public class Player
{
    /** This player's name. */
    private String name;
    
    /** The square where this player is located. */
    private Square location;
    
    /** The game board. */
    private Board board;
    
    /** The dice shared by all players. */
    private Dice dice;     
    
    /**
     * Constructs a new player with the specified name. The player is
     * placed in the board's starting square.
     *
     * @param name The player's name.
     * @param board The game board.
     * @param dice The dice shared by both players.
     */
    public Player(String name, Board board, Dice dice)
    {
        this.name = name;
        this.board = board;
        this.dice = dice;
        location = board.startingSquare();
    }
  
    /**
     * Rolls the dice and moves this player by the number of squares
     * equal to the value rolled. 
     */
    public void takeTurn()
    {
        int rollTotal = dice.roll();
        System.out.println(name + " rolled " + rollTotal);
        location = board.nextSquare(location, rollTotal); 
        System.out.println(name + " landed on " + location.description()); 
    }
}

    