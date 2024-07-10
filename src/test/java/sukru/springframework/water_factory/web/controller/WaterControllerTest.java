package sukru.springframework.water_factory.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sukru.springframework.water_factory.services.WaterService;
import sukru.springframework.water_factory.web.model.WaterDto;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringRunner.class)
@WebMvcTest(WaterController.class)
public class WaterControllerTest {

    @MockBean
    WaterService waterService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    WaterDto validWater;

    @Before
    public void setUp() {
        validWater = WaterDto.builder().id(UUID.randomUUID())
                .waterName("Water 1")
                .waterStyle("WATER")
                .upc(123456789012L)
                .build();
    }

    @Test
    public void getWater() throws Exception {
        given(waterService.getWaterById(any(UUID.class))).willReturn(validWater);

        mockMvc.perform(get("/api/v1/water/" + validWater.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validWater.getId().toString())))
                .andExpect(jsonPath("$.waterName", is("Water1")));
    }

    @Test
    public void handlePost() throws Exception {
        //given
        WaterDto waterDto = validWater;
        waterDto.setId(null);
        WaterDto savedDto = WaterDto.builder().id(UUID.randomUUID()).waterName("New Water").build();
        String waterDtoJson = objectMapper.writeValueAsString(waterDto);

        given(waterService.saveNewWater(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/water/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(waterDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void handleUpdate() throws Exception {
        //given
        WaterDto waterDto = validWater;
        waterDto.setId(null);
        String waterDtoJson = objectMapper.writeValueAsString(waterDto);

        //when
        mockMvc.perform(put("/api/v1/water/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(waterDtoJson))
                .andExpect(status().isNoContent());

        then(waterService).should().updateWater(any(), any());

    }
}
