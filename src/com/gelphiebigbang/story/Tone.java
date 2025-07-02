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

    public Preference getFluff() {
        return fluff;
    }

    public Preference getAngst() {
        return angst;
    }

    public Preference getHumor() {
        return humor;
    }

    public Preference getHurt_comfort() {
        return hurt_comfort;
    }

    public Preference getLight() {
        return light;
    }

    public Preference getDark() {
        return dark;
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

    public int maxScore(int rank) {
        int max = 0;
        if (this.fluff == Preference.YES){
            max += rank;
        }
        if (this.angst == Preference.YES){
            max += rank;
        }
        if (this.humor == Preference.YES){
            max += rank;
        }
        if (this.hurt_comfort == Preference.YES){
            max += rank;
        }
        if (this.dark == Preference.YES){
            max += rank;
        }
        if (this.light == Preference.YES){
            max += rank;
        }
        return max;
    }

    public double compareTone(Tone compareTo, int rank){
        double score = 0;
        double penalty = -(double) rank/3;
        double halfPenalty = penalty/2;
        // if -999.999 it is invalid
        if (this.fluff == Preference.YES){
            if (compareTo.getFluff() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.fluff == Preference.NO && compareTo.getFluff() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getFluff() == Preference.YES){
            score += halfPenalty;
        }

        if (this.angst == Preference.YES){
            if (compareTo.getAngst() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.angst == Preference.NO && compareTo.getAngst() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getAngst() == Preference.YES){
            score += halfPenalty;
        }

        if (this.humor == Preference.YES){
            if (compareTo.getHumor() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.humor == Preference.NO && compareTo.getHumor() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getHumor() == Preference.YES){
            score += halfPenalty;
        }

        if (this.hurt_comfort == Preference.YES){
            if (compareTo.getHurt_comfort() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.hurt_comfort == Preference.NO && compareTo.getHurt_comfort() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getHurt_comfort() == Preference.YES){
            score += halfPenalty;
        }

        if (this.light == Preference.YES){
            if (compareTo.getLight() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.light == Preference.NO && compareTo.getLight() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getLight() == Preference.YES){
            score += halfPenalty;
        }

        if (this.dark == Preference.YES){
            if (compareTo.getDark() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.dark == Preference.NO && compareTo.getDark() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getDark() == Preference.YES){
            score += halfPenalty;
        }
        
        return score;
    }
}
