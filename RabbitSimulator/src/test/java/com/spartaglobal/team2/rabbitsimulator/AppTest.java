package com.spartaglobal.team2.rabbitsimulator;

import com.spartaglobal.team2.rabbitsimulator.Foxes.AddNewFox;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxUpdater;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.AddNewRabbit;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest {
    RabbitUpdater rabbitUpdater = new RabbitUpdater();
    FoxUpdater foxUpdater = new FoxUpdater();


    AddNewRabbit addNewRabbit = new AddNewRabbit("text\\TotalRabbits.csv");
    AddNewFox addNewFox = new AddNewFox("text\\TotalFoxes.csv");
    EnvironmentController environmentController = new EnvironmentController();
    RabbitDataRetriever rabbitDataRetriever = new RabbitDataRetriever();
    FoxDataRetriever foxDataRetriever = new FoxDataRetriever();

    public AppTest() throws IOException {
    }
    @BeforeEach
    public void run() throws InterruptedException, IOException {
        rabbitUpdater.totalRabbitFileCleaner(); //cleans TotalRabbits file so that code can execute without previous run's data
        foxUpdater.totalFoxesFileCleaner();
        addNewRabbit.createRabbit("m");
        addNewRabbit.createRabbit("f"); //write the starting to TotalRabbits file
        addNewFox.createFox("m");
        addNewFox.createFox("f");

        int simTime = 1;

        int foxReleaseTime = 20;

        environmentController.increaseTime(simTime, foxReleaseTime);
    }
    @Test
    public void testThatFoxesAre2() throws IOException {
        Assertions.assertEquals(2, foxDataRetriever.getNumOfFoxes());
    }
    @Test
    public void testThatRabbitsAre2() throws IOException {
        Assertions.assertEquals(2, rabbitDataRetriever.getNumOfRabbits());
    }
    @Test
    public void testThatRabbitsAreNotDead() throws IOException {
        Assertions.assertEquals(0, rabbitDataRetriever.getNumOfDeadRabbits());
    }
    @Test
    public void testThatFoxesAreNotDead() throws IOException {
        Assertions.assertEquals(0, foxDataRetriever.getNumOfDeadFoxes());
    }
}