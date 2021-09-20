package com.globant.musicstore.mapper;

import com.globant.musicstore.dto.Cat_GenreDTO;
import com.globant.musicstore.entity.Cat_Genre;
import org.springframework.stereotype.Component;

@Component
public class Cat_GenreMapper {
    public Cat_Genre cat_genreDTOToEntity(Cat_GenreDTO cat_genreDTO){
        Cat_Genre cat_genre = new Cat_Genre();
        return cat_genre;
    }
    public Cat_GenreDTO cat_genreEntityToDTO(Cat_Genre cat_genre){
        Cat_GenreDTO cat_genreDTO = new Cat_GenreDTO();
        return cat_genreDTO;
    }
}
