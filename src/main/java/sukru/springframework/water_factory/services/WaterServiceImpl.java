package sukru.springframework.water_factory.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sukru.springframework.water_factory.web.model.WaterDto;

import java.util.UUID;

@Slf4j
@Service
public class WaterServiceImpl implements WaterService{

    @Override
    public WaterDto getWaterById(UUID waterId) {
        return WaterDto.builder().id(UUID.randomUUID()).waterName("Fruit").waterStyle("fruit_juice").build();
    }

    @Override
    public WaterDto saveNewWater(WaterDto waterDto) {
        return WaterDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateWater(UUID waterId, WaterDto waterDto) {
        log.debug("Updating water...");
    }

    @Override
    public void deleteById(UUID waterId) {
        log.debug("Deleting water...");
    }
}
