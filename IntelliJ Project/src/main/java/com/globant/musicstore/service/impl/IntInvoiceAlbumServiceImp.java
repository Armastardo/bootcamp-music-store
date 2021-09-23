package com.globant.musicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.globant.musicstore.dao.IntInvoiceAlbumDAO;
import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;
import com.globant.musicstore.entity.IntInvoiceAlbum;
import com.globant.musicstore.utils.mapper.IntInvoiceAlbumMapper;
import com.globant.musicstore.service.IntInvoiceAlbumService;
import org.springframework.stereotype.Service;

@Service
public class IntInvoiceAlbumServiceImp implements IntInvoiceAlbumService{

	@Autowired
	private IntInvoiceAlbumMapper intInvoiceAlbumDTOMapper;
	
	@Autowired
	private IntInvoiceAlbumDAO intInvoiceAlbumDAO;
	
	@Override
	public IntInvoiceAlbumDTO createIntInvoiceAlbum(IntInvoiceAlbumDTO intInvoiceAlbumDTO) {
		
		intInvoiceAlbumDTO.setIsActive(Boolean.TRUE);
		return intInvoiceAlbumDTOMapper.EntityToIntInvoiceAlbumDTO(intInvoiceAlbumDAO.save(intInvoiceAlbumDTOMapper.IntInvoiceAlbumDTOToEntity(intInvoiceAlbumDTO)));
				
	}

	@Override
	public IntInvoiceAlbumDTO getIntInvoiceAlbum(Long intInvoiceAlbumId) {
		return intInvoiceAlbumDTOMapper.EntityToIntInvoiceAlbumDTO(intInvoiceAlbumDAO.getById(intInvoiceAlbumId));
	}

	@Override
	public IntInvoiceAlbumDTO updateIntInvoiceAlbum(IntInvoiceAlbumDTO intInvoiceAlbumDTO) {
		
		return intInvoiceAlbumDTOMapper.EntityToIntInvoiceAlbumDTO(intInvoiceAlbumDAO.save(intInvoiceAlbumDTOMapper.IntInvoiceAlbumDTOToEntity(intInvoiceAlbumDTO)));
	}

	@Override
	public IntInvoiceAlbumDTO deleteIntInvoiceAlbum(Long intInvoiceAlbumId) {
		
		IntInvoiceAlbum intInvoiceToBeDisabled = new IntInvoiceAlbum();
		intInvoiceToBeDisabled = intInvoiceAlbumDAO.getById(intInvoiceAlbumId);
		intInvoiceToBeDisabled.setIsActive(Boolean.FALSE);		
		
		return intInvoiceAlbumDTOMapper.EntityToIntInvoiceAlbumDTO(intInvoiceAlbumDAO.save(intInvoiceToBeDisabled));
	}

}
