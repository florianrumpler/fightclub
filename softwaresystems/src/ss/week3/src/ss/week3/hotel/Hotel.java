package ss.week3.hotel;

import java.io.PrintStream;

import ss.week3.pw.Password;

public class Hotel {
	//@ private invariant rooms != null;
	private Password password;
	private Room[] rooms;
	private Guest[] guests;
	private String name;
	
	//@ requires name != null;
    //@ ensures rooms != null;
    //@ ensures guests != null;
	public Hotel(String name) {
		this.name = name;
		password = new Password();
		rooms = new Room[2];
		rooms[0] = new Room(001, new Safe());
		rooms[1] = new Room(002, new Safe());
		guests = new Guest[2];
	}
	
	//@ requires password != null;
    //@ requires name != null;
	public Room checkIn(String password, String name) {
		Room r = null;
        if(this.password.testWord(password) && getFreeRoom() != null && getRoom(name) == null){
            Guest guest = new Guest (name);
            r = getFreeRoom();
            guest.checkin(r);
            for(Guest g: guests){
                if (g == null) {
                    g = guest;
                    break;
                }
            }
        }
        return r;
    }

	//@ requires name != null;
    //@ ensures \old getRoom(name) == null;
    public void checkOut(String name){
        Room r = getRoom(name);
        if(r != null){
            r.getGuest().checkout();
            r.getSafe().deactivate();;
        }
    }
    
    public Bill getBill(String name, int no_nights, PrintStream theOutStream) {
    	Room room = getRoom(name);
    	Bill bill = new Bill(theOutStream);
    	if (room instanceof PricedRoom) {
    		for (int i = 0; i <= no_nights; i ++) {
    			PricedRoom r = (PricedRoom)room;
    			bill.newItem(r);
    			Safe safe = r.getSafe();
    			if (safe instanceof PricedSafe && safe.isActive()) {
    				PricedSafe s = (PricedSafe)safe;
    				bill.newItem(s);
    			}
    		}
    		return bill;
    	}
        return null;   
    }

    /*@ pure */public Room getFreeRoom(){
        for(Room r: rooms){
            if (r.getGuest() == null){
                return r;
            }
        }
        return null;
    }

    /*@ pure */public Room getRoom(String name){
        for(Room r: rooms){
            if (r.getGuest() != null && r.getGuest().getName().equals(name)){
                return r;
            }
        }
        return null;
    }

    /*@ pure */public Password getPassword(){
        return password;
    }

    /*@ pure */public String toString(){
        String result;
        result = "The hotel " + name + " has " + rooms.length + " rooms.";
        int i = 0;
        for(Room r: rooms){
            if(r.getGuest() != null){
                result += "Room " + r.getNumber() + " has a guest named " + r.getGuest().getName() + ".";
                result += "The status of the safe of room " + r.getNumber() + " is for if it is active: " + r.getSafe().isActive() + "and if it is open: " + r.getSafe().isOpen() + ".";
            }else{
            	result += "Room " + r.getNumber() + "is empty.";
            	result += "The status of the safe of room " + r.getNumber() + " is for if it is active: " + r.getSafe().isActive() + "and if it is open: " + r.getSafe().isOpen() + ".";
                i ++;
            }
        }
        result += "There are " + i + " empty rooms.";
        return result;
    }
}