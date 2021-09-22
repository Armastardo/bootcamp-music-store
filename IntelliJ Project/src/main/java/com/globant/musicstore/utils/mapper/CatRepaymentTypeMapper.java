package com.globant.musicstore.mapper;

import com.globant.musicstore.dao.CatRepaymentTypeDAO;
import com.globant.musicstore.dto.CatRepaymentTypeDTO;
import com.globant.musicstore.entity.CatRepaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatRepaymentTypeMapper {

    @Autowired
    private CatRepaymentTypeDAO catRepaymentTypeDAO;


    public CatRepaymentType catRepaymentTypeDTOToEntity(CatRepaymentTypeDTO catRepaymentTypeDTO){

        CatRepaymentType catRepaymentType = CatRepaymentType.builder()
                .catRepaymentTypeId(catRepaymentTypeDTO.getCatRepaymentTypeId())
                .catRepaymentType(catRepaymentTypeDTO.getCatRepaymentType())
                .catRepaymentDescription(catRepaymentTypeDTO.getCatRepaymentDescription())
                .isActive(catRepaymentTypeDTO.getIsActive())
                .build();
        return catRepaymentType;
    }

    public CatRepaymentTypeDTO catRepaymentTypeEntityToDTO (CatRepaymentType catRepaymentType){

        CatRepaymentTypeDTO catRepaymentTypeDTO = CatRepaymentTypeDTO.builder()
                .catRepaymentTypeId(catRepaymentType.getCatRepaymentTypeId())
                .catRepaymentType(catRepaymentType.getCatRepaymentType())
                .catRepaymentDescription(catRepaymentType.getCatRepaymentDescription())
                .isActive(catRepaymentType.getIsActive())
                .build();

        return  catRepaymentTypeDTO;
    }
}
