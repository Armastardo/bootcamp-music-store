package com.globant.musicstore.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RepaymentRequestDTO {
    private Long invoiceId;
    private HashMap<Long, Long> returnMap;
}
