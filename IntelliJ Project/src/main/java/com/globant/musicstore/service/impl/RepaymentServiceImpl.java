package com.globant.musicstore.service.impl;

import com.globant.musicstore.dao.RepaymentDAO;
import com.globant.musicstore.dto.RepaymentDTO;
import com.globant.musicstore.exception.InvalidDataException;
import com.globant.musicstore.mapper.RepaymentMapper;
import com.globant.musicstore.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.globant.musicstore.utils.Constants.REPAYMENT_DELETED;


@Service
public class RepaymentServiceImpl implements RepaymentService {

    @Autowired
    RepaymentMapper repaymentMapper;

    @Autowired
    RepaymentDAO repaymentDAO;

    @Autowired
    RepaymentService repaymentService;

    @Override
    public RepaymentDTO getRepaymentId(Long repaymentId) {
        return repaymentMapper.repaymentEntityToDTO(repaymentDAO.getById(repaymentId));
    }

    @Override
    public RepaymentDTO getAlbumId(Long albumId) {
        return repaymentMapper.repaymentEntityToDTO(repaymentDAO.getById(albumId));
    }

    @Override
    public RepaymentDTO deleteRepayment(Long repaymentId) {
        RepaymentDTO repaymentDTO = getRepaymentId(repaymentId);
        if(repaymentDTO.getIsActive()){
            repaymentDTO.setIsActive(false);
            return  updateRepayment(repaymentId, repaymentDTO);
        }else{
            throw new InvalidDataException(REPAYMENT_DELETED);
        }
    }


    @Override
    public RepaymentDTO addRepayment(Long id, RepaymentDTO repaymentDTO) {
        repaymentService.getRepaymentId(id);
        return repaymentMapper.repaymentEntityToDTO(repaymentDAO.save(repaymentMapper.repaymentDTOToEntity(repaymentDTO)));
    }

    @Override
    public RepaymentDTO updateRepayment(Long id, RepaymentDTO repaymentDTO) {
        getRepaymentId(id);
        return repaymentMapper.repaymentEntityToDTO(repaymentDAO.save(repaymentMapper.repaymentDTOToEntity(repaymentDTO)));
    }
}
