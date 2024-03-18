import junit.framework.TestCase;

import java.awt.print.Printable;

public class RationalNumberTest extends TestCase {
    public void testAdd(){
        RationalNumber a = new RationalNumber(3, 10);
        RationalNumber b = new RationalNumber(2, 10);

        RationalNumber c = a.add(b);
        assertEquals(c, new RationalNumber(20, 40));
    }

    public void testMultiply(){
        RationalNumber a = new RationalNumber(3, 10);
        RationalNumber b = new RationalNumber(2, 10);

        RationalNumber c = a.multiply(b);
        RationalNumber d = new RationalNumber(-2, 10);

        assertEquals(c, new RationalNumber(3, 50));
        assertEquals(a.multiply(d), new RationalNumber(3, -50));
    }
}
