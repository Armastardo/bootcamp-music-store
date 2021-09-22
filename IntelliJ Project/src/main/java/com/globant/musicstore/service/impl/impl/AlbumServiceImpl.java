package com.globant.musicstore.service.impl.impl;

import com.globant.musicstore.dao.AlbumDAO;
import com.globant.musicstore.dto.AlbumDTO;
import com.globant.musicstore.entity.Album;
import com.globant.musicstore.entity.Song;
import com.globant.musicstore.exception.NotFoundException;
import com.globant.musicstore.mapper.AlbumMapper;
import com.globant.musicstore.mapper.SongMapper;
import com.globant.musicstore.service.impl.AlbumService;
import com.globant.musicstore.service.impl.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.globant.musicstore.utils.Constants.ITEM_DOES_NOT_EXIST;
import static com.globant.musicstore.utils.Constants.ITEM_IS_ALREADY_DISABLE;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumMapper albumMapper;

    @Autowired
    SongMapper songMapper;

    @Autowired
    ArtistService artistService;

    @Autowired
    AlbumDAO albumDAO;

    @Override
    public List<AlbumDTO> showList() {
        List<Album> albums = albumDAO.findAll();
        List<AlbumDTO> albumDTOList = albums.stream().map(album -> {
            return AlbumDTO.builder()
                    .id(album.getId())
                    .name(album.getName())
                    .yearCreation(album.getYearCreation())
                    .description(album.getDescription())
                    .price(album.getPrice())
                    .isActive(album.getIsActive())
                    .quantityAvailable(album.getQuantityAvailable())
                    .artistId(album.getArtist().getId())
                    .songs(songMapper.listSongToDTO(album.getSongs()))
                    .build();
        }).collect(Collectors.toList());
        return albumDTOList;
    }

    @Override
    public AlbumDTO addAlbum(Long idArtist, AlbumDTO albumDTO) {
        artistService.getArtistById(idArtist);
        return albumMapper.albumEntityToDTO(albumDAO.save(albumMapper.albumDTOToEntity(albumDTO)));
    }

    @Override
    public AlbumDTO getAlbumById(Long idAlbum) {
        Album album = albumDAO.findById(idAlbum).orElse(null);

        if (album == null) {
            throw new NotFoundException(ITEM_DOES_NOT_EXIST);
        }
        AlbumDTO albumDTO = albumMapper.albumEntityToDTO(album);
        return albumDTO;
    }

    @Override
    public AlbumDTO deleteAlbum(Long idAlbum) {
        AlbumDTO albumDTO = getAlbumById(idAlbum);
        if (albumDTO.getIsActive() == true) {
            albumDTO.setIsActive(false);
            updateAlbum(idAlbum, albumDTO);
        } else {
            throw new NotFoundException(ITEM_IS_ALREADY_DISABLE);
        }
        return albumDTO;
    }

    @Override
    public List<Song> getAlbumSongs(Long idAlbum) {
        return albumDAO.getById(idAlbum).getSongs();
    }

    @Override
    public AlbumDTO updateAlbum(Long idAlbum, AlbumDTO albumDTO) {
        getAlbumById(idAlbum);
        return albumMapper.albumEntityToDTO(albumDAO.save(albumMapper.albumDTOToEntity(albumDTO)));
    }

    @Override
    public List<AlbumDTO> getAlbumByGenre(Long idCatGenre) {
        List<Album> album = new ArrayList<>();
        List<AlbumDTO> albumDTOList = new ArrayList<>();
        return null;
    }
}
