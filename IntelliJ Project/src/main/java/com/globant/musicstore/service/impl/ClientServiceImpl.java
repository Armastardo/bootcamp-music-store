package com.globant.musicstore.service.impl;

import com.globant.musicstore.dao.ClientDAO;
import com.globant.musicstore.dao.ClientTypeDAO;
import com.globant.musicstore.dto.ClientDTO;
import com.globant.musicstore.entity.Client;
import com.globant.musicstore.mapper.ClientMapper;
import com.globant.musicstore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientTypeDAO clientTypeDAO;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        clientDTO.setClientType(1L);
        clientDTO.setIsActive(Boolean.TRUE);
        clientDTO.setStars(0);
        return clientMapper.clientEntityToDTO(clientDAO.save(clientMapper.clientDTOToEntity(clientDTO)));
    }

    @Override
    public ClientDTO getClient(Long id) {
        return clientMapper.clientEntityToDTO(clientDAO.getById(id));
    }

    @Override
    public ClientDTO addStars(Long id, Integer stars) {
        Client client = clientDAO.getById(id);
        client.setStars(client.getStars()+stars);
        return clientMapper.clientEntityToDTO(clientDAO.save(client));
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = clientDAO.getById(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setMail(clientDTO.getMail());
        client.setStars(clientDTO.getStars());
        client.setClientType(clientTypeDAO.getClientType(clientDTO.getClientType()));
        client.setIsActive(clientDTO.getIsActive());
        return null;
    }

    @Override
    public ClientDTO deactivateClient(Long id) {
        Client client = clientDAO.getById(id);
        client.setIsActive(Boolean.FALSE);
        return clientMapper.clientEntityToDTO(clientDAO.save(client));
    }

    @Override
    public ClientDTO activateClient(Long id) {
        Client client = clientDAO.getById(id);
        client.setIsActive(Boolean.TRUE);
        return clientMapper.clientEntityToDTO(clientDAO.save(client));
    }
}
