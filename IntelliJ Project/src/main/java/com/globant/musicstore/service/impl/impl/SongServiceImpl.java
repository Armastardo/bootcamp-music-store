package com.globant.musicstore.service.impl.impl;

import com.globant.musicstore.dao.SongDAO;
import com.globant.musicstore.dto.SongDTO;
import com.globant.musicstore.entity.Song;
import com.globant.musicstore.exception.NotFoundException;
import com.globant.musicstore.mapper.SongMapper;
import com.globant.musicstore.service.impl.AlbumService;
import com.globant.musicstore.service.impl.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.globant.musicstore.utils.Constants.*;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    AlbumService albumService;

    @Autowired
    SongMapper songMapper;

    @Autowired
    SongDAO songDAO;

    @Override
    public List<Song> showList() {
        return songDAO.findAll();
    }

    @Override
    public SongDTO addSong(Long id_album, SongDTO songDTO) {
        albumService.getAlbumById(id_album);
        return songMapper.songEntityToDTO(songDAO.save(songMapper.songDTOToEntity(songDTO)));
    }

    @Override
    public SongDTO getSongById(Long id_song) {
        Song song = songDAO.findById(id_song).orElse(null);

        if(song == null){
            throw new NotFoundException(ITEM_DOES_NOT_EXIST);
        }
        SongDTO songDTO = songMapper.songEntityToDTO(song);
        return songDTO;
    }

    @Override
    public void deleteSong(Long id_song) {
        SongDTO songDTO = getSongById(id_song);
        if(songDTO.getIs_active() == true){
            songDTO.setIs_active(false);
            updateSong(id_song, songDTO);
        }else{
            throw new NotFoundException(ITEM_IS_ALREADY_DISABLE);
        }
    }

    @Override
    public SongDTO updateSong(Long id_song, SongDTO songDTO) {
        getSongById(id_song);
        return songMapper.songEntityToDTO(songDAO.save(songMapper.songDTOToEntity(songDTO)));
    }
}
