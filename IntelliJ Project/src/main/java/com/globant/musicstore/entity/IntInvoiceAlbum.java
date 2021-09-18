package com.globant.musicstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "int_invoice_album ")
public class IntInvoiceAlbum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "int_invoice_album_id ")
	private Integer int_invoice_album_id ;
	
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice_id;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Album album_id;
	
	@Column(name = "album_quantity")
	private Integer album_quantity;
	
	@Column(name = "is_active")
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
