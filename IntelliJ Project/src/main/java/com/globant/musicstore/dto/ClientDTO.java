package com.globant.musicstore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private Integer stars;
    private Long clientType;
    private Boolean isActive;
}