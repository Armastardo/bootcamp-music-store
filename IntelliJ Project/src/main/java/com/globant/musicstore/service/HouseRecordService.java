package com.globant.musicstore.service;

import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;

import java.util.List;

public interface HouseRecordService {

    List<HouseRecordDTO> getAllHouseRecords();

    HouseRecordDTO saveHouseRecord(HouseRecordDTO houseRecordDTO);

    HouseRecordDTO getHouseRecordById(long houseRecordId);

    HouseRecordDTO updateHouseRecord(long houseRecordId, HouseRecordDTO houseRecordDTO);

    HouseRecordDTO deleteHouseRecordLogically(long houseRecordId);
}
