package com.globant.musicstore.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class RepaymentDTO {
    private Long id;
    private Date date;
    private Long invoiceId;
    private Long catRepaymentId;
    private Integer albumId;
    private Integer quantity;
    private Boolean isActive;
}