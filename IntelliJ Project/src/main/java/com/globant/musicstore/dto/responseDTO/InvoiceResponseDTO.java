package com.globant.musicstore.dto.responseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InvoiceResponseDTO<T> {


	private String message;
	private T content;
	
	public InvoiceResponseDTO(String message, T content) {
		super();
		this.message = message;
		this.content = content;
	}
		
}
