package com.example.individual;

public class ParserFactory {
    public static Parser getParser(String file){
        if(file.endsWith(".csv")){
            return new CSVParser();
        }
        else if(file.endsWith(".json")){
            return new JSONParser();
        }
        else {
            return new XMLParser();
        }

    }
}
