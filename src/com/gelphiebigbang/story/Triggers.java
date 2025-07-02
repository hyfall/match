package com.gelphiebigbang.story;

public class Triggers {
    // true -> not include | in story
    private Boolean mental_health = false;
    private Boolean physical_violence = false;
    private Boolean non_consent = false;
    private Boolean death = false;
    private Boolean unhappy_ending = false;
    private Boolean emotional_abuse = false;
    private Boolean substance_abuse = false;
    private Boolean failure_of_society = false;

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

    public Boolean compareTriggers(Triggers compareTo) {
        if (this.mental_health && compareTo.mental_health) {
            return false;
        }
        if (this.physical_violence && compareTo.physical_violence) {
            return false;
        }
        if (this.non_consent && compareTo.non_consent) {
            return false;
        }
        if (this.death && compareTo.death) {
            return false;
        }
        if (this.unhappy_ending && compareTo.unhappy_ending) {
            return false;
        }
        if (this.emotional_abuse && compareTo.emotional_abuse) {
            return false;
        }
        if (this.substance_abuse && compareTo.substance_abuse) {
            return false;
        }
        if (this.failure_of_society && compareTo.failure_of_society) {
            return false;
        }
        return true;
    }
}
