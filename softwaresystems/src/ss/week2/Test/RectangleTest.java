package ss.week2.Test;

import org.junit.Test;
import ss.week2.Rectangle;

/**
 * Test Rectangle class
 * @author Willem
 * @version 1.0.0
 */
public class RectangleTest {

    private Rectangle r;

    @Test
    public void testConstructor(){
        r = new Rectangle(2,1);
        assert (r.theLength() == 2);
        assert (r.thewWidth() == 1);
        r = new Rectangle(0,5);
        assert (r.theLength() == 0);
        assert (r.thewWidth() == 5);
        r = new Rectangle(5,0);
        assert (r.theLength() == 5);
        assert (r.thewWidth() == 0);
    }

    @Test
    public void testArea(){
        r = new Rectangle(2,1);
        assert (r.area() == 2);
        r = new Rectangle(0,4);
        assert (r.area() == 0);
        r = new Rectangle(3,2);
        assert (r.area() == 6);
    }

    @Test
    public void testPerimeter(){
        r = new Rectangle(2,1);
        assert (r.perimeter() == 6);
        r = new Rectangle(0,0);
        assert (r.perimeter() == 0);
        r = new Rectangle(0,5);
        assert (r.perimeter() == 10);
    }
}
