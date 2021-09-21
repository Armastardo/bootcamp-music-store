package com.globant.musicstore.mapper;

import com.globant.musicstore.dto.Album;
import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;
import com.globant.musicstore.entity.IntInvoiceAlbum;
import com.globant.musicstore.entity.Invoice;

public class IntInvoiceAlbumDTOMapper {
	
	public IntInvoiceAlbum IntInvoiceAlbumDTOToEntity(IntInvoiceAlbumDTO intInvoiceAlbumDTO  ) {
		
		IntInvoiceAlbum intInvoiceAlbum = IntInvoiceAlbum.builder()
				.int_invoice_album_id(intInvoiceAlbumDTO.getInt_invoice_album_id())
				.invoice_id(intInvoiceAlbumDTO.getInvoice_id())
				.album_id(intInvoiceAlbumDTO.getAlbum_id())
				.album_quantity(intInvoiceAlbumDTO.getAlbum_quantity())
				.is_active(intInvoiceAlbumDTO.getIs_active())
				.build();

		return intInvoiceAlbum;
		
	}
	
	public  IntInvoiceAlbumDTO EntityToIntInvoiceAlbumDTO (IntInvoiceAlbum intInvoiceAlbum  ) {
		
		IntInvoiceAlbumDTO intInvoiceAlbumDTO = IntInvoiceAlbumDTO.builder()
				.int_invoice_album_id(intInvoiceAlbum.getInt_invoice_album_id())
				.invoice_id(intInvoiceAlbum.getInvoice_id())
				.album_id(intInvoiceAlbum.getAlbum_id())
				.album_quantity(intInvoiceAlbum.getAlbum_quantity())
				.is_active(intInvoiceAlbum.getIs_active())
				.build();
				
		return intInvoiceAlbumDTO;
		
	}

}
