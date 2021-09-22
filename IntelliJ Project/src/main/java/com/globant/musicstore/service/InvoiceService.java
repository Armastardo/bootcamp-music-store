package com.globant.musicstore.service;

import com.globant.musicstore.dto.requestDTO.InvoiceDTO;

public interface InvoiceService {

	InvoiceDTO createInvoice (InvoiceDTO invoiceDTO);
	
	InvoiceDTO getInvoice (Long invoiceId);
	
	InvoiceDTO updateInvoice (InvoiceDTO invoiceDTO);
	
	InvoiceDTO deleteInvoice (Long invoiceId);
	
}
