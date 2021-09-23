package com.globant.musicstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.globant.musicstore.entity.Client;

public interface ClientDAO extends JpaRepository<Client, Long> {
	@Query("SELECT client From Client client WHERE client.id IN :id")
	Client getClient(Long id);


}
