package com.globant.musicstore.dao;

import com.globant.musicstore.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumDAO extends JpaRepository<Album, Long> {
    @Query("SELECT album FROM Album album WHERE album.id IN :id")
    Album getAlbum(Long id);

    List<Album> findByArtist(Long idArtist);
}
