package com.globant.musicstore.dto.requestDTO;

import java.util.Date;

import com.globant.musicstore.entity.Client;
import com.globant.musicstore.entity.HouseRecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class InvoiceDTO {
	
	private Integer invoiceId ;
	private Client clientId;
	private Date invoiceDate;
	private Double totalAmount;
	private Boolean isActive;
	
	public InvoiceDTO() {
		
	}
	
}
