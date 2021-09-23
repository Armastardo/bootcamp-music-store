package com.globant.musicstore.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class PurchaseRequestDTO {
    private Long clientId;
    private HashMap<Long, Integer> purchaseMap;
}
