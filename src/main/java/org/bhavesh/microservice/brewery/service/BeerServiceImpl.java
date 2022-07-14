package org.bhavesh.microservice.brewery.service;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getbeer(UUID beerid) {
        return BeerDTO.builder().id(UUID.randomUUID())
                . beerName("Galaxy Cat")
                . beerStyle("Pale Ale")
                .build();

    }
}
