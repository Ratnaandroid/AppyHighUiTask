package com.ratna.appyhighuitask.model;

/**
 * Created by ratna on 15-05-2020.
 */

public class LatestAdded {
    String name,directory;
    int latestimageadd;

    public LatestAdded(String name, String directory, int latestimageadd) {
        this.name = name;
        this.directory = directory;
        this.latestimageadd = latestimageadd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public int getLatestimageadd() {
        return latestimageadd;
    }

    public void setLatestimageadd(int latestimageadd) {
        this.latestimageadd = latestimageadd;
    }
}
