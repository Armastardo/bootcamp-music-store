package com.globant.musicstore.mapper;

import com.globant.musicstore.dto.Album;
import com.globant.musicstore.dto.IntInvoiceAlbumDTO;
import com.globant.musicstore.entity.IntInvoiceAlbum;
import com.globant.musicstore.entity.Invoice;

public class IntInvoiceAlbumDTOMapper {
	
	public IntInvoiceAlbum IntInvoiceAlbumDTOToEntity(IntInvoiceAlbumDTO intInvoiceAlbumDTO  ) {
		
		IntInvoiceAlbum intInvoiceAlbum = new IntInvoiceAlbum();
		intInvoiceAlbum.setInt_invoice_album_id(intInvoiceAlbumDTO.getInt_invoice_album_id());
		intInvoiceAlbum.setInvoice_id(intInvoiceAlbumDTO.getInvoice_id());
		intInvoiceAlbum.setAlbum_id(intInvoiceAlbumDTO.getAlbum_id());
		intInvoiceAlbum.setAlbum_quantity(intInvoiceAlbumDTO.getAlbum_quantity());
		intInvoiceAlbum.setIs_active(intInvoiceAlbumDTO.getIs_active());
		return intInvoiceAlbum;
		
	}
	
	public  IntInvoiceAlbumDTO EntityToIntInvoiceAlbumDTO (IntInvoiceAlbum intInvoiceAlbum  ) {
		
		IntInvoiceAlbumDTO intInvoiceAlbumDTO = new IntInvoiceAlbumDTO();
		intInvoiceAlbumDTO.setInt_invoice_album_id(intInvoiceAlbum.getInt_invoice_album_id());
		intInvoiceAlbumDTO.setInvoice_id(intInvoiceAlbum.getInvoice_id());
		intInvoiceAlbumDTO.setAlbum_id(intInvoiceAlbum.getAlbum_id());
		intInvoiceAlbumDTO.setAlbum_quantity(intInvoiceAlbum.getAlbum_quantity());
		intInvoiceAlbumDTO.setIs_active(intInvoiceAlbum.getIs_active());
		return intInvoiceAlbumDTO;
		
	}

}
