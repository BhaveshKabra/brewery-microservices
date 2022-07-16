package org.bhavesh.microservice.brewery.controller;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.bhavesh.microservice.brewery.model.CustomerDTO;
import org.bhavesh.microservice.brewery.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO savedCustomerDto= customerService.save(customerDTO);
        HttpHeaders headers=new HttpHeaders();
        headers.add("location","/api/v1/customer/"+savedCustomerDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);

    }
    @PutMapping({"/{customerId}"})
    public ResponseEntity handleUpdate(@PathVariable UUID customerId, @RequestBody CustomerDTO customerDTO)
    {
        customerService.updateCustomer(customerId,customerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId)
    {
        customerService.deleteByid(customerId);
    }
}
