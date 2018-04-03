package com.magier.tripservice.domain;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelPriceComputor implements PriceComputor{

    private TravelFeesRepositoryPort travelFeesRepository;

    public TravelPriceComputor(TravelFeesRepositoryPort travelFeesRepository) {
        this.travelFeesRepository = travelFeesRepository;
    }

    public Integer calculatePrice(final Destination destination) {
        checkDestination(destination);
        return travelFeesRepository.getAgencyFeesByDestination(destination) + travelFeesRepository.getTravelFeesByDestination(destination);
    }

    private void checkDestination(final Destination destination) {
        Optional<Destination> operationOpt = Optional.ofNullable(destination);
        operationOpt.orElseThrow(IllegalArgumentException::new);
    }
}
