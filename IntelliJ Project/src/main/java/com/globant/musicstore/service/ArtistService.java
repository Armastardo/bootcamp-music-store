package com.globant.musicstore.service;

import com.globant.musicstore.dto.requestDTO.ArtistDTO;

import java.util.List;

public interface ArtistService {

    List<ArtistDTO> getAllArtists();

    ArtistDTO saveArtist(ArtistDTO artistData);

    ArtistDTO getArtistById(long artistId);

    ArtistDTO updateArtist(long artistId, ArtistDTO artistDataToUpdate);

    ArtistDTO deleteArtistLogically(long artistId);

    ArtistDTO assignHouseRecordToArtist(long houseRecordId, long artistId);
}
