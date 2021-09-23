package com.globant.musicstore.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashMap;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PurchaseResponseDTO {
    private Long clientId;
    private HashMap<Long, Integer> purchaseMap;
    private Date date;
    private Integer stars;
    private Double total;
}
