import junit.framework.TestCase;

import org.junit.Test;

public class BaseChangerTest extends TestCase {

    @Test
    public void testFrom10ToX() {
        assertEquals("0", BaseChanger.from10ToX(0, 16));
        assertEquals("F", BaseChanger.from10ToX(15, 16));
        assertEquals("1001", BaseChanger.from10ToX(9, 2));
        assertEquals("27", BaseChanger.from10ToX(23, 8));
    }

    @Test
    public void testFromXTo10() {
        assertEquals(0, BaseChanger.fromXTo10("0", 16));
        assertEquals(15, BaseChanger.fromXTo10("F", 16));
        assertEquals(9, BaseChanger.fromXTo10("1001", 2));
        assertEquals(23, BaseChanger.fromXTo10("27", 8));
    }

}
