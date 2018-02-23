/**
 * Player models the players in the game of Chance-It.
 *
 * @author D.L. Bailey & L.S. Marshall, SCE, Carleton University
 * @version 2.00 September 23, 2007
 */
public class Player
{
    /** The player's name. */
    private String name;

    /** The Dice object shared by all players. */
    private Dice pairOfDice;

    /** The value obtained by the most recent roll of the dice. */
    private int currentRoll;

    /**
     * The value obtained the first time that the dice are rolled
     * during a turn. During the turn, if the player rolls this value
     * a second time, the turn ends and the turn score for is 0.
     */
    private int firstRoll;

    /** The score obtained during the current turn. */
    private int turnScore;

    /**
     * The player's cumulative score; i.e., the sum of the turn scores
     * for all of the rounds played so far.
     */
    private int totalScore;

    /**
     * The most recent turnScore obtained by the other player. This
     * value may be useful when formulating the strategy that
     * determines when to stop rolling the dice.
     */
    private int opponentsTurnScore;

    /**
     * Constructs a new player using the specified dice.
     *
     * @param d The dice object shared by all players.
     * @param name The player's name.
     */
    public Player(Dice d, String myName)
    {
        pairOfDice = d; 

        name = myName;
        totalScore = 0;
    }

    /**
     * Resets this player's total score to 0.
     */
    public void resetTotalScore()
    {
        totalScore = 0;
    }

    /**
     * Returns this players's cumulative score.
     *
     * @return The sum of this player's turn scores for all of the
     * rounds played so far.
     */
    public int score()
    {
        return totalScore;
    }

    /**
     * Returns this player's name.
     *
     * @return The name of this player.
     */
    public String name()
    {
        return name;
    }

    /**
     * Takes one turn for this player.
     *
     * @param otherTurnScore The most recent turn score obtained by the
     * other player. This value may be useful when formulating
     * the strategy that determines when to stop rolling the
     * dice.
     * @return The score obtained by this player during the turn.
     */
    public int takeTurn(int otherTurnScore)
    {
        opponentsTurnScore = otherTurnScore;

        currentRoll = pairOfDice.roll();
        firstRoll = currentRoll;
        turnScore = currentRoll;
        System.out.println("\t\tFirst roll: " + firstRoll);

        for(int i = 0;i < 3;i++) {
            if (stopRolling(i)) {
                totalScore = totalScore + turnScore;
                System.out.println("\t\tStopping with turn score = " +
                    turnScore + ", total score = " + totalScore);
                return turnScore; 

            }

            currentRoll = pairOfDice.roll();
            System.out.println("\t\tNext roll: " + currentRoll);

            if (currentRoll == firstRoll) {
                turnScore = 0;
                System.out.println("\t\tOops! Rolled a match!");
                System.out.println("\t\tStopping with turn score = " +
                    turnScore + ", total score = " + totalScore);
                return turnScore;
            }

            // The current roll is not the same as the first roll.
            if (currentRoll > turnScore)
                turnScore = currentRoll;
        }
        return 0;
    }

    /**
     * Encapsulates the strategy used by this player to determine when
     * to stop rolling the dice during each turn.
     *
     * As currently implemented, the player will always decide to stop
     * when the current roll is 7 or higher.
     *
     * @return true when the player decides to end their current turn;
     * otherwise returns false.
     */
    private boolean stopRolling(int i)
    {
        if(currentRoll % 2 == 0 && currentRoll > 
        8 && currentRoll> opponentsTurnScore || i == 3 ){
            return true;
        } else {
            return false;
        }
    }
} 