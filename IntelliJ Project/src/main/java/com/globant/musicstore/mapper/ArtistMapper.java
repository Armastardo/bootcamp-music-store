package com.globant.musicstore.mapper;

import com.globant.musicstore.dto.ArtistDTO;
import com.globant.musicstore.entity.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {
    public Artist artistDTOToEntity(ArtistDTO artistDTO){
        Artist artist = new Artist();
        artist.setId(artistDTO.getId());
        return artist;
    }

    public ArtistDTO artistEntityToDTO(Artist artist){
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setId(artistDTO.getId());
        return artistDTO;
    }
}
