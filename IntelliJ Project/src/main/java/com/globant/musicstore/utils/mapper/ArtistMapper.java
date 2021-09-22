package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.entity.Artist;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArtistMapper {

    public ArtistDTO artistToDTO(Artist artistEntity) {
        return ArtistDTO.builder()
                .id(artistEntity.getId())
                .name(artistEntity.getName())
                .yearFrom(artistEntity.getYearFrom())
                .isSingle(artistEntity.isSingle())
                .description(artistEntity.getDescription())
                .isActive(artistEntity.isActive())
                .houseRecord(artistEntity.getHouseRecord())
                .build();
    }

    public Artist artistDTOtoArtist(ArtistDTO artistDTO) {
        return Artist.builder()
                .id(artistDTO.getId())
                .name(artistDTO.getName())
                .yearFrom(artistDTO.getYearFrom())
                .isSingle(artistDTO.isSingle())
                .description(artistDTO.getDescription())
                .isActive(artistDTO.isActive())
                .houseRecord(artistDTO.getHouseRecord())
                .build();
    }

    public List<ArtistDTO> listArtistToDTO(List<Artist> artistList) {
        List<ArtistDTO> artistDTOList = new ArrayList<ArtistDTO>();
        artistList.forEach(artist -> artistDTOList.add(artistToDTO(artist)));
        return artistDTOList;
    }
}
