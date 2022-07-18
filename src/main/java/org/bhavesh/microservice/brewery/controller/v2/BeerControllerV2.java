package org.bhavesh.microservice.brewery.controller.v2;

import org.bhavesh.microservice.brewery.model.BeerDTO;
import org.bhavesh.microservice.brewery.model.v2.BeerDTOV2;
import org.bhavesh.microservice.brewery.service.BeerService;
import org.bhavesh.microservice.brewery.service.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer/")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService)
    {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable UUID beerId)
    {
        return new ResponseEntity<>(beerService.getBeer(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDTOV2 beerDTO)
    {
        BeerDTOV2 savedBeerDto= beerService.save(beerDTO);
        HttpHeaders headers=new HttpHeaders();
        headers.add("location","/api/v1/beer/"+savedBeerDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);

    }
    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable UUID beerId, @RequestBody BeerDTOV2 beerDTO)
    {
        beerService.updateBeer(beerId,beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId)
    {
        beerService.deleteById(beerId);
    }
}
