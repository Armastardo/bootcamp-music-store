package com.globant.musicstore.service.impl;

import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.entity.Song;

import java.util.List;

public interface AlbumService {
    public List<AlbumDTO> showList();
    public AlbumDTO addAlbum(Long idArtist, AlbumDTO albumDTO);
    public AlbumDTO getAlbumById(Long idAlbum);
    public List<Song> getAlbumSongs(Long idAlbum);
    public void deleteAlbum(Long idAlbum);
    public AlbumDTO updateAlbum(Long idAlbum, AlbumDTO albumDTO);
}
