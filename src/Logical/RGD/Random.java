package Logical.RGD;

import Logical.Data.OpData;

public class Random {
    public OpData Random() {
        // TODO implement here
        int a = (int)(Math.random()*9+1);
        int b = (int)(Math.random()*9+1);
        int c = (int)(Math.random()*2);
        OpData Data = new OpData(a,b,c);
        return Data;
    }

    public int RandomLine(int n){
        int a = (int)(Math.random()*n+1);
        return a;
    }
}
