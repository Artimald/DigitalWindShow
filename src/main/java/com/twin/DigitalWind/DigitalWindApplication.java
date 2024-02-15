package com.twin.DigitalWind;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DigitalWindApplication {

    public static List<String[]> Noise;
    public static List<String[]> Reference;
    public static List<String[]> Efficiency;

    public static void main(String[] args) {
        SpringApplication.run(DigitalWindApplication.class, args);
        Reference = readCSV("csvFiles/Reference.csv");//Эталон
        Noise = readCSV("csvFiles/Noise.csv");//Зашумленный
        Efficiency = readCSV("csvFiles/KPD.csv");//КПД
    }

    private static List<String[]> readCSV(String csvFileName) {
        List<String[]> records = null;
        try (CSVReader reader = new CSVReader(new FileReader(csvFileName))) {
            records = reader.readAll();

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return records;
    }

}
