package com.gelphiebigbang.story;

public class Tone {
    private Preference fluff = Preference.MAYBE;
    private Preference angst = Preference.MAYBE;
    private Preference humor = Preference.MAYBE;
    private Preference hurt_comfort = Preference.MAYBE;
    private Preference dark = Preference.MAYBE;
    private Preference light = Preference.MAYBE;

    public Tone (){}

    public Tone (String inputString){
        if (inputString.contains("Fluff")) {
            this.fluff = Preference.YES;
        }
        if (inputString.contains("Angst")) {
            this.angst = Preference.YES;
        }
        if (inputString.contains("Humor")) {
            this.humor = Preference.YES;
        }
        if (inputString.contains("Hurt/comfort")) {
            this.hurt_comfort = Preference.YES;
        }
        if (inputString.contains("Dark fic")) {
            this.dark = Preference.YES;
        }
        if (inputString.contains("Light fic")) {
            this.light = Preference.YES;
        }
    }

    public void setNo(String inputString){
        if (inputString.contains("Fluff")) {
            this.fluff = Preference.NO;
        }
        if (inputString.contains("Angst")) {
            this.angst = Preference.NO;
        }
        if (inputString.contains("Humor")) {
            this.humor = Preference.NO;
        }
        if (inputString.contains("Hurt/comfort")) {
            this.hurt_comfort = Preference.NO;
        }
        if (inputString.contains("Dark fic")) {
            this.dark = Preference.NO;
        }
        if (inputString.contains("Light fic")) {
            this.light = Preference.NO;
        }
    }
}
