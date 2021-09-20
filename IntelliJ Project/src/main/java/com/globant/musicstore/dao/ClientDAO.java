package com.globant.musicstore.dao;

import com.globant.musicstore.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<Client, Long> {


}
