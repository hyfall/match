package com.gelphiebigbang.writer;

import java.util.ArrayList;

import com.gelphiebigbang.artist.ArtStyle;
import com.gelphiebigbang.artist.Artist;
import com.gelphiebigbang.story.Story;

public class Writer {
    private String ID;
    private String email;
    private Boolean active;
    private Story story;
    private ArtStyle artStyle;

    // match categories
    private ArrayList<Artist> perfect = new ArrayList<Artist>();
    private ArrayList<Artist> great = new ArrayList<Artist>();
    private ArrayList<Artist> good = new ArrayList<Artist>();
    private ArrayList<Artist> fair = new ArrayList<Artist>();
    private ArrayList<Artist> poor = new ArrayList<Artist>();

    public Writer(String inputString){
        int index = inputString.indexOf(",");
        int activeInteger = Integer.parseInt(inputString.substring(0, index));
        if (activeInteger == 1){
            this.active = true;
        } else {
            this.active = false;
        }
        int lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        this.ID = inputString.substring(lastIndex, index);
        lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        this.email = inputString.substring(lastIndex, index);
        lastIndex = index + 1;
        index = inputString.indexOf("STORYEND");
        this.story = new Story(inputString.substring(lastIndex, index));
        // art styles
        lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        if (index == -1){ // no preference so all
            this.artStyle = new ArtStyle(true);
        } else {
            String preferredArtStyles = inputString.substring(lastIndex);
            this.artStyle = new ArtStyle(preferredArtStyles);
        }
    }

    public Story getStory() {
        return story;
    }

    public ArtStyle getArtStyle() {
        return artStyle;
    }

    public void addPerfect(Artist artist){
        this.perfect.add(artist);
    }

    public void addGreat(Artist artist){
        this.great.add(artist);
    }

    public void addGood(Artist artist){
        this.good.add(artist);
    }

    public void addFair(Artist artist){
        this.fair.add(artist);
    }

    public void addPoor(Artist artist){
        this.poor.add(artist);
    }

    public String writerCSVNumbers(){
        String line = email + "," + ID + "," + perfect.size() + "," + great.size() + "," + good.size() + "," + fair.size() + "," + poor.size() + ",";
        return line;
    }
    
}
