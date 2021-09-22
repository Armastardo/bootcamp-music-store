package com.globant.musicstore.utils.mapper.data;

import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.entity.Artist;

public class CreateArtist {

    public static Artist createArtist() {
        return Artist.builder()
                .id(1L)
                .name("mj")
                .isSingle(Boolean.TRUE)
                .description("the king of pop")
                .build();
    }

    public static ArtistDTO createArtistDTO() {
        return ArtistDTO.builder()
                .id(1L)
                .name("mj")
                .isSingle(Boolean.TRUE)
                .description("the king of pop")
                .build();
    }
}
