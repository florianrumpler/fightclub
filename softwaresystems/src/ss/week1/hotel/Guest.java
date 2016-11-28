package ss.week1.hotel;

/**
 * Class guest for a hotel system
 * @author Jesper & Willem
 * @version 1.0.0
 */
public class Guest extends java.lang.Object{
    // ------------------ Instance variables ----------------

    private String name;
    private Room room;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Guest</code> with the given number, without a room
     * @param name name of the new <code>Guest</code>
     */
    public Guest (java.lang.String name){
        this.name = name;
    }

    // ------------------ Queries --------------------------s

    /**
     * Assigns a <code>Room</code> to this <code>Guest</code> if this <code>Guest</code>
     * hasn't allready got a ,<code>Room</code> and the <code>Room</code> must be empty
     * @param r <code>Room</code> the <code>Guest</code> get's checked in to
     * @return a <code>boolean</code> which is true if checkin() was succesfull
     *         otherwise it's false.
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
     * Checks out this <code>Guest</code> from its <code>Room</code> and
     * removes the <code>Guest</code> from the <code>Room</code>
     * @return a <code>boolean</code> which is true if checkout() was succesfull
     *         otherwise it returns false.
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
     * Returns the name of this <code>Guest</code>
     * @return a <code>String</code> with the name of this <code>Guest</code>
     */
    public java.lang.String getName(){
        return name;
    }

    /**
     * Returns the <code>Room</code> of this <code>Guest</code>
     * @return the <code>Room</code> of this <code>Guest</code>
     */
    public Room getRoom(){
        return room;
    }

    /**
     * Returns a <code>String</code> with a description of this <code>Guest</code>
     * including it's name and <code>Room</code> in a sentence.
     * @return a <code>String</code> with a description of this <code>Guest</code>
     */
    public java.lang.String toString(){
        String description;
        description = "Guest ";
        description += name;
        if (room != null) {
            description += " resides in " + room.getNumber();
        }else{
            description += " Has not yet checked in to a room";
        }
        description += ".";
        return description;
    }
}
