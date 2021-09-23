package com.globant.musicstore.controller;

import com.globant.musicstore.dto.RepaymentDTO;
import com.globant.musicstore.dto.requestDTO.PurchaseRequestDTO;
import com.globant.musicstore.dto.ResponseDTO;
import com.globant.musicstore.dto.requestDTO.RepaymentRequestDTO;
import com.globant.musicstore.dto.responseDTO.PurchaseResponseDTO;
import com.globant.musicstore.service.StoreService;
import com.globant.musicstore.utils.Constants.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.globant.musicstore.utils.constants.Constants.PURCHASE_SUCCESSFULL;
import static com.globant.musicstore.utils.constants.Constants.REPAYMENT_SUCCESSFULL;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreService purchaseService;

    @PostMapping("/")
    public ResponseEntity<ResponseDTO<PurchaseResponseDTO>> makePurchase(@RequestBody PurchaseRequestDTO purchaseDTO) {
        ResponseDTO<PurchaseResponseDTO> response = new ResponseDTO<>(ResponseConstants.SUCCESS, PURCHASE_SUCCESSFULL, purchaseService.purchaseAlbum(purchaseDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/return/")
    public ResponseEntity<ResponseDTO<List<RepaymentDTO>>> returnItems(@RequestBody RepaymentRequestDTO repaymentRequestDTO) {
        ResponseDTO<List<RepaymentDTO>> response = new ResponseDTO<>(ResponseConstants.SUCCESS, REPAYMENT_SUCCESSFULL, purchaseService.returnItems(repaymentRequestDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
