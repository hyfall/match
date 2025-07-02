package com.gelphiebigbang.writer;

import com.gelphiebigbang.artist.ArtStyle;
import com.gelphiebigbang.story.Story;

public class Writer {
    private String ID;
    private String email;
    private Boolean active;
    private Story story;
    private ArtStyle artStyle;

    public Writer(String inputString){
        int index = inputString.indexOf(",");
        this.active = Boolean.parseBoolean(inputString.substring(0, index));
        int lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        this.ID = inputString.substring(lastIndex, index);
        lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        this.email = inputString.substring(lastIndex, index);
        lastIndex = index + 1;
        index = inputString.indexOf("STORYEND");
        this.story = new Story(inputString.substring(lastIndex, index));
        // art styles
        lastIndex = index + 1;
        index = inputString.indexOf(",", lastIndex);
        if (index == -1){ // no preference so all
            this.artStyle = new ArtStyle(true);
        } else {
            String preferredArtStyles = inputString.substring(lastIndex);
            this.artStyle = new ArtStyle(preferredArtStyles);
        }
    }
}
