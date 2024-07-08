package sukru.springframework.water_factory.services;

import sukru.springframework.water_factory.web.model.WaterDto;

import java.util.UUID;

public interface WaterService {
    WaterDto getWaterById(UUID waterId);

    WaterDto saveNewWater(WaterDto waterDto);
}
