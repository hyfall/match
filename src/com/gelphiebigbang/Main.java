package com.gelphiebigbang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.gelphiebigbang.writer.Writer;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // Parse Writers to Array
        ArrayList<Writer> writers = new ArrayList<Writer>();
        BufferedReader readWriters = new BufferedReader(new FileReader("writerresponse.csv"));
        String writerInput;
        while ((writerInput = readWriters.readLine()) != null){
            if (writerInput.startsWith("0")) {
                // dropping out
                continue;
            }
            Writer writer = new Writer(writerInput);
            writers.add(writer);
        }
    }
}
