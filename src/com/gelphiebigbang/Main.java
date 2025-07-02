package com.gelphiebigbang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.gelphiebigbang.artist.Artist;
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

        // Parse Artists into ArrayList
        ArrayList<Artist> artists = new ArrayList<Artist>();
        BufferedReader readArtists = new BufferedReader(new FileReader("artistresponse.csv"));
        String artistInput;
        while ((artistInput = readArtists.readLine()) != null){
            if (artistInput.startsWith("0")) {
                // dropping out
                continue;
            }
            Artist artist = new Artist(artistInput);
            artists.add(artist);
        }
    }
}
