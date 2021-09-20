package com.globant.musicstore.dao;

import com.globant.musicstore.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistDAO extends JpaRepository<Artist, Long> {

}
