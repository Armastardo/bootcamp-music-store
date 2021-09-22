package com.globant.musicstore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CatRepaymentTypeDTO {
    private Long catRepaymentTypeId;
    private String catRepaymentType;
    private String catRepaymentDescription;
    private Boolean isActive;
}

