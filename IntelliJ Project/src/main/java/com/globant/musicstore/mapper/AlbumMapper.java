package com.globant.musicstore.mapper;

import com.globant.musicstore.dao.ArtistDAO;
import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumMapper {

    @Autowired
    ArtistDAO artistDAO;

    public Album albumDTOToEntity(AlbumDTO albumDTO){
        Album album = new Album();
        album.setId(albumDTO.getId());
        album.setName(albumDTO.getName());
        album.setYearCreation(albumDTO.getYearCreation());
        album.setDescription(albumDTO.getDescription());
        album.setPrice(albumDTO.getPrice());
        album.setQuantityAvailable(albumDTO.getQuantityAvailable());
        album.setIsActive(albumDTO.getIsActive());
        album.setSongs(albumDTO.getSongs());
        album.setArtist(artistDAO.getArtist(albumDTO.getArtistId()));
        return album;
    }

    public AlbumDTO albumEntityToDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(album.getId());
        albumDTO.setName(album.getName());
        albumDTO.setYearCreation(album.getYearCreation());
        albumDTO.setDescription(album.getDescription());
        albumDTO.setPrice(album.getPrice());
        albumDTO.setQuantityAvailable(album.getQuantityAvailable());
        albumDTO.setIsActive(album.getIsActive());
        albumDTO.setSongs(album.getSongs());
        albumDTO.setArtistId(album.getArtist().getId());
        return albumDTO;
    }

    public List<AlbumDTO> listAlbumToDTO(List<Album> albumList){
        List<AlbumDTO> albumDTOList = new ArrayList<AlbumDTO>();
        albumList.forEach(album -> albumDTOList.add(albumEntityToDTO(album)));
        return albumDTOList;
    }

}
