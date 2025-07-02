package com.gelphiebigbang.artist;

public class ArtStyle {
    private Boolean digital;
    private Boolean trad_hand_drawn;
    private Boolean trad_painting;
    private Boolean comic;
    private Boolean poster;
    private Boolean photo;
    private Boolean moodboard;
    private Boolean animation;

    public ArtStyle(Boolean allValues){
        this.digital = allValues;
        this.trad_hand_drawn = allValues;
        this.trad_painting = allValues;
        this.comic = allValues;
        this.poster = allValues;
        this.photo = allValues;
        this.moodboard = allValues;
        this.animation = allValues;
    }

    public ArtStyle(String inputString){
        if (inputString.contains("Digital Illustration")) {
            this.digital = true;
        }
        if (inputString.contains("Traditional art: Copy of hand drawn art")) {
            this.trad_hand_drawn = true;
        }
        if (inputString.contains("Traditional art: Copy of painting")) {
            this.trad_painting = true;
        }
        if (inputString.contains("Comics / panels")) {
            this.comic = true;
        }
        if (inputString.contains("Movie / Fic Posters")) {
            this.poster = true;
        }
        if (inputString.contains("Photo edits / manips")) {
            this.photo = true;
        }
        if (inputString.contains("Moodboards / Aesthetic collages")) {
            this.moodboard = true;
        }
        if (inputString.contains("Animation or gifs")) {
            this.animation = true;
        }
    }
}
