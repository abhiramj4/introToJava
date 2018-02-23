
/**
 * Write a description of class Experiment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Experiment
{
    // array of ints
    private int[] samples;
    public static final int SIZE = 10;

    /**
     * Constructor for objects of class Experiment
     */
    public Experiment()
    {
        samples = new int[SIZE];
       
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void fillArray()
    {
        for (int i = 0; i < SIZE; i++){
            
            //can use samples.length instead
            samples[i] = i;
        
        }
        
        samples[5] = 3;
        samples[0] = 7;
        samples[9] = 3;
       
    }
    
    public void printArray(){
    
        for(int element: samples){
            
            System.out.print(element + " ");
        }
        System.out.println();
            
        }
        
    public int occurrences(int target){
        
        int count = 0;
        for (int element: samples){
        
            if(element == target){
                count++;
            }
        
        }
        
        return count;
    }
        
    }
    
   

