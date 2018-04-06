package com.magier.tripservice.infrastructure.travel.fees;

import com.magier.tripservice.domain.Priceable;
import com.magier.tripservice.domain.PriceComputorDriverPort;
import com.magier.tripservice.domain.Destination;
import org.springframework.stereotype.Service;

@Service
public class TravelPriceComputorDriverAdapter implements PriceComputorDriverPort{
    private final Priceable priceable;

    public TravelPriceComputorDriverAdapter(final Priceable priceable) {
        this.priceable=priceable;
    }

    @Override
    public Integer computeTravelPrice(String destinationName) {
        Destination destination = new Destination();
        destination.setName(destinationName);
        return priceable.calculatePrice(destination);
    }

}
