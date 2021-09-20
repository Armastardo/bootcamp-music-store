package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;
import com.globant.musicstore.entity.HouseRecord;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HouseRecordMapper {

    public HouseRecordDTO houseRecordToDTO(HouseRecord houseRecordEntity) {
        HouseRecordDTO houseRecordDTO = HouseRecordDTO.builder()
                .id(houseRecordEntity.getId())
                .name(houseRecordEntity.getName())
                .year_from(houseRecordEntity.getYear_from())
                .description(houseRecordEntity.getDescription())
                .isActive(houseRecordEntity.isActive())
                .artists(houseRecordEntity.getArtists())
                .build();

        return houseRecordDTO;
    }

    public HouseRecord houseRecordDTOToHouseRecord(HouseRecordDTO houseRecordDTO) {
        HouseRecord houseRecordEntity = HouseRecord.builder()
                .id(houseRecordDTO.getId())
                .name(houseRecordDTO.getName())
                .year_from(houseRecordDTO.getYear_from())
                .description(houseRecordDTO.getDescription())
                .isActive(houseRecordDTO.isActive())
                .artists(houseRecordDTO.getArtists())
                .build();

        return houseRecordEntity;
    }

    public List<HouseRecordDTO> houseRecordToListDTO(List<HouseRecord> houseRecordList) {
        List<HouseRecordDTO> listHouseRecordDTO = new ArrayList<HouseRecordDTO>();
        houseRecordList.forEach(houseRecord -> listHouseRecordDTO.add(houseRecordToDTO(houseRecord)));
        return listHouseRecordDTO;
    }
}
