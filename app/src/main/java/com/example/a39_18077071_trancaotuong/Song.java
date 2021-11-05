package com.example.a39_18077071_trancaotuong;

import java.io.Serializable;

public class Song implements Serializable{
    private String title;
    private String single;
    private int image;
    private int resource;

    public Song(String title, String single, int image, int resource) {
        this.title = title;
        this.single = single;
        this.image = image;
        this.resource = resource;
    }

    public Song() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", single='" + single + '\'' +
                ", image=" + image +
                ", resource=" + resource +
                '}';
    }
}
