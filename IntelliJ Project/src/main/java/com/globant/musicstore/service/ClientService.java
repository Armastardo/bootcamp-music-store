package com.globant.musicstore.service;

import com.globant.musicstore.dto.ClientDTO;
import com.globant.musicstore.entity.Client;

public interface ClientService {
    public ClientDTO createClient(ClientDTO clientDTO);

    public ClientDTO getClient(Long id);

    public ClientDTO addStars(Long id, Integer stars);

    public ClientDTO updateClient(ClientDTO clientDTO);

    public ClientDTO deactivateClient(Long id);

    public ClientDTO activateClient(Long id);
}
