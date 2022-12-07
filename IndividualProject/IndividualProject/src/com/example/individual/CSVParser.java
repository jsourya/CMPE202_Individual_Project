package com.example.individual;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser implements Parser{
    ArrayList<String> tokens = new ArrayList<>();

    public CSVParser() {
    }

    @Override
    public ArrayList<String> parse(String path) {
        CSVReader reader = null;
        try
        {

            reader = new CSVReader(new FileReader(path));
            reader.skip(1);
            String [] nextLine;

            while ((nextLine = reader.readNext()) != null)
            {
                tokens.add(nextLine[0]);
            }

            return tokens;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void write(String file, ArrayList<String> data) {
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "CardNumber", "CardType"};
            writer.writeNext(header);

            // add data to csv
            for (String a: data
                 ) {
                String[] d = a.split(",");
                writer.writeNext(d);
            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
