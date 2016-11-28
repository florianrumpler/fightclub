package ss.week2.hotel;

/**
 * Safe in a Hotel room
 * @author Willem
 * @version 1.1.0
 */
public class Safe {
    //-------------------------Class variables--------------
    private Password password;
    private boolean active;
    private boolean open;
    private Room room;

    //------------------Constructor-------------------------
    /**
     * Constructor of the safe, assigns a password.
     * @param pass A <code>String</code> with the safe's new password.
     */
    //@ ensures !isOpen();
    //@ ensures !isActive();
    public Safe (String pass){
        assert (pass != null);
        password = new Password();
        password.setWord(Password.INITIAL, pass);
        active = false;
        open = false;
    }

    //------------------------Methods-----------------------
    /**
     * Enables the <code>Safe</code> if the input matches the safe's password;
     * @param code A <code>String</code> which needs to be the same as the safe's password;
     */
    //@ requires password.testWord(code) || isActive();
    //@ ensures isActive();
    public void activate (String code){
        active = password.testWord(code) || active;
    }

    /**
     * Disables this <code>Safe</code>.
     */
    //@ ensures !isActive();
    //@ ensures !isOpen();
    public void deactivate () {
        active = false;
        open = false;
    }

    /**
     * Opens the safe if the code is correct.
     * @param code A <code>String</code> which has to be the same as the <code>Safe</code>'s password.
     */
    //@ requires code != null;
    //@ ensures password.testWord(code) ==> isOpen();
    public void open (String code) {
        assert (code != null);
        open = isActive() && password.testWord(code);
    }

    /**
     * Closes this <code>Safe</code>.
     */
    //@ ensures !isOpen();
    public void close () {
        open = false;
    }

    //-------------------------Queries----------------------
    /**
     * Checks if this <code>Safe</code> is active or not.
     * @return A <code>boolean</code> which says wether the safe is active or not.
     */
    //@ ensures \result == active;
    /*@ pure */public boolean isActive () {
        return active;
    }

    /**
     * Checks if this <code>Safe</code> is open or not.
     * @return A <code>boolean</code> which says wether the safe is open or not.
     */
    //@ ensures \result == open;
    /*@ pure */public boolean isOpen () {
        return open;
    }

    /**
     * Returns the <code>Password</code> of this <code>Safe</code>.
     * @return A <code>Password</code> of this <code>Safe</code>.
     */
    //@ ensures \result != null;
    /*@ pure */public Password getPassword () {
        return password;
    }

    /**
     * Assigns this <code>Safe</code> to an already instantiated <code>Room</code>.
     * @param room A <code>Room</code> where this <code>Safe</code> is located.
     */
    //ensures room.getSafe() == getRoom();
    public void setRoom(Room room){
        this.room = room;
        room.setSafe(this);
    }

    /**
     * Removes this <code>Safe</code> from it's <code>Room</code>.
     */
    //@ ensures getRoom == null;
    //@ ensures (\old(getRoom().getSafe() == null);
    public void removeRoom() {
        room.setSafe(null);
        room = null;
    }

    /**
     * Returns the <code>Room</code> of this <code>Safe</code>.
     * @return A <code>Room</code> where this <code>Safe</code> is located;
     * null if this <code>Safe</code> isn't assigned to a <code>Room</code>.
     */
    /*@ pure */public Room getRoom() {
        return room;
    }
}
