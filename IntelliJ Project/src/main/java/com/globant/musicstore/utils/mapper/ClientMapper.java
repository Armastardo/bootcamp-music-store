package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dao.ClientDAO;
import com.globant.musicstore.dao.ClientTypeDAO;
import com.globant.musicstore.dto.ClientDTO;
import com.globant.musicstore.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<ClientDTO> clientEntityListToDTOList(List<Client> clientList) {
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientList.forEach(client -> clientDTOList.add(clientEntityToDTO(client)));
        return clientDTOList;
    }
}
