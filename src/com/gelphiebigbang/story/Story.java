package com.gelphiebigbang.story;

enum Rating {
    GEN,
    TEEN,
    MATURE,
    EXPLICIT;
}

enum Ship {
    ONLY_GELPHIE,
    GELPHIE_ENDGAME,
    GELPHIE_DRAWING,
    ANY_PAIRING
}

enum Preference {
    YES,
    MAYBE,
    NO
}

public class Story {
    Rating rating;
    Tone tone;
    Romance romance;
    Setting setting;
    Triggers triggers;

    public Story(String inputString){
        int index = inputString.indexOf("END");
        String storyElements = inputString.substring(0, index);
        this.tone = new Tone(storyElements);
        this.romance = new Romance(storyElements);
        this.setting = new Setting(storyElements);
        int lastIndex = index + 4;
        index = inputString.indexOf(",", lastIndex);
        String ratingString = inputString.substring(lastIndex, index);
        while (ratingString.contains("\"")){
            // use last rating if multiple are selected
            // System.out.println(ratingString);
            lastIndex = index + 1;
            index = inputString.indexOf(",", lastIndex);
            ratingString = inputString.substring(lastIndex, index);
            if (ratingString.endsWith("\"")){
                ratingString = ratingString.substring(0, ratingString.length()-1);
            }
        }
        switch (ratingString) {
            case "General (G)":
                this.rating = Rating.GEN;
                break;
            case "Teen (T)":
                this.rating = Rating.TEEN;
                break;
            case "Mature (M) - (18+ only)":
                this.rating = Rating.MATURE;
                break;
            case "Explicit (E) - (18+ only)":
                this.rating = Rating.EXPLICIT;
                break;
            default:
                break;
        }
    }

}
