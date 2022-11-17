import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//package com.zetcode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class FileService {
    private static FileService instance;

    private FileService() {
    }

    public static FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public static List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    public static void writeCSV(String filepath, String[] account) {
        File file = new File(filepath);
        try {
            FileWriter outputfile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(outputfile);
            writer.writeNext(account);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void deleteRow(Account account, String path) {
        try {
            CSVReader reader2 = new CSVReader(new FileReader(path));
            List<String[]> allElements = reader2.readAll();
            int rowNumber = 0;
            for (String[] s : allElements) {
                rowNumber += 1;
                if (s[2].toString().equals(account.getEmail())) {
                    allElements.remove(rowNumber);
                    FileWriter sw = new FileWriter(path);
                    CSVWriter writer = new CSVWriter(sw);
                    writer.writeAll(allElements);
                    writer.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteRowByEmail(String email, String path) {
        try {
            CSVReader reader2 = new CSVReader(new FileReader(path));
            List<String[]> allElements = reader2.readAll();
            int rowNumber = 0;
            for (String[] s : allElements) {
                rowNumber += 1;
                if (s[2].toString().equals(email)) {
                    allElements.remove(rowNumber);
                    FileWriter sw = new FileWriter(path);
                    CSVWriter writer = new CSVWriter(sw);
                    writer.writeAll(allElements);
                    writer.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

