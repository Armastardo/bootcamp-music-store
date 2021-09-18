package com.globant.musicstore.service;

import com.globant.musicstore.dto.InvoiceDTO;

public interface InvoiceService {


	InvoiceDTO createInvoice (InvoiceDTO invoiceDTO);
	
	InvoiceDTO getInvoice (Integer invoiceId);
	
	InvoiceDTO updateInvoice (InvoiceDTO invoiceDTO);
	
	InvoiceDTO deleteInvoice (Integer invoiceId);
	
}
