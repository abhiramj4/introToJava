

public class Car
{
    /** This car's identifier. */
    private int id;
   
    /**
     * true == this car is a business-class car,
     * false == this car is an economy-class car.
     */
    private boolean businessClass;
    
    /** The cost of a business class seat, in dollars. */
    public static final double BUSINESS_SEAT_COST = 125.0;
    
    /** The cost of an economy class seat, in dollars. */
    public static final double ECONOMY_SEAT_COST = 50.0;    
  
    /** The number of seats in a business class car. */
    public static final int BUSINESS_SEATS = 30;   
    
    /** The number of seats in an economy class car. */
    public static final int ECONOMY_SEATS = 40;   
   
    /** The list of this car's seats. */
    private Seat[] seats;
    
    private int counter = 0;
    
    
   
    /**
     * Constructs a new Car object with the specified id.
     * If parameter isBusinessClass is true, the car is a business-class
     * car. If parameter isBusinessClass is false, the car is an
     * economy-class car.
     */
    public Car(int carId, boolean isBusinessClass)
    {
        businessClass = isBusinessClass;
        id = carId;
        if(isBusinessClass == true){
            //change this to 30
            seats = new Seat[30];
            for (int i = 0; i < 30; i++){
                seats[i] = new Seat(i + 1, BUSINESS_SEAT_COST);
            }
            
        } else {
            seats = new Seat[40];
            for (int i = 0; i < 40; i++){
                seats[i] = new Seat(i + 1, ECONOMY_SEAT_COST); 
            }
        }
         
        
    }

    /**
     * Returns this car's list of seats. This method is intended for 
     * testing purposes only, and should not be called by other objects,
     * as it may be removed from the final version of this class.
     * 
     * @return The seats in this car, an array of Seat objects.
     */
    public Seat[] seats()
    {
        return seats;
    }
 
    /** 
     * Returns true if this is a business-class car,
     * false if this is an economy-class car.
     */
    public boolean isBusinessClass()
    {
        if (businessClass == true){
            return true;
        } else{
            return false;
        }
        
    }
 
    /**
     * Returns the id of this car.
     */
    public int id()
    {
        return id;
    }
  
    /**
     * This method is called when the specified seat has been booked,
     * to print a ticket for that seat.
     * 
     * @param seatNo The integer identifier of the seat.
     */
    private void printTicket(int seatNo)
    {
        System.out.println("Car ID: " + id);
        System.out.println("Seat number: " + seatNo);
        System.out.println("Price: ");
        if (businessClass) {
            System.out.println(BUSINESS_SEAT_COST);
        } else {
            System.out.println(ECONOMY_SEAT_COST);
        }
    }   
 
    /**
     * Attempts to book a seat. If successful, this method prints a 
     * ticket and returns true.
     * If no seats are available, this method returns false.
     */
    public boolean bookNextSeat()
    {
        // After booking an available seat, print the ticket by calling
        // private method printTicket(); e.g.,
        // printTicket(seats[i].number());
        
        
        if(businessClass != true){
            
            for(int i = 0;i < ECONOMY_SEATS; i++){
                if(!seats[i].isBooked()){
                
                    seats[i].book();
                    printTicket(seats[i].number());
                    return true;
                }
                
                    if(i==ECONOMY_SEATS -1){
                    
                    return false;
                    }
                
            }
        
        }
        
        
        if(businessClass = true){
            for(int i = 0;i < BUSINESS_SEATS; i++){
                if(!seats[i].isBooked()){
                
                    seats[i].book();
                    printTicket(i);
                    return true;
                }
                
                    if(i==BUSINESS_SEATS -1){
                    
                    return false;
                    }
                
            }   
        
        }
        
 
        
        
        
       return true;
    }

    /** 
     * Cancels the booking for the specified seat, which must be between
     * 1 and the maximum number of seats in the car.
     * If the seat number is valid and if the seat has been reserved, this
     * method cancels the booking for that seat and returns true. 
     * If the seat number is not valid, this method returns false. 
     * If the seat number is valid, but the seat has not been reserved, 
     * this method returns false.
     */
    public boolean cancelSeat(int seatNo)
    {
        //loop thru array x amount till seat
        //cancel booking if isBooked returns true
        
          if(seatNo<=seats.length && seatNo > 0 && seats[seatNo-1].isBooked()){
            seats[seatNo -1].cancelBooking();
            return true;
            
            }
           
        
        
        return false;
    }    
}
