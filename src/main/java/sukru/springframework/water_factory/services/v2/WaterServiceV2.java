package sukru.springframework.water_factory.services.v2;

import sukru.springframework.water_factory.web.model.v2.WaterDtoV2;

import java.util.UUID;

public interface WaterServiceV2 {
    WaterDtoV2 getWaterById(UUID waterId);

    WaterDtoV2 saveNewWater(WaterDtoV2 waterDto);

    void updateWater(UUID waterId, WaterDtoV2 waterDto);

    void deleteById(UUID waterId);
}
