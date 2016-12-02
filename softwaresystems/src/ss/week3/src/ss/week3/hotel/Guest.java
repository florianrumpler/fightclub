package ss.week3.hotel;

/**
 * Class guest for a hotel system
 * @author Jesper and Willem
 * @version 1.0.0
 */
public class Guest {
	// ------------------ Instance variables ----------------
	
    private String name;
    private Room room;
    
    // ------------------ Constructor ------------------------
    
    /**
     * Creates a <code>Guest</code> with the given name, without a room.
     * @param name of the new <code>Guest</code>.
     */
    public Guest (String name){
        this.name = name;
    }
    
    // ------------------ Queries --------------------------

    /**
     * Returns if the checkin into this <code>Room</code> was succesfull.
     * If succesfull assign a <code>Room</code> to this <code>Guest</code>.
     * @return if checkin into <code>Room</code> r was succesfull;
     *         False if this <code>Room</code> is currently rented
     *         or this <code>Guest</code> has already rented a room.
     * @param r the <code>Room</code> this <code>Guest</code> checked into.
     */
    public boolean checkin(Room r){
        if(this.room != null || r.getGuest() != null){
            return false;
        }else{
            room = r;
            r.setGuest(this);
            return true;
        }
    }

    /**
     * Returns if the checkout out of this <code>Room</code> was succesfull.
     * If succesfull set <code>Room</code> of this <code>Guest</code> to <code>null</code>.
     * @return if checkout out of <code>Room</code> r was succesfull;
     *         False if this <code>Guest</code> is not renting a room.
     */

    public boolean checkout() {
        if(this.room != null){
            room.setGuest(null);
            room = null;
            return true;
        }else{
            return false;
        }
    }
    /**
     * Returns the name of this <code>Guest</code>.
     * @return the name of this <code>Guest</code>.
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the current room this <code>Guest</code> is renting.
     * @return the room of this <code>Guest</code>;
     *         if no room is rented return <code>null</code>
     */
    public Room getRoom(){
        return room;
    }
    
    /**
     * Returns a description of this <code>Guest</code>.
     */
    public String toString() {
    	String result;
    	result = "The name of this guest is " + name + ".";
    	return result;
    }
}

