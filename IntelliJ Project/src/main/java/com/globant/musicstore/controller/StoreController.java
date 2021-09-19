package com.globant.musicstore.controller;

import com.globant.musicstore.dto.ClientDTO;
import com.globant.musicstore.dto.ResponseDTO;
import com.globant.musicstore.service.ClientService;
import com.globant.musicstore.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.globant.musicstore.utils.Constants.CLIENT_ADDED_SUCCESSFULLY;
import static com.globant.musicstore.utils.Constants.CLIENT_RETRIEVED_SUCCESSFULLY;

@RestController
@RequestMapping("musicstore")
public class StoreController {

    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/addClient", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ClientDTO>> createClient(@RequestBody ClientDTO clientDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, CLIENT_ADDED_SUCCESSFULLY, clientService.createClient(clientDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping(path = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<ClientDTO>> getClient(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, CLIENT_RETRIEVED_SUCCESSFULLY, clientService.getClient(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
