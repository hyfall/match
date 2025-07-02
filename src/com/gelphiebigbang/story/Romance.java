package com.gelphiebigbang.story;

public class Romance {
    private Preference romance = Preference.MAYBE;
    private Preference dark_romance = Preference.MAYBE;
    private Preference soulmates = Preference.MAYBE;
    private Preference slow_burn = Preference.MAYBE;
    private Preference est_relationship = Preference.MAYBE;
    private Preference smut = Preference.MAYBE;

    public Romance(){}

    public Romance (String inputString){
        if (inputString.contains(",Romance") || inputString.contains("Romance,") || inputString.equalsIgnoreCase("Romance")) {
            this.romance = Preference.YES;
        }
        if (inputString.contains("Dark Romance")) {
            this.dark_romance = Preference.YES;
        }
        if (inputString.contains("Soulmates")) {
            this.soulmates = Preference.YES;
        }
        if (inputString.contains("Slow burn")) {
            this.slow_burn = Preference.YES;
        }
        if (inputString.contains("Established relationship")) {
            this.est_relationship = Preference.YES;
        }
        if (inputString.contains("Smut")) {
            this.smut = Preference.YES;
        }
    }

    public void setNo(String inputString){
        if (inputString.contains(",Romance") || inputString.contains("Romance,") || inputString.equalsIgnoreCase("Romance")) {
            this.romance = Preference.NO;
        }
        if (inputString.contains("Dark Romance")) {
            this.dark_romance = Preference.NO;
        }
        if (inputString.contains("Soulmates")) {
            this.soulmates = Preference.NO;
        }
        if (inputString.contains("Slow burn")) {
            this.slow_burn = Preference.NO;
        }
        if (inputString.contains("Established relationship")) {
            this.est_relationship = Preference.NO;
        }
        if (inputString.contains("Smut")) {
            this.smut = Preference.NO;
        }
    }
}
