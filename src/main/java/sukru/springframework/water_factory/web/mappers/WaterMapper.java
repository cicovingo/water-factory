package sukru.springframework.water_factory.web.mappers;

import org.mapstruct.Mapper;
import sukru.springframework.water_factory.domian.Water;
import sukru.springframework.water_factory.web.model.WaterDto;

@Mapper
public interface WaterMapper {

    WaterDto waterToWaterDto(Water water);

    Water waterDtoToWater(WaterDto dto);
}
