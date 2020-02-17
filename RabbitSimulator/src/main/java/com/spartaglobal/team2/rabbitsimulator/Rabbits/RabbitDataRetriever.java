package com.spartaglobal.team2.rabbitsimulator.Rabbits;

import java.io.*;

public class RabbitDataRetriever {
    DeadRabbitStorage deadRabbitStorage = new DeadRabbitStorage();

    public int getNumOfDeadRabbits(){
        return deadRabbitStorage.getNumberOfDeadRabbits();
    }

    public long getNumOfRabbits() throws IOException { //returns number of all rabbits
        long counter = 0;
        File totalRabbits = new File("text\\TotalRabbits.csv");
        FileReader totalRabbitsFileReader = new FileReader(totalRabbits); // A stream that connects to the text file
        BufferedReader bufferedTotalRabbitsReader = new BufferedReader(totalRabbitsFileReader); // Connect the FileReader to the BufferedReader
        while (bufferedTotalRabbitsReader.readLine() != null) {
            counter++;
        }
        return counter;
    }

    public long getNumOfRabbits(String gender) throws IOException { //returns number of rabbits with given gender
        long counter = 0;
        String line;
        File totalRabbits = new File("text\\TotalRabbits.csv");
        FileReader totalRabbitsFileReader = new FileReader(totalRabbits); // A stream that connects to the text file
        BufferedReader bufferedTotalRabbitsReader = new BufferedReader(totalRabbitsFileReader); // Connect the FileReader to the BufferedReader
        while ((line = bufferedTotalRabbitsReader.readLine()) != null) {
            String[] array = line.split(", ");
            if (array[1].equals(gender)) {
                counter++;
            }
        }
        return counter;
    }

    public long getNumOfMatureRabbits(String gender) throws IOException { //returns number of rabbits with given gender
        long counter = 0;
        String line;
        File totalRabbits = new File("text\\TotalRabbits.csv");
        FileReader totalRabbitsFileReader = new FileReader(totalRabbits); // A stream that connects to the text file
        BufferedReader bufferedTotalRabbitsReader = new BufferedReader(totalRabbitsFileReader); // Connect the FileReader to the BufferedReader
        while ((line = bufferedTotalRabbitsReader.readLine()) != null) {
            String[] array = line.split(", ");
            if (array[1].equals(gender) && array[2].equals("true")) {
                counter++;
            }
        }
        return counter;
    }
}
