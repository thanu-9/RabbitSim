package com.spartaglobal.team2.rabbitsimulator.Foxes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoxUpdaterWithoutBirth {
    File totalFoxes = new File("text\\TotalFoxes.csv");
    File temp = new File("text\\TempFoxes.csv");
    DeadFoxStorage deadFoxStorage = new DeadFoxStorage();

    public FoxUpdaterWithoutBirth() throws IOException {
        tempFileCleaner();
    }

    public void incrementAge() throws IOException {

        FileWriter tempFileWriter = new FileWriter(temp, true);
        FileReader tempFileReader = new FileReader(temp);

        FileWriter totalFoxesFileWriter = new FileWriter(totalFoxes, true);
        FileReader totalFoxesFileReader = new FileReader(totalFoxes); // A stream that connects to the text file

        BufferedWriter bufferedTotalFoxesWriter = new BufferedWriter(totalFoxesFileWriter);
        BufferedReader bufferedTotalFoxesReader = new BufferedReader(totalFoxesFileReader); // Connect the FileReader to the BufferedReader

        BufferedWriter bufferedTempWriter = new BufferedWriter(tempFileWriter);
        BufferedReader bufferedTempReader = new BufferedReader(tempFileReader); // Connect the FileReader to the BufferedReader

        FoxDataRetriever FoxDataRetriever = new FoxDataRetriever();

        tempFileCleaner();
        long matureMaleFoxCount = FoxDataRetriever.getNumOfMatureFoxes("m"); //get number of male foxes (cant impregnate more than this number of females)
        long pregnantFemaleCount = 0;

        String line;
        while ((line = bufferedTotalFoxesReader.readLine()) != null) { //do for each fox

            String[] array = line.split(", ");

            int i = Integer.parseInt(array[0]);
            i++; //increment age for fox

            if (i < 60) { // if the foxes age is less than 60

                // set maturity to true when older than 2
                if (i > 9) {
                    array[2] = "true";
                }


                bufferedTempWriter.write(i + ", " + array[1] + ", " + array[2] + ", " + array[3]); // age, gender, maturity, pregnant
                bufferedTempWriter.newLine();

            } else {
                deadFoxStorage.incrementDeadFoxes();// if foxes are > 59, increment the counter
            }
        }
        bufferedTotalFoxesReader.close();
        bufferedTempWriter.close();
        totalFoxesFileCleaner();

        while ((line = bufferedTempReader.readLine()) != null) {
            bufferedTotalFoxesWriter.write(line);
            bufferedTotalFoxesWriter.newLine();
        }
        bufferedTempReader.close();
        bufferedTotalFoxesWriter.close();

    }


    private void tempFileCleaner() throws IOException {
        FileWriter fileWriter = new FileWriter(temp, false);
        BufferedWriter bufferedTempWriter = new BufferedWriter(fileWriter);
        bufferedTempWriter.write("");
    }

    public void totalFoxesFileCleaner() throws IOException {
        FileWriter fileWriter = new FileWriter(totalFoxes, false);
        BufferedWriter bufferedTempWriter = new BufferedWriter(fileWriter);
        bufferedTempWriter.write("");
    }
}
