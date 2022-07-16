package org.bhavesh.microservice.brewery.service;

import lombok.extern.slf4j.Slf4j;
import org.bhavesh.microservice.brewery.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceimpl implements  CustomerService{
    @Override
    public CustomerDTO getCustomer(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("testy Customer")
                .build();
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name(customerDTO.getName())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        if(getCustomer(customerId)!=null)
        {
            CustomerDTO savedCustomer=getCustomer(customerId);
            savedCustomer.setName(customerDTO.getName());
        }
    }

    @Override
    public void deleteByid(UUID customerId) {
        log.debug("Customer Deleted");
    }
}
