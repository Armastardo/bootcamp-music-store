package com.globant.musicstore.service;

import com.globant.musicstore.dto.RepaymentDTO;
import com.globant.musicstore.dto.requestDTO.PurchaseRequestDTO;
import com.globant.musicstore.dto.requestDTO.RepaymentRequestDTO;
import com.globant.musicstore.dto.responseDTO.PurchaseResponseDTO;

import java.util.List;

public interface StoreService {
    PurchaseResponseDTO purchaseAlbum(PurchaseRequestDTO purchaseDTO);

    List<RepaymentDTO> returnItems(RepaymentRequestDTO repaymentRequestDTO);
}
