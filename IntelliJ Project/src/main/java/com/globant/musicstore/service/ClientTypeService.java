package com.globant.musicstore.service;

import com.globant.musicstore.dto.ClientTypeDTO;

public interface ClientTypeService {
    public ClientTypeDTO createClientType(ClientTypeDTO clientTypeDTO);

    public ClientTypeDTO updateClientType(ClientTypeDTO clientTypeDTO);

    public void deactivateClientType(ClientTypeDTO clientTypeDTO);

    public void activateClientType(ClientTypeDTO clientTypeDTO);
}
