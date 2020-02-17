package com.spartaglobal.team2.rabbitsimulator;

import oldFiles.RabbitLifecycle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRabbitLifecycle {
    RabbitLifecycle r2 = new RabbitLifecycle();

    public RabbitLifecycle getR2() {
        return r2;
    }

    @BeforeEach
     void createRabbit() throws InterruptedException {
        r2.increaseTime(60);

    }
    @Test
    public void testDeathCountIsCorrectValue() {
        Assertions.assertEquals(2, r2.getDeathToll());
    }
    @Test
    public void testDeathCountIsNotCorrect() {
        Assertions.assertNotEquals(1, r2.getDeathToll());
    }
}
