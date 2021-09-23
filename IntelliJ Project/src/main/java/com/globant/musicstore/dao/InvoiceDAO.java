package com.globant.musicstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.globant.musicstore.entity.Invoice;

public interface InvoiceDAO extends JpaRepository<Invoice, Long>{
	@Query("SELECT invoice From Invoice invoice WHERE invoice.invoiceId IN :id")
	Invoice getinvoice (Long id);

}
