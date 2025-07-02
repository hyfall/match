package com.gelphiebigbang.artist;

import java.util.ArrayList;

import com.gelphiebigbang.story.Rating;
import com.gelphiebigbang.story.Romance;
import com.gelphiebigbang.story.Setting;
import com.gelphiebigbang.story.Story;
import com.gelphiebigbang.story.Tone;
import com.gelphiebigbang.story.Triggers;
import com.gelphiebigbang.writer.Writer;

public class Artist {
    private String ID;
    private String email;
    private Boolean active;
    private Boolean over18;
    private Story story;
    private ArtStyle artStyle;

    // ratings
    private Boolean RatingTeen = false;
    private Boolean RatingMature = false;
    private Boolean RatingExplicit = false;

    // rank
    private int toneRank = 1;
    private int romanceRank = 1;
    private int settingRank = 1;

    // match categories
    private ArrayList<Writer> perfect = new ArrayList<Writer>();
    private ArrayList<Writer> great = new ArrayList<Writer>();
    private ArrayList<Writer> good = new ArrayList<Writer>();
    private ArrayList<Writer> fair = new ArrayList<Writer>();
    private ArrayList<Writer> poor = new ArrayList<Writer>();

    public Artist(String inputString){
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
        index = inputString.indexOf(",", lastIndex);
        int over18Integer = Integer.parseInt(inputString.substring(lastIndex, index));
        if (over18Integer == 1){
            this.over18 = true;
        } else {
            this.over18 = false;
        }
        lastIndex = index + 1;
        index = inputString.indexOf("END", lastIndex);
        this.artStyle = new ArtStyle(inputString.substring(lastIndex, index));
        lastIndex = index + 4;
        index = inputString.indexOf(",", lastIndex);
        int triggerCheck = Integer.parseInt(inputString.substring(lastIndex, index));
        lastIndex = index + 1;
        index = inputString.indexOf("END", lastIndex);
        Triggers triggers;
        switch (triggerCheck) {
            case 0:
                triggers = new Triggers(true);
                break;
            case 2:
                triggers = new Triggers(false);
                break;
            case 1:
            default:
                triggers = new Triggers(inputString.substring(lastIndex, index));
                break;
        }
        lastIndex = index + 4;
        index = inputString.indexOf("END", lastIndex);
        if (inputString.substring(lastIndex, index).contains("Teen (T)")) {
            this.RatingTeen = true;
        }
        if (inputString.substring(lastIndex, index).contains("Mature (M)") && this.over18) {
            this.RatingMature = true;
        }
        if (inputString.substring(lastIndex, index).contains("Explicit (E)") && this.over18) {
            this.RatingExplicit = true;
        }
        lastIndex = index + 4;
        index = inputString.indexOf(",", lastIndex);
        int gelphieShip = Integer.parseInt(inputString.substring(lastIndex, index));
        lastIndex = index + 1;
        index = inputString.indexOf("END", lastIndex);
        Tone tone;
        Romance romance;
        Setting setting;
        if (inputString.substring(lastIndex, index).contains("No preference")){
            tone = new Tone();
        } else {
            tone = new Tone(inputString.substring(lastIndex, index));
        }
        lastIndex = index + 4;
        index = inputString.indexOf("END", lastIndex);
        if (inputString.substring(lastIndex, index).contains("No preference")){
            romance = new Romance();
        } else {
            romance = new Romance(inputString.substring(lastIndex, index));
        }
        lastIndex = index + 4;
        index = inputString.indexOf("END", lastIndex);
        if (inputString.substring(lastIndex, index).contains("No preference")){
            setting = new Setting();
        } else {
            setting = new Setting(inputString.substring(lastIndex, index));
        }
        lastIndex = index + 4;
        index = inputString.indexOf("END", lastIndex);
        tone.setNo(inputString.substring(lastIndex, index));
        romance.setNo(inputString.substring(lastIndex, index));
        setting.setNo(inputString.substring(lastIndex, index));

        this.story = new Story(tone, romance, setting, triggers, gelphieShip);

        lastIndex = index + 4;
        index = inputString.indexOf(",", lastIndex);
        String rank1 = inputString.substring(lastIndex, index);
        if (rank1.equalsIgnoreCase("Tone/Mood")) {
            this.toneRank = 3;
        } else if (rank1.equalsIgnoreCase("Romantic Dynamics")) {
            this.romanceRank = 3;
        } else {
            this.settingRank = 3;
        }
        lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        String rank2 = inputString.substring(lastIndex, index);
        if (rank2.equalsIgnoreCase("Tone/Mood")) {
            this.toneRank = 2;
        } else if (rank2.equalsIgnoreCase("Romantic Dynamics")) {
            this.romanceRank = 2;
        } else {
            this.settingRank = 2;
        }
    }

    public Boolean getOver18() {
        return over18;
    }

    public ArtStyle getArtStyle() {
        return artStyle;
    }

    public Boolean getRatingTeen() {
        return RatingTeen;
    }

    public Boolean getRatingMature() {
        return RatingMature;
    }

    public Boolean getRatingExplicit() {
        return RatingExplicit;
    }

    public Story getStory() {
        return story;
    }

    public int getToneRank() {
        return toneRank;
    }

    public int getRomanceRank() {
        return romanceRank;
    }

    public int getSettingRank() {
        return settingRank;
    }

    public int getMaxScore(){
        int max = 5; // matched art style
        max += this.story.getTone().maxScore(toneRank);
        max += this.story.getRomance().maxScore(romanceRank);
        max += this.story.getSetting().maxScore(settingRank);
        return max;
    }

    public Boolean checkRating(Rating rating){
        switch (rating) {
            case TEEN:
                if(this.RatingTeen){
                    return true;
                } else return false;  
            case MATURE:
                if(this.RatingMature){
                    return true;
                } else return false;
            case EXPLICIT:
                if(this.RatingTeen){
                    return true;
                } else return false;  
        }
        return false;
    }

    public void addPerfect(Writer writer){
        this.perfect.add(writer);
    }

    public void addGreat(Writer writer){
        this.great.add(writer);
    }

    public void addGood(Writer writer){
        this.good.add(writer);
    }

    public void addFair(Writer writer){
        this.fair.add(writer);
    }

    public void addPoor(Writer writer){
        this.poor.add(writer);
    }

    public String artistCSVNumbers(){
        String line = email + "," + ID + "," + perfect.size() + "," + great.size() + "," + good.size() + "," + fair.size() + "," + poor.size() + ",";
        return line;
    }
}
