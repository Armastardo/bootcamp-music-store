package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;
import com.globant.musicstore.entity.IntInvoiceAlbum;
import com.globant.musicstore.entity.Invoice;
import org.springframework.stereotype.Component;

@Component
public class IntInvoiceAlbumDTOMapper {
	
	public IntInvoiceAlbum IntInvoiceAlbumDTOToEntity(IntInvoiceAlbumDTO intInvoiceAlbumDTO  ) {
		
		IntInvoiceAlbum intInvoiceAlbum = IntInvoiceAlbum.builder()
				.intInvoiceAlbumId(intInvoiceAlbumDTO.getIntInvoiceAlbumId())
				.invoiceId(intInvoiceAlbumDTO.getInvoiceId())
				.albumId(intInvoiceAlbumDTO.getAlbumId())
				.albumQuantity(intInvoiceAlbumDTO.getAlbumQuantity())
				.isActive(intInvoiceAlbumDTO.getIsActive())
				.build();

		return intInvoiceAlbum;
		
	}
	
	public  IntInvoiceAlbumDTO EntityToIntInvoiceAlbumDTO (IntInvoiceAlbum intInvoiceAlbum  ) {
		
		IntInvoiceAlbumDTO intInvoiceAlbumDTO = IntInvoiceAlbumDTO.builder()
				.intInvoiceAlbumId(intInvoiceAlbum.getIntInvoiceAlbumId())
				.invoiceId(intInvoiceAlbum.getInvoiceId())
				.albumId(intInvoiceAlbum.getAlbumId())
				.albumQuantity(intInvoiceAlbum.getAlbumQuantity())
				.isActive(intInvoiceAlbum.getIsActive())
				.build();
				
		return intInvoiceAlbumDTO;
		
	}

}
