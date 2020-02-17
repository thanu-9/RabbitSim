package com.spartaglobal.team2.rabbitsimulator.Rabbits;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class AddNewRabbit {

    String fileName;

    public AddNewRabbit(String fileName) {
        this.fileName = fileName;
    }

    //create rabbit of gender given
    public void createRabbit(String gender) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, true); // A stream that connects to the text file
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // Connect the FileWriter to the BufferedWriter

        if (gender.equals("m")) {
            bufferedWriter.write("0" + ", " + "m" + ", " + "false" + ", " + "false"); // age, gender, maturity, pregnant
            bufferedWriter.newLine();
        } else if (gender.equals("f")) {
            bufferedWriter.write("0" + ", " + "f" + ", " + "false" + ", " + "false");// age, gender, maturity, pregnant
            bufferedWriter.newLine();
        } else {
            System.out.println("Select m or f");
        }

        bufferedWriter.close(); // Close the stream
    }
}

