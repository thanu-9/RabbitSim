package com.spartaglobal.team2.rabbitsimulator;

import com.spartaglobal.team2.rabbitsimulator.Rabbits.DeadRabbitStorage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeadRabbitStorageTest {
    DeadRabbitStorage deadRabbitStorage = new DeadRabbitStorage();

    @Test
    @Order(1)
    public void testThatDeadRabbitStorageInstantiatesToZero(){
        Assertions.assertEquals(0, deadRabbitStorage.getNumberOfDeadRabbits());
    }

    @Test
    @Order(2)
    public void testThatRabbitsKilledByFoxesCounterInstantiatesToZero(){
        Assertions.assertEquals(0, DeadRabbitStorage.getRabbitsKilledByFoxes());
    }

    @Test
    @Order(3)
    public void testThatDeadRabbitCounterIncrementsCorrectly() {
        int deadBefore = deadRabbitStorage.getNumberOfDeadRabbits() + 1;
        deadRabbitStorage.incrementDeadRabbits();
        Assertions.assertEquals(deadBefore, deadRabbitStorage.getNumberOfDeadRabbits());
    }

    @Test
    @Order(4)
    public void testThatDeadRabbitsKilledByFoxesIncrementsCorrectly() {
        int killedBefore = DeadRabbitStorage.getRabbitsKilledByFoxes() + 1;
        deadRabbitStorage.incrementKilledRabbits();
        Assertions.assertEquals(killedBefore, DeadRabbitStorage.getRabbitsKilledByFoxes());
    }

}
