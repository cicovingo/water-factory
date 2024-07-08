package sukru.springframework.water_factory.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sukru.springframework.water_factory.services.CustomerService;
import sukru.springframework.water_factory.web.model.CustomerDto;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@AllArgsConstructor
@RestController
public class CustomerController {

    private final CustomerService  customerService;

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID waterId){

        return new ResponseEntity<>(CustomerDto.builder().build(), HttpStatus.OK);
    }
}
