package com.globant.musicstore.mapper;


import com.globant.musicstore.dao.RepaymentDAO;
import com.globant.musicstore.dto.RepaymentDTO;
import com.globant.musicstore.entity.Repayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepaymentMapper {

    @Autowired
    private RepaymentDAO repaymentDAO;

    public RepaymentDTO repaymentEntityToDTO(Repayment repayment) {
        RepaymentDTO repaymentDTO = RepaymentDTO.builder()
                .id(repayment.getId())
                .date(repayment.getDate())
                .invoiceId(repayment.getInvoiceId())
                .catRepaymentId(repayment.getCatRepaymentId().getId())
                .albumId(repayment.getAlbumId())
                .quantity(repayment.getQuantity())
                .isActive(repayment.getIsActive())
                .build();

        return repaymentDTO;
    }

    public Repayment repaymentDTOToEntity(RepaymentDTO repaymentDTO) {
        Repayment repayment = Repayment.builder()

                .date(repaymentDTO.getDate())
                .invoiceId(repaymentDTO.getInvoiceId())
                .catRepaymentId(repaymentDAO.getById(repaymentDTO.getCatRepaymentId()))
                .albumId(repaymentDTO.getAlbumId())
                .quantity(repaymentDTO.getQuantity())
                .isActive(repaymentDTO.getIsActive())
                .build();

        return repayment;
    }
}