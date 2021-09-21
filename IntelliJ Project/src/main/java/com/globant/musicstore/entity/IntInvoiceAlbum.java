package com.globant.musicstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
