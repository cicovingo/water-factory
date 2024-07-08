package sukru.springframework.water_factory.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import sukru.springframework.water_factory.web.model.CustomerDto;
import sukru.springframework.water_factory.web.model.WaterDto;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Sukru").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Updating customer...");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting customer...");
    }
}
