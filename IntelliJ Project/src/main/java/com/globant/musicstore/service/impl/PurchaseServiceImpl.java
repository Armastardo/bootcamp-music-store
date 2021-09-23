package com.globant.musicstore.service.impl;

import com.globant.musicstore.dao.AlbumDAO;
import com.globant.musicstore.dao.IntInvoiceAlbumDAO;
import com.globant.musicstore.dao.InvoiceDAO;
import com.globant.musicstore.dto.requestDTO.IntInvoiceAlbumDTO;
import com.globant.musicstore.dto.requestDTO.InvoiceDTO;
import com.globant.musicstore.dto.requestDTO.PurchaseRequestDTO;
import com.globant.musicstore.dto.responseDTO.PurchaseResponseDTO;
import com.globant.musicstore.entity.Album;
import com.globant.musicstore.exception.NotEnoughInventoryException;
import com.globant.musicstore.service.ClientService;
import com.globant.musicstore.service.PurchaseService;
import com.globant.musicstore.utils.constants.Constants;
import com.globant.musicstore.utils.mapper.IntInvoiceAlbumMapper;
import com.globant.musicstore.utils.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private AlbumDAO albumDAO;

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private IntInvoiceAlbumDAO intInvoiceAlbumDAO;

    @Autowired
    private IntInvoiceAlbumMapper intInvoiceAlbumMapper;

    @Autowired
    private InvoiceMapper invoiceMapper;

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
        //TODO: Por alguna razón usar este id genera un comportamiento extraño. Hay que revisarlo.

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
