

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DogTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DogTest
{
    private Farm farm;
    /**
     * Default constructor for test class DogTest
     */
    public DogTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
        farm = new Farm();
    }

    @Test
    public void testDoSomething(){
        String resultString = farm.doSomething();
        String expectedString = "Ribbit!Woof!";
        assertEquals(resultString,expectedString);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        farm = null;
    }
}
