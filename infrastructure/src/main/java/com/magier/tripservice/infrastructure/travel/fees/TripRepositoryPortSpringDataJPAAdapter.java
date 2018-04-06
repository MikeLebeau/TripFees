package com.magier.tripservice.infrastructure.travel.fees;

import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.domain.Trip;
import com.magier.tripservice.domain.TripRepositoryPort;

//@Repository
public class TripRepositoryPortSpringDataJPAAdapter implements TripRepositoryPort {

    @Override
    public Trip findTripByDestination(Destination destination) {
        return null;
    }
}
