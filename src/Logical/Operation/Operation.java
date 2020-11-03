package Logical.Operation;

import Logical.ALU.Add;
import Logical.ALU.Algorithm;
import Logical.ALU.Sub;
import Logical.Data.OpData;
import Logical.RGD.Random;

public class Operation implements Operator{

    Algorithm alu;
    Random r = new Random();

    @Override
    public int Op_rule(OpData data) {
        switch(data.getData3()) {
            case 0:
                alu = new Add();
                return alu.Option(data.getData1(), data.getData2());
            case 1:
                alu = new Sub();
                return alu.Option(data.getData1(), data.getData2());
            default:
                return -1;
        }
    }

    @Override
    public OpData RandomData() {

        return r.Random();
    }

    @Override
    public int RandomLine(int n) {
        return r.RandomLine(n);
    }

}
