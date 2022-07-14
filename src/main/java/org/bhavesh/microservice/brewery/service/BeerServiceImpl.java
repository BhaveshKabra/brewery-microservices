package org.bhavesh.microservice.brewery.service;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeer(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                . beerName("Galaxy Cat")
                . beerStyle("Pale Ale")
                .build();

    }
}
