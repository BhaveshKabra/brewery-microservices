package org.bhavesh.microservice.brewery.controller;

import org.bhavesh.microservice.brewery.model.CustomerDTO;
import org.bhavesh.microservice.brewery.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"/{customerId}"})
    private ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID customerId)
    {
        return new ResponseEntity<>(customerService.getCustomer(customerId),HttpStatus.OK);
    }
}
