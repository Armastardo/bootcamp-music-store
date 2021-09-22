package com.globant.musicstore.service.impl;


import com.globant.musicstore.dao.ArtistDAO;
import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.entity.Artist;
import com.globant.musicstore.utils.mapper.ArtistMapper;
import com.globant.musicstore.utils.mapper.data.CreateArtist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ArtistServiceImplTest {

    @InjectMocks
    private ArtistServiceImpl artistService;

    @Mock
    private ArtistMapper artistMapper;

    @Mock
    private ArtistDAO artistDAO;

    @Test
    public void testArtistService_WhenWeGetAllArtists_Ok(){
        ArtistDTO artistDTOResponse = CreateArtist.createArtistDTO();
        Artist artistEntity = CreateArtist.createArtist();

        List<ArtistDTO> artistDTOList = new ArrayList<ArtistDTO>();
        artistDTOList.add(artistDTOResponse);

        List<Artist> artistList = new ArrayList<Artist>();
        artistList.add(artistEntity);

        Mockito.when(artistDAO.findAll()).thenReturn(artistList);
        Mockito.when(artistMapper.listArtistToDTO(artistList)).thenReturn(artistDTOList);

        List<ArtistDTO> response = artistService.getAllArtists();

        assertNotNull(response);
        assertEquals(response.get(0).getId(), artistDTOList.get(0).getId());
        assertEquals(response.get(0).getName(), artistDTOList.get(0).getName());
    }

    @Test
    public void testArtistService_WhenWeGetAnArtistById_Ok(){
        ArtistDTO artistDTOResponse = CreateArtist.createArtistDTO();
        Artist artistEntity = CreateArtist.createArtist();

        Mockito.when(artistDAO.findById(artistDTOResponse.getId())).thenReturn(Optional.of(artistEntity));
        Mockito.when(artistMapper.artistToDTO(artistEntity)).thenReturn(artistDTOResponse);

        ArtistDTO response = artistService.getArtistById(artistDTOResponse.getId());

        assertNotNull(response);
        assertEquals(response.getId(), artistDTOResponse.getId());
        assertEquals(response.getName(), artistDTOResponse.getName());

        Mockito.verify(artistDAO, Mockito.times(1)).findById(artistDTOResponse.getId());
        Mockito.verify(artistMapper, Mockito.times(1)).artistToDTO(artistEntity);
    }


    @Test
    public void testArtistService_WhenWeSaveAnArtist_Fail(){
        ArtistDTO artistDTORequest = CreateArtist.createArtistDTO();
        ArtistDTO artistDTOResponse = CreateArtist.createArtistDTO();
        Artist artistEntity = CreateArtist.createArtist();
        Artist artistEntityResponse = CreateArtist.createArtist();

        Mockito.when(artistMapper.artistDTOtoArtist(artistDTORequest)).thenReturn(artistEntityResponse);
        Mockito.when(artistDAO.save(artistEntity)).thenReturn(artistEntityResponse);
        Mockito.when(artistMapper.artistToDTO(artistEntityResponse)).thenReturn(artistDTOResponse);

        ArtistDTO response = artistService.saveArtist(artistDTORequest);

        assertNotNull(response);
        assertEquals(response.getId(), artistDTOResponse.getId());
        assertEquals(response.getName(), artistDTOResponse.getName());
        assertEquals(response.getDescription(), artistDTOResponse.getDescription());

        Mockito.verify(artistMapper, Mockito.times(1)).artistDTOtoArtist(artistDTORequest);
        Mockito.verify(artistDAO, Mockito.times(1)).save(artistEntity);
        Mockito.verify(artistMapper, Mockito.times(1)).artistToDTO(artistEntityResponse);
    }
}