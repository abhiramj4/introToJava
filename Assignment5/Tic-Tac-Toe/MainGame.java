import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.sound.sampled.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * Write a description of class MainGame here.
 *
 * @author (Abhiram Santhosh)
 * @version (03-12-17)
 */
public class MainGame
{

    private Board gameBoard; //board that the game is played on
    private JFrame frame; //the frame of the game
    private JPanel mainPanel; //main panel where game runs
    private JPanel sidePanel; //panel on the side 
    private JSplitPane splitPane; //split the panel
    private JMenuItem newGame; //menu tiems
    private JMenuItem quitGame;

    private JTextField display; //display

    private int numFreeSquares = 9; //number of free squares
    private String winner = null;
    private String currentPlayer;

    private Boolean gameRun; //if the game is running or not

    public static final String PLAYER_X = "X"; // player using "X"
    public static final String PLAYER_O = "O"; // player using "O"
    public static  Boolean TIE = false; // game ended in a tie

    private static ImageIcon iconBlank; //blank image
    private static ImageIcon iconX; //x image
    private static ImageIcon iconO; //O image

    /**
     * Constructor for objects of class MainGame
     */
    public MainGame()
    {

        gameBoard = new Board();
        display = new JTextField();

        //initialize fonts
        Font font = new Font("Courier",Font.BOLD,20);
        Font font1 = new Font("Courier",Font.BOLD,16);

        //initialize icons
        iconBlank = new ImageIcon("blank.jpg", " ");
        iconX = new ImageIcon("X.jpg", "X");
        iconO = new ImageIcon("o.jpg", "O");

        //initialize the jframe
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setVisible(true);

        //initialize the menu bars
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Options");
        menuBar.add(fileMenu);
        fileMenu.setFont(font1);

        newGame = new JMenuItem("New game");
        fileMenu.add(newGame);
        newGame.setFont(font1);
        newGame.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //create a new game
                    gameBoard.clearBoard();
                    for(int i = 0; i < 3;i++){
                        for(int j = 0; j <3; j++){
                            (gameBoard.returnBoard())[i][j].setIcon(iconBlank);
                        }
                    }
                    currentPlayer = PLAYER_X;
                    numFreeSquares = 9;
                    display.setText("Tic Tac Toe! Player " + currentPlayer+ "'s turn");
                    gameRun = true;
                }

            });

        quitGame = new JMenuItem("Quit Game");
        fileMenu.add(quitGame);
        quitGame.setFont(font1);
        quitGame.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    gameBoard.clearBoard();
                    System.exit(0);
                }

            });

        //shortcuts to exit the game or to make a new game
        final int SHORTCUT = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,SHORTCUT));
        quitGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,SHORTCUT));

        //main panel for the tic tac toe board
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0,3));
        frame.add(mainPanel);

        //side panel where the display is
        sidePanel = new JPanel();

        splitPane = new JSplitPane();
        frame.getContentPane().setLayout(new GridLayout());
        frame.getContentPane().add(splitPane);

        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(350);
        splitPane.setTopComponent(mainPanel);
        splitPane.setBottomComponent(sidePanel);

        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

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

    }

    /**
     * Initialize the board and add an actionlistener to each cell
     * 
     */
    private void boardInit(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                (gameBoard.returnBoard())[i][j].setIcon(iconBlank);

                ((gameBoard.returnBoard())[i][j]).addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            //get the source of the actionevent
                            Cell source = (Cell)e.getSource();
                            //Perform the tic tac toe logic once the button
                            //is pressed
                            play(source);

                        }
                    });
                //add to the main panel.
                mainPanel.add((gameBoard.returnBoard())[i][j]);
            }
        }

    }

    /**
     * Play the game
     * 
     * @param Cell source, source of the button that was just clicked
     */
    private void play(Cell source){

        outerloop:
        while(gameRun == true){
            //run while game is going
            if(numFreeSquares == 0){
                TIE = true;
                break outerloop;
            }

            if(currentPlayer.equals(PLAYER_X)){
                if(source.getDescription().equals("X") || source.getDescription().equals("O")){
                    //if the player tries to press twice
                    display.setText("You can't do that");
                    break outerloop;
                } else {
                    //continue with the logic
                    source.setIcon(iconX);
                    source.setDescription("X");
                    numFreeSquares--;
                    //check if there is a winner, X or O
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
                    //if no winner, next player
                    currentPlayer = PLAYER_O;

                    display.setText("Player " + currentPlayer + "'s turn!");

                    break outerloop;
                }

            } else if(currentPlayer.equals(PLAYER_O)) {

                if(source.getDescription().equals("X") || source.getDescription().equals("O")){
                    display.setText("You can't do that");
                    break outerloop;
                } else {
                    source.setIcon(iconO);
                    source.setDescription("O");
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

    /**
     * Check for a winner
     * 
     * @return boolean true for win condition
     * @param int row, row the clicked cell, int col, column of the clicked cell
     */
    private boolean haveWinner(int row, int col){
        //Can't have a winner if the number of free squares
        //is above 4
        if(numFreeSquares > 4) return false;
        //check row on the button
        if((((gameBoard.returnBoard())[row][0]).getDescription()).equals(((gameBoard.returnBoard())[row][1]).getDescription()) 
        && (((gameBoard.returnBoard())[row][0]).getDescription()).equals(((gameBoard.returnBoard())[row][2]).getDescription() )) return true;
        //check column of the button
        if((((gameBoard.returnBoard())[0][col]).getDescription()).equals(((gameBoard.returnBoard())[1][col]).getDescription()) 
        && (((gameBoard.returnBoard())[0][col]).getDescription()).equals(((gameBoard.returnBoard())[2][col]).getDescription() )) return true;
        //check left to right diagonal
        if(row == col)
            if((((gameBoard.returnBoard())[0][0]).getDescription()).equals(((gameBoard.returnBoard())[1][1]).getDescription()) 
            && (((gameBoard.returnBoard())[0][0]).getDescription()).equals(((gameBoard.returnBoard())[2][2]).getDescription())) return true;
        //check right to left diagonal
        if(row == 2- col)
            if((((gameBoard.returnBoard())[0][2]).getDescription()).equals(((gameBoard.returnBoard())[1][1]).getDescription()) 
            && (((gameBoard.returnBoard())[0][2]).getDescription()).equals(((gameBoard.returnBoard())[2][0]).getDescription())) return true;
        //return false if none of the above statements pass
        return false;
    }

}
