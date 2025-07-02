package com.gelphiebigbang.artist;

public class ArtStyle {
    private Boolean digital = false;
    private Boolean trad_hand_drawn = false;
    private Boolean trad_painting = false;
    private Boolean comic = false;
    private Boolean poster = false;
    private Boolean photo = false;
    private Boolean moodboard = false;
    private Boolean animation = false;

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

    public double compareArtStyle(ArtStyle compareTo){
        if (this.digital && compareTo.digital) {
            return 5;
        }
        if (this.trad_hand_drawn && compareTo.trad_hand_drawn) {
            return 5;
        }
        if (this.trad_painting && compareTo.trad_painting) {
            return 5;
        }
        if (this.comic && compareTo.comic) {
            return 5;
        }
        if (this.poster && compareTo.poster) {
            return 5;
        }
        if (this.photo && compareTo.photo) {
            return 5;
        }
        if (this.moodboard && compareTo.moodboard) {
            return 5;
        }
        if (this.animation && compareTo.animation) {
            return 5;
        }
        return -1;
    }
}
