package Logical.GetAward;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGetAward {
    GetAward ga = new GetAward();
    @Test
    public void TestGet(){
        assertEquals("加油",ga.get(1));
        assertEquals("厉害",ga.get(2));
        assertEquals("棒棒的",ga.get(3));
    }


}
