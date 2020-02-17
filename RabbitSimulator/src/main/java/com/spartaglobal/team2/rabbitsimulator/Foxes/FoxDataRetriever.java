package com.spartaglobal.team2.rabbitsimulator.Foxes;

import java.io.*;

public class FoxDataRetriever {
    DeadFoxStorage deadFoxStorage = new DeadFoxStorage();

    public int getNumOfDeadFoxes() {
        return deadFoxStorage.getNumberOfDeadFoxes();
    }

    public long getNumOfFoxes() throws IOException { //returns number of all Foxes
        long counter = 0;
        File totalFoxes = new File("text\\TotalFoxes.csv");
        FileReader totalFoxesFileReader = new FileReader(totalFoxes); // A stream that connects to the text file
        BufferedReader bufferedTotalFoxesReader = new BufferedReader(totalFoxesFileReader); // Connect the FileReader to the BufferedReader
        while (bufferedTotalFoxesReader.readLine() != null) {
            counter++;
        }
        return counter;
    }

    public long getNumOfFoxes(String gender) throws IOException { //returns number of Foxes with given gender
        long counter = 0;
        String line;
        File totalFoxes = new File("text\\TotalFoxes.csv");
        FileReader totalFoxesFileReader = new FileReader(totalFoxes); // A stream that connects to the text file
        BufferedReader bufferedTotalFoxesReader = new BufferedReader(totalFoxesFileReader); // Connect the FileReader to the BufferedReader
        while ((line = bufferedTotalFoxesReader.readLine()) != null) {
            String[] array = line.split(", ");
            if (array[1].equals(gender)) {
                counter++;
            }
        }
        return counter;
    }

    public long getNumOfMatureFoxes(String gender) throws IOException { //returns number of foxes with given gender
        long counter = 0;
        String line;
        File totalFoxes = new File("text\\TotalFoxes.csv");
        FileReader totalFoxesFileReader = new FileReader(totalFoxes); // A stream that connects to the text file
        BufferedReader bufferedTotalFoxesReader = new BufferedReader(totalFoxesFileReader); // Connect the FileReader to the BufferedReader
        while ((line = bufferedTotalFoxesReader.readLine()) != null) {
            String[] array = line.split(", ");
            if (array[1].equals(gender) && array[2].equals("true")) {
                counter++;
            }
        }
        return counter;
    }

    public static long getNumberOfRabbitsToBeKilledByFoxes() throws IOException { //returns number of rabbits that are to be eaten by foxes
        long counter = 0;
        File totalFoxes = new File("text\\TotalFoxes.csv");
        FileReader totalFoxesFileReader = new FileReader(totalFoxes); // A stream that connects to the text file
        BufferedReader bufferedTotalFoxesReader = new BufferedReader(totalFoxesFileReader); // Connect the FileReader to the BufferedReader
        while (bufferedTotalFoxesReader.readLine() != null) {
            counter += (int)(Math.random()*20);
        }
        return counter;
    }
}