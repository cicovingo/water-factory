package sukru.springframework.water_factory.services;

import org.springframework.stereotype.Service;
import sukru.springframework.water_factory.web.model.CustomerDto;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Sukru").build();
    }
}
