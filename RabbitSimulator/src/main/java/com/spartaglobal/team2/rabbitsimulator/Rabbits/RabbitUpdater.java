package com.spartaglobal.team2.rabbitsimulator.Rabbits;

import com.spartaglobal.team2.rabbitsimulator.EnvironmentController;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxDataRetriever;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RabbitUpdater {
    File totalRabbits = new File("text\\TotalRabbits.csv");
    File temp = new File("text\\Temp.csv");
    DeadRabbitStorage deadRabbitStorage = new DeadRabbitStorage();

    public RabbitUpdater() throws IOException {
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

        String line;
        long rabbitsToKill = FoxDataRetriever.getNumberOfRabbitsToBeKilledByFoxes();
        //long totalNoOfLines = rabbitDataRetriever.getNumOfRabbits(); //number of lines in file
        while ((line = bufferedTotalRabbitsReader.readLine()) != null) { //do for each rabbit
            String[] array = line.split(", ");
            if (((rabbitsToKill < 0))) {//&& !(rabbitsToKill >= totalNoOfLines/2)) {/*&& (lineCount <= totalNoOfLines / 2)){*/  // foxes can kill rabbits if counter is not 0

                int ageIncrementer = Integer.parseInt(array[0]);
                ageIncrementer++; //increment age for rabbit

                if (ageIncrementer < 60) { // if the rabbits age is less than 60

                    // set maturity to true when older than 2
                    if (ageIncrementer > 2) {
                        array[2] = "true";
                    }

                    if (array[1].equals("f")) {
                        // this method comes before setting pregnant to ensure rabbits dont give birth immediately
                        if (array[3].equals("true")) { //if a rabbit is pregnant and is female
                            giveBirth(); //create a new rabbit
                            array[3] = "false"; //set rabbit to no longer pregnant
                        }

                        // if there are still unmated mature males, and this rabbit is a mature female
                        if ((matureMaleRabbitCount > 0) && array[2].equals("true")) {
                            array[3] = "true";
                            matureMaleRabbitCount--;
                        }
                    }
                    bufferedTempWriter.write(ageIncrementer + ", " + array[1] + ", " + array[2] + ", " + array[3]); // age, gender, maturity, pregnant
                    bufferedTempWriter.newLine();
                } else {
                    deadRabbitStorage.incrementDeadRabbits(); // if rabbits are > 59mo, increment the counter
                }
            } else {//if ((rabbitsToKill > 0)&&(lineCount >= totalNoOfLines / 2)) {
                deadRabbitStorage.incrementDeadRabbits();
                deadRabbitStorage.incrementKilledRabbits();
                rabbitsToKill--;
            }
        }
        bufferedTotalRabbitsReader.close();
        bufferedTempWriter.close();
        totalRabbitFileCleaner();

        while ((line = bufferedTempReader.readLine()) != null) { // writing back from temp to rabbit file
            bufferedTotalRabbitsWriter.write(line);
            bufferedTotalRabbitsWriter.newLine();
        }
        bufferedTempReader.close();
        bufferedTotalRabbitsWriter.close();
    }

    private void giveBirth() throws IOException {
        AddNewRabbit addNewRabbit = new AddNewRabbit("text\\TotalRabbits.csv");
        int max = 14;
        int min = 1;
        int rabbitsToCreate = (int) (Math.random() * ((max - min) + 1)) + min; //create random number between max and min

        for (int i = 0; i < rabbitsToCreate; i++) { //create between min and max new rabbits
            List<String> gender = new ArrayList<>();
            gender.add("m");
            gender.add("f"); //add male and female as options for genders
            if (Math.random() >= 0.50) {
                Collections.shuffle(gender); //randomises m/f in array
                addNewRabbit.createRabbit(gender.get(0)); //creates new rabbit with random gender
            }
        }
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

