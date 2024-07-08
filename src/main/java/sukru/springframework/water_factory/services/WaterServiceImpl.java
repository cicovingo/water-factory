package sukru.springframework.water_factory.services;

import org.springframework.stereotype.Service;
import sukru.springframework.water_factory.web.model.WaterDto;

import java.util.UUID;

@Service
public class WaterServiceImpl implements WaterService{

    @Override
    public WaterDto getWaterById(UUID waterId) {
        return WaterDto.builder().id(UUID.randomUUID()).waterName("Clean").waterStyle("resource").build();
    }

    @Override
    public WaterDto saveNewWater(WaterDto waterDto) {
        return WaterDto.builder().id(UUID.randomUUID()).build();
    }
}
