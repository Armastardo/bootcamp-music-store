package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;
import com.globant.musicstore.entity.HouseRecord;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HouseRecordMapper {

    public HouseRecordDTO houseRecordToDTO(HouseRecord houseRecordEntity) {
        return HouseRecordDTO.builder()
                .id(houseRecordEntity.getId())
                .name(houseRecordEntity.getName())
                .yearFrom(houseRecordEntity.getYearFrom())
                .description(houseRecordEntity.getDescription())
                .isActive(houseRecordEntity.isActive())
                .artists(houseRecordEntity.getArtists())
                .build();
    }

    public HouseRecord houseRecordDTOToHouseRecord(HouseRecordDTO houseRecordDTO) {
        return HouseRecord.builder()
                .id(houseRecordDTO.getId())
                .name(houseRecordDTO.getName())
                .yearFrom(houseRecordDTO.getYearFrom())
                .description(houseRecordDTO.getDescription())
                .isActive(houseRecordDTO.isActive())
                .artists(houseRecordDTO.getArtists())
                .build();
    }

    public List<HouseRecordDTO> houseRecordToListDTO(List<HouseRecord> houseRecordList) {
        List<HouseRecordDTO> listHouseRecordDTO = new ArrayList<HouseRecordDTO>();
        houseRecordList.forEach(houseRecord -> listHouseRecordDTO.add(houseRecordToDTO(houseRecord)));
        return listHouseRecordDTO;
    }
}
