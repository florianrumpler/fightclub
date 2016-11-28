package ss.week2;

/**
 * This class defines a rectangle
 * @author Willem
 * @version 1.0.0
 */
public class Rectangle {
    //---------------Class variables-----------------
    //@ private invariant length >= 0;
    //@ private invariant width >= 0;
    private int length;
    private int width;

    //---------------Constructor---------------------
    //@ requires l >= 0 && w >= 0;
    public Rectangle(int l, int w){
        length = l;
        width = w;
    }

    //---------------Class methods-------------------
    //@ ensures /result >= 0
    /*@ pure */public int theLength () {
        return length;
    }

    //@ ensures /result >= 0
    /*@ pure */public int thewWidth (){
        return width;
    }

    //@ ensures /result >= 0
    /*@ pure */public int area () {
        return length*width;
    }

    //@ ensures /result >= 0
    /*@ pure */public int perimeter () {
        return 2*(length+width);
    }

}
