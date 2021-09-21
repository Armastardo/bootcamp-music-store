package com.globant.musicstore.dto;

import java.sql.Time;

public class SongDTO {
    private Long id;
    private String name;
    private Time duration;
    private Boolean isActive;
    private Long albumId;
    private Long catGenreId;

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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getCatGenreId() {
        return catGenreId;
    }

    public void setCatGenreId(Long catGenreId) {
        this.catGenreId = catGenreId;
    }
}
