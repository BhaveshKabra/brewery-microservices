package org.bhavesh.microservice.brewery.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTOV2 {
    @Null
    private UUID id;
    @NotBlank
    private String beerName;
    @NotBlank
    private BeerStyleEnum beerStyle;
    @Positive
    private long upc;
}
