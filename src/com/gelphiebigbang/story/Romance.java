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

    public Preference getRomance() {
        return romance;
    }

    public Preference getDark_romance() {
        return dark_romance;
    }

    public Preference getSoulmates() {
        return soulmates;
    }

    public Preference getSlow_burn() {
        return slow_burn;
    }

    public Preference getEst_relationship() {
        return est_relationship;
    }

    public Preference getSmut() {
        return smut;
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

    public int maxScore(int rank) {
        int max = 0;
        if (this.romance == Preference.YES){
            max += rank;
        }
        if (this.dark_romance == Preference.YES){
            max += rank;
        }
        if (this.soulmates == Preference.YES){
            max += rank;
        }
        if (this.slow_burn == Preference.YES){
            max += rank;
        }
        if (this.est_relationship == Preference.YES){
            max += rank;
        }
        if (this.smut == Preference.YES){
            max += rank;
        }
        return max;
    }

    public double compareRomance(Romance compareTo, int rank){
        double score = 0;
        double penalty = -(double) rank/3;
        double halfPenalty = penalty/2;
        // if -999.999 it is invalid
        if (this.romance == Preference.YES){
            if (compareTo.getRomance() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.romance == Preference.NO && compareTo.getRomance() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getRomance() == Preference.YES){
            score += halfPenalty;
        }

        if (this.dark_romance == Preference.YES){
            if (compareTo.getDark_romance() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.dark_romance == Preference.NO && compareTo.getDark_romance() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getDark_romance() == Preference.YES){
            score += halfPenalty;
        }

        if (this.soulmates == Preference.YES){
            if (compareTo.getSoulmates() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.soulmates == Preference.NO && compareTo.getSoulmates() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getSoulmates() == Preference.YES){
            score += halfPenalty;
        }

        if (this.slow_burn == Preference.YES){
            if (compareTo.getSlow_burn() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.slow_burn == Preference.NO && compareTo.getSlow_burn() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getSlow_burn() == Preference.YES){
            score += halfPenalty;
        }

        if (this.est_relationship == Preference.YES){
            if (compareTo.getEst_relationship() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.est_relationship == Preference.NO && compareTo.getEst_relationship() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getEst_relationship() == Preference.YES){
            score += halfPenalty;
        }

        if (this.smut == Preference.YES){
            if (compareTo.getSmut() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.smut == Preference.NO && compareTo.getSmut() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getSmut() == Preference.YES){
            score += halfPenalty;
        }
        
        return score;
    }
}
