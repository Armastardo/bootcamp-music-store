package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.CatGenreDTO;
import com.globant.musicstore.entity.CatGenre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatGenreMapper {

    public CatGenreDTO genreToDto(CatGenre catGenreEntity) {
        CatGenreDTO catGenreDTO = CatGenreDTO.builder()
                .id(catGenreEntity.getId())
                .name(catGenreEntity.getName())
                .description(catGenreEntity.getDescription())
                .isActive(catGenreEntity.isActive())
                .build();
        return catGenreDTO;
    }

    public CatGenre genreDTOToGenre(CatGenreDTO catGenreDTO) {
        CatGenre catGenreEntity = CatGenre.builder()
                .id(catGenreDTO.getId())
                .name(catGenreDTO.getName())
                .description(catGenreDTO.getDescription())
                .isActive(catGenreDTO.isActive())
                .build();
        return catGenreEntity;
    }

    public List<CatGenreDTO> listGenreToDTO(List<CatGenre> catGenreList) {
        List<CatGenreDTO> catGenreDTOList = new ArrayList<CatGenreDTO>();
        catGenreList.forEach(genre -> catGenreDTOList.add(genreToDto(genre)));
        return catGenreDTOList;
    }
}
