package com.globant.musicstore.service.impl.impl;

import com.globant.musicstore.dao.AlbumDAO;
import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.entity.Album;
import com.globant.musicstore.entity.Song;
import com.globant.musicstore.exception.NotFoundException;
import com.globant.musicstore.mapper.AlbumMapper;
import com.globant.musicstore.service.impl.AlbumService;
import com.globant.musicstore.service.impl.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.globant.musicstore.utils.Constants.ITEM_DOES_NOT_EXIST;
import static com.globant.musicstore.utils.Constants.ITEM_IS_ALREADY_DISABLE;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumMapper albumMapper;

    @Autowired
    ArtistService artistService;

    @Autowired
    AlbumDAO albumDAO;

    public List<Album> showList(){
        return albumDAO.findAll();
    }

    public AlbumDTO addAlbum(Long id_artist, AlbumDTO albumDTO){
        artistService.getArtistById(id_artist);
        return albumMapper.albumEntityToDTO(albumDAO.save(albumMapper.albumDTOToEntity(albumDTO)));
    }
    public AlbumDTO getAlbumById(Long id_album){
        Album album = albumDAO.findById(id_album).orElse(null);

        if(album == null){
            throw new NotFoundException(ITEM_DOES_NOT_EXIST);
        }
        AlbumDTO albumDTO = albumMapper.albumEntityToDTO(album);
        return albumDTO;
    }
    public void deleteAlbum(Long id_album){
        AlbumDTO albumDTO = getAlbumById(id_album);
        if(albumDTO.getIs_active() == true){
            albumDTO.setIs_active(false);
            updateAlbum(id_album, albumDTO);
        }else{
            throw new NotFoundException(ITEM_IS_ALREADY_DISABLE);
        }
    }

    @Override
    public List<Song> getAlbumSongs(Long id_album) {
        return albumDAO.getById(id_album).getSongs();
    }

    public AlbumDTO updateAlbum(Long id_album, AlbumDTO albumDTO){
        getAlbumById(id_album);
        return albumMapper.albumEntityToDTO(albumDAO.save(albumMapper.albumDTOToEntity(albumDTO)));
    }
}
