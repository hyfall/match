package com.gelphiebigbang.artist;

import com.gelphiebigbang.story.Romance;
import com.gelphiebigbang.story.Setting;
import com.gelphiebigbang.story.Story;
import com.gelphiebigbang.story.Tone;
import com.gelphiebigbang.story.Triggers;

public class Artist {
    private String ID;
    private String email;
    private Boolean active;
    private Boolean over18;
    private Story story;
    private ArtStyle artStyle;

    // ratings
    private Boolean RatingGen = false;
    private Boolean RatingTeen = false;
    private Boolean RatingMature = false;
    private Boolean RatingExplicit = false;

    // rank
    private int toneRank = 3;
    private int romanceRank = 3;
    private int settingRank = 3;

    public Artist(String inputString){
        int index = inputString.indexOf(",");
        this.active = Boolean.parseBoolean(inputString.substring(0, index));
        int lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        this.ID = inputString.substring(lastIndex, index);
        lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        this.email = inputString.substring(lastIndex, index);
        lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        this.over18 = Boolean.parseBoolean(inputString.substring(lastIndex, index));
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
        if (inputString.substring(lastIndex, index).contains("General (G)")) {
            this.RatingGen = true;
        }
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
            this.toneRank = 1;
        } else if (rank1.equalsIgnoreCase("Romantic Dynamics")) {
            this.romanceRank = 1;
        } else {
            this.settingRank = 1;
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
}
