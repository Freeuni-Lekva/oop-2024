import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {
    @Test
    public void addZeroTest(){
        assertEquals(0, Math.add(0, 0));
        assertEquals(0, Math.add(-5, 5));
    }

    @Test
    public void negativesTest(){
        assertEquals(-15, Math.add(-5, -10));
        assertEquals(-14, Math.add(-4, -10));
        assertEquals(-13, Math.add(-3, -10));
    }

    @Test
    public void positivesTest(){
        assertEquals(1015, Math.add(1000, 15));
    }

    @Test
    public void positiveNegativeTest(){
        assertEquals(150, Math.add(200, -50));
        assertEquals(-150, Math.add(-200, 50));
    }

    @Test
    public void maxValueTest(){
        assertThrows(ArithmeticException.class, () -> {Math.add(Integer.MAX_VALUE, 1);});
    }
}