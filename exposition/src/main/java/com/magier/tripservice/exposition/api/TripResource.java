package com.magier.tripservice.exposition.api;

import com.magier.tripservice.domain.PriceComputorDriverPort;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api")
public class TripResource {

    private final PriceComputorDriverPort priceComputorDriverPort;

    public TripResource(final PriceComputorDriverPort priceComputorDriverPort) {
        this.priceComputorDriverPort = priceComputorDriverPort;
    }

    @ApiOperation(value="Compute travel fees", notes="Returns the price of a trip")
    @RequestMapping(value={"/trip/{destination}/calculateTripPrice"}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> calculateTripPrice(
            @PathVariable(value="destination") String destinationName) {
        Integer travelPrice = priceComputorDriverPort.computeTravelPrice(destinationName);
        return new ResponseEntity<>(travelPrice, HttpStatus.OK);
    }
}
