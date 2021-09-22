package com.globant.musicstore.dto.requestDTO;

import com.globant.musicstore.entity.HouseRecord;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.sql.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ArtistDTO {

    private long id;
    private String name;
    private Date yearFrom;
    private boolean isSingle;
    private String description;
    private boolean isActive = true;
    private HouseRecord houseRecord;

    public ArtistDTO() {
    }

}
