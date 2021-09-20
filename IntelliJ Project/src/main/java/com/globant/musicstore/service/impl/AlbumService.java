package com.globant.musicstore.service.impl;

import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.entity.Album;
import com.globant.musicstore.entity.Song;

import java.util.List;

public interface AlbumService {
    public List<Album> showList();
    public AlbumDTO addAlbum(Long id_artist, AlbumDTO albumDTO);
    public AlbumDTO getAlbumById(Long id_album);
    public List<Song> getAlbumSongs(Long id_album);
    public void deleteAlbum(Long id_album);
    public AlbumDTO updateAlbum(Long id_album, AlbumDTO albumDTO);
}
