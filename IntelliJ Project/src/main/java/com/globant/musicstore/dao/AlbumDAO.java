package com.globant.musicstore.dao;

import com.globant.musicstore.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumDAO extends JpaRepository<Album, Long> {
}
