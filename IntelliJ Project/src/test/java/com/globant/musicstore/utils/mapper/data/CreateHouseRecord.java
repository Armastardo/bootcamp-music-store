package com.globant.musicstore.utils.mapper.data;

import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;
import com.globant.musicstore.entity.HouseRecord;

public class CreateHouseRecord {

    public static HouseRecord createHRecord(){
        return HouseRecord.builder()
                .id(1L)
                .name("sony")
                .description("bad")
                .build();
    }

    public static HouseRecordDTO createHRecordDTO(){
        return HouseRecordDTO.builder()
                .id(1L)
                .name("sony")
                .description("bad")
                .build();
    }
}
