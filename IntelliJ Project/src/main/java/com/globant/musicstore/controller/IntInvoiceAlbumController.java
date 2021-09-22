package com.globant.musicstore.controller;

import static com.globant.musicstore.utils.IntInvoiceAlbumConstants.INTINVOICEALBUM_ADDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.IntInvoiceAlbumConstants.INTINVOICEALBUM_FOUNDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.IntInvoiceAlbumConstants.INTINVOICEALBUM_UPDATED_SUCCESSFULLY;
import static com.globant.musicstore.utils.IntInvoiceAlbumConstants.INTINVOICEALBUM_DELETED_SUCCESSFULLY;

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

import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;
import com.globant.musicstore.dto.responseDTO.IntInvoiceAlbumResponseDTO;
import com.globant.musicstore.service.IntInvoiceAlbumService;
import com.globant.musicstore.utils.IntInvoiceAlbumConstants.ResponseConstants;

@RestController
@RequestMapping("intInvoiceAlbumController")
public class IntInvoiceAlbumController {

	@Autowired
	IntInvoiceAlbumService intInvoiceAlbumService;
	
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IntInvoiceAlbumResponseDTO<IntInvoiceAlbumDTO>> createIntInvoiceAlbum(@RequestBody IntInvoiceAlbumDTO intInvoiceAlbumDTO){
		
		IntInvoiceAlbumResponseDTO intInvoiceAlbumResponseDTO = new IntInvoiceAlbumResponseDTO(INTINVOICEALBUM_ADDED_SUCCESSFULLY, intInvoiceAlbumService.createIntInvoiceAlbum(intInvoiceAlbumDTO));
		return new ResponseEntity<>(intInvoiceAlbumResponseDTO, HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "/{intInvoiceAlbumId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IntInvoiceAlbumResponseDTO<IntInvoiceAlbumDTO>> getIntInvoiceAlbum(@PathVariable Integer invoiceId){
		
		IntInvoiceAlbumResponseDTO intInvoiceAlbumResponseDTO = new IntInvoiceAlbumResponseDTO(INTINVOICEALBUM_FOUNDED_SUCCESSFULLY, intInvoiceAlbumService.getIntInvoiceAlbum(invoiceId));
		return new ResponseEntity<>(intInvoiceAlbumResponseDTO, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IntInvoiceAlbumResponseDTO<IntInvoiceAlbumDTO>> updateIntInvoiceAlbum(@RequestBody IntInvoiceAlbumDTO intInvoiceAlbumDTO){
		
		IntInvoiceAlbumResponseDTO intInvoiceAlbumResponseDTO = new IntInvoiceAlbumResponseDTO(INTINVOICEALBUM_UPDATED_SUCCESSFULLY, intInvoiceAlbumService.updateIntInvoiceAlbum(intInvoiceAlbumDTO));
		return new ResponseEntity<>(intInvoiceAlbumResponseDTO, HttpStatus.OK);
	}
		
	@PutMapping(path = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IntInvoiceAlbumResponseDTO<IntInvoiceAlbumDTO>> deleteIntInvoiceAlbum(@RequestBody Integer intInvoiceAlbumDTO) {
		
		IntInvoiceAlbumResponseDTO intInvoiceAlbumResponseDTO  = new IntInvoiceAlbumResponseDTO(INTINVOICEALBUM_DELETED_SUCCESSFULLY , intInvoiceAlbumService.deleteIntInvoiceAlbum(intInvoiceAlbumDTO));
		return new ResponseEntity<>(intInvoiceAlbumResponseDTO, HttpStatus.OK);
	}
		
}
