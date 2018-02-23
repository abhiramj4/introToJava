
/**
 * Abstract class Vehicle - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Vehicle
{
    // instance variables - replace the example below with your own
    private Company company;
    private Location location;
    private Location targetLocation;

    public Vehicle(Company company, Location location){
        if(company == null){
            throw new NullPointerException("company");
        } 
        if(location == null){
            throw new NullPointerException("location");
        }
    
        this.company = company;
        this.location = location;
        targetLocation = null;
    }
    //how the vehicle should behave
    public abstract void act();
    
    public abstract void setPickupLocation(Location location);
    
    public abstract void pickUp(Passenger passenger);
    
    public abstract boolean isFree();
    
    public abstract void offloadPassenger();
    
    public Location getTargetLocation(){
        return location;
    }
    
    public void setTargetLocation(Location location){
    
        if(location == null){
            throw new NullPointerException();
        } else {
            targetLocation = location;
        }
    }
    
    public void clearTargetLocation(){
        targetLocation = null;
    }
}
