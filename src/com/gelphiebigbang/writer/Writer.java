package com.gelphiebigbang.writer;

import com.gelphiebigbang.story.Story;


public class Writer {
    private String ID;
    private String email;
    private Boolean active;
    private Story story;
    
    // art preferences
    private Boolean digital;
    private Boolean trad_hand_drawn;
    private Boolean trad_painting;
    private Boolean comic;
    private Boolean poster;
    private Boolean photo;
    private Boolean moodboard;
    private Boolean animation;

    public Writer(String inputString){
        int index = inputString.indexOf(",");
        this.active = Boolean.parseBoolean(inputString.substring(0, index));
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
            this.digital = true;
            this.trad_hand_drawn = true;
            this.trad_painting = true;
            this.comic = true;
            this.poster = true;
            this.photo = true;
            this.moodboard = true;
            this.animation = true;
        } else {
            String preferredArtStyles = inputString.substring(lastIndex);
            if (preferredArtStyles.contains("Digital Illustration")) {
                this.digital = true;
            }
            if (preferredArtStyles.contains("Traditional art: Copy of hand drawn art")) {
                this.trad_hand_drawn = true;
            }
            if (preferredArtStyles.contains("Traditional art: Copy of painting")) {
                this.trad_painting = true;
            }
            if (preferredArtStyles.contains("Comics / panels")) {
                this.comic = true;
            }
            if (preferredArtStyles.contains("Movie / Fic Posters")) {
                this.poster = true;
            }
            if (preferredArtStyles.contains("Photo edits / manips")) {
                this.photo = true;
            }
            if (preferredArtStyles.contains("Moodboards / Aesthetic collages")) {
                this.moodboard = true;
            }
            if (preferredArtStyles.contains("Animation or gifs")) {
                this.animation = true;
            }
        }
    }
}
