package com.globant.musicstore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Builder
public class SongDTO {
    private Long id;
    private String name;
    private Time duration;
    private Boolean isActive;
    private Long albumId;
    private Long catGenreId;
}
