package com.globant.musicstore.controller;

import com.globant.musicstore.dto.requestDTO.PurchaseRequestDTO;
import com.globant.musicstore.dto.ResponseDTO;
import com.globant.musicstore.dto.responseDTO.PurchaseResponseDTO;
import com.globant.musicstore.service.PurchaseService;
import com.globant.musicstore.utils.Constants.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/")
    public ResponseEntity<ResponseDTO<PurchaseResponseDTO>> makePurchase(@RequestBody PurchaseRequestDTO purchaseDTO) {
        ResponseDTO<PurchaseResponseDTO> response = new ResponseDTO<>(ResponseConstants.SUCCESS, "good", purchaseService.purchaseAlbum(purchaseDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
