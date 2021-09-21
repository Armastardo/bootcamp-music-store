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
	
	private Integer invoice_id ;
	private Client client_id;
	private Date invoice_date;
	private Double total_amount;
	private Boolean is_active;
	
	public InvoiceDTO() {
		
	}
	
}
