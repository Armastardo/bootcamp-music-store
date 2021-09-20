package com.globant.musicstore.controller;

import com.globant.musicstore.dto.ResponseDTO;
import com.globant.musicstore.dto.SongDTO;
import com.globant.musicstore.service.impl.SongService;
import com.globant.musicstore.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.globant.musicstore.utils.Constants.*;

@RestController
@RequestMapping("/song")
public class SongController {


    @Autowired
    SongService songService;

    @PostMapping(path = "add/{id_album}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<SongDTO>> addSong(@PathVariable Long id_album, @RequestBody SongDTO songDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_ADDED_SUCCESSFULLY, songService.addSong(id_album, songDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("delete/{id_song}")
    public String deleteSong(@PathVariable Long id_song) {
        songService.deleteSong(id_song);
        return ITEM_DELETED_SUCCESSFULLY;
    }

    @RequestMapping(path = "/{id_song}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<SongDTO>> getSongById(@PathVariable Long id_song) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_ADDED_SUCCESSFULLY, songService.getSongById(id_song));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/listSongs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<SongDTO>> showList() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEMS_SHOWED_SUCCESSFULLY, songService.showList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(path = "update/{id_song}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<SongDTO>> updateSong(@PathVariable Long id_song, @RequestBody SongDTO songDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_UPDATED_SUCCESSFULLY, songService.updateSong(id_song, songDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
