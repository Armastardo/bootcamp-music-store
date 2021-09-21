package com.globant.musicstore.mapper;

import com.globant.musicstore.dao.ClientDAO;
import com.globant.musicstore.dao.ClientTypeDAO;
import com.globant.musicstore.dto.ClientDTO;
import com.globant.musicstore.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ClientTypeDAO clientTypeDAO;

    public Client clientDTOToEntity(ClientDTO clientDTO) {
        Client client = Client.builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .surname(clientDTO.getSurname())
                .mail(clientDTO.getMail())
                .stars(clientDTO.getStars())
                .clientType(clientTypeDAO.getClientType(clientDTO.getClientType()))
                .isActive(clientDTO.getIsActive())
                .build();
        return client;
    }

    public ClientDTO clientEntityToDTO(Client client) {
        ClientDTO clientDTO = ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .mail(client.getMail())
                .stars(client.getStars())
                .clientType(client.getClientType().getId())
                .isActive(client.getIsActive())
                .build();
        return clientDTO;
    }
}
