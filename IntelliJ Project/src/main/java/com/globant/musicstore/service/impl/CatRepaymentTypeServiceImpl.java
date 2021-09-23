package com.globant.musicstore.service.impl;


import com.globant.musicstore.dao.CatRepaymentTypeDAO;
import com.globant.musicstore.dto.CatRepaymentTypeDTO;
import com.globant.musicstore.exception.InvalidDataException;
import com.globant.musicstore.service.CatRepaymentTypeService;
import com.globant.musicstore.utils.mapper.CatRepaymentTypeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.globant.musicstore.utils.Constants.REPAYMENT_DELETED;



@Service
public class CatRepaymentTypeServiceImpl implements CatRepaymentTypeService {

    @Autowired
    CatRepaymentTypeMapper catRepaymentTypeMapper;

    @Autowired
    CatRepaymentTypeDAO catRepaymentTypeDAO;

    @Autowired
    CatRepaymentTypeService catRepaymentTypeService;

    @Override
    public CatRepaymentTypeDTO getCatRepaymentId(Long id) {
        return catRepaymentTypeMapper.catRepaymentTypeEntityToDTO(catRepaymentTypeDAO.getById(id));
    }

    @Override
    public CatRepaymentTypeDTO addRepaymentType(Long id, CatRepaymentTypeDTO catRepaymentTypeDTO) {

        catRepaymentTypeService.getCatRepaymentId(id);
        return catRepaymentTypeMapper.catRepaymentTypeEntityToDTO(catRepaymentTypeDAO.save(catRepaymentTypeMapper.catRepaymentTypeDTOToEntity(catRepaymentTypeDTO)));
    }

    @Override
    public CatRepaymentTypeDTO updateRepaymentType(Long id, CatRepaymentTypeDTO catRepaymentTypeDTO) {
        getCatRepaymentId(id);
        return catRepaymentTypeMapper.catRepaymentTypeEntityToDTO(catRepaymentTypeDAO.save(catRepaymentTypeMapper.catRepaymentTypeDTOToEntity(catRepaymentTypeDTO)));
    }

    @Override
    public CatRepaymentTypeDTO deleteRepaymentType(Long id) {
        CatRepaymentTypeDTO catRepaymentTypeDTO = getCatRepaymentId(id);
        if(catRepaymentTypeDTO.getIsActive()){
            catRepaymentTypeDTO.setIsActive(false);
            return updateRepaymentType(id, catRepaymentTypeDTO);
        }else{
            throw new InvalidDataException(REPAYMENT_DELETED);
        }
    }
}
