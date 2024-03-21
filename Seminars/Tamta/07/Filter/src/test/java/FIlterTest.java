import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FIlterTest {
    private Filter filter;

    @Before
    public void init() {
        filter = new BitmaskFilter();
    }
    @Test
    public void testIsPresent() {
        for (int i = 0; i < 15; i++) {
            filter.add(i);
            assertTrue(filter.isPresent(i));
            assertFalse(filter.isPresent(i+1));
        }
    }

    @Test
    public void testSize() {
        assertEquals(0, filter.size());
        for (int i = 0; i < 15; i++) {
            filter.add(i);
            assertEquals(i+1, filter.size());
        }
    }

    @Test
    public void testAdd() {
        assertEquals(0, filter.size());
        for (int i = 0; i < 1000; i++) {
            if (i % 100 == 0) {
                filter.add(i);
                assertTrue(filter.isPresent(i));
            } else {
                assertFalse(filter.isPresent(i));
            }
        }
    }

    @Test
    public void testRemove() {
        assertEquals(0, filter.size());
        for (int i = 0; i < 100; i++) {
            filter.add(i);
        }

        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) filter.remove(i);
        }

        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) assertFalse(filter.isPresent(i));
            else assertTrue(filter.isPresent(i));
        }
    }
}
