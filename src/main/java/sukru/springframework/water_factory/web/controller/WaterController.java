package sukru.springframework.water_factory.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sukru.springframework.water_factory.services.WaterService;
import sukru.springframework.water_factory.web.model.WaterDto;

import java.util.UUID;

@RequestMapping("api/v1/water")
@AllArgsConstructor
@RestController
public class WaterController {

    private final WaterService  waterService;

    @GetMapping({"/{waterId}"})
    public ResponseEntity<WaterDto> getWater(@PathVariable("waterId") UUID waterId){

        return new ResponseEntity<>(WaterDto.builder().build(), HttpStatus.OK);
    }
}
