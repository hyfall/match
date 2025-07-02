package com.gelphiebigbang.story;

public class Setting {
    private Preference canon_divergent = Preference.MAYBE;
    private Preference alt_universe = Preference.MAYBE;
    private Preference shiz_era = Preference.MAYBE;
    private Preference act_2_spoilers = Preference.MAYBE;
    private Preference book_canon = Preference.MAYBE;
    private Preference musical_canon = Preference.MAYBE;

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
}
