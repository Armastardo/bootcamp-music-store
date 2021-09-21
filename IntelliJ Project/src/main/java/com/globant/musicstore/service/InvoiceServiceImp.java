package com.globant.musicstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.globant.musicstore.dao.InvoiceDAO;
import com.globant.musicstore.dto.requestDTO.InvoiceDTO;
import com.globant.musicstore.entity.Invoice;
import com.globant.musicstore.mapper.InvoiceMapper;

public class InvoiceServiceImp implements InvoiceService{

	@Autowired
	InvoiceMapper invoiceMapper;
	
	@Autowired
	InvoiceDAO invoiceDAO;
	
	@Override
	public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
		
		invoiceDTO.setIs_active(Boolean.TRUE);
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
		invoiceToBeDisabled.setIs_active(Boolean.FALSE);		
		
		return invoiceMapper.EntityToInvoiceDTO(invoiceDAO.save(invoiceToBeDisabled));
		
	}

}
