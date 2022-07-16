package org.bhavesh.microservice.brewery.service;

import org.bhavesh.microservice.brewery.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerService {
    CustomerDTO getCustomer(UUID customerId);

    CustomerDTO save(CustomerDTO customerDTO);

    void updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteByid(UUID customerId);
}
