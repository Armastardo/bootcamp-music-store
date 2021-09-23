package com.globant.musicstore.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class IntInvoiceAlbumDTO {

	private Integer intInvoiceAlbumId ;	
	private Long invoiceId;
	private Long albumId;
	private Integer albumQuantity;	
	private Boolean isActive;
	
	public IntInvoiceAlbumDTO() {
		
	}
	
}
