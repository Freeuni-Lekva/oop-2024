package V1;

import V1.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testValue(){
        Node node = new Node(5);
        assertEquals(5.0, node.evaluate(), 0);
        assertEquals("5.0", node.toString());
    }

    @Test
    public void testAdd(){
        Node node = new Node('+', 5, 6);
        assertEquals(11.0, node.evaluate(), 0);
        assertEquals("(5.0+6.0)", node.toString());
    }

    @Test
    public void testMultiply(){
        Node node = new Node('*', 5, 6);
        assertEquals(30.0, node.evaluate(), 0);
        assertEquals("(5.0*6.0)", node.toString());
    }

    @Test
    public void testComplex(){
        Node left = new Node('*', 5, 6);
        Node right = new Node('-', 15, 20);
        Node node = new Node('/', left, right);
        assertEquals(-6.0, node.evaluate(), 0);
        assertEquals("((5.0*6.0)/(15.0-20.0))", node.toString());
    }
}
