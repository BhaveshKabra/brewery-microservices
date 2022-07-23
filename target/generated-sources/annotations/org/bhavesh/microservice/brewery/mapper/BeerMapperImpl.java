package org.bhavesh.microservice.brewery.mapper;

import javax.annotation.processing.Generated;
import org.bhavesh.microservice.brewery.model.Beer;
import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-23T19:58:16+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDTO beerToBeerDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTO.BeerDTOBuilder beerDTO = BeerDTO.builder();

        beerDTO.id( beer.getId() );
        beerDTO.beerName( beer.getBeerName() );
        beerDTO.beerStyle( beer.getBeerStyle() );
        beerDTO.upc( beer.getUpc() );

        return beerDTO.build();
    }

    @Override
    public Beer beerDTOToBeer(BeerDTO beer) {
        if ( beer == null ) {
            return null;
        }

        Beer.BeerBuilder beer1 = Beer.builder();

        beer1.id( beer.getId() );
        beer1.beerName( beer.getBeerName() );
        beer1.beerStyle( beer.getBeerStyle() );
        beer1.upc( beer.getUpc() );

        return beer1.build();
    }
}
