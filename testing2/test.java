
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    private int x[];

    /**
     * Constructor for objects of class test
     */
    public test()
    {
        // initialise instance variables
        x = new int [10];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean add(int y)
    {
      for(int i = 0; i <10 ; i++){
          
          if(x[i] == 0){
              x[i] = y;
              return true;
            }
        
        }
      return false;
    }
}
