package com.globant.musicstore.dto;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    private Long id;
    private String name;
    private Time duration;
    private Boolean isActive;
    private Long albumId;
    private Long catGenreId;
}
