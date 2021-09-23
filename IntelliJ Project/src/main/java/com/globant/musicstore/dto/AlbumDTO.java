package com.globant.musicstore.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {

    private Long id;
    private String name;
    private Date yearCreation;
    private String description;
    private Double price;
    private Boolean isActive;
    private Integer quantityAvailable;
    private Long artistId;
    private List<SongDTO> songs;

}
