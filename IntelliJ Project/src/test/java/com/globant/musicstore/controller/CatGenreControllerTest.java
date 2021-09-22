package com.globant.musicstore.controller;

import com.globant.musicstore.dto.requestDTO.CatGenreDTO;
import com.globant.musicstore.dto.responseDTO.ResponseDTO;
import com.globant.musicstore.entity.CatGenre;
import com.globant.musicstore.service.CatGenreService;
import com.globant.musicstore.utils.mapper.data.CreateGenre;
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
public class CatGenreControllerTest {

    @InjectMocks
    private CatGenreController catGenreController;

    @Mock
    private CatGenreService catGenreService;

    @Test
    public void testController_WhenWeCallGetGenreById_Ok(){
        CatGenre catGenreRequest = CreateGenre.createGenre();
        CatGenreDTO catGenreDTO = CreateGenre.createGenreDTO();

        Mockito.when(catGenreService.getGenreById(catGenreRequest.getId())).thenReturn(catGenreDTO);

        ResponseEntity<ResponseDTO<CatGenreDTO>> response = catGenreController.getGenreById(catGenreRequest.getId());

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getResponse().getId(), catGenreDTO.getId());
        assertEquals(response.getBody().getResponse().getDescription(),catGenreDTO.getDescription());

        Mockito.verify(catGenreService, Mockito.times(1)).getGenreById(catGenreRequest.getId());
    }
}