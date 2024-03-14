import interfacesAndAbstractClass.Cat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// just an example, class is not fully tested
class CatTest {
    @Test
    public void testNoise(){
        Cat cat = new Cat();
        assertEquals(4, cat.legNum());
    }

}