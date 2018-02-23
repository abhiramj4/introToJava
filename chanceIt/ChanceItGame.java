
import java.util.*;
/**
 * ChanceItGame plays the game of Chance-It, the simple dice game
 * introduced by Joel Adams at Calvin College in the late 1990's.
 *
 * The only change from the version discussed in class is that there is
 * now just one Player class (player1 and player2 are both instances of
 * Player).
 *
 * @author D.L. Bailey & L.S. Marshall, SCE, Carleton University
 * @version 1.04 September 23, 2007
 */

public class ChanceItGame
{
    /** The number of rounds in a game.*/
    private int numberOfRounds;
    private ArrayList<Player> players;
    private Dice dice;

    /** The player who takes the first turn in each round. */
    private Player player1;

    /** The player who takes the second turn in each round. */
    private Player player2;

    /**
     * The score obtained by the player who most recently took a turn.
     */
    private int turnScore;
    private Integer[] x;
    /**
     * Constructs a new Chance-It game with the specified number of
     * rounds.
     *
     * @param rounds The number of rounds in a game.
     * @param player1Name The name of the player who takes the first
     * turn in each round.
     * @param player2Name The name of the player who takes the second
     * turn in each round.
     */
    public ChanceItGame(int rounds)
    {
        numberOfRounds = rounds;
        players = new ArrayList<Player>();
        dice = new Dice();
    }

    /**
     * Plays one game of Chance-It.
     */
    
    public void addPlayer(String playerName){
        Player p = new Player(dice,playerName);
        players.add(p);
    
    }
    
    public void playGame()
    {
        /* Reset both players' total scores. Doing this here allows us
         * to play multiple games without having to create a new
         * ChanceItGame object (and therefore new player objects) each
         * time.
         */
        if(players.size() < 2){
            System.out.println("There are only two players");
        } else {
            for(Player p:players){
                p.resetTotalScore();
            }
        }

        for (int round = 1; round <= numberOfRounds; round++) {
            playOneRound(round);
        }
        //announceResults();
    }

    /**
     * Play one round of the game.
     *
     * @param round the round number.
     */
    private void playOneRound(int round)
    {
        System.out.println("Round " + round + ":");

        // The first player takes a turn.
        
        for(Player p: players){
        
            int count = 0;
            if(turnScore == 0){
                turnScore = p.takeTurn(turnScore);
                count++;
            } else {
                turnScore = p.takeTurn((players.get(count).score()));
            }
        
        }
        
    }

    /**
     * Determines which player won the game or if there is a tie,
     * and displays the results.
     */
    private void announceResults()
    {
        if (player1.score() > player2.score()) {
            System.out.println(player1.name() + " wins the game.");
        } else if (player1.score() < player2.score()) {
            System.out.println(player2.name() + " wins the game.");
        } else {
            System.out.println("We have a tie."); 

        }
    }
} 
