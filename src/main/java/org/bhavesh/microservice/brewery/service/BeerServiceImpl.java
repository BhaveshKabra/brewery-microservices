package org.bhavesh.microservice.brewery.service;

import lombok.extern.slf4j.Slf4j;
import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeer(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                . beerName("Galaxy Cat")
                . beerStyle("Pale Ale")
                .build();

    }

    @Override
    public BeerDTO save(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        if(getBeer(beerId)!=null)
        {
            BeerDTO updatebeerDTO=getBeer(beerId);
            updatebeerDTO.setBeerName(beerDTO.getBeerName());
            updatebeerDTO.setBeerStyle(beerDTO.getBeerStyle());
            updatebeerDTO.setUpc(beerDTO.getUpc());
        }
    }

    @Override
    public void deleteByid(UUID beerId) {
        log.debug("deleting a beer");
    }
}
