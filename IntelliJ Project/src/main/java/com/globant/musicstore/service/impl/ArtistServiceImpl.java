package com.globant.musicstore.service.impl;

import com.globant.musicstore.dao.ArtistDAO;
import com.globant.musicstore.dao.HouseRecordDAO;
import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.entity.Artist;
import com.globant.musicstore.entity.HouseRecord;
import com.globant.musicstore.exception.InvalidDataException;
import com.globant.musicstore.exception.ModelNotFoundException;
import com.globant.musicstore.utils.constants.Constants;
import com.globant.musicstore.utils.mapper.ArtistMapper;
import com.globant.musicstore.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistDAO artistDAO;

    @Autowired
    private HouseRecordDAO houseRecordDAO;

    @Autowired
    private ArtistMapper artistMapper;

    @Override
    public List<ArtistDTO> getAllArtists() {
        return artistMapper.listArtistToDTO(artistDAO.findAll());
    }

    @Override
    public ArtistDTO saveArtist(ArtistDTO artistData) {
        validationInputFromUser(artistData);
        return artistMapper
                .artistToDTO(artistDAO.save(artistMapper.artistDTOtoArtist(artistData)));
    }

    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDataToUpdate) {
        long artistId = artistDataToUpdate.getId();
        getArtistById(artistId);
        validationInputFromUser(artistDataToUpdate);
        artistDataToUpdate.setId(artistId);
        return artistMapper.artistToDTO(artistDAO.save(artistMapper.artistDTOtoArtist(artistDataToUpdate)));
    }


    public void validationInputFromUser(ArtistDTO artistDTO) {
        if (artistDTO.getName().isEmpty() || artistDTO.getDescription().isEmpty() || Objects.isNull(artistDTO.getYearFrom())) {
            throw new InvalidDataException(Constants.RESPONSE_EXCEPTION_INVALID_DATA);
        }
    }

    @Override
    public ArtistDTO deleteArtistLogically(long artistId) {
        ArtistDTO getArtistById = getArtistById(artistId);
        getArtistById.setActive(false);

        return artistMapper.artistToDTO(artistDAO.save(artistMapper.artistDTOtoArtist(getArtistById)));
    }

    @Override
    public ArtistDTO assignHouseRecordToArtist(long houseRecordId, long artistId) {
        HouseRecord getHouseRecord = houseRecordDAO.findById(houseRecordId).get();
        Artist getArtist = artistDAO.findById(artistId).get();

        getArtist.setHouseRecord(getHouseRecord);
        return artistMapper.artistToDTO(artistDAO.save(getArtist));
    }

    @Override
    public ArtistDTO getArtistById(long artistId) {
        Artist findArtistById = artistDAO.findById(artistId).orElseThrow(() -> new ModelNotFoundException(Constants.RESPONSE_EXCEPTION_NOT_FOUND));
        return artistMapper.artistToDTO(findArtistById);
    }

}
