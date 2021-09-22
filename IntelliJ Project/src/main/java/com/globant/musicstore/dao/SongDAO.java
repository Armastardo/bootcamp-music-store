package com.globant.musicstore.dao;

import com.globant.musicstore.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongDAO extends JpaRepository<Song, Long> {
    @Query("SELECT song FROM Song song WHERE song.id IN :id")
    Song getSong(Long id);
}
