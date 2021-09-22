package com.globant.musicstore.mapper;

import com.globant.musicstore.dto.requestDTO.InvoiceDTO;
import com.globant.musicstore.entity.Invoice;

public class InvoiceMapper {

	public Invoice InvoiceDTOToEntity(InvoiceDTO invoiceDTO ) {
		
		Invoice invoice = Invoice.builder()
				.invoice_id(invoiceDTO.getInvoice_id())
				.client_id(invoiceDTO.getClient_id())
				.invoice_date(invoiceDTO.getInvoice_date())
				.total_amount(invoiceDTO.getTotal_amount())
				.is_active(invoiceDTO.getIs_active())
				.build();
		return invoice;		
	}
	
	public InvoiceDTO EntityToInvoiceDTO(Invoice invoice ) {
		
		InvoiceDTO invoiceDTO = InvoiceDTO.builder()
				.invoice_id(invoice.getInvoice_id())
				.client_id(invoice.getClient_id())
				.invoice_date(invoice.getInvoice_date())
				.total_amount(invoice.getTotal_amount())
				.is_active(invoice.getIs_active())
				.build();
		return invoiceDTO;
		
	}
	
}
