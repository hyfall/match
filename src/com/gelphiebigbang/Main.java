package com.gelphiebigbang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.gelphiebigbang.artist.Artist;
import com.gelphiebigbang.match.Match;
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

        // go through each artist
        // find highest and lowest scores to make threshold barriers
        // use threshold and anything negative is poor
        // then cycle through every writer to see what where

        for(int i=0; i<artists.size(); i++){
            Artist checkingArtist = artists.get(i);
            // find thresholds
            int max = checkingArtist.getMaxScore();
            float threshold = (float)max / 3;
            for (int j=0; j<writers.size(); j++) {
                Writer checkingWriter = writers.get(j);
                Match.checkArtistAndWriter(checkingArtist, checkingWriter, max, threshold);
                // int score = checkingArtist.scoreWriter(checkingWriter, max, threshold);
                // System.out.println(score);
                // System.out.println(threshold);

                // on last index of artists + writers print to csv writers
            }
        }

    }
}
