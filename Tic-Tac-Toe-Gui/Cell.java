import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Cell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cell extends JButton
{
    // instance variables - replace the example below with your own
    int row;
    int col;
    /**
     * Constructor for objects of class Cell
     */
    public Cell(int row, int col)
    {
        super();
        this.row = row;
        this.col = col;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
}
