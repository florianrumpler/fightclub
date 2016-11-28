package ss.week1;

import ss.week1.hotel.Guest;
import ss.week1.hotel.Room;

/**
 * Created by willem on 16-11-16.
 */
public class Main {
    private static Guest guest = new Guest("Karel");
    private static Room room = new Room(112);

    public static void main (String[] args){
        testEmployee();
    }

    private static void testEmployee () {
        guest.checkin(room);
        System.out.println(guest.toString());
        System.out.println(room.toString());
    }

    private static void testLamp () {
    }
}
