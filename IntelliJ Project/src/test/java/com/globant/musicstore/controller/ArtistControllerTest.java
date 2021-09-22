package com.globant.musicstore.controller;

import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.entity.Artist;
import com.globant.musicstore.service.impl.ArtistServiceImpl;
import com.globant.musicstore.utils.mapper.data.CreateArtist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ArtistControllerTest {

    @InjectMocks
    private ArtistController artistController;

    @Mock
    private ArtistServiceImpl artistService;

    @Test
    public void testController_WhenWeCallGetByIdArtist_Ok(){
        Artist artistRequest = CreateArtist.createArtist();
        ArtistDTO artistDTO = CreateArtist.createArtistDTO();

        Mockito.when(artistService.getArtistById(artistRequest.getId())).thenReturn(artistDTO);

        ResponseEntity<ResponseDTO<ArtistDTO>> response = artistController.getArtistById(artistRequest.getId());

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getResponse().getId(), artistDTO.getId());
        assertEquals(response.getBody().getResponse().getName(), artistDTO.getName());

        Mockito.verify(artistService, Mockito.times(1)).getArtistById(artistRequest.getId());
    }

    @Test
    public void testController_WhenWeCallGetAllArtists_Ok(){
        List<ArtistDTO> artistDTOList = new ArrayList<ArtistDTO>();
        ArtistDTO artistDTO = CreateArtist.createArtistDTO();
        artistDTOList.add(artistDTO);

        Mockito.when(artistService.getAllArtists()).thenReturn(artistDTOList);

        ResponseEntity<ResponseDTO<List<ArtistDTO>>> response = artistController.getAllArtists();

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getResponse().get(0).getId(), artistDTO.getId());
        assertEquals(response.getBody().getResponse().get(0).getName(), artistDTO.getName());

        Mockito.verify(artistService, Mockito.times(1)).getAllArtists();
    }


    @Test
    public void testController_WhenWeSaveAnArtist_Ok(){
        ArtistDTO artistDTOResponse = CreateArtist.createArtistDTO();
        ArtistDTO artistDTO = CreateArtist.createArtistDTO();

        Mockito.when(artistService.saveArtist(artistDTO)).thenReturn(artistDTOResponse);

        ResponseEntity<ResponseDTO<ArtistDTO>> response = artistController.saveArtist(artistDTO);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getResponse().getId(), artistDTOResponse.getId());
        assertEquals(response.getBody().getResponse().getName(), artistDTOResponse.getName());

        Mockito.verify(artistService, Mockito.times(1)).saveArtist(artistDTO);
    }


    @Test
    public void testController_WhenWeUpdateAnArtist_Ok(){
        ArtistDTO artistDTOResponse = CreateArtist.createArtistDTO();
        ArtistDTO artistDTO = CreateArtist.createArtistDTO();

        Mockito.when(artistService.updateArtist(artistDTO)).thenReturn(artistDTOResponse);

        ResponseEntity<ResponseDTO<ArtistDTO>> response = artistController.updateArtist(artistDTO);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getResponse().getId(), artistDTOResponse.getId());
        assertEquals(response.getBody().getResponse().getName(), artistDTOResponse.getName());

        Mockito.verify(artistService, Mockito.times(1)).updateArtist(artistDTO);
    }

    @Test
    public void testController_WhenWeDeleteAnArtist_Ok(){
        Artist artistRequest = CreateArtist.createArtist();
        ArtistDTO artistDTO = CreateArtist.createArtistDTO();

        Mockito.when(artistService.deleteArtistLogically(artistRequest.getId())).thenReturn(artistDTO);

        ResponseEntity<ResponseDTO<ArtistDTO>> response = artistController.deleteArtistById(artistRequest.getId());

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getResponse().getId(), artistDTO.getId());
        assertEquals(response.getBody().getResponse().getName(), artistDTO.getName());

        Mockito.verify(artistService, Mockito.times(1)).deleteArtistLogically(artistRequest.getId());
    }



}