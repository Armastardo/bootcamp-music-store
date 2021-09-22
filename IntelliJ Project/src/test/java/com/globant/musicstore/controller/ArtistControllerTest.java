package com.globant.musicstore.controller;

import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.entity.Artist;
import com.globant.musicstore.service.imp.ArtistServiceImp;
import com.globant.musicstore.utils.mapper.data.CreateArtist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ArtistControllerTest {

    @InjectMocks
    private ArtistController artistController;

    @Mock
    private ArtistServiceImp artistService;

    @Test
    public void testController_WhenWeCallGetById_Ok(){
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
}