package com.globant.musicstore.service;

import com.globant.musicstore.dto.CatRepaymentTypeDTO;

public interface CatRepaymentTypeService {
    CatRepaymentTypeDTO getCatRepaymentId(Long id);
    CatRepaymentTypeDTO addRepaymentType(Long id ,CatRepaymentTypeDTO catRepaymentTypeDTO);
    CatRepaymentTypeDTO updateRepaymentType (Long id, CatRepaymentTypeDTO catRepaymentTypeDTO);
    CatRepaymentTypeDTO deleteRepaymentType(Long id);
}
