import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A class modelling a tic-tac-toe (noughts and crosses, Xs and Os) game in a very
 * simple GUI window.
 * 
 * @author Lynn Marshall
 * @version November 8, 2012
 */

public class TicTacToeFrame 
{ 
    private JTextArea status; // text area to print game status
    private JFrame frame;

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;

    private String player;   // current player (PLAYER_X or PLAYER_O)

    private String winner;   // winner: PLAYER_X, PLAYER_O, TIE, EMPTY = in progress

    private int numFreeSquares; // number of squares still free

    private String board[][]; // 3x3 array representing the board

    public static final String PLAYER_X = "X"; // player using "X"
    public static final String PLAYER_O = "O"; // player using "O"
    public static final String EMPTY = " ";  // empty cell
    public static final String TIE = "T"; // game ended in a tie
    public static String boardString = "";

    /** 
     * Constructs a new Tic-Tac-Toe board and sets up the basic
     * JFrame containing a JTextArea in a JScrollPane GUI.
     */
    public TicTacToeFrame()
    { 
        //super();
        board = new String[3][3];

        JScrollPane scrollPane = new JScrollPane(status); 

        frame = new JFrame("GUI STUFF");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0,3));
        frame.add(mainPanel);

        b1 = new JButton("Start");
        mainPanel.add(b1);

        b2 = new JButton();
        b2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            }); 
        mainPanel.add(b2);

        b3 = new JButton();
        b3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            });
        mainPanel.add(b3);

        b4 = new JButton();
        b4.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            });
        mainPanel.add(b4);

        b5 = new JButton();
        b5.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            });
        mainPanel.add(b5);

        b6 = new JButton();
        b6.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            });
        mainPanel.add(b6);

        b7 = new JButton();
        b7.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            });
        mainPanel.add(b7);

        b8 = new JButton();
        b8.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            });
        mainPanel.add(b8);

        b9 = new JButton();
        b9.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            });
        mainPanel.add(b9);

        frame.pack();
        playGame();
    }

    public void playGame()
    {

        clearBoard(); // clear the board

        // print starting board

        // loop until the game ends
        while (winner==EMPTY) { // game still in progress
            b1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){

                }
            });
            board[][] = player;        // fill in the square with player
            numFreeSquares--;            // decrement number of free squares

            // see if the game is over
            if (haveWinner(row,col)) 
                winner = player; // must be the player who just went
            else if (numFreeSquares==0) 
                winner = TIE; // board is full so it's a tie

            // print current board

            // change to other player (this won't do anything if game has ended)
            if (player==PLAYER_X) 
                player=PLAYER_O; 
            else 
                player=PLAYER_X;
        }

    } 

    private void clearBoard()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
        winner = EMPTY;
        numFreeSquares = 9;
        player = PLAYER_X;     // Player X always has the first turn.
    }

    private boolean haveWinner(int row, int col) 
    {
        // unless at least 5 squares have been filled, we don't need to go any further
        // (the earliest we can have a winner is after player X's 3rd move).

        if (numFreeSquares>4) return false;

        // Note: We don't need to check all rows, columns, and diagonals, only those
        // that contain the latest filled square.  We know that we have a winner 
        // if all 3 squares are the same, as they can't all be blank (as the latest
        // filled square is one of them).

        // check row "row"
        if ( board[row][0].equals(board[row][1]) &&
        board[row][0].equals(board[row][2]) ) return true;

        // check column "col"
        if ( board[0][col].equals(board[1][col]) &&
        board[0][col].equals(board[2][col]) ) return true;

        // if row=col check one diagonal
        if (row==col)
            if ( board[0][0].equals(board[1][1]) &&
            board[0][0].equals(board[2][2]) ) return true;

        // if row=2-col check other diagonal
        if (row==2-col)
            if ( board[0][2].equals(board[1][1]) &&
            board[0][2].equals(board[2][0]) ) return true;

        // no winner yet
        return false;
    }
}