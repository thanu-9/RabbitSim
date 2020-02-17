package com.spartaglobal.team2.rabbitsimulator;

import com.spartaglobal.team2.rabbitsimulator.Foxes.AddNewFox;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxDataRetriever;
import org.junit.jupiter.api.*;

import java.io.*;

public class TestAddNewFox {
    AddNewFox addNewFox = new AddNewFox("text\\TestAddNewFox.csv");
    FileWriter fileWriter = new FileWriter("text\\TestAddNewFox.csv", false);


    public TestAddNewFox() throws IOException {
    }

    @BeforeEach
    public void Clean() throws IOException {
        BufferedWriter bufferedTempWriter = new BufferedWriter(fileWriter);
        bufferedTempWriter.write("");
    }
    public void Adder () throws IOException {

        addNewFox.createFox("m");
        addNewFox.createFox("f");
    }
    public long getNumOfFoxes() throws IOException { //returns number of all Foxes
        long counter = 0;
        File totalFoxes = new File("text\\TestAddNewFox.csv");
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
        File totalFoxes = new File("text\\TestAddNewFox.csv");
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
        File totalFoxes = new File("text\\TestAddNewFox.csv");
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

    @Test
    public void testThatFoxesAreAddedWhenToldToBeAdded () throws IOException {
        Adder();
        Assertions.assertEquals(2, getNumOfFoxes());
    }
    @Test
    public void testThatThereIsOneMaleFox () throws IOException {
        Adder();
        Assertions.assertEquals(1, getNumOfFoxes("m"));
    }
    @Test
    public void testThatThereIsOneFemaleFox () throws IOException {
        Adder();
        Assertions.assertEquals(1, getNumOfFoxes("f"));
    }
}
