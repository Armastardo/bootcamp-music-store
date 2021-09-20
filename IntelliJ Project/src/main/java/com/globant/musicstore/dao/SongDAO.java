package com.globant.musicstore.dao;

import com.globant.musicstore.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongDAO extends JpaRepository<Song, Long> {
}
