import java.util.*;
/**
 * Subclass of room, where players will go to teleport to other rooms
 *
 * @author (Abhiram Santhosh)
 * @version (12/11/17)
 */
public class TransporterRoom extends Room
{
    
    private ArrayList<Room> pRooms; //possible rooms to transport to
    /**
     * Constructor for the transporter room
     * 
     * @param String description, description of the room
     */
    public TransporterRoom(String description)
    {
        super(description);
        pRooms = new ArrayList<Room>();
    }
    
    /**
     * Choose a random room.
     *
     * @return Room, The room we end up in upon leaving this one.
     */
    private Room findRandomRoom()
    {
        //randomly search the arraylist of rooms

        Random r = new Random();
        int index = r.nextInt((pRooms).size());
        Room randomRoom = pRooms.get(index);
        
        return randomRoom;
    }
    
    /**
     * Pass the list of rooms to the transporter room so that the transporter room can
     * copy this list
     * 
     * @param ArrayList<Room> rooms, arraylist of all rooms in the game.
     */
    public void passedRooms(ArrayList<Room> rooms){
           
        for(Room r:rooms){
            pRooms.add(r);

        }
    }
    
    /**
     * Get the exit of the room, overide the superclass 
     * 
     * @param String direction, exit direction of the room
     * @return Room, returns the random room.
     */
    public Room getExit(String direction)
    {
        return findRandomRoom();
    }
}
