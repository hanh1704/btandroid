package com.example.musicapp.model;

public class Song {
    int id;
    int name;
    String url;
    private String title;
    private String artist;

    public Song()
    {

    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(int _name) {
        this.name = _name;
    }

    public void setUrl(String _url) {
        this.url = _url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String _artist) {
        this.artist = _artist;
    }
}
