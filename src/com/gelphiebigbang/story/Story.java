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
    Ship ship;

    // TODO add triggers and gelphie ship on writer path
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

    public Story(Tone _tone, Romance _romance, Setting _setting, Triggers _triggers, int gelphieShip){
        switch (gelphieShip) {
            case 0:
                this.ship = Ship.ONLY_GELPHIE;
                break;
            case 1:
                this.ship = Ship.GELPHIE_ENDGAME;
                break;
            case 2:
                this.ship = Ship.GELPHIE_DRAWING;
                break;
            case 3:
                this.ship = Ship.ANY_PAIRING;
                break;
        }
        this.tone = _tone;
        this.romance = _romance;
        this.setting = _setting;
        this.triggers = _triggers;
    }

}
