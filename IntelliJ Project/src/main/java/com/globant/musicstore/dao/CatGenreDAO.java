package com.globant.musicstore.dao;

import com.globant.musicstore.entity.CatGenre;
import com.globant.musicstore.entity.Cat_Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CatGenreDAO extends JpaRepository<CatGenre, Long> {
    @Query("SELECT cat_genre FROM Cat_Genre cat_genre WHERE cat_genre.id IN :id")
    Cat_Genre getCatGenre(Long id);
}
