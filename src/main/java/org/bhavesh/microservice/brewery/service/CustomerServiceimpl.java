package org.bhavesh.microservice.brewery.service;

import org.bhavesh.microservice.brewery.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceimpl implements  CustomerService{
    @Override
    public CustomerDTO getCustomer(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("testy Customer")
                .build();
    }
}
