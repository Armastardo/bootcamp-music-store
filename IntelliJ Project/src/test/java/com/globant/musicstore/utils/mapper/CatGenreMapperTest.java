package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.CatGenreDTO;
import com.globant.musicstore.entity.CatGenre;
import com.globant.musicstore.utils.mapper.data.CreateGenre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CatGenreMapperTest {

    @Mock
    private CatGenreMapper catGenreMapper;

    @Test
    public void testGenre_WhenAGenreToDTO_Ok(){
        CatGenre genreRequest = CreateGenre.createGenre();
        CatGenreDTO genreResponse = CreateGenre.createGenreDTO();

        Mockito.when(catGenreMapper.genreToDto(genreRequest)).thenReturn(genreResponse);

        CatGenreDTO response = catGenreMapper.genreToDto(genreRequest);

        assertNotNull(response);
        assertEquals(response.getId(), genreResponse.getId());
        assertEquals(response.getName(), genreResponse.getName());
        assertEquals(response.getDescription(), genreResponse.getDescription());

        Mockito.verify(catGenreMapper, Mockito.times(1)).genreToDto(genreRequest);
    }

    @Test
    public void testGenre_WhenAGenreDTOToEntity_Ok(){
        CatGenre genreResponse = CreateGenre.createGenre();
        CatGenreDTO genreRequest = CreateGenre.createGenreDTO();

        Mockito.when(catGenreMapper.genreDTOToGenre(genreRequest)).thenReturn(genreResponse);

        CatGenre response = catGenreMapper.genreDTOToGenre(genreRequest);

        assertNotNull(response);
        assertEquals(response.getId(), genreResponse.getId());
        assertEquals(response.getName(), genreResponse.getName());
        assertEquals(response.getDescription(), genreResponse.getDescription());

        Mockito.verify(catGenreMapper, Mockito.times(1)).genreDTOToGenre(genreRequest);
    }

}