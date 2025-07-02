package com.gelphiebigbang.story;

public class Triggers {
    // true -> not include | in story
    private Boolean mental_health;
    private Boolean physical_violence;
    private Boolean non_consent;
    private Boolean death;
    private Boolean unhappy_ending;
    private Boolean emotional_abuse;
    private Boolean substance_abuse;
    private Boolean failure_of_society;

    public Triggers(Boolean allValues){
        this.mental_health = allValues;
        this.physical_violence = allValues;
        this.non_consent = allValues;
        this.death = allValues;
        this.unhappy_ending = allValues;
        this.emotional_abuse = allValues;
        this.substance_abuse = allValues;
        this.failure_of_society = allValues;
    }

    public Triggers(String inputString){
        if (inputString.contains("TW: Mental Health (depression, panic attacks, self-harm, suicide)")) {
            this.mental_health = true;
        }
        if (inputString.contains("TW: Physical Violence (torture, graphic violence)")) {
            this.physical_violence = true;
        }
        if (inputString.contains("TW: Non Consensual (drug use, rape/sexual assault, dubious consent)")) {
            this.non_consent = true;
        }
        if (inputString.contains("TW: Major Character Death")) {
            this.death = true;
        }
        if (inputString.contains("TW: Unhappy Ending")) {
            this.unhappy_ending = true;
        }
        if (inputString.contains("TW: Emotional/relational abuses like gaslighting, bullying, verbal abuse, physical abuse, domestic violence, child abuse.")) {
            this.emotional_abuse = true;
        }
        if (inputString.contains("TW: Substance Abuse / Alcohol Abuse")) {
            this.substance_abuse = true;
        }
        if (inputString.contains("TW Societal triggers: racism, homophobia, slavery.")) {
            this.failure_of_society = true;
        }
    }
}
