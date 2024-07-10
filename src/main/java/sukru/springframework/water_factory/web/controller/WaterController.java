package sukru.springframework.water_factory.web.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody WaterDto waterDto){
        WaterDto savedDto = waterService.saveNewWater(waterDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/water"+savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{waterId}")
    public ResponseEntity handleUpdate(@PathVariable("waterId") UUID waterId, @Valid @RequestBody WaterDto waterDto){

        waterService.updateWater(waterId, waterDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{waterId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWater(@PathVariable("waterId") UUID waterId){
        waterService.deleteById(waterId);
    }
}
