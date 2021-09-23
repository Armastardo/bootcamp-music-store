package com.globant.musicstore.service;

import com.globant.musicstore.dto.requestDTO.PurchaseRequestDTO;
import com.globant.musicstore.dto.responseDTO.PurchaseResponseDTO;

public interface PurchaseService {
    PurchaseResponseDTO purchaseAlbum(PurchaseRequestDTO purchaseDTO);
}
