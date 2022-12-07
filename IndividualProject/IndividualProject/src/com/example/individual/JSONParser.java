package com.example.individual;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class JSONParser implements Parser {
    public JSONParser() {
    }

    @Override
    public ArrayList<String> parse(String path) {
        ArrayList<String> tokens= new ArrayList<>();
        org.json.simple.parser.JSONParser parser1 = new org.json.simple.parser.JSONParser();
        try {
            FileReader reader = new FileReader(path);
            Object obj = parser1.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject j = (JSONObject) jsonArray.get(i);
                tokens.add((String) j.get("cardNumber"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return tokens;

    }

    @Override
    public void write(String file, ArrayList<String> d) throws IOException {
        FileWriter file1 = new FileWriter(file);
        JSONArray jsonArr= new JSONArray();
        for (String a: d
        ) {
            String[] d1 = a.split(",");
            JSONObject j = new JSONObject();
            j.put("cardNumber", d1[0]);
            j.put("cardType", d1[1]);
            jsonArr.add(j);

        }

        try {
            file1.write(jsonArr.toJSONString());
            file1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
