
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.sound.*;


/**
 * Write a description of class MainGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainGame
{
    // instance variables - replace the example below with your own
    private Board gameBoard;
    private JFrame frame;
    private JPanel mainPanel; //main panel where game runs
    private JPanel sidePanel; //panel on the side 
    private JSplitPane splitPane;

    private JButton newGame;
    private JTextField display;

    private int numFreeSquares = 9;
    private String winner = null;
    private String currentPlayer;

    private Boolean gameRun;

    public static final String PLAYER_X = "X"; // player using "X"
    public static final String PLAYER_O = "O"; // player using "O"
    public static  Boolean TIE = false; // game ended in a tie

    private static Clip clip;
    public static AudioInputStream audioInputStream;
    
    /**
     * Constructor for objects of class MainGame
     */
    public MainGame()
    {
        gameBoard = new Board();
        newGame = new JButton();
        display = new JTextField();

        Font font = new Font("Courier",Font.BOLD,20);

        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0,3));
        frame.add(mainPanel);

        sidePanel = new JPanel();

        splitPane = new JSplitPane();
        frame.getContentPane().setLayout(new GridLayout());
        frame.getContentPane().add(splitPane);

        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(350);
        splitPane.setTopComponent(mainPanel);
        splitPane.setBottomComponent(sidePanel);

        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

        sidePanel.add(newGame);
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGame.setPreferredSize(new Dimension(250,40));
        newGame.setText("New Game");

        sidePanel.add(display);
        display.setAlignmentX(Component.CENTER_ALIGNMENT);
        display.setFont(font);
        display.setEnabled(false);

        boardInit();

        frame.pack();

        currentPlayer = PLAYER_X;

        gameRun = true;

        gameBoard.clearBoard();
        currentPlayer = PLAYER_X;
        numFreeSquares = 9;
        display.setText("Tic Tac Toe! Player " + currentPlayer+ "'s turn");

        newGame.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    gameBoard.clearBoard();
                    currentPlayer = PLAYER_X;
                    numFreeSquares = 9;
                    display.setText("Tic Tac Toe! Player " + currentPlayer+ "'s turn");
                    gameRun = true;
                }

            });
    }

    private void boardInit(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                ((gameBoard.returnBoard())[i][j]).addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            Cell source = (Cell)e.getSource();
                            play(source);
                        }
                    });
                mainPanel.add((gameBoard.returnBoard())[i][j]);
            }
        }

    }

    public void play(Cell source){

        outerloop:
        while(gameRun == true){
            //run while game is going
            if(numFreeSquares == 0){
                TIE = true;
                break outerloop;
            }

            if(currentPlayer.equals(PLAYER_X)){
                if(source.getText().equals("X") || source.getText().equals("O")){
                    display.setText("You can't do that");
                    break outerloop;
                } else {
                    
                    source.setText("X");
                    numFreeSquares--;
                    if(haveWinner(source.getRow(),source.getCol())){
                        winner = currentPlayer;
                        gameRun = false;
                        display.setText("Game over! Player " + currentPlayer + " wins!");
                        break outerloop;
                    } else if(numFreeSquares == 0){
                        display.setText("Game over! It's a tie");
                        gameRun = false;
                        break outerloop;
                    }
                    currentPlayer = PLAYER_O;
                    
                    display.setText("Player " + currentPlayer + "'s turn!");
                    
                    break outerloop;
                }

            } else if(currentPlayer.equals(PLAYER_O)) {

                if(source.getText().equals("X") || source.getText().equals("O")){
                    display.setText("You can't do that");
                    break outerloop;
                } else {
                    
                    source.setText("O");
                    numFreeSquares--;
                    if(haveWinner(source.getRow(),source.getCol())){
                        winner = currentPlayer;
                        gameRun = false;
                        display.setText("Game over! Player " + currentPlayer + " wins!");
                        break outerloop;
                    } else if(numFreeSquares == 0){
                        display.setText("Game over! It's a tie");
                        gameRun = false;
                        break outerloop;
                    }
                    currentPlayer = PLAYER_X;
                    display.setText("Player " + currentPlayer + "'s turn!");
                    

                    break outerloop;
                }

            }

        }
    }

    private boolean haveWinner(int row, int col){
        if(numFreeSquares > 4) return false;

        if((((gameBoard.returnBoard())[row][0]).getText()).equals(((gameBoard.returnBoard())[row][1]).getText()) 
        && (((gameBoard.returnBoard())[row][0]).getText()).equals(((gameBoard.returnBoard())[row][2]).getText() )) return true;

        if((((gameBoard.returnBoard())[0][col]).getText()).equals(((gameBoard.returnBoard())[1][col]).getText()) 
        && (((gameBoard.returnBoard())[0][col]).getText()).equals(((gameBoard.returnBoard())[2][col]).getText() )) return true;

        if(row == col)
            if((((gameBoard.returnBoard())[0][0]).getText()).equals(((gameBoard.returnBoard())[1][1]).getText()) 
            && (((gameBoard.returnBoard())[0][0]).getText()).equals(((gameBoard.returnBoard())[2][2]).getText())) return true;

        if(row == 2- col)
            if((((gameBoard.returnBoard())[0][2]).getText()).equals(((gameBoard.returnBoard())[1][1]).getText()) 
            && (((gameBoard.returnBoard())[0][2]).getText()).equals(((gameBoard.returnBoard())[2][0]).getText())) return true;

        return false;
    }
    

}
