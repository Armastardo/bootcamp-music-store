package com.globant.musicstore.utils.mapper;

import org.springframework.stereotype.Component;

import com.globant.musicstore.dto.Cat_GenreDTO;
import com.globant.musicstore.entity.Cat_Genre;

@Component
public class Cat_GenreMapper {
	
    public Cat_Genre cat_genreDTOToEntity(Cat_GenreDTO catGenreDTO){
       
    	return Cat_Genre.builder()
    			.id(catGenreDTO.getId())
    			.build();
    }
    
    public Cat_GenreDTO cat_genreEntityToDTO(Cat_Genre catGenre){
    	
    	return Cat_GenreDTO.builder()
    			.id(catGenre.getId())
    			.build();
    }
    
}
