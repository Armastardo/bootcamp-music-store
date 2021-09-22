package com.globant.musicstore.dto.requestDTO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.globant.musicstore.entity.Album;
import com.globant.musicstore.entity.HouseRecord;
import com.globant.musicstore.entity.Invoice;

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
	private Invoice invoiceId;	
	private Album albumId;	
	private Integer albumQuantity;	
	private Boolean isActive;
	
	public IntInvoiceAlbumDTO() {
		
	}
	
}
