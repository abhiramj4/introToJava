
/**
 * Write a description of class Taxi here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Taxi extends Vehicle
{
    // instance variables - replace the example below with your own
    private Passenger passenger;
    
    /**
     * Constructor for objects of class Taxi
     */
    public Taxi(Company company, Location location)
    {
        super(company,location);
    }
    
    public void offloadPassenger(){
    
        passenger = null;
        clearTargetLocation();
    }
    
    public boolean isFree(){
    
        return getTargetLocation() == null && passenger == null;
    }

    public void pickUp(Passenger passenger){
    
        if(passenger == null){
            throw new NullPointerException("Passenger");
        } else if (this.passenger != null) {
            System.out.println("This taxi is full");
        } else {
            this.passenger = passenger;
        }
    }
    
    public void setPickupLocation(Location location){
        setTargetLocation(location);
    }
    
    public void act(){
        Location target = getTargetLocation();
    }
}
