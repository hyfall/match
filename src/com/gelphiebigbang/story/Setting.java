package com.gelphiebigbang.story;

public class Setting {
    private Preference canon_divergent = Preference.MAYBE;
    private Preference alt_universe = Preference.MAYBE;
    private Preference shiz_era = Preference.MAYBE;
    private Preference act_2_spoilers = Preference.MAYBE;
    private Preference book_canon = Preference.MAYBE;
    private Preference musical_canon = Preference.MAYBE;

    public Setting (){}

    public Setting(String inputString) {
        if (inputString.contains("Canon-Divergent")) {
            this.canon_divergent = Preference.YES;
        }
        if (inputString.contains("AU")) {
            this.alt_universe = Preference.YES;
        }
        if (inputString.contains("Shiz-Era")) {
            this.shiz_era = Preference.YES;
        }
        if (inputString.contains("Act 2 Spoilers")) {
            this.act_2_spoilers = Preference.YES;
        }
        if (inputString.contains("Book Canon")) {
            this.book_canon = Preference.YES;
        }
        if (inputString.contains("Musical Canon")) {
            this.musical_canon = Preference.YES;
        }
    }

    public Preference getCanon_divergent() {
        return canon_divergent;
    }

    public Preference getAlt_universe() {
        return alt_universe;
    }

    public Preference getShiz_era() {
        return shiz_era;
    }

    public Preference getAct_2_spoilers() {
        return act_2_spoilers;
    }

    public Preference getBook_canon() {
        return book_canon;
    }

    public Preference getMusical_canon() {
        return musical_canon;
    }

    public void setNo(String inputString){
        if (inputString.contains("Canon-Divergent")) {
            this.canon_divergent = Preference.NO;
        }
        if (inputString.contains("AU")) {
            this.alt_universe = Preference.NO;
        }
        if (inputString.contains("Shiz-Era")) {
            this.shiz_era = Preference.NO;
        }
        if (inputString.contains("Act 2 Spoilers")) {
            this.act_2_spoilers = Preference.NO;
        }
        if (inputString.contains("Book Canon")) {
            this.book_canon = Preference.NO;
        }
        if (inputString.contains("Musical Canon")) {
            this.musical_canon = Preference.NO;
        }
    }

    public int maxScore(int rank) {
        int max = 0;
        if (this.canon_divergent == Preference.YES){
            max += rank;
        }
        if (this.alt_universe == Preference.YES){
            max += rank;
        }
        if (this.shiz_era == Preference.YES){
            max += rank;
        }
        if (this.act_2_spoilers == Preference.YES){
            max += rank;
        }
        if (this.book_canon == Preference.YES){
            max += rank;
        }
        if (this.musical_canon == Preference.YES){
            max += rank;
        }
        return max;
    }

    public double compareSetting(Setting compareTo, int rank){
        double score = 0;
        double penalty = -(double) rank/3;
        double halfPenalty = penalty/2;
        // if -999.999 it is invalid
        if (this.canon_divergent == Preference.YES){
            if (compareTo.getCanon_divergent() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.canon_divergent == Preference.NO && compareTo.getCanon_divergent() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getCanon_divergent() == Preference.YES){
            score += halfPenalty;
        }

        if (this.alt_universe == Preference.YES){
            if (compareTo.getAlt_universe() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.alt_universe == Preference.NO && compareTo.getAlt_universe() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getAlt_universe() == Preference.YES){
            score += halfPenalty;
        }

        if (this.shiz_era == Preference.YES){
            if (compareTo.getShiz_era() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.shiz_era == Preference.NO && compareTo.getShiz_era() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getShiz_era() == Preference.YES){
            score += halfPenalty;
        }

        if (this.act_2_spoilers == Preference.YES){
            if (compareTo.getAct_2_spoilers() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.act_2_spoilers == Preference.NO && compareTo.getAct_2_spoilers() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getAct_2_spoilers() == Preference.YES){
            score += halfPenalty;
        }

        if (this.book_canon == Preference.YES){
            if (compareTo.getBook_canon() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.book_canon == Preference.NO && compareTo.getBook_canon() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getBook_canon() == Preference.YES){
            score += halfPenalty;
        }

        if (this.musical_canon == Preference.YES){
            if (compareTo.getMusical_canon() == Preference.YES){
                score += rank;
            } else {
                score += penalty;
            }
        } else if (this.musical_canon == Preference.NO && compareTo.getMusical_canon() == Preference.YES){
            return -rank*2;
        } else if (compareTo.getMusical_canon() == Preference.YES){
            score += halfPenalty;
        }
        
        return score;
    }
}
