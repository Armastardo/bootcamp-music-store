package com.globant.musicstore.dto.responseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IntInvoiceAlbumResponseDTO<T> {

	private String message;
	private T content;
	
	public IntInvoiceAlbumResponseDTO(String message, T content) {
		super();
		this.message = message;
		this.content = content;
	}

	
}
