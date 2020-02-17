/*
package com.spartaglobal.team2.rabbitsimulator.Rabbits;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RabbitUpdaterWithoutBirth {

    File totalRabbits = new File("text\\TotalRabbits.csv");
    File temp = new File("text\\Temp.csv");
    DeadRabbitStorage deadRabbitStorage = new DeadRabbitStorage();


    public RabbitUpdaterWithoutBirth() throws IOException {
        //totalRabbitFileCleaner();
        tempFileCleaner();
    }

    public void incrementAge() throws IOException {

        FileWriter tempFileWriter = new FileWriter(temp, true);
        FileReader tempFileReader = new FileReader(temp);

        FileWriter totalRabbitsFileWriter = new FileWriter(totalRabbits, true);
        FileReader totalRabbitsFileReader = new FileReader(totalRabbits); // A stream that connects to the text file

        BufferedWriter bufferedTotalRabbitsWriter = new BufferedWriter(totalRabbitsFileWriter);
        BufferedReader bufferedTotalRabbitsReader = new BufferedReader(totalRabbitsFileReader); // Connect the FileReader to the BufferedReader

        BufferedWriter bufferedTempWriter = new BufferedWriter(tempFileWriter);
        BufferedReader bufferedTempReader = new BufferedReader(tempFileReader); // Connect the FileReader to the BufferedReader

        RabbitDataRetriever rabbitDataRetriever = new RabbitDataRetriever();

        tempFileCleaner();
        long matureMaleRabbitCount = rabbitDataRetriever.getNumOfMatureRabbits("m"); //get number of male rabbits (cant impregnate more than this number of females)
        long pregnantFemaleCount = 0;

        String line;
        while ((line = bufferedTotalRabbitsReader.readLine()) != null) { //do for each rabbit

            String[] array = line.split(", ");

            int i = Integer.parseInt(array[0]);
            i++; //increment age for rabbit

            if (i < 60) { // if the rabbits age is less than 60

                /// set maturity to true when older than 2
                if (i > 2) {
                    array[2] = "true";
                }

                bufferedTempWriter.write(i + ", " + array[1] + ", " + array[2] + ", " + array[3]); // age, gender, maturity, pregnant
                bufferedTempWriter.newLine();

            } else {
                deadRabbitStorage.incrementDeadRabbits();// if rabbits are > 59, increment the counter
            }
        }
        bufferedTotalRabbitsReader.close();
        bufferedTempWriter.close();
        totalRabbitFileCleaner();

        while ((line = bufferedTempReader.readLine()) != null) {
            bufferedTotalRabbitsWriter.write(line);
            bufferedTotalRabbitsWriter.newLine();
        }
        bufferedTempReader.close();
        bufferedTotalRabbitsWriter.close();

    }
    private void tempFileCleaner() throws IOException {
        FileWriter fileWriter = new FileWriter(temp, false);
        BufferedWriter bufferedTempWriter = new BufferedWriter(fileWriter);
        bufferedTempWriter.write("");
    }

    public void totalRabbitFileCleaner() throws IOException {
        FileWriter fileWriter = new FileWriter(totalRabbits, false);
        BufferedWriter bufferedTempWriter = new BufferedWriter(fileWriter);
        bufferedTempWriter.write("");
    }
}

*/
