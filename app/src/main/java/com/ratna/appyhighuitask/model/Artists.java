package com.ratna.appyhighuitask.model;

/**
 * Created by ratna on 15-05-2020.
 */

public class Artists {
    public String artisttype,artistname;
    int artistimage;

    public Artists(String artisttype, String artistname, int artistimage) {
        this.artisttype = artisttype;
        this.artistname = artistname;
        this.artistimage = artistimage;
    }

    public String getArtisttype() {
        return artisttype;
    }

    public void setArtisttype(String artisttype) {
        this.artisttype = artisttype;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public int getArtistimage() {
        return artistimage;
    }

    public void setArtistimage(int artistimage) {
        this.artistimage = artistimage;
    }
}
