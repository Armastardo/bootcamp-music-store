package com.globant.musicstore.service;

import com.globant.musicstore.dto.SongDTO;

import java.util.List;

public interface SongService {
    public List<SongDTO> showList();
    public SongDTO addSong(Long idAlbum, SongDTO songDTO);
    public SongDTO getSongById(Long idSong);
    public SongDTO deleteSong(Long idSong);
    public SongDTO updateSong(Long idSong, SongDTO songDTO);
}
