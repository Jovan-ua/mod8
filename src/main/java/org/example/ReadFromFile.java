package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    public String readSql(String file) throws IOException {
        StringBuilder str = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null){
            str.append(line).append("\n");
        }
        }
        return str.toString();

    }
}