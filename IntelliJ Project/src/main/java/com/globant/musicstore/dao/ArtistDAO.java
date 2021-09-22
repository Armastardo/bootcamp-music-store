package com.globant.musicstore.dao;

import com.globant.musicstore.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistDAO extends JpaRepository<Artist, Long> {
    @Query("SELECT artist FROM Artist artist WHERE artist.id IN :id")
    Artist getArtist(Long id);

}
