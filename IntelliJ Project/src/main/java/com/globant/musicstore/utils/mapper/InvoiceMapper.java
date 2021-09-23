package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.InvoiceDTO;
import com.globant.musicstore.entity.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

	public Invoice InvoiceDTOToEntity(InvoiceDTO invoiceDTO ) {
		
		Invoice invoice = Invoice.builder()
				.invoiceId(invoiceDTO.getInvoiceId())
				.clientId(invoiceDTO.getClientId())
				.invoiceDate(invoiceDTO.getInvoiceDate())
				.totalAmount(invoiceDTO.getTotalAmount())
				.isActive(invoiceDTO.getIsActive())
				.build();
		return invoice;		
	}
	
	public InvoiceDTO EntityToInvoiceDTO(Invoice invoice ) {
		
		InvoiceDTO invoiceDTO = InvoiceDTO.builder()
				.invoiceId(invoice.getInvoiceId())
				.clientId(invoice.getClientId())
				.invoiceDate(invoice.getInvoiceDate())
				.totalAmount(invoice.getTotalAmount())
				.isActive(invoice.getIsActive())
				.build();
		return invoiceDTO;
		
	}
	
}
