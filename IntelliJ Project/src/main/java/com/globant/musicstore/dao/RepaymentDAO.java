package com.globant.musicstore.dao;

import com.globant.musicstore.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepaymentDAO extends JpaRepository<Repayment, Long> {
}
