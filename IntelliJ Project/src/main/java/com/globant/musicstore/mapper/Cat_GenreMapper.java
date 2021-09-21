package com.globant.musicstore.mapper;

import com.globant.musicstore.dto.Cat_GenreDTO;
import com.globant.musicstore.entity.Cat_Genre;
import org.springframework.stereotype.Component;

@Component
public class Cat_GenreMapper {
    public Cat_Genre cat_genreDTOToEntity(Cat_GenreDTO catGenreDTO){
        Cat_Genre catGenre = new Cat_Genre();
        return catGenre;
    }
    public Cat_GenreDTO cat_genreEntityToDTO(Cat_Genre catGenre){
        Cat_GenreDTO catGenreDTO = new Cat_GenreDTO();
        return catGenreDTO;
    }
}
