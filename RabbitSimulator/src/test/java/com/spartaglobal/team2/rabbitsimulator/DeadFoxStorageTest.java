package com.spartaglobal.team2.rabbitsimulator;

import com.spartaglobal.team2.rabbitsimulator.Foxes.DeadFoxStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeadFoxStorageTest {
    DeadFoxStorage deadFoxStorage = new DeadFoxStorage();

    @Test
    public void testThatDeadFoxStorageInstantiatesToZero(){
        Assertions.assertEquals(0, deadFoxStorage.getNumberOfDeadFoxes());
    }

    @Test
    public void testThatDeadFoxCounterIncrementsCorrectly() {
        int deadBefore = deadFoxStorage.getNumberOfDeadFoxes() + 1;
        deadFoxStorage.incrementDeadFoxes();
        Assertions.assertEquals(deadBefore, deadFoxStorage.getNumberOfDeadFoxes());
    }

}
