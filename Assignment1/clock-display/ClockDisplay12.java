
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay12
{
    public NumberDisplay hours;
    public NumberDisplay minutes;
    public String displayString;    // simulates the actual display
    private final String AM = "AM"; //display a.m or p.m
    private final String PM = "PM";
    public String period = "AM";
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(12, 0, AM);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay12(int hour, int minute, String amPm)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        if((amPm).equals(AM)){
            
            //Set the time to AM if the input of amPm is AM
            //update the period of day as AM
            //update the display
            setTime(hour, minute, AM);
            period = AM;
            updateDisplay();
        } 
        else if ((amPm).equals(PM)){
            
            //Set the time to AM if the input of amPm is PM
            //update the period of day as PM
            //update the display
            setTime(hour, minute, PM);
            period = PM;
            updateDisplay();
        } else {
            
            //handles a case where the input is neither am or pm, defaults to am
            setTime(hour, minute, AM);
            period = AM;
            updateDisplay();
        }
        
       
        
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            
            if ((period.toLowerCase()).equals(AM.toLowerCase())){
                period = PM;
            } else if ((period.toLowerCase()).equals(PM.toLowerCase())){
                period = AM;
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String amPm)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        period = amPm;
        updateDisplay();
        
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        //update displaystring
        //uses substrings to split up the period
        //makes sure that hours isn't 0
        if(hours.getValue()==0){
            
            displayString = "12" + ":" + 
                        minutes.getDisplayValue() + (period.toLowerCase()).substring(0,1)+"." + (period.toLowerCase()).substring(1);
        } else {
        
            displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + (period.toLowerCase()).substring(0,1)+"." + (period.toLowerCase()).substring(1);
        }
        
        
    }
    
    
    
}
