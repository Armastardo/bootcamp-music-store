package com.globant.musicstore.controller;

import com.globant.musicstore.dto.requestDTO.CatGenreDTO;
import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.service.CatGenreService;
import com.globant.musicstore.utils.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class CatGenreController {

    @Autowired
    private CatGenreService catGenreService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO<List<CatGenreDTO>>> getAllGenres() {
        ResponseDTO<List<CatGenreDTO>> response = new ResponseDTO<List<CatGenreDTO>>(Constants.RESPONSE_GET_GENRES, catGenreService.getAllGenres());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO<CatGenreDTO>> save(@RequestBody CatGenreDTO catGenreDTO) {
        ResponseDTO<CatGenreDTO> response = new ResponseDTO<CatGenreDTO>(Constants.RESPONSE_SAVE_GENRE, catGenreService.saveGenre(catGenreDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<CatGenreDTO>> getGenreById(@PathVariable("id") long genreId) {
        ResponseDTO<CatGenreDTO> response = new ResponseDTO<CatGenreDTO>(Constants.RESPONSE_GET_GENRE_BY_ID, catGenreService.getGenreById(genreId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<CatGenreDTO>> updateGenre(@PathVariable("id") long genreId,
                                                                @RequestBody CatGenreDTO catGenreDTO) {
        ResponseDTO<CatGenreDTO> response = new ResponseDTO<CatGenreDTO>(Constants.RESPONSE_UPDATE_GENRE, catGenreService.updateGenre(genreId, catGenreDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<CatGenreDTO>> deleteGenre(@PathVariable("id") long genreId) {
        ResponseDTO<CatGenreDTO> response = new ResponseDTO<CatGenreDTO>(Constants.RESPONSE_DELETE_GENRE, catGenreService.deleteGenreLogically(genreId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
