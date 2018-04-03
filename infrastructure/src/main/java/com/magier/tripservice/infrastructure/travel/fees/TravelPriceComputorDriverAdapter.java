package com.magier.tripservice.infrastructure.travel.fees;

import com.magier.tripservice.domain.PriceComputor;
import com.magier.tripservice.domain.PriceComputorDriverPort;
import com.magier.tripservice.domain.Destination;
import org.springframework.stereotype.Service;

@Service
public class TravelPriceComputorDriverAdapter implements PriceComputorDriverPort{
    private final PriceComputor priceComputor;

    public TravelPriceComputorDriverAdapter(final PriceComputor priceComputor) {
        this.priceComputor = priceComputor;
    }

    @Override
    public Integer computeTravelPrice(String destinationName) {
        Destination destination = new Destination();
        destination.setName(destinationName);
        return priceComputor.calculatePrice(destination);
    }

}
