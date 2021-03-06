package com.globant.musicstore.service.impl;

import com.globant.musicstore.dao.AlbumDAO;
import com.globant.musicstore.dao.IntInvoiceAlbumDAO;
import com.globant.musicstore.dao.InvoiceDAO;
import com.globant.musicstore.dao.RepaymentDAO;
import com.globant.musicstore.dto.RepaymentDTO;
import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;
import com.globant.musicstore.dto.requestDTO.InvoiceDTO;
import com.globant.musicstore.dto.requestDTO.PurchaseRequestDTO;
import com.globant.musicstore.dto.requestDTO.RepaymentRequestDTO;
import com.globant.musicstore.dto.responseDTO.PurchaseResponseDTO;
import com.globant.musicstore.entity.Album;
import com.globant.musicstore.exception.NotEnoughInventoryException;
import com.globant.musicstore.service.ClientService;
import com.globant.musicstore.service.StoreService;
import com.globant.musicstore.utils.constants.Constants;
import com.globant.musicstore.utils.mapper.IntInvoiceAlbumMapper;
import com.globant.musicstore.utils.mapper.InvoiceMapper;
import com.globant.musicstore.utils.mapper.RepaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private AlbumDAO albumDAO;

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private RepaymentDAO repaymentDAO;

    @Autowired
    private IntInvoiceAlbumDAO intInvoiceAlbumDAO;

    @Autowired
    private IntInvoiceAlbumMapper intInvoiceAlbumMapper;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private RepaymentMapper repaymentMapper;

    @Autowired
    private ClientService clientService;

    @Override
    public PurchaseResponseDTO purchaseAlbum(PurchaseRequestDTO purchaseDTO) {
        PurchaseResponseDTO purchaseResponseDTO = PurchaseResponseDTO.builder()
                .clientId(purchaseDTO.getClientId())
                .purchaseMap(purchaseDTO.getPurchaseMap())
                .date(new Date())
                .build();

        Double purchaseTotal = 0D;
        for (Map.Entry<Long, Integer> entry : purchaseDTO.getPurchaseMap().entrySet()) {
            purchaseTotal += decreaseAlbumExistence(entry.getKey(), entry.getValue());
        }
        purchaseResponseDTO.setTotal(purchaseTotal);
        purchaseResponseDTO.setStars(addClientStars(purchaseDTO.getClientId(), purchaseDTO.getPurchaseMap()));
        createInvoice(purchaseDTO, purchaseTotal);

        return purchaseResponseDTO;
    }

    @Override
    public List<RepaymentDTO> returnItems(RepaymentRequestDTO repaymentRequestDTO) {
        List<RepaymentDTO> returnedItemList = new ArrayList<>();

        for (Map.Entry<Long, Long> entry : repaymentRequestDTO.getReturnMap().entrySet()) {
            RepaymentDTO repaymentDTO = RepaymentDTO.builder()
                    .date(new Date())
                    .invoiceId(repaymentRequestDTO.getInvoiceId())
                    .catRepaymentId(entry.getValue())
                    .albumId(entry.getKey())
                    .quantity(1)
                    .isActive(Boolean.TRUE)
                    .build();
            Album returnedAlbum = albumDAO.getAlbum(entry.getKey());
            returnedAlbum.setQuantityAvailable(returnedAlbum.getQuantityAvailable() + 1);
            returnedItemList.add(repaymentMapper.repaymentEntityToDTO(repaymentDAO.save(repaymentMapper.repaymentDTOToEntity(repaymentDTO))));
        }
        return returnedItemList;
    }


    private Double decreaseAlbumExistence(Long albumId, Integer quantity) {
        double albumTotalCost = 0D;
        Album album = albumDAO.getById(albumId);
        if (album.getQuantityAvailable() < quantity) {
            throw new NotEnoughInventoryException(Constants.RESPONSE_EXCEPTION_NOT_ENOUGH_INVENTORY);
        } else {
            album.setQuantityAvailable(album.getQuantityAvailable() - quantity);
            albumTotalCost = album.getPrice() * quantity;
        }

        return albumTotalCost;
    }

    private Integer addClientStars(Long clientId, Map<Long, Integer> purchasesMap) {
        Integer totalStars = 0;
        for (Map.Entry<Long, Integer> entry : purchasesMap.entrySet()) {
            totalStars += entry.getValue();
        }
        clientService.addStars(clientId, totalStars);
        return totalStars;
    }

    private void createInvoice(PurchaseRequestDTO purchaseDTO, Double purchaseTotal) {
        InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                .clientId(purchaseDTO.getClientId())
                .invoiceDate(new Date())
                .totalAmount(purchaseTotal)
                .isActive(Boolean.TRUE)
                .build();

        Long savedInvoiceId = invoiceDAO.save(invoiceMapper.InvoiceDTOToEntity(invoiceDTO)).getInvoiceId();
        //TODO: Por alguna raz??n usar este id genera un comportamiento extra??o. Hay que revisarlo.

        for (Map.Entry<Long, Integer> entry : purchaseDTO.getPurchaseMap().entrySet()) {
            IntInvoiceAlbumDTO intInvoiceAlbumDTO = IntInvoiceAlbumDTO.builder()
                    .invoiceId(savedInvoiceId)
                    .albumId(entry.getKey())
                    .albumQuantity(entry.getValue())
                    .isActive(Boolean.TRUE)
                    .build();
            intInvoiceAlbumDAO.save(intInvoiceAlbumMapper.IntInvoiceAlbumDTOToEntity(intInvoiceAlbumDTO));
        }
    }

}
