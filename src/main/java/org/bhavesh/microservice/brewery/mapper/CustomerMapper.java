package org.bhavesh.microservice.brewery.mapper;

import org.bhavesh.microservice.brewery.model.Customer;
import org.bhavesh.microservice.brewery.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customer);
}
