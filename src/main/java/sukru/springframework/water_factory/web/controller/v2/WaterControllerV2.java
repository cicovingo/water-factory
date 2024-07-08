package sukru.springframework.water_factory.web.controller.v2;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sukru.springframework.water_factory.services.WaterService;
import sukru.springframework.water_factory.services.v2.WaterServiceV2;
import sukru.springframework.water_factory.web.model.WaterDto;
import sukru.springframework.water_factory.web.model.v2.WaterDtoV2;

import java.util.UUID;

@RequestMapping("api/v2/water")
@AllArgsConstructor
@RestController
public class WaterControllerV2 {

    private final WaterServiceV2 waterServiceV2;

    @GetMapping({"/{waterId}"})
    public ResponseEntity<WaterDto> getWater(@PathVariable("waterId") UUID waterId){

        return new ResponseEntity<>(WaterDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody WaterDtoV2 waterDto){
        WaterDtoV2 savedDto = waterServiceV2.saveNewWater(waterDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/water"+savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{waterId}")
    public ResponseEntity handleUpdate(@PathVariable("waterId") UUID waterId, @RequestBody WaterDtoV2 waterDto){

        waterServiceV2.updateWater(waterId, waterDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{waterId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWater(@PathVariable("waterId") UUID waterId){
        waterServiceV2.deleteById(waterId);
    }
}
