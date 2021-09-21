package com.globant.musicstore.controller;

import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO<List<ArtistDTO>>> getAllArtists(){
        ResponseDTO<List<ArtistDTO>> response = new ResponseDTO<List<ArtistDTO>>("bien", artistService.getAllArtists());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<ArtistDTO>> getArtistById(@PathVariable("id") long artistId){
        ResponseDTO<ArtistDTO> response = new ResponseDTO<ArtistDTO>("bien", artistService.getArtistById(artistId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO<ArtistDTO>> saveArtist(@RequestBody ArtistDTO artistData){
        ResponseDTO<ArtistDTO> response = new ResponseDTO<ArtistDTO>("bien", artistService.saveArtist(artistData));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<ArtistDTO>> updateArtist(@PathVariable("id") long artistId,
                                  @RequestBody ArtistDTO artistDataToUpdate){
        ResponseDTO<ArtistDTO> response = new ResponseDTO<ArtistDTO>("bien", artistService.updateArtist(artistId,artistDataToUpdate));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<ArtistDTO>> deleteArtistById(@PathVariable("id") long artistId){
        ResponseDTO<ArtistDTO> response = new ResponseDTO<ArtistDTO>("bien", artistService.deleteArtistLogically(artistId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{artistId}/house-record/{recordId}")
    public ResponseEntity<ResponseDTO<ArtistDTO>> assignHouseRecordToArtist(@PathVariable("artistId") long artistId,
                                                               @PathVariable("recordId") long recordId){
        ResponseDTO<ArtistDTO> response = new ResponseDTO<ArtistDTO>("bien", artistService.assignHouseRecordToArtist(recordId,artistId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
