package com.globant.musicstore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientTypeDTO {
    private Long id;
    private String type;
    private String description;
    private Boolean isActive;
}
