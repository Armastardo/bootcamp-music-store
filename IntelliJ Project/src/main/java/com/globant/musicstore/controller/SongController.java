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

    @PostMapping(path = "/{idAlbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<SongDTO>> addSong(@PathVariable Long idAlbum, @RequestBody SongDTO songDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_ADDED_SUCCESSFULLY, songService.addSong(idAlbum, songDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{idSong}")
    public String deleteSong(@PathVariable Long idSong) {
        songService.deleteSong(idSong);
        return ITEM_DELETED_SUCCESSFULLY;
    }

    @GetMapping(path = "/{idSong}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<SongDTO>> getSongById(@PathVariable Long idSong) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEMS_SHOWED_SUCCESSFULLY, songService.getSongById(idSong));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping(path = "/listSongs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<SongDTO>> showList() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEMS_SHOWED_SUCCESSFULLY, songService.showList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/{idSong}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<SongDTO>> updateSong(@PathVariable Long idSong, @RequestBody SongDTO songDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, ITEM_UPDATED_SUCCESSFULLY, songService.updateSong(idSong, songDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
