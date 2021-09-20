package com.globant.musicstore.mapper;

import com.globant.musicstore.dto.SongDTO;
import com.globant.musicstore.entity.Song;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {
    public Song songDTOToEntity(SongDTO songDTO){
        Song song = new Song();
        song.setId(songDTO.getId());
        song.setName(songDTO.getName());
        song.setDuration(songDTO.getDuration());
        song.setIs_active(songDTO.getIs_active());
        song.setAlbum(songDTO.getAlbum());
        song.setCat_genre(songDTO.getCat_genre());
        return song;
    }

    public SongDTO songEntityToDTO(Song song){
        SongDTO songDTO = new SongDTO();
        songDTO.setId(song.getId());
        songDTO.setName(song.getName());
        songDTO.setDuration(song.getDuration());
        songDTO.setIs_active(song.getIs_active());
        songDTO.setAlbum(song.getAlbum());
        songDTO.setCat_genre(song.getCat_genre());
        return songDTO;
    }
}
