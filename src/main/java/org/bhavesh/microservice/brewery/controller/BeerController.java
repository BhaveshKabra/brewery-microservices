package org.bhavesh.microservice.brewery.controller;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.springframework.http.HttpHeaders;
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

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDTO beerDTO)
    {
        BeerDTO savedBeerDto= beerService.save(beerDTO);
        HttpHeaders headers=new HttpHeaders();
        headers.add("location","/api/v1/beer/"+savedBeerDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);

    }
    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable UUID beerId, @RequestBody BeerDTO beerDTO)
    {
        beerService.updateBeer(beerId,beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId)
    {
        beerService.deleteByid(beerId);
    }

}
