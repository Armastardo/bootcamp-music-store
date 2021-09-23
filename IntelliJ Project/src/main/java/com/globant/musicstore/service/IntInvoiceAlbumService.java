package com.globant.musicstore.service;

import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;

public interface IntInvoiceAlbumService {
	
	IntInvoiceAlbumDTO createIntInvoiceAlbum (IntInvoiceAlbumDTO intInvoiceAlbumDTO);
	
	IntInvoiceAlbumDTO getIntInvoiceAlbum (Long intInvoiceAlbumId);
	
	IntInvoiceAlbumDTO updateIntInvoiceAlbum (IntInvoiceAlbumDTO intInvoiceAlbumDTO);
	
	IntInvoiceAlbumDTO deleteIntInvoiceAlbum (Long intInvoiceAlbumId);
	
}
