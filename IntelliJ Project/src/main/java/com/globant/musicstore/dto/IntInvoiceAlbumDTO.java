package com.globant.musicstore.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.globant.musicstore.entity.Album;
import com.globant.musicstore.entity.Invoice;

public class IntInvoiceAlbumDTO {

	private Integer int_invoice_album_id ;	
	private Invoice invoice_id;	
	private Album album_id;	
	private Integer album_quantity;	
	private Boolean is_active;
	
	public Integer getInt_invoice_album_id() {
		return int_invoice_album_id;
	}
	public void setInt_invoice_album_id(Integer int_invoice_album_id) {
		this.int_invoice_album_id = int_invoice_album_id;
	}
	public Invoice getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Invoice invoice_id) {
		this.invoice_id = invoice_id;
	}
	public Album getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(Album album_id) {
		this.album_id = album_id;
	}
	public Integer getAlbum_quantity() {
		return album_quantity;
	}
	public void setAlbum_quantity(Integer album_quantity) {
		this.album_quantity = album_quantity;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	
}
