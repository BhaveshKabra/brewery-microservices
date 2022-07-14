package org.bhavesh.microservice.brewery.controller;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bhavesh.microservice.brewery.service.BeerService;
import java.util.UUID;

@RequestMapping("/api/v1/beer/")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeer(beerId), HttpStatus.OK);
    }
}
