package com.ratna.appyhighuitask.model;

/**
 * Created by ratna on 15-05-2020.
 */

public class Albums {
    public String songname,albumname,albumartistname;
    int album;

    public Albums(String songname, String albumname, String albumartistname, int album) {
        this.songname = songname;
        this.albumname = albumname;
        this.albumartistname = albumartistname;
        this.album = album;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getAlbumartistname() {
        return albumartistname;
    }

    public void setAlbumartistname(String albumartistname) {
        this.albumartistname = albumartistname;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }
}
