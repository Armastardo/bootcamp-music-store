package com.globant.musicstore.controller;

import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.dto.ResponseDTO;
import com.globant.musicstore.service.impl.AlbumService;
import com.globant.musicstore.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.globant.musicstore.utils.Constants.*;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @PostMapping(path = "/add/{id_artist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> addAlbum(@PathVariable Long id_artist, @RequestBody AlbumDTO albumDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_ADDED_SUCCESSFULLY, albumService.addAlbum(id_artist, albumDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("delete/{id_album}")
    public String deleteAlbum(@PathVariable Long id_album) {
        albumService.deleteAlbum(id_album);
        return ITEM_DELETED_SUCCESSFULLY;
    }

    @RequestMapping(path = "/{id_album}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> getAlbumById(@PathVariable Long id_album, @RequestBody AlbumDTO albumDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_ADDED_SUCCESSFULLY, albumService.getAlbumById(id_album));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/songsList/{id_album}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> getAlbumSongs(@PathVariable Long id_album) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEMS_SHOWED_SUCCESSFULLY, albumService.getAlbumSongs(id_album));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/listAlbum", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> showList() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEMS_SHOWED_SUCCESSFULLY, albumService.showList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(path = "update/{id_album}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> updateAlbum(@PathVariable Long id_album, @RequestBody AlbumDTO albumDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_UPDATED_SUCCESSFULLY, albumService.updateAlbum(id_album, albumDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
