package com.globant.musicstore.dto;

import com.globant.musicstore.utils.IntInvoiceAlbumConstants.ResponseConstants;

public class IntInvoiceAlbumResponseDTO<T> {

	private ResponseConstants invoiceConstants;
	private String message;
	private T content;
	
	public IntInvoiceAlbumResponseDTO(ResponseConstants invoiceConstants, String message, T content) {
		super();
		this.invoiceConstants = invoiceConstants;
		this.message = message;
		this.content = content;
	}

	public ResponseConstants getInvoiceConstants() {
		return invoiceConstants;
	}

	public void setInvoiceConstants(ResponseConstants invoiceConstants) {
		this.invoiceConstants = invoiceConstants;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
}
