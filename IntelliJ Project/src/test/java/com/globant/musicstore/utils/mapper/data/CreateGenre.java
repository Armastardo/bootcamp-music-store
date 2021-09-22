package com.globant.musicstore.utils.mapper.data;

import com.globant.musicstore.dto.requestDTO.CatGenreDTO;
import com.globant.musicstore.entity.CatGenre;

public class CreateGenre {

    public static CatGenre createGenre(){
        return CatGenre.builder()
                .id(1L)
                .name("rock")
                .description("great")
                .build();
    }

    public static CatGenreDTO createGenreDTO(){
        return CatGenreDTO.builder()
                .id(1L)
                .name("rock")
                .description("great")
                .build();
    }
}
