package com.globant.musicstore.service;

import com.globant.musicstore.dto.ClientDTO;
import com.globant.musicstore.entity.Client;

import java.util.List;

public interface ClientService {
    public ClientDTO createClient(ClientDTO clientDTO);

    public ClientDTO getClient(Long id);

    public List<ClientDTO> getAllClients();

    public ClientDTO addStars(Long id, Integer stars);

    public ClientDTO updateClient(ClientDTO clientDTO);

    public ClientDTO deactivateClient(Long id);

    public ClientDTO activateClient(Long id);
}
