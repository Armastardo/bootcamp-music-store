package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dao.AlbumDAO;
import com.globant.musicstore.dao.CatGenreDAO;
import com.globant.musicstore.dto.SongDTO;
import com.globant.musicstore.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SongMapper {
	
    @Autowired
    AlbumDAO albumDAO;

    @Autowired
    CatGenreDAO catGenreDAO;

    public Song songDTOToEntity(SongDTO songDTO){
    	
    	return Song.builder()
    			.id(songDTO.getId())
    			.name(songDTO.getName())
    			.duration(songDTO.getDuration())
    			.isActive(songDTO.getIsActive())
    			.album(albumDAO.getAlbum(songDTO.getAlbumId()))
				.catGenre(catGenreDAO.findById(songDTO.getCatGenreId()).get())
				.build();    	

    }

    public SongDTO songEntityToDTO(Song song){
       

    	return SongDTO.builder()
    			.id(song.getId())
    			.name(song.getName())
    			.duration(song.getDuration())
    			.isActive(song.getIsActive())
    			.albumId(song.getAlbum().getId())
				.catGenreId(song.getCatGenre().getId())
				.build();
    }

    public List<SongDTO> listSongToDTO(List<Song> songList){
        List<SongDTO> songDTOList = new ArrayList<SongDTO>();
        songList.forEach(song -> songDTOList.add(songEntityToDTO(song)));
        return songDTOList;
    }

    public List<Song> listSongDTOToEntity(List<SongDTO> songList){
        List<Song> songEntityList = new ArrayList<Song>();
        songList.forEach(song -> songEntityList.add(songDTOToEntity(song)));
        return songEntityList;
    }
}
