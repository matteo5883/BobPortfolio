package main.java.service;

import main.java.model.CryptoItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseFileService implements IParseFileService {

    public List<CryptoItem> parseFile(String filename) {

        List<CryptoItem> items = new ArrayList<>();
        try (BufferedReader br
                     = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("=");
                items.add(new CryptoItem().setSymbol(split[0]).setValue(Long.valueOf(split[1])));
            }
        } catch (IOException e) {
            System.out.println("Could not open file passed as input (" + filename + "). Pass a valid input as first argument or don't pass nothing and use the default file");
            System.out.println("**********************");
            e.printStackTrace();
        }
        return items;

    }
}
