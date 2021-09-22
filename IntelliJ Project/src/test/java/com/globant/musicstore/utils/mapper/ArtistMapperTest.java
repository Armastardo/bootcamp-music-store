package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.ArtistDTO;
import com.globant.musicstore.entity.Artist;
import com.globant.musicstore.utils.mapper.data.CreateArtist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ArtistMapperTest {

    @Mock
    private ArtistMapper artistMapper;

    @Test
    public void testArtistMapper_WhenAnArtistToDTO_Ok() {
        Artist artistRequest = CreateArtist.createArtist();
        ArtistDTO artistResponse = CreateArtist.createArtistDTO();

        Mockito.when(artistMapper.artistToDTO(artistRequest)).thenReturn(artistResponse);

        ArtistDTO response = artistMapper.artistToDTO(artistRequest);

        assertNotNull(response);
        assertEquals(response.getId(), artistResponse.getId());
        assertEquals(response.getName(), artistResponse.getName());
        assertEquals(response.getDescription(), artistResponse.getDescription());

        Mockito.verify(artistMapper, Mockito.times(1)).artistToDTO(artistRequest);
    }

    @Test
    public void testArtistMapper_WhenAnArtistDTOToEntity_Ok() {
        Artist artistResponse = CreateArtist.createArtist();
        ArtistDTO artistRequest = CreateArtist.createArtistDTO();

        Mockito.when(artistMapper.artistDTOtoArtist(artistRequest)).thenReturn(artistResponse);

        Artist response = artistMapper.artistDTOtoArtist(artistRequest);

        assertNotNull(response);
        assertEquals(response.getId(), artistResponse.getId());
        assertEquals(response.getName(), artistResponse.getName());
        assertEquals(response.getDescription(), artistResponse.getDescription());

        Mockito.verify(artistMapper, Mockito.times(1)).artistDTOtoArtist(artistRequest);
    }
}