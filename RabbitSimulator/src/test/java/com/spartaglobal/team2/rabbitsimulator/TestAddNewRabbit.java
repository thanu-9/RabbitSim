package com.spartaglobal.team2.rabbitsimulator;

import com.spartaglobal.team2.rabbitsimulator.Rabbits.AddNewRabbit;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitDataRetriever;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;


public class TestAddNewRabbit {
    AddNewRabbit addNewRabbit = new AddNewRabbit("text\\TestAddNewRabbit.csv");
    FileWriter fileWriter = new FileWriter("text\\TestAddNewRabbit.csv", false);

    public TestAddNewRabbit() throws IOException {
    }

    @BeforeEach
    public void Clean() throws IOException {
        BufferedWriter bufferedTempWriter = new BufferedWriter(fileWriter);
        bufferedTempWriter.write("");
    }
    public void Adder () throws IOException {

        addNewRabbit.createRabbit("m");
        addNewRabbit.createRabbit("f");
    }

    public long getNumOfRabbits() throws IOException { //returns number of all rabbits
        long counter = 0;
        File totalRabbits = new File("text\\TestAddNewRabbit.csv");
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
        File totalRabbits = new File("text\\TestAddNewRabbit.csv");
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
        File totalRabbits = new File("text\\TestAddNewRabbit.csv");
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

    @Test
    public void testThatRabbitsAreAddedWhenToldToBeAdded() throws IOException {
        Adder();
        Assertions.assertEquals(2, getNumOfRabbits());
    }
    @Test
    public void testThatRabbitsAreNotEmptyWhenAdded() throws IOException {
        Adder();
        Assertions.assertNotEquals(0, getNumOfRabbits());
    }

    @Test
    public void testThatThereIsOneMaleRabbit() throws IOException {
        Adder();
        Assertions.assertEquals(1, getNumOfRabbits("m"));
    }

    @Test
    public void testThatThereIsNotZeroMales() throws IOException {
        Adder();
        Assertions.assertNotEquals(0, getNumOfRabbits("m"));
    }

    @Test
    public void testThatThereIsOneFemaleRabbit() throws IOException {
        Adder();
        Assertions.assertEquals(1, getNumOfRabbits("f"));
    }
    @Test
    public void testThereAreNoMatureMaleRabbit() throws IOException {
        Adder();
        Assertions.assertEquals(0, getNumOfMatureRabbits("m"));
    }
    @Test
    public void testThereAreNoMatureFemaleRabbit() throws IOException {
        Adder();
        Assertions.assertEquals(0, getNumOfMatureRabbits("f"));
    }

}
