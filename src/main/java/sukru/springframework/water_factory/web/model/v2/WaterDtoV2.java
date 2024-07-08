package sukru.springframework.water_factory.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaterDtoV2 {
    private UUID id;
    private String waterName;
    private WaterStyle waterStyle;
    private Long upc;
}
