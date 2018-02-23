
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    private int x;
    String s;
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        s = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void reverse(String s)
    {
       char[] array = s.toCharArray();
       char[] newString = new char[array.length];
       int j = 0;
       for(int i = array.length ; i >0; i--){
           
           newString[j] = array[i];
           j++;

        }
        
        for(char c: newString){
            System.out.println(c);
        }
       
    }
}
