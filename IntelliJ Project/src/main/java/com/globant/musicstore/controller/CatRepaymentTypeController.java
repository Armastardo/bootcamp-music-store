package com.globant.musicstore.controller;

import com.globant.musicstore.dto.CatRepaymentTypeDTO;
import com.globant.musicstore.dto.ResponseDTO;
import com.globant.musicstore.service.CatRepaymentTypeService;
import com.globant.musicstore.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.globant.musicstore.utils.Constants.ID_FOUNDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.Constants.ITEM_ADDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.Constants.ITEM_UPDATED_SUCCESSFULLY;

@RestController
@RequestMapping("/api/repayments")
public class CatRepaymentTypeController {

    @Autowired
    CatRepaymentTypeService catRepaymentTypeService;

    @GetMapping(path = "/{RepaymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<CatRepaymentTypeDTO>>  getCatRepaymentId(@PathVariable Long id) {

        ResponseDTO catRepaymentTypeResponseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ID_FOUNDED_SUCCESSFULLY, catRepaymentTypeService.getCatRepaymentId(id));
        return new ResponseEntity<>(catRepaymentTypeResponseDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<CatRepaymentTypeDTO>> deleteRepaymentType(@RequestBody Long id) {

        ResponseDTO catRepaymentTypeResponseDTO  = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ID_FOUNDED_SUCCESSFULLY , catRepaymentTypeService.deleteRepaymentType(id));
        return new ResponseEntity<>(catRepaymentTypeResponseDTO, HttpStatus.OK);
    }


    @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<CatRepaymentTypeDTO>> updateRepaymentType(@PathVariable Long id, @RequestBody CatRepaymentTypeDTO catRepaymentTypeDTO) {

        ResponseDTO catRepaymentTypeResponseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_UPDATED_SUCCESSFULLY,catRepaymentTypeService.updateRepaymentType(id, catRepaymentTypeDTO));
        return new ResponseEntity<>(catRepaymentTypeResponseDTO, HttpStatus.CREATED);
    }
    @PostMapping(path = "/add/{idRepayment  }", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<CatRepaymentTypeDTO>> addRepaymentType(@PathVariable Long id, @RequestBody CatRepaymentTypeDTO catRepaymentTypeDTO) {

        ResponseDTO catRepaymentTypeResponseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_ADDED_SUCCESSFULLY, catRepaymentTypeService.addRepaymentType(id,catRepaymentTypeDTO));
        return new ResponseEntity<>(catRepaymentTypeResponseDTO, HttpStatus.CREATED);
    }
}

