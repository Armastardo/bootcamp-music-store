package com.globant.musicstore.service.impl;

import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.dto.SongDTO;
import com.globant.musicstore.entity.Album;
import com.globant.musicstore.entity.Song;

import java.util.List;

public interface SongService {
    public List<Song> showList();
    public SongDTO addSong(Long id_Album, SongDTO songDTO);
    public SongDTO getSongById(Long id_song);
    public void deleteSong(Long id_song);
    public SongDTO updateSong(Long id_song, SongDTO songDTO);
}
