package org.bhavesh.microservice.brewery.mapper;

import javax.annotation.processing.Generated;
import org.bhavesh.microservice.brewery.model.Customer;
import org.bhavesh.microservice.brewery.model.CustomerDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-23T19:58:17+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO.CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.name( customer.getName() );

        return customerDTO.build();
    }

    @Override
    public Customer customerDTOToCustomer(CustomerDTO customer) {
        if ( customer == null ) {
            return null;
        }

        Customer.CustomerBuilder customer1 = Customer.builder();

        customer1.id( customer.getId() );
        customer1.name( customer.getName() );

        return customer1.build();
    }
}
