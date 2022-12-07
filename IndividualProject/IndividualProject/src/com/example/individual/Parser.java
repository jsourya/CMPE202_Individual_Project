package com.example.individual;

import java.io.IOException;
import java.util.ArrayList;

public interface Parser {
    ArrayList<String> parse(String path);
    void write(String file, ArrayList<String> d) throws IOException;
}
