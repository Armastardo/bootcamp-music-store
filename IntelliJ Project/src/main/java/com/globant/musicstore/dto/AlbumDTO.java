package com.globant.musicstore.dto;

import com.globant.musicstore.entity.Artist;
import com.globant.musicstore.entity.Song;

import java.util.Date;
import java.util.List;

public class AlbumDTO {
    private Long id;
    private String name;
    private Date year_creation;
    private String description;
    private Double price;
    private Boolean is_active;
    private Integer quantity_available;
    private Artist artist;
    private List<Song> songs;

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

    public Date getYear_creation() {
        return year_creation;
    }

    public void setYear_creation(Date year_creation) {
        this.year_creation = year_creation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Integer getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(Integer quantity_available) {
        this.quantity_available = quantity_available;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
