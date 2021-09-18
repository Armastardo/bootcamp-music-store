package com.globant.musicstore.mapper;

import java.util.Date;

import com.globant.musicstore.dto.Client;
import com.globant.musicstore.dto.InvoiceDTO;
import com.globant.musicstore.entity.Invoice;

public class InvoiceMapper {

	public Invoice InvoiceDTOToEntity(InvoiceDTO invoiceDTO ) {
		
		Invoice invoice = new Invoice();
		invoice.setInvoice_id(invoiceDTO.getInvoice_id());
		invoice.setClient_id(invoiceDTO.getClient_id());
		invoice.setInvoice_date(invoiceDTO.getInvoice_date());
		invoice.setTotal_amount(invoiceDTO.getTotal_amount());
		invoice.setIs_active(invoiceDTO.getIs_active());
		return invoice;
		
	}
	
	public InvoiceDTO EntityToInvoiceDTO(Invoice invoice ) {
		
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setInvoice_id(invoice.getInvoice_id());
		invoiceDTO.setClient_id(invoice.getClient_id());
		invoiceDTO.setInvoice_date(invoice.getInvoice_date());
		invoiceDTO.setTotal_amount(invoice.getTotal_amount());
		invoiceDTO.setIs_active(invoice.getIs_active());
		return invoiceDTO;
		
	}
	
}
