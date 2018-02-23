
/**
 * Write a description of class Alarm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Alarm
{

    public boolean alarmSet; //boolean to see if the alarm is set
    ClockDisplay12 clock;
    public String period = "AM"; //default period for the alarm
    private String displayString = "Hello"; //this is the default so that there isn't a null pointer exception
    private String time;
    
    
    
    /**
     * Constructor for objects of class Alarm
     */
    public Alarm()
    {
        clock = new ClockDisplay12();
        alarmSet = false;
        period = "AM";
        updateDisplay();
    }
    
    /**
     * Constructor for objects of class Alarm with several parameters
     * It also creates a new clock object, this is because the alarm is a type of clock
     * This will allow us to access all the methods and fields that come with the clock
     */
    
    public Alarm(int hour, int minute, String amPm, boolean set)
    {

        clock = new ClockDisplay12(hour, minute, amPm);
        clock.hours.setValue(hour); //set the value of the hours of the clock to what was inputed 
        clock.minutes.setValue(minute); //set the minutes of the clock to what was inputed
        clock.period = amPm;
        updateDisplay();
        alarmSet = set; //set the alarm
    
    }
    
    /**
     * Set the clock hours, minutes, and period of what was inputed. 
     * Do this by accessing the clock object's hours, minutes and period.
     */
    
    public void SetTime(int hour, int minute, String amPm){
        
        clock.hours.setValue(hour);
        clock.minutes.setValue(minute);
        clock.period = amPm;
        updateDisplay();
        
    }
    
    /**
     * Set the alarm on
     */
    public void turnOn (){
        alarmSet = true;
    }
    
    /**
     * Set the alarm off
     */
    public void turnOff(){
        alarmSet = false;
    }
    
    /**
     * Check to see if the alarm is set to on or off
     */
    public boolean isSet(){
    
        if(alarmSet == true){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime(){
        
        return displayString;
  
    }
    
    /**
     * Update the internal string that represents the display.
     */
        private void updateDisplay()
    {
        //uses substrings to split up the period
        //makes sure that hours isn't 0
         if(clock.hours.getValue()==0){
            displayString = "12" + ":" + 
                        clock.minutes.getDisplayValue() + ((clock.period).toLowerCase()).substring(0,1) + "." + ((clock.period).toLowerCase()).substring(1);
        } else {
        
            displayString = clock.hours.getDisplayValue() + ":" + 
                        clock.minutes.getDisplayValue() + ((clock.period).toLowerCase()).substring(0,1) + "." + ((clock.period).toLowerCase()).substring(1);
        }
        
    }
    


}
