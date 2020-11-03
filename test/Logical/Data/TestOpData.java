package Logical.Data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOpData {
    OpData od = new OpData(3,4,1);
    @Test
    public void TestData1(){
        assertEquals(3,od.getData1());
    }

    @Test
    public void TestData2(){
        assertEquals(4,od.getData2());
    }

    @Test
    public void TestData3(){
        assertEquals(1,od.getData3());
    }
}
