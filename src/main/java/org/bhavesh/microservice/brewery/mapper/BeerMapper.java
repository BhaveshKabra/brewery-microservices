package org.bhavesh.microservice.brewery.mapper;

import org.bhavesh.microservice.brewery.model.Beer;
import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDTO beerToBeerDTO(Beer beer);
    Beer beerDTOToBeer(BeerDTO beer);
}
