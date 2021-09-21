package com.globant.musicstore.dto;

import com.globant.musicstore.entity.Song;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AlbumDTO {

    private Long id;
    private String name;
    private Date yearCreation;
    private String description;
    private Double price;
    private Boolean isActive;
    private Integer quantityAvailable;
    private Long artistId;
    private List<Song> songs;

}
