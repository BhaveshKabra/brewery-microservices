package org.bhavesh.microservice.brewery.controller;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.bhavesh.microservice.brewery.service.BeerService;
import java.util.UUID;

@RestController("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerid)
    {
        return new ResponseEntity<>(beerService.getbeer(beerid), HttpStatus.OK);
    }
}
