import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Cell here.
 *
 * @author (Abhiram Santhosh)
 * @version (-03-12-17)
 */
public class Cell extends JButton
{

    int row; //row of cell
    int col; //column of cell
    String description;
    /**
     * Constructor for objects of class Cell
     * 
     * @param int row, row of the cell, int col, column of the cell
     */
    public Cell(int row, int col)
    {
        super();
        this.row = row;
        this.col = col;
    }
    
    /**
     * Get row for this specific cell
     * 
     * @return int row, row of the cell
     */
    public int getRow(){
        return row;
    }
    
    /**
     * Get column for this specific cell
     * 
     * @return int col, col of the cell
     */
    public int getCol(){
        return col;
    }
    
    /**
     * Set description for this cell
     * 
     * @param String description, take the string description of the cell
     */
    public void setDescription(String description){
        this.description = description;
    }
    
    /**
     * get description for this cell
     * 
     * @return String, cell's description
     */
    public String getDescription(){
        return this.description;
    }
}
