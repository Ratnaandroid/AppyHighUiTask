package com.ratna.appyhighuitask.model;

/**
 * Created by ratna on 16-05-2020.
 */

public class playlist {
    String name,duration;
    int image;

    public playlist(String name, String duration, int image) {
        this.name = name;
        this.duration = duration;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
