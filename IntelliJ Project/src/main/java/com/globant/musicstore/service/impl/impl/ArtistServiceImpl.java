package com.globant.musicstore.service.impl.impl;

import com.globant.musicstore.dao.ArtistDAO;
import com.globant.musicstore.dto.ArtistDTO;
import com.globant.musicstore.entity.Artist;
import com.globant.musicstore.exception.NotFoundException;
import com.globant.musicstore.mapper.ArtistMapper;
import com.globant.musicstore.service.impl.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.globant.musicstore.utils.Constants.ITEM_DOES_NOT_EXIST;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistDAO artistDAO;

    @Autowired
    ArtistMapper artistMapper;
    @Override
    public ArtistDTO getArtistById(Long idArtist) {
        Artist artist = artistDAO.findById(idArtist).orElse(null);

        if(artist == null){
            throw new NotFoundException(ITEM_DOES_NOT_EXIST);
        }
        ArtistDTO artistDTO = artistMapper.artistEntityToDTO(artist);
        return artistDTO;
    }
}
