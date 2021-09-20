package com.globant.musicstore.dao;

import com.globant.musicstore.entity.HouseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRecordDAO extends JpaRepository<HouseRecord, Long> {
}
