
/**
 * Write a description of class AlarmClock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AlarmClock
{
    // instance variables - replace the example below with your own
    ClockDisplay12 clock;
    Alarm alarm;
    private String displayString = "Hello";
    

    /**
     * Constructor for AlarmClock, creates a default clock and a default alarm (which creates a default clock as well
     * but the two clocks are seperate).
     */
    public AlarmClock()
    {
        clock = new ClockDisplay12();
        alarm = new Alarm();
        
    }
    
    /**
     * Constructor for AlarmClock, creates a clock with the input values and an alarm with the input values
     * (which creates a default clock as well, but the two clocks are seperate).
     */
    public AlarmClock(int hours, int minutes, String amPm,int hoursAlarm, int minutesA, String amPmA, boolean set)
    {
        clock = new ClockDisplay12(hours,minutes,amPm);
        alarm = new Alarm(hours,minutesA,amPmA,set);
    
    }
    
    /**
     * Set the time of the clock display to the specified hour,
     * minute and period.
     */
    public void setTime(int hours, int minutes,String amPm){
        clock.setTime(hours,minutes,amPm);        
    }
    
    /**
     * Set the time of the alarm display to the specified hour,
     * minute and period.
     */
    public void setAlarmTime(int hours, int minutes, String amPm){
    // access the clock created in alarm
        alarm.clock.setTime(hours,minutes,amPm);
        //alarm.clock.hours.setValue(hours);
        //alarm.clock.minutes.setValue(minutes);

    }
   
    /**
     * Invokes the timeTick method in the clock class to change the time of the clock then
     * updates the display and checks if the conditions are met before sounding the alarm
     * else, just continue like normal.
     */
    public void clockTick(){
        clock.timeTick();
        updateDisplay();
        
        if((clock.displayString).equals(alarm.clock.displayString) && alarm.alarmSet == true){
            System.out.println("RING RING RING");
        }
    
    }
    
    /**
     * Return the current time of this display in the format HH:MM.
     */    
    public String getTime(){
        return clock.displayString;
    }
    
    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getAlarmTime(){
        return alarm.clock.displayString;
    }
    
    /**
     * Set the alarm object's alarmSet field to true
     */
    public void setAlarm(){
    
        alarm.alarmSet = true;
    }
    
    /**
     * Set the alarm object's alarmSet field to false
     */
    public void unsetAlarm(){
    
        alarm.alarmSet = false;
    }
    
    /**
     * Return false if the alarm isn't set, return true if it is set
     */
    public boolean isAlarmSet(){
        if(alarm.alarmSet == true){
            return true;
        } else {
            return false;
        }
    
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
                        clock.minutes.getDisplayValue() + ((clock.period).toLowerCase()).substring(0,1) + "." + ((clock.period).toLowerCase()).substring(1);;
        } else {
        
            displayString = clock.hours.getDisplayValue() + ":" + 
                        clock.minutes.getDisplayValue() + ((clock.period).toLowerCase()).substring(0,1) + "." + ((clock.period).toLowerCase()).substring(1);;
        }
    }
    
}
