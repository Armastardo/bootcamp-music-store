package com.globant.musicstore.utils.mapper;


import com.globant.musicstore.dao.InvoiceDAO;
import com.globant.musicstore.dao.RepaymentDAO;
import com.globant.musicstore.dto.RepaymentDTO;
import com.globant.musicstore.entity.Repayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepaymentMapper {

    @Autowired
    private RepaymentDAO repaymentDAO;

    @Autowired
    private InvoiceDAO invoiceDAO;

    public RepaymentDTO repaymentEntityToDTO(Repayment repayment) {
        return RepaymentDTO.builder()
                .id(repayment.getId())
                .date(repayment.getDate())
                .invoiceId(repayment.getInvoice().getInvoiceId())
                .catRepaymentId(repayment.getCatRepaymentId().getId())
                .albumId(repayment.getAlbumId())
                .quantity(repayment.getQuantity())
                .isActive(repayment.getIsActive())
                .build();
    }

    public Repayment repaymentDTOToEntity(RepaymentDTO repaymentDTO) {
        return Repayment.builder()
                .id(repaymentDTO.getId())
                .date(repaymentDTO.getDate())
                .invoice(invoiceDAO.getById(repaymentDTO.getInvoiceId()))
                .catRepaymentId(repaymentDAO.getById(repaymentDTO.getCatRepaymentId()))
                .albumId(repaymentDTO.getAlbumId())
                .quantity(repaymentDTO.getQuantity())
                .isActive(repaymentDTO.getIsActive())
                .build();
    }
}