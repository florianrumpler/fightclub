package ss.week1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by willem on 21-11-16.
 */
public class LampTest {
    public Lamp lamp = new Lamp();

    @Test
    public void testInitialState () {
        assertEquals("Off", lamp.getSetting());
    }

    @Test
    public void testSwitchState () {
        lamp.switchSetting();
        assertEquals("Low", lamp.getSetting());
        lamp.switchSetting();
        assertEquals("Medium", lamp.getSetting());
        lamp.switchSetting();
        assertEquals("High", lamp.getSetting());
    }

    @Test
    public void testModuloSwitch () {
        lamp.setSetting(3);
        lamp.switchSetting();
        assertEquals("Off", lamp.getSetting());
    }
}
