package sukru.springframework.water_factory.services;

import sukru.springframework.water_factory.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
