package com.globant.musicstore.service;

import com.globant.musicstore.dto.IntInvoiceAlbumDTO;

public interface IntInvoiceAlbumService {
	
	IntInvoiceAlbumDTO createIntInvoiceAlbum (IntInvoiceAlbumDTO intInvoiceAlbumDTO);
	
	IntInvoiceAlbumDTO getIntInvoiceAlbum (Integer intInvoiceAlbumId);
	
	IntInvoiceAlbumDTO updateIntInvoiceAlbum (IntInvoiceAlbumDTO intInvoiceAlbumDTO);
	
	IntInvoiceAlbumDTO deleteIntInvoiceAlbum (Integer intInvoiceAlbumId);
	
}
