import java.util.*;
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Integer> list;
    private Integer [] y;
    private int count;

    /**
     * Constructor for objects of class test
     */
    public Test()
    {
        list = new ArrayList<Integer>();
        y = new Integer[10];
        count = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addNumber(int y)
    {
        list.add(y);
        this.y[count++]=y;
    }
    
    public boolean addNumberArray(Integer x){
    
        if(count == (this.y).length - 1 ){
        
            return false;
        }
        
        for(int i = 0; i < (this.y).length ;i++){
        
            if(this.y[i] == 0){
                //found an empty spot    
                this.y[i] = x;
                count++;
                return true;
            }
        
        }
        return false;
    }
    
    public void printArray(){
    
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
    public void printArr(){
    
        for(int i = 0; i < (this.y).length;i++){
        
            if(this.y[i] != 0){
                // print this
                System.out.println((this.y[i]));
            }
        }
    }
}
