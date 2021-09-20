package com.globant.musicstore.service;

import com.globant.musicstore.dto.requestDTO.CatGenreDTO;

import java.util.List;

public interface CatGenreService {

    List<CatGenreDTO> getAllGenres();

    CatGenreDTO saveGenre(CatGenreDTO catGenreDTO);

    CatGenreDTO getGenreById(long catGenreId);

    CatGenreDTO updateGenre(long genreId, CatGenreDTO catGenreDTO);

    CatGenreDTO deleteGenreLogically(long catGenreId);
}
