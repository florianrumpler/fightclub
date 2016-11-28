package ss.week2.Test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.Safe;

/**
 * Created by willem on 23-11-16.
 */
public class SafeTest {
    private Safe safe;

    @Before
    public void initialize(){
        safe = new Safe("correct");
    }

    @Test
    public void testActivating() {
        assert (!safe.isActive());

        safe.activate("incorrect");
        assert (!safe.isActive());

        safe.activate("correct");
        assert (safe.isActive());
    }

    @Test
    public void testOpening() {
        safe.open("incorrect");
        assert (!safe.isOpen());

        safe.open("correct");
        assert (!safe.isOpen());

        safe.activate("correct");
        assert (!safe.isOpen());

        safe.open("incorrect");
        assert (!safe.isOpen());

        safe.open("correct");
        assert (safe.isOpen());
    }

    @Test
    public void testPassword() {
        assert (!safe.getPassword().testWord("incorrect"));
        assert (safe.getPassword().testWord("correct"));
    }

    @Test
    public void testClosing() {
        assert (!safe.isOpen());

        safe.activate("correct");
        safe.open("correct");
        safe.close();
        assert (!safe.isOpen());

        safe.open("correct");
        safe.deactivate();
        assert (!safe.isOpen());
    }

    @Test
    public void testDeactivating() {
        assert (!safe.isActive());

        safe.activate("correct");
        safe.deactivate();
        assert (!safe.isActive());

        safe.activate("correct");
        safe.open("correct");
        safe.deactivate();
        assert (!safe.isActive());
        assert (!safe.isOpen());
    }
}
