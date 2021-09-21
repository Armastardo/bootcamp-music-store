package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.entity.Artist;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArtistMapper {

    public ArtistDTO artistToDTO(Artist artistEntity) {
        ArtistDTO artistDTO = ArtistDTO.builder()
                .id(artistEntity.getId())
                .name(artistEntity.getName())
                .year_from(artistEntity.getYear_from())
                .isSingle(artistEntity.isSingle())
                .description(artistEntity.getDescription())
                .isActive(artistEntity.isActive())
                .houseRecord(artistEntity.getHouseRecord())
                .build();
        return artistDTO;
    }

    public Artist artistDTOtoArtist(ArtistDTO artistDTO) {
        Artist artistEntity = Artist.builder()
                .id(artistDTO.getId())
                .name(artistDTO.getName())
                .year_from(artistDTO.getYear_from())
                .isSingle(artistDTO.isSingle())
                .description(artistDTO.getDescription())
                .isActive(artistDTO.isActive())
                .houseRecord(artistDTO.getHouseRecord())
                .build();
        return artistEntity;
    }

    public List<ArtistDTO> listArtistToDTO(List<Artist> artistList) {
        List<ArtistDTO> artistDTOList = new ArrayList<ArtistDTO>();
        artistList.forEach(artist -> artistDTOList.add(artistToDTO(artist)));
        return artistDTOList;
    }
}
