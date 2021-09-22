package com.globant.musicstore.service;


import com.globant.musicstore.dto.RepaymentDTO;

public interface RepaymentService {
    RepaymentDTO getRepaymentId(Long repaymentId);
    RepaymentDTO getAlbumId (Long albumId);
    RepaymentDTO deleteRepayment(Long repaymentId);
    RepaymentDTO addRepayment(Long id, RepaymentDTO repaymentDTO);
    RepaymentDTO updateRepayment(Long id, RepaymentDTO repaymentDTO);
}
