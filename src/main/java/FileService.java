import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
//package com.zetcode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

//Sigleton to work with CSV files
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

    //Returns List of Arrays with account data
    public static List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    //Writes new record to CSV
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

    //Deletes row in CSV by Account object, not used in code because deleting by email is more optimal
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

    //Deletes row by email, I understood that in this case it`s more convenient than by Account object
    public static void deleteRowByEmail(String email, String path) {
        try {
            CSVReader reader2 = new CSVReader(new FileReader(path));
            List<String[]> allElements = reader2.readAll();
            int rowNumber = 0;
            for (ListIterator<String[]> it = allElements.listIterator(); it.hasNext();) {
                String[] value = it.next();
                if (value.length <2){
                    continue;
                }
                rowNumber += 1;
                if (value[2].toString().equals(email)) {
                    it.remove();
                    FileWriter sw = new FileWriter(path);
                    CSVWriter writer = new CSVWriter(sw);
                    writer.writeAll(allElements);
                    writer.close();
                    sw.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

