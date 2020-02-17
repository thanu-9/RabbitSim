package com.spartaglobal.team2.rabbitsimulator;

import com.spartaglobal.team2.rabbitsimulator.Foxes.AddNewFox;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxUpdater;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.AddNewRabbit;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.DeadRabbitStorage;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdater;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    public static void run() throws InterruptedException, IOException {
        RabbitUpdater rabbitUpdater = new RabbitUpdater();
        FoxUpdater foxUpdater = new FoxUpdater();
        rabbitUpdater.totalRabbitFileCleaner(); //cleans TotalRabbits file so that code can execute without previous run's data
        foxUpdater.totalFoxesFileCleaner();

        AddNewRabbit addNewRabbit = new AddNewRabbit("text\\TotalRabbits.csv");
        AddNewFox addNewFox = new AddNewFox("text\\TotalFoxes.csv");
        addNewRabbit.createRabbit("m");
        addNewRabbit.createRabbit("f"); //write the starting to TotalRabbits file
        addNewFox.createFox("m");
        addNewFox.createFox("f");

        /*
        Below is the Scanner which takes the input into the console
         */
        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        String strInput = null;
        while (!validInput) { //ensure that only numerical values are passed as an input
            System.out.print("How many months would you like to simulate?: ");
            strInput = in.nextLine();
            if (strInput.matches("-?\\d+(\\.\\d+)?")) {
                validInput = true;
            }
        }
        int simTime = Integer.parseInt(strInput);
        boolean validInput2 = false;
        String strInput2 = null;
        while(!validInput2){
            System.out.print("When do you want to release the foxes?: ");
            strInput2 = in.nextLine();
            if (strInput.matches("-?\\d+(\\.\\d+)?")) {
                validInput2 = true;
            }
        }
        int foxReleaseTime = Integer.parseInt(strInput);

        EnvironmentController environmentController = new EnvironmentController();
        environmentController.increaseTime(simTime, foxReleaseTime);
        //increase time in environment.
        // Can be changed to increaseTimeWithoutBirth to ensure both rabbits and foxes die after 60 months

        //print data to console
        RabbitDataRetriever rabbitDataRetriever = new RabbitDataRetriever();
        FoxDataRetriever foxDataRetriever = new FoxDataRetriever();

        //System.out.println();
        System.out.println("----- End Of Simulation Report -----");
        System.out.println();
        System.out.println("Number of rabbits alive:    " + rabbitDataRetriever.getNumOfRabbits());
        System.out.println("  Male:                     " + rabbitDataRetriever.getNumOfRabbits("m"));
        System.out.println("  Female:                   " + rabbitDataRetriever.getNumOfRabbits("f"));
        System.out.println("Number of dead rabbits:     " + rabbitDataRetriever.getNumOfDeadRabbits());
        System.out.println("  Killed by foxes:          " + DeadRabbitStorage.getRabbitsKilledByFoxes());
        System.out.println("  Death by old age:         " + (rabbitDataRetriever.getNumOfDeadRabbits() - DeadRabbitStorage.getRabbitsKilledByFoxes()));

        System.out.println();

        System.out.println("Total alive foxes:          " + foxDataRetriever.getNumOfFoxes());
        System.out.println("  Male:                     " + foxDataRetriever.getNumOfFoxes("m"));
        System.out.println("  Female:                   " + foxDataRetriever.getNumOfFoxes("f"));
        System.out.println("Total dead foxes:           " + foxDataRetriever.getNumOfDeadFoxes());

        rabbitUpdater.totalRabbitFileCleaner(); //cleans TotalRabbits file so that code can execute without previous run's data
        foxUpdater.totalFoxesFileCleaner();
    }
}