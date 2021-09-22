package com.globant.musicstore.controller;

import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;
import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.service.HouseRecordService;
import com.globant.musicstore.utils.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api/house-records")
public class HouseRecordController {

    @Autowired
    private HouseRecordService houseRecordService;

    @PostMapping("/")
    public ResponseEntity<ResponseDTO<HouseRecordDTO>> save(@RequestBody HouseRecordDTO houseRecordDTO) {
        ResponseDTO<HouseRecordDTO> response = new ResponseDTO<HouseRecordDTO>(Constants.RESPONSE_SAVE_HOUSE_RECORD, houseRecordService.saveHouseRecord(houseRecordDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDTO<List<HouseRecordDTO>>> getAllHouseRecords() {
        ResponseDTO<List<HouseRecordDTO>> response = new ResponseDTO<List<HouseRecordDTO>>(Constants.RESPONSE_GET_HOUSE_RECORDS, houseRecordService.getAllHouseRecords());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<HouseRecordDTO>> getHouseRecordById(@PathVariable("id") long houseRecordId) {
        ResponseDTO<HouseRecordDTO> response = new ResponseDTO<HouseRecordDTO>(Constants.RESPONSE_GET_HOUSE_RECORD_BY_ID, houseRecordService.getHouseRecordById(houseRecordId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDTO<HouseRecordDTO>> updateHouseRecord(@RequestBody HouseRecordDTO houseRecordDTO) {
        ResponseDTO<HouseRecordDTO> response = new ResponseDTO<HouseRecordDTO>(Constants.RESPONSE_UPDATE_HOUSE_RECORD, houseRecordService.updateHouseRecord(houseRecordDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<HouseRecordDTO>> updateHouseRecord(@PathVariable("id") long houseRecordId) {
        ResponseDTO<HouseRecordDTO> response = new ResponseDTO<HouseRecordDTO>(Constants.RESPONSE_UPDATE_HOUSE_RECORD, houseRecordService.deleteHouseRecordLogically(houseRecordId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
