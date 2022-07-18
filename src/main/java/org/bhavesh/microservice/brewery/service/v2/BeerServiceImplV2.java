package org.bhavesh.microservice.brewery.service.v2;

import lombok.extern.slf4j.Slf4j;
import org.bhavesh.microservice.brewery.model.v2.BeerDTOV2;
import org.bhavesh.microservice.brewery.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeer(UUID beerId) {
        return BeerDTOV2.builder().id(UUID.randomUUID())
                . beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();

    }

    @Override
    public BeerDTOV2 save(BeerDTOV2 beerDTO) {
        return BeerDTOV2.builder()
                .id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .beerStyle(beerDTO.getBeerStyle())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 beerDTO) {
        if(getBeer(beerId)!=null)
        {
            BeerDTOV2 updateBeerDTO=getBeer(beerId);
            updateBeerDTO.setBeerName(beerDTO.getBeerName());
            updateBeerDTO.setBeerStyle(beerDTO.getBeerStyle());
            updateBeerDTO.setUpc(beerDTO.getUpc());
        }
    }

    @Override
    public void deleteById(UUID beerId)
    {
        log.debug("deleting a beer");
    }
}
