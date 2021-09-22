package com.globant.musicstore.utils.mapper;

import com.globant.musicstore.dto.requestDTO.HouseRecordDTO;
import com.globant.musicstore.entity.HouseRecord;
import com.globant.musicstore.utils.mapper.data.CreateHouseRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class HouseRecordMapperTest {

    @Mock
    private HouseRecordMapper houseRecordMapper;

    @Test
    public void testHouseRecord_WhenAHRecordToDTO_Ok(){
        HouseRecord houseRecordRequest = CreateHouseRecord.createHRecord();
        HouseRecordDTO houseRecordDTOResponse = CreateHouseRecord.createHRecordDTO();

        Mockito.when(houseRecordMapper.houseRecordToDTO(houseRecordRequest)).thenReturn(houseRecordDTOResponse);

        HouseRecordDTO response = houseRecordMapper.houseRecordToDTO(houseRecordRequest);

        assertNotNull(response);
        assertEquals(response.getId(), houseRecordDTOResponse.getId());
        assertEquals(response.getName(), houseRecordDTOResponse.getName());
        assertEquals(response.getDescription(), houseRecordDTOResponse.getDescription());

        Mockito.verify(houseRecordMapper, Mockito.times(1)).houseRecordToDTO(houseRecordRequest);
    }

    @Test
    public void testHouseRecord_WhenAHRecordDTOToEntity_Ok(){
        HouseRecord houseRecordResponse = CreateHouseRecord.createHRecord();
        HouseRecordDTO houseRecordDTORequest = CreateHouseRecord.createHRecordDTO();

        Mockito.when(houseRecordMapper.houseRecordDTOToHouseRecord(houseRecordDTORequest)).thenReturn(houseRecordResponse);

        HouseRecord response = houseRecordMapper.houseRecordDTOToHouseRecord(houseRecordDTORequest);

        assertNotNull(response);
        assertEquals(response.getId(), houseRecordResponse.getId());
        assertEquals(response.getName(), houseRecordResponse.getName());
        assertEquals(response.getDescription(), houseRecordResponse.getDescription());

        Mockito.verify(houseRecordMapper, Mockito.times(1)).houseRecordDTOToHouseRecord(houseRecordDTORequest);
    }
}