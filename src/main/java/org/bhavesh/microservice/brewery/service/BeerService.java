package org.bhavesh.microservice.brewery.service;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerService {
    BeerDTO getBeer(UUID beerid);
}
