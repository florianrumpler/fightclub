package ss.week3.hotel;

import ss.week3.pw.Password;

/**
 * Safe in a Hotel room
 * @author Jesper Simon
 * @version 1.1.0
 */

public class Safe {
	//-------------------------Class variables--------------
	private boolean open;
	private boolean active;
	private Password password;
    
    //------------------Constructor-------------------------
    /**
     * Constructor of the safe, assigns a password.
     * @param pass A <code>String</code> with the safe's new password.
     */
    public Safe() { 
	   open = false;
       active = false;
       password = new Password();
    }
    
    //------------------------Methods-----------------------
    /**
     * Enables the <code>Safe</code> if the input matches the safe's password;
     * @param code A <code>String</code> which needs to be the same as the safe's password;
     */
    //@ requires code != null;
	//@ requires getPassword() != null;
	//@ ensures getPassword().testWord(pass) ==> isActive();
	public void activate(String code) {
		assert code != null;
		assert getPassword() != null;
		if (password.testWord(code)) {
			active = true;
		}
	}
	
	/**
     * Disables this <code>Safe</code>.
     */
	//@ requires !isOpen();
	//@ ensures !isActive();
	public void deactivate() {
		    open = false;
			active = false;
	}
	
	/**
     * Opens the safe if the code is correct.
     * @param code A <code>String</code> which has to be the same as the <code>Safe</code>'s password.
     */
	//@ requires getPassword() != null;
	//@ requires isActive();
	//@requires !isOpen();
    //@ ensures isActive() && getPassword().testWord(pass) ==> isActive();
	public void open(String code) {
		assert code != null;
		assert getPassword() != null;
		if (isActive() && password.testWord(code)) {
			open = true;
		}
	}
	
	/**
     * Closes this <code>Safe</code>.
     */
	//@ requires isActive();
	//@ requires isOpen();
	//@ ensures !isOpen();
	public void close() {
		open = false;
	}
	
	//-------------------------Queries----------------------
    /**
     * Checks if this <code>Safe</code> is active or not.
     * @return A <code>boolean</code> which says wether the safe is active or not.
     */
	/*@ pure */ public boolean isActive() {
		return active;
	}
	
	/**
     * Checks if this <code>Safe</code> is open or not.
     * @return A <code>boolean</code> which says wether the safe is open or not.
     */
	/*@ pure */ public boolean isOpen() {
		return open;
	}
	
	/**
     * Returns the <code>Password</code> of this <code>Safe</code>.
     * @return A <code>Password</code> of this <code>Safe</code>.
     */
	//@ ensures \result != null;
	/*@pure */ public Password getPassword() {
		return password ;
	}
}