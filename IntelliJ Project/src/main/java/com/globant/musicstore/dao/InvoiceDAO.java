package com.globant.musicstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.musicstore.entity.Invoice;

public interface InvoiceDAO extends JpaRepository<Invoice, Integer>{

}
