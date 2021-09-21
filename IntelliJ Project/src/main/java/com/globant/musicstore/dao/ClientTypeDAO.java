package com.globant.musicstore.dao;

import com.globant.musicstore.entity.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientTypeDAO extends JpaRepository<ClientType, Long> {
    @Query("SELECT clientType FROM ClientType clientType WHERE clientType.id IN :id")
    ClientType getClientType(Long id);

}
