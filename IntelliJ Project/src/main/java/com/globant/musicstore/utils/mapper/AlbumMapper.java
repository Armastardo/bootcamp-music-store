package com.globant.musicstore.utils.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.musicstore.dao.ArtistDAO;
import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.entity.Album;

@Component
public class AlbumMapper {

    @Autowired
    ArtistDAO artistDAO;
    
    @Autowired
    SongMapper songMapper;

    public Album albumDTOToEntity(AlbumDTO albumDTO){
        
    	return Album.builder()
    			.id(albumDTO.getId())
    			.name(albumDTO.getName())
    			.yearCreation(albumDTO.getYearCreation())
    			.description(albumDTO.getDescription())
    			.price(albumDTO.getPrice())
    			.quantityAvailable(albumDTO.getQuantityAvailable())
    			.isActive(albumDTO.getIsActive())
    			.songs(songMapper.listSongDTOToEntity(albumDTO.getSongs()))
    			.artist(artistDAO.getArtist(albumDTO.getArtistId()))
    			.build();    			    			
    }

    public AlbumDTO albumEntityToDTO(Album album) {
    	
    	return AlbumDTO.builder()
    			.id(album.getId())
    			.name(album.getName())
    			.yearCreation(album.getYearCreation())
    			.description(album.getDescription())
    			.price(album.getPrice())
    			.quantityAvailable(album.getQuantityAvailable())
    			.isActive(album.getIsActive())
    			.songs(songMapper.listSongToDTO(album.getSongs()))
    			.artistId(album.getArtist().getId())
    			.build();
    }

    public List<AlbumDTO> listAlbumToDTO(List<Album> albumList){
    	
    	List<AlbumDTO> albumDTOList = new ArrayList<AlbumDTO>();
        albumList.forEach(album -> albumDTOList.add(albumEntityToDTO(album)));
        return albumDTOList;        
    }

}
