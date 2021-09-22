package com.globant.musicstore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ArtistDTO {
    private Long id;
    private List<AlbumDTO> albums;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AlbumDTO> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumDTO> albums) {
        this.albums = albums;
    }

    public void addAlbum(AlbumDTO albumDTO){
        albums.add(albumDTO);
    }
}

