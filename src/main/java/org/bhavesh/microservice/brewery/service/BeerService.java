package org.bhavesh.microservice.brewery.service;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerService {
    BeerDTO getBeer(UUID beerid);

    BeerDTO save(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteByid(UUID beerId);
}
