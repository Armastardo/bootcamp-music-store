package com.globant.musicstore.dao;

import com.globant.musicstore.entity.CatGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatGenreDAO extends JpaRepository<CatGenre, Long> {
}
