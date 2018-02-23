import java.util.ArrayList;

public class Train
{
    /** The cars in this train. */
    private ArrayList<Car> cars;

    /** 
     * Constructs an empty train; i.e., one that has no cars.
     */
    public Train()
    {
        cars = new ArrayList<Car>();
    }

    /**
     * Adds the specified car to this train.
     */
    public void addCar(Car car)
    {

        cars.add(car);
    }

    /**
     * Returns this trains's list of cars. This method is intended for 
     * testing purposes only, and should not be called by other objects,
     * as it may be removed from the final version of this class.
     * 
     * @return A list of the cars in the train
     */
    public ArrayList<Car> cars()
    {
        return cars;
    }    

    /**
     * Attempts to issue a ticket for a business class seat or an
     * economy class seat, as specified by the method's argument.
     * It will attempt to book a seat in the first car of the appropriate
     * type, but if a seat is not available it will attempt to book a seat
     * in the second car of the appropriate type, and so on. 
     * A request to issue a ticket in a business-class car will never result
     * in a seat being reserved in an economy-class car, and vice-versa. 
     * Returns true if successful, false otherwise.
     */
    public boolean issueTicket(boolean businessClassSeat)
    {

        //look for seat in first car
        
        for(Car car: cars){
            //check if car is business class
          
            if(car.isBusinessClass() == businessClassSeat){
                
if(car.bookNextSeat()){
    
                return true;
}
            
                
            } 
        }

        return false;
    }

    /**
     * Cancels the ticket for the specified seat in the specified car.
     * Returns true if successful, false otherwise.
     */
    public boolean cancelTicket(int carId, int seatNo)
    {
        if(carId < 0 || seatNo < 0){
            return false;
        }
        
        for(Car car: cars){
            if(car.id() == carId){
                //we have the right car
                if(car.cancelSeat(seatNo)){
                    return true;
                }
            }
        }
        return false;
    }
}
