import java.util.*;
/**
 * Write a description of class Showroom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Showroom
{
    // instance variables - replace the example below with your own
    private ArrayList<Car> carList;

    /**
     * Constructor for objects of class Showroom
     */
    public Showroom()
    {
        carList = new ArrayList<Car>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int carIndex(String name, String comp){
    
        for(Car car: carList){
        
            if((car.getName()).equals(name) && (car.getComp()).equals(comp)){
            
                return carList.indexOf(car);
            }
        }
        return -1;
    
    }
    
    public void addCar(Car newCar){
    
        if(carList.contains(newCar)){
        
            (carList.get(carList.indexOf(newCar))).addStock();
        
        } else {
            carList.add(newCar);
            (carList.get(carList.indexOf(newCar))).addStock();
            
        }
    }
    
    public boolean borrowCar(String name, String comp){
    
        for(Car car: carList){
        
            if((car.getName()).equals(name) && (car.getComp()).equals(comp)
            ){
                car.removeStock();
                return true;
            }
        }
        return false;
    }
}
