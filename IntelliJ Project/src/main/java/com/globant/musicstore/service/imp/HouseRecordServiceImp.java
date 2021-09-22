package com.globant.musicstore.service.imp;

import com.globant.musicstore.dao.HouseRecordDAO;
import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;
import com.globant.musicstore.entity.HouseRecord;
import com.globant.musicstore.exception.InvalidDataException;
import com.globant.musicstore.exception.ModelNotFoundException;
import com.globant.musicstore.service.HouseRecordService;
import com.globant.musicstore.utils.mapper.HouseRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseRecordServiceImp implements HouseRecordService {

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
    public HouseRecordDTO updateHouseRecord(long houseRecordId, HouseRecordDTO houseRecordDTO) {
        HouseRecordDTO getHouseRecordById = getHouseRecordById(houseRecordId);
        validationInputFromUser(houseRecordDTO);
        houseRecordDTO.setId(houseRecordId);
        return houseRecordMapper
                .houseRecordToDTO(houseRecordDAO
                        .save(houseRecordMapper
                                .houseRecordDTOToHouseRecord(houseRecordDTO)));
    }

    @Override
    public HouseRecordDTO deleteHouseRecordLogically(long houseRecordId) {
        HouseRecordDTO getHouseRecordById = getHouseRecordById(houseRecordId);
        getHouseRecordById.setActive(false);

        return houseRecordMapper.houseRecordToDTO(houseRecordDAO.save(houseRecordMapper.houseRecordDTOToHouseRecord(getHouseRecordById)));

    }

    @Override
    public HouseRecordDTO getHouseRecordById(long houseRecordId) {
        HouseRecord findHouseRecordById = houseRecordDAO.findById(houseRecordId).orElseThrow(() -> new ModelNotFoundException(("no existe")));
        return houseRecordMapper.houseRecordToDTO(findHouseRecordById);
    }

    public void validationInputFromUser(HouseRecordDTO houseRecordDTO) {
        if (houseRecordDTO.getName().isEmpty() || houseRecordDTO.getDescription().isEmpty() || houseRecordDTO.getYear_from() == null) {
            throw new InvalidDataException("error input");
        }
    }
}