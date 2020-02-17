package com.spartaglobal.team2.rabbitsimulator.Foxes;

public class DeadFoxStorage {
    static private int deadFoxCounter;

    public int getNumberOfDeadFoxes() {
        return deadFoxCounter;
    }

    public void incrementDeadFoxes() {
        deadFoxCounter++;
    }
}
