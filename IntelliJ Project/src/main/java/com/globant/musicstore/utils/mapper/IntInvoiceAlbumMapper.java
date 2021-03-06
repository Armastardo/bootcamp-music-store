package com.globant.musicstore.utils.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.musicstore.dao.AlbumDAO;
import com.globant.musicstore.dao.InvoiceDAO;
import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;
import com.globant.musicstore.entity.IntInvoiceAlbum;

@Component
public class IntInvoiceAlbumMapper {
	
	@Autowired
	AlbumDAO albumDAO;
	
	@Autowired
	InvoiceDAO invoiceDAO;
	
	public IntInvoiceAlbum IntInvoiceAlbumDTOToEntity(IntInvoiceAlbumDTO intInvoiceAlbumDTO  ) {
			
		
		IntInvoiceAlbum intInvoiceAlbum = IntInvoiceAlbum.builder()
				.intInvoiceAlbumId(intInvoiceAlbumDTO.getIntInvoiceAlbumId())
				.invoiceId(invoiceDAO.getInvoice(intInvoiceAlbumDTO.getAlbumId()))
				.albumId(albumDAO.getAlbum(intInvoiceAlbumDTO.getAlbumId()))
				.albumQuantity(intInvoiceAlbumDTO.getAlbumQuantity())
				.isActive(intInvoiceAlbumDTO.getIsActive())
				.build();

		return intInvoiceAlbum;
		
	}
	
	public  IntInvoiceAlbumDTO EntityToIntInvoiceAlbumDTO (IntInvoiceAlbum intInvoiceAlbum  ) {
		
		IntInvoiceAlbumDTO intInvoiceAlbumDTO = IntInvoiceAlbumDTO.builder()
				.intInvoiceAlbumId(intInvoiceAlbum.getIntInvoiceAlbumId())
				.invoiceId(intInvoiceAlbum.getInvoiceId().getInvoiceId())
				.albumId(intInvoiceAlbum.getAlbumId().getId())
				.albumQuantity(intInvoiceAlbum.getAlbumQuantity())
				.isActive(intInvoiceAlbum.getIsActive())
				.build();
				
		return intInvoiceAlbumDTO;
		
	}

}
