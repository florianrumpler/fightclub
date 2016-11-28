package ss.week2.hotel;

/**
 * Hotel room with number and possibly a guest.
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class Room {
    // ------------------ Instance variables ----------------

    private int number;
    private Guest guest;
    private Safe safe;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param no number of the new <code>Room</code>
     */
    public Room(int no, Safe safe) {
    	number = no;
        this.safe = safe;
        safe.setRoom(this);
    }

    // ------------------ Queries --------------------------

    /**
     * Returns the number of this <code>Room</code>.
     */
    public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     * @return the guest of this <code>Room</code>;
     *         <code>null</code> if this <code>Room</code>
     *         is not currently rented
     */
    public Guest getGuest() {
    	return guest;
    }

    // ------------------ Commands --------------------------

    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     * @param g the next guest renting this <code>Room</code>;
     *        if <code>null</code> is inputted, this <code>Room</code>
     *        is empty afterwards
     */
    public void setGuest(Guest g) {
    	guest = g;
    }

    /**
     * Returns a <code>String</code> which describes this <code>Room</code>.
     * @return A <code>String</code> with the description of the room, it
     *         shows this <code>Room</code>s number and <code>Guest</code>.
     */
    public String toString() {
        String description;
        description = "Room ";
        description += number;
        if(guest != null){
            description += " is booked by " + guest.getName();
        }else{
            description += " is still empty";
        }
        description += ".";
        return description;
    }

    /**
     * Assigns an already instantiated <code>Safe</code> to this <code>Room</code>.
     * @param safe A <code>Safe</code> which is assigned to this <code>Room</code>.
     */
    public void setSafe(Safe safe) {
        this.safe = safe;
    }

    /**
     * Removes this <code>Safe</code> from this <code>Room</code>.
     */
    public void removeSafe() {
        safe.setRoom(null);
        safe = null;
    }

    /**
     * Returns the <code>Safe</code> of this <code>Room</code>.
     * @return The <code>Safe</code> of this <code>Room</code>;
     * null if this <code>Room</code> isn't assigned to a <code>Safe</code>.
     */
    /*@ pure */public Safe getSafe() {
        return safe;
    }
}
