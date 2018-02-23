
/**
 * Write a description of class Board here.
 *
 * @author (Abhiram Santhosh)
 * @version (03-12-17)
 */
public class Board
{

    private int numFreeSquares; // number of squares still free

    private Cell board[][]; // 3x3 array representing the board

    //every cell in the board
    private Cell cell1;
    private Cell cell2;
    private Cell cell3;
    private Cell cell4;
    private Cell cell5;
    private Cell cell6;
    private Cell cell7;
    private Cell cell8;
    private Cell cell9;
    
    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        board = new Cell[3][3];
        
        cell1 = new Cell(0,0);
        cell2 = new Cell(0,1);
        cell3 = new Cell(0,2);
        
        cell4 = new Cell(1,0);
        cell5 = new Cell(1,1);
        cell6 = new Cell(1,2);
        
        cell7 = new Cell(2,0);
        cell8 = new Cell(2,1);
        cell9 = new Cell(2,2);
        
        board[0][0] = cell1;
        board[0][1] = cell2;
        board[0][2] = cell3;
        
        board[1][0] = cell4;
        board[1][1] = cell5;
        board[1][2] = cell6;
        
        board[2][0] = cell7;
        board[2][1] = cell8;
        board[2][2] = cell9;

        clearBoard();
    }
    
    /**
     * Clear board by setting cell text to empty
     * 
     */
    public void clearBoard()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setDescription("");
            }
        }
    }

    /**
     * Return the entire board array
     * 
     * @return Cell[][] board, 3x3 2d array of cells
     */
    public Cell[][] returnBoard(){
        return board;
    }
}
