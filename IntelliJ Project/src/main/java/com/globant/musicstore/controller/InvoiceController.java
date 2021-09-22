package com.globant.musicstore.controller;

import static com.globant.musicstore.utils.InvoiceConstants.INVOICE_ADDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.InvoiceConstants.INVOICE_DELETED_SUCCESSFULLY;
import static com.globant.musicstore.utils.InvoiceConstants.INVOICE_FOUNDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.InvoiceConstants.INVOICE_UPDATED_SUCCESSFULLY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.musicstore.dto.requestDTO.InvoiceDTO;
import com.globant.musicstore.dto.responseDTO.InvoiceResponseDTO;
import com.globant.musicstore.service.InvoiceService;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InvoiceResponseDTO<InvoiceDTO>> createInvoice(@RequestBody InvoiceDTO invoiceDTO){
		
		InvoiceResponseDTO invoiceResponseDTO = new  InvoiceResponseDTO(INVOICE_ADDED_SUCCESSFULLY, invoiceService.createInvoice(invoiceDTO));
		return new ResponseEntity<>(invoiceResponseDTO, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InvoiceResponseDTO<InvoiceDTO>> getInvoice(@PathVariable Integer invoiceId){
		
		InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO(INVOICE_FOUNDED_SUCCESSFULLY, invoiceService.getInvoice(invoiceId));		
		return new ResponseEntity<>(invoiceResponseDTO, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InvoiceResponseDTO<InvoiceDTO>> updateInvoice(@RequestBody InvoiceDTO invoiceDTO) {	
		
		InvoiceResponseDTO invoiceResponseDTO = new  InvoiceResponseDTO(INVOICE_UPDATED_SUCCESSFULLY, invoiceService.updateInvoice(invoiceDTO));
		return new ResponseEntity<>(invoiceResponseDTO, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InvoiceResponseDTO<InvoiceDTO>> deleteInvoice(@PathVariable Integer invoiceId) {
		
		InvoiceResponseDTO invoiceResponseDTO  = new InvoiceResponseDTO(INVOICE_DELETED_SUCCESSFULLY , invoiceService.deleteInvoice(invoiceId));
		return new ResponseEntity<>(invoiceResponseDTO, HttpStatus.OK);
	}
		
}
