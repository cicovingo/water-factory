package sukru.springframework.water_factory.services.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sukru.springframework.water_factory.web.model.WaterDto;
import sukru.springframework.water_factory.web.model.v2.WaterDtoV2;
import sukru.springframework.water_factory.web.model.v2.WaterStyle;

import java.util.UUID;

@Slf4j
@Service
public class WaterServiceV2Impl implements WaterServiceV2 {

    @Override
    public WaterDtoV2 getWaterById(UUID waterId) {
        return WaterDtoV2.builder().id(UUID.randomUUID()).waterName("Fruit").waterStyle(WaterStyle.FRUITE_JUICE).build();
    }

    @Override
    public WaterDtoV2 saveNewWater(WaterDtoV2 waterDto) {
        return WaterDtoV2.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateWater(UUID waterId, WaterDtoV2 waterDto) {
        log.debug("Updating water...");
    }

    @Override
    public void deleteById(UUID waterId) {
        log.debug("Deleting water...");
    }
}
