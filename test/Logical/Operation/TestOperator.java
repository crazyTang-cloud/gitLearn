package Logical.Operation;

import Logical.Data.OpData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOperator {
    Operator op = new Operation();
    @Test
    public void TestOp_rule(){
        OpData od1 = new OpData(3,5,0);
        OpData od2 = new OpData(6,4,1);
        assertEquals(8,op.Op_rule(od1));
        assertEquals(2,op.Op_rule(od2));
    }
}
