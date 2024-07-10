package sukru.springframework.water_factory.web.mappers;

import org.mapstruct.Mapper;
import sukru.springframework.water_factory.domian.Customer;
import sukru.springframework.water_factory.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto dto);
}
