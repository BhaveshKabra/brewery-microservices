package org.bhavesh.microservice.brewery.service.v2;

import org.bhavesh.microservice.brewery.model.v2.BeerDTOV2;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public interface BeerServiceV2 {
    BeerDTOV2 getBeer(UUID beerId);
    BeerDTOV2 save(BeerDTOV2 beerDTO);
    void updateBeer(UUID beerId, BeerDTOV2 beerDTO);
    void deleteById(UUID beerId);

}
