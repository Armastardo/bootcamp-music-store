package com.globant.musicstore.dto;


import com.globant.musicstore.entity.Album;
import com.globant.musicstore.entity.Cat_Genre;

import java.sql.Time;

public class SongDTO {
    private Long id;
    private String name;
    private Time duration;
    private Boolean is_active;
    private Album album;
    private Cat_Genre cat_genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Cat_Genre getCat_genre() {
        return cat_genre;
    }

    public void setCat_genre(Cat_Genre cat_genre) {
        this.cat_genre = cat_genre;
    }

}
