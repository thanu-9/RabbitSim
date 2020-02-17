package com.spartaglobal.team2.rabbitsimulator;

import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxUpdater;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxUpdaterWithoutBirth;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdater;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdaterWithBirthWithoutDeath;
//import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdaterWithoutBirth;

import java.io.IOException;

public class EnvironmentController {

    public static int currentMonthCounter = 0;

    public void increaseTime(int time, int month) throws InterruptedException, IOException { //set to sleep
        RabbitUpdater rabbitUpdater = new RabbitUpdater();
        FoxUpdater foxUpdater = new FoxUpdater();
        RabbitUpdaterWithBirthWithoutDeath rabbitUpdaterWithBirthWithoutDeath = new RabbitUpdaterWithBirthWithoutDeath();
        int foxBreedPerYear = 0;

        for (int i = 0; i < time; i++) {
            currentMonthCounter++;
            if (currentMonthCounter >= month) { //after n months, rabbits can start to be killed by foxes //19 is a good number to ensure rabbits don't get killed immediately
                rabbitUpdater.incrementAge();
                //foxUpdater.incrementAge();
            } else {
                rabbitUpdaterWithBirthWithoutDeath.incrementAge();
                //foxUpdaterWithoutBirth.incrementAge();
            }
            foxUpdater.incrementAge(foxBreedPerYear);
            if(foxBreedPerYear < 12){
                foxBreedPerYear++;
            }else{foxBreedPerYear=0;}

            RabbitDataRetriever rabbitDataRetriever = new RabbitDataRetriever();

            System.out.println("Current month:          " + currentMonthCounter);
            System.out.println("Rabbits alive:          " + rabbitDataRetriever.getNumOfRabbits());
            System.out.println("  Male rabbits:         " + rabbitDataRetriever.getNumOfMatureRabbits("m"));
            System.out.println("  Female rabbits:       " + rabbitDataRetriever.getNumOfMatureRabbits("f"));
            FoxDataRetriever foxDataRetriever = new FoxDataRetriever();
            System.out.println("Foxes alive:            " + foxDataRetriever.getNumOfFoxes());
            System.out.println("  Male foxes:           " + foxDataRetriever.getNumOfFoxes("m"));
            System.out.println("  Female foxes:         " + foxDataRetriever.getNumOfFoxes("f"));
            System.out.println("Fox kills this month:   " + FoxDataRetriever.getNumberOfRabbitsToBeKilledByFoxes());
            System.out.println("-------------------------");
            System.out.println();
            Thread.sleep(1); //1000
        }
    }
/*
    public void increaseTimeWithoutBirth(int time) throws InterruptedException, IOException { //set to sleep
        RabbitUpdaterWithoutBirth rabbitUpdaterWithoutBirth = new RabbitUpdaterWithoutBirth();
        FoxUpdaterWithoutBirth foxUpdaterWithoutBirth = new FoxUpdaterWithoutBirth();
        for (int i = 0; i < time; i++) {
            rabbitUpdaterWithoutBirth.incrementAge();
            foxUpdaterWithoutBirth.incrementAge();
            Thread.sleep(1); //1000
        }
    }*/
}
