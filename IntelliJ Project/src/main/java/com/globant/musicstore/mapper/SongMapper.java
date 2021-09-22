package com.globant.musicstore.mapper;

import com.globant.musicstore.dao.AlbumDAO;
import com.globant.musicstore.dao.Cat_GenreDAO;
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
    Cat_GenreDAO catGenreDAO;

    public Song songDTOToEntity(SongDTO songDTO){
        Song song = new Song();
        song.setId(songDTO.getId());
        song.setName(songDTO.getName());
        song.setDuration(songDTO.getDuration());
        song.setIsActive((songDTO.getIsActive()));
        song.setAlbum(albumDAO.getAlbum(songDTO.getAlbumId()));
        song.setCatGenre(catGenreDAO.getCatGenre(songDTO.getCatGenreId()));
        return song;
    }

    public SongDTO songEntityToDTO(Song song){
        SongDTO songDTO = new SongDTO();
        songDTO.setId(song.getId());
        songDTO.setName(song.getName());
        songDTO.setDuration(song.getDuration());
        songDTO.setIsActive(song.getIsActive());
        songDTO.setAlbumId(song.getAlbum().getId());
        songDTO.setCatGenreId(song.getCatGenre().getId());
        return songDTO;
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
