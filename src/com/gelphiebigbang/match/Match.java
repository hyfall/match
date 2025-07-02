package com.gelphiebigbang.match;

import com.gelphiebigbang.artist.Artist;
import com.gelphiebigbang.story.Rating;
import com.gelphiebigbang.writer.Writer;

public class Match {

    
    public static void checkArtistAndWriter(Artist artist, Writer writer, int max, float threshold){
        // return int based on cat
        // 0 perfect 1 great 2 good 3 fine 4 poor 5 no match
        // System.out.println("here");
        int writerStoryRating = writer.getStory().getRating();
        if (!artist.getOver18()){
            if (writerStoryRating == 2 || writerStoryRating == 3) {
                return;
            }
        }
        // System.out.println("here1");
        // check if rating works with artist
        if (writerStoryRating == 1 && !artist.getRatingTeen()) {
            return;
        } else if (writerStoryRating == 2 && !artist.getRatingMature()) {
            return;
        } else if (writerStoryRating == 3 && !artist.getRatingExplicit()) {
            return;
        }
        // System.out.println("here2");
        // check triggers
        if (!artist.getStory().getTriggers().compareTriggers(writer.getStory().getTriggers())){
            return;
        }

        // System.out.println("here3");
        // check ship
        if (!artist.getStory().compareShips(writer.getStory().getShip())){
            return;
        }

        // check art styles
        // System.out.println("here4");
        double score = artist.getArtStyle().compareArtStyle(writer.getArtStyle());

        // compare tone
        // System.out.println("here5");
        double toneScore = artist.getStory().getTone().compareTone(writer.getStory().getTone(), artist.getToneRank());
        score += toneScore;

        // compare romance
        double romanceScore = artist.getStory().getRomance().compareRomance(writer.getStory().getRomance(), artist.getRomanceRank());
        score += romanceScore;

        // compare setting
        double settingScore = artist.getStory().getSetting().compareSetting(writer.getStory().getSetting(), artist.getSettingRank());
        score += settingScore;

        // System.out.println(score + " : " + max);
        if (score == max){
            // add to perfect
            artist.addPerfect(writer);
            writer.addPerfect(artist);
        } else if (score >= (max - threshold)){
            artist.addGreat(writer);
            writer.addGreat(artist);
        } else if (score >= (max - (threshold*2))){
            artist.addGood(writer);
            writer.addGood(artist);
        } else if (score >= (max - (threshold*3))){
            artist.addFair(writer);
            writer.addFair(artist);
        } else {
            artist.addPoor(writer);
            writer.addPoor(artist);
        }

    }
}
