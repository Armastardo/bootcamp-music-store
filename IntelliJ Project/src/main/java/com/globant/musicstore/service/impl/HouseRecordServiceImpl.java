package com.globant.musicstore.service.impl;

import com.globant.musicstore.dao.HouseRecordDAO;
import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;
import com.globant.musicstore.entity.HouseRecord;
import com.globant.musicstore.exception.InvalidDataException;
import com.globant.musicstore.exception.ModelNotFoundException;
import com.globant.musicstore.service.HouseRecordService;
import com.globant.musicstore.utils.constants.Constants;
import com.globant.musicstore.utils.mapper.HouseRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HouseRecordServiceImpl implements HouseRecordService {

    @Autowired
    private HouseRecordDAO houseRecordDAO;

    @Autowired
    private HouseRecordMapper houseRecordMapper;

    @Override
    public List<HouseRecordDTO> getAllHouseRecords() {
        return houseRecordMapper.houseRecordToListDTO(houseRecordDAO.findAll());
    }

    @Override
    public HouseRecordDTO saveHouseRecord(HouseRecordDTO houseRecordDTO) {
        validationInputFromUser(houseRecordDTO);
        return houseRecordMapper
                .houseRecordToDTO(houseRecordDAO
                        .save(houseRecordMapper
                                .houseRecordDTOToHouseRecord(houseRecordDTO)));
    }


    @Override
    public HouseRecordDTO updateHouseRecord(HouseRecordDTO houseRecordDTO) {
        long houseRecordId = houseRecordDTO.getId();
        getHouseRecordById(houseRecordId);
        validationInputFromUser(houseRecordDTO);
        return houseRecordMapper
                .houseRecordToDTO(houseRecordDAO
                        .save(houseRecordMapper
                                .houseRecordDTOToHouseRecord(houseRecordDTO)));
    }

    public void validationInputFromUser(HouseRecordDTO houseRecordDTO) {
        if (houseRecordDTO.getName().isEmpty() || houseRecordDTO.getDescription().isEmpty() || Objects.isNull(houseRecordDTO.getYearFrom())) {
            throw new InvalidDataException(Constants.RESPONSE_EXCEPTION_INVALID_DATA);
        }
    }

    @Override
    public HouseRecordDTO deleteHouseRecordLogically(long houseRecordId) {
        HouseRecordDTO getHouseRecordById = getHouseRecordById(houseRecordId);
        getHouseRecordById.setActive(false);

        return houseRecordMapper.houseRecordToDTO(houseRecordDAO.save(houseRecordMapper.houseRecordDTOToHouseRecord(getHouseRecordById)));

    }

    @Override
    public HouseRecordDTO getHouseRecordById(long houseRecordId) {
        HouseRecord findHouseRecordById = houseRecordDAO.findById(houseRecordId).orElseThrow(() -> new ModelNotFoundException((Constants.RESPONSE_EXCEPTION_NOT_FOUND)));
        return houseRecordMapper.houseRecordToDTO(findHouseRecordById);
    }

}
