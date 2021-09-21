package com.globant.musicstore.controller;

import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;
import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.service.HouseRecordService;
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
        ResponseDTO<HouseRecordDTO> response = new ResponseDTO<HouseRecordDTO>("bien", houseRecordService.saveHouseRecord(houseRecordDTO));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDTO<List<HouseRecordDTO>>> getAllHouseRecords() {
        ResponseDTO<List<HouseRecordDTO>> response = new ResponseDTO<List<HouseRecordDTO>>("bien", houseRecordService.getAllHouseRecords());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<HouseRecordDTO>> getHouseRecordById(@PathVariable("id") long houseRecordId) {
        ResponseDTO<HouseRecordDTO> response = new ResponseDTO<HouseRecordDTO>("bien", houseRecordService.getHouseRecordById(houseRecordId));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<HouseRecordDTO>> updateHouseRecord(@PathVariable("id") long houseRecordId,
                                                                         @RequestBody HouseRecordDTO houseRecordDTO) {
        ResponseDTO<HouseRecordDTO> response = new ResponseDTO<HouseRecordDTO>("bien", houseRecordService.updateHouseRecord(houseRecordId, houseRecordDTO));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<HouseRecordDTO>> updateHouseRecord(@PathVariable("id") long houseRecordId) {
        ResponseDTO<HouseRecordDTO> response = new ResponseDTO<HouseRecordDTO>("bien", houseRecordService.deleteHouseRecordLogically(houseRecordId));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
