package com.globant.musicstore.dto.requestDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CatGenreDTO {

    private long id;
    private String name;
    private String description;
    private boolean isActive = true;

    public CatGenreDTO() {
    }
}
