package com.globant.musicstore.dto;

import java.util.Date;

public class InvoiceDTO {
	
	private Integer invoice_id ;
	private Client client_id;
	private Date invoice_date;
	private Double total_amount;
	private Boolean is_active;
	
	public Integer getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}
	public Client getClient_id() {
		return client_id;
	}
	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}
	public Date getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}
	public Double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

}
