package org.example.exceptionHandling.ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WarehouseFileReader {

    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
