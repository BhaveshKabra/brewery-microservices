package org.bhavesh.microservice.brewery.mapper;

import javax.annotation.processing.Generated;
import org.bhavesh.microservice.brewery.model.Beer;
import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T10:48:32+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

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
        beerDTO.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDTO.lastUpdatedDate( dateMapper.asOffsetDateTime( beer.getLastUpdatedDate() ) );

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
        beer1.createdDate( dateMapper.asTimeStamp( beer.getCreatedDate() ) );
        beer1.lastUpdatedDate( dateMapper.asTimeStamp( beer.getLastUpdatedDate() ) );

        return beer1.build();
    }
}
