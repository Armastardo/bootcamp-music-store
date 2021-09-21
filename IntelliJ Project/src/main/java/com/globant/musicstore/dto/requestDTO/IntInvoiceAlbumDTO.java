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

	private Integer int_invoice_album_id ;	
	private Invoice invoice_id;	
	private Album album_id;	
	private Integer album_quantity;	
	private Boolean is_active;
	
	public IntInvoiceAlbumDTO() {
		
	}
	
}
