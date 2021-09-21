package com.globant.musicstore.dto.requestDTO;

import com.globant.musicstore.entity.Artist;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class HouseRecordDTO {
    private long id;
    private String name;
    private Date year_from;
    private String description;
    private boolean isActive = true;
    private Set<Artist> artists;

    public HouseRecordDTO() {
    }
}
