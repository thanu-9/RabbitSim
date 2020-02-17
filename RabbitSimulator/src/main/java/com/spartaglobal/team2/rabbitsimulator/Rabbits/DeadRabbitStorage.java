package com.spartaglobal.team2.rabbitsimulator.Rabbits;

public class DeadRabbitStorage {
    static private int deadRabbitsCounter=0;
    static private int rabbitsKilledByFoxes=0;

    public static int getRabbitsKilledByFoxes() {
        return rabbitsKilledByFoxes;
    }

    public int getNumberOfDeadRabbits() {
        return deadRabbitsCounter;
    }

    public void incrementDeadRabbits() {
        deadRabbitsCounter++;
    }

    public void incrementKilledRabbits() {
        rabbitsKilledByFoxes++;
    }
}
