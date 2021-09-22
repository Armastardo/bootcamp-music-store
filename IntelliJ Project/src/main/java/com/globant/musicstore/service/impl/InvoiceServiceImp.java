package com.globant.musicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.globant.musicstore.dao.InvoiceDAO;
import com.globant.musicstore.dto.requestDTO.InvoiceDTO;
import com.globant.musicstore.entity.Invoice;
import com.globant.musicstore.mapper.InvoiceMapper;
import com.globant.musicstore.service.InvoiceService;

public class InvoiceServiceImp implements InvoiceService{

	@Autowired
	InvoiceMapper invoiceMapper;
	
	@Autowired
	InvoiceDAO invoiceDAO;
	
	@Override
	public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
		
		invoiceDTO.setIsActive(Boolean.TRUE);
		return invoiceMapper.EntityToInvoiceDTO(invoiceDAO.save(invoiceMapper.InvoiceDTOToEntity(invoiceDTO)));
				
	}

	@Override
	public InvoiceDTO getInvoice(Integer invoiceId) {
		
		return invoiceMapper.EntityToInvoiceDTO(invoiceDAO.getById(invoiceId));
		
	}

	@Override
	public InvoiceDTO updateInvoice(InvoiceDTO invoiceDTO) {

		return invoiceMapper.EntityToInvoiceDTO(invoiceDAO.save(invoiceMapper.InvoiceDTOToEntity(invoiceDTO)));
	}

	@Override
	public InvoiceDTO deleteInvoice(Integer invoiceId) {

		Invoice invoiceToBeDisabled = new Invoice();
		invoiceToBeDisabled = invoiceDAO.getById(invoiceId);
		invoiceToBeDisabled.setIsActive(Boolean.FALSE);		
		
		return invoiceMapper.EntityToInvoiceDTO(invoiceDAO.save(invoiceToBeDisabled));
		
	}

}
