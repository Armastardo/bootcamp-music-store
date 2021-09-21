package com.globant.musicstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.globant.musicstore.dao.IntInvoiceAlbumDAO;
import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;
import com.globant.musicstore.entity.IntInvoiceAlbum;
import com.globant.musicstore.entity.Invoice;
import com.globant.musicstore.mapper.IntInvoiceAlbumDTOMapper;

public class IntInvoiceAlbumServiceImp implements IntInvoiceAlbumService{

	@Autowired
	IntInvoiceAlbumDTOMapper intInvoiceAlbumDTOMapper;
	
	@Autowired
	IntInvoiceAlbumDAO intInvoiceAlbumDAO;
	
	@Override
	public IntInvoiceAlbumDTO createIntInvoiceAlbum(IntInvoiceAlbumDTO intInvoiceAlbumDTO) {
		
		intInvoiceAlbumDTO.setIs_active(Boolean.TRUE);
		return intInvoiceAlbumDTOMapper.EntityToIntInvoiceAlbumDTO(intInvoiceAlbumDAO.save(intInvoiceAlbumDTOMapper.IntInvoiceAlbumDTOToEntity(intInvoiceAlbumDTO)));
				
	}

	@Override
	public IntInvoiceAlbumDTO getIntInvoiceAlbum(Integer intInvoiceAlbumId) {
		return intInvoiceAlbumDTOMapper.EntityToIntInvoiceAlbumDTO(intInvoiceAlbumDAO.getById(intInvoiceAlbumId));
	}

	@Override
	public IntInvoiceAlbumDTO updateIntInvoiceAlbum(IntInvoiceAlbumDTO intInvoiceAlbumDTO) {
		
		return intInvoiceAlbumDTOMapper.EntityToIntInvoiceAlbumDTO(intInvoiceAlbumDAO.save(intInvoiceAlbumDTOMapper.IntInvoiceAlbumDTOToEntity(intInvoiceAlbumDTO)));
	}

	@Override
	public IntInvoiceAlbumDTO deleteIntInvoiceAlbum(Integer intInvoiceAlbumId) {
		
		IntInvoiceAlbum intInvoiceToBeDisabled = new IntInvoiceAlbum();
		intInvoiceToBeDisabled = intInvoiceAlbumDAO.getById(intInvoiceAlbumId);
		intInvoiceToBeDisabled.setIs_active(Boolean.FALSE);		
		
		return intInvoiceAlbumDTOMapper.EntityToIntInvoiceAlbumDTO(intInvoiceAlbumDAO.save(intInvoiceToBeDisabled));
	}

}
