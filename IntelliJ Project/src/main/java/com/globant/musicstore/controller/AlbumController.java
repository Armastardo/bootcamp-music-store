package com.globant.musicstore.controller;

import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.dto.ResponseDTO;
import com.globant.musicstore.service.AlbumService;
import com.globant.musicstore.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.globant.musicstore.utils.Constants.*;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @PostMapping(path = "/{idArtist}")
    public ResponseEntity<ResponseDTO<AlbumDTO>> addAlbum(@PathVariable Long idArtist, @RequestBody AlbumDTO albumDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_ADDED_SUCCESSFULLY, albumService.addAlbum(idArtist, albumDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{idAlbum}")
    public ResponseEntity<ResponseDTO<AlbumDTO>> deleteAlbum(@PathVariable Long idAlbum) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_DELETED_SUCCESSFULLY, albumService.deleteAlbum(idAlbum));
        return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{idAlbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> getAlbumById(@PathVariable Long idAlbum) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEMS_SHOWED_SUCCESSFULLY, albumService.getAlbumById(idAlbum));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/songsList/{idAlbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> getAlbumSongs(@PathVariable Long idAlbum) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEMS_SHOWED_SUCCESSFULLY, albumService.getAlbumSongs(idAlbum));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/listAlbum", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> showList() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEMS_SHOWED_SUCCESSFULLY, albumService.showList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/{idAlbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AlbumDTO>> updateAlbum(@PathVariable Long idAlbum, @RequestBody AlbumDTO albumDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_UPDATED_SUCCESSFULLY, albumService.updateAlbum(idAlbum, albumDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
