package Logical.ALU;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAlgorithm {
    @Test
    public void testAdd(){
        Algorithm al = new Add();
        assertEquals(2,al.Option(1,1));
        assertEquals(5,al.Option(2,3));
        assertEquals(0,al.Option(0,0));
        assertEquals(0,al.Option(-1,1));
    }

    @Test
    public void testSub(){
        Algorithm al = new Sub();
        assertEquals(0,al.Option(1,1));
        assertEquals(-1,al.Option(2,3));
        assertEquals(1,al.Option(3,2));
        assertEquals(-1,al.Option(0,1));
    }
}
