package com.spartaglobal.team2.rabbitsimulator.Foxes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddNewFox {
    String fileName;

    public AddNewFox(String fileName) {
        this.fileName = fileName;
    }

    public void createFox(String gender) throws IOException {
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