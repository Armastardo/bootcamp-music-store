package com.globant.musicstore.mapper;

import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.dto.SongDTO;
import com.globant.musicstore.entity.Album;
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {
    public Album albumDTOToEntity(AlbumDTO albumDTO){
        Album album = new Album();
        album.setId(albumDTO.getId());
        album.setName(albumDTO.getName());
        album.setYear_creation(albumDTO.getYear_creation());
        album.setDescription(albumDTO.getDescription());
        album.setPrice(albumDTO.getPrice());
        album.setQuantity_available(albumDTO.getQuantity_available());
        album.setIs_active(albumDTO.getIs_active());
        album.setSongs(albumDTO.getSongs());
        album.setArtist(albumDTO.getArtist());
        return album;
    }

    public AlbumDTO albumEntityToDTO(Album album){
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(album.getId());
        albumDTO.setName(album.getName());
        albumDTO.setYear_creation(album.getYear_creation());
        albumDTO.setDescription(album.getDescription());
        albumDTO.setPrice(album.getPrice());
        albumDTO.setQuantity_available(album.getQuantity_available());
        albumDTO.setIs_active(album.getIs_active());
        albumDTO.setSongs(album.getSongs());
        albumDTO.setArtist(album.getArtist());
        return albumDTO;
    }
}
