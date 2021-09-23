package com.globant.musicstore.service.impl;

import com.globant.musicstore.dao.AlbumDAO;
import com.globant.musicstore.dao.ClientDAO;
import com.globant.musicstore.dao.InvoiceDAO;
import com.globant.musicstore.dto.requestDTO.PurchaseRequestDTO;
import com.globant.musicstore.dto.responseDTO.PurchaseResponseDTO;
import com.globant.musicstore.entity.Album;
import com.globant.musicstore.service.ClientService;
import com.globant.musicstore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private AlbumDAO albumDAO;

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private ClientService clientService;


    @Override
    public PurchaseResponseDTO purchaseAlbum(PurchaseRequestDTO purchaseDTO) {
        PurchaseResponseDTO purchaseResponseDTO = PurchaseResponseDTO.builder()
                .clientId(purchaseDTO.getClientId())
                .purchaseMap(purchaseDTO.getPurchaseMap())
                .build();

        Double purchaseTotal = 0D;
        for (Map.Entry<Long,Integer> entry : purchaseDTO.getPurchaseMap().entrySet()){
             purchaseTotal += decreaseAlbumExistence(entry.getKey(), entry.getValue());
        }
        purchaseResponseDTO.setTotal(purchaseTotal);
        addClientStars(purchaseDTO.getClientId(), purchaseDTO.getPurchaseMap());


        return purchaseResponseDTO;
    }

    private Double decreaseAlbumExistence(Long albumId, Integer quantity){
        double albumTotalCost = 0D;
        Album album = albumDAO.getById(albumId);
        if(album.getQuantityAvailable() < quantity){
            // TODO Add exception
        } else {
            album.setQuantityAvailable(album.getQuantityAvailable() - quantity);
            albumTotalCost = album.getPrice() * quantity;
        }

        return albumTotalCost;
    }

    private void addClientStars(Long clientId, Map<Long, Integer> purchasesMap) {
        Integer totalStars = 0;
        for (Map.Entry<Long,Integer> entry : purchasesMap.entrySet()){
            totalStars += entry.getValue();
        }
        clientService.addStars(clientId, totalStars);
    }
}
