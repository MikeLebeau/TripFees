package com.magier.tripservice.infrastructure.travel.fees.mock;

import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.domain.Trip;
import com.magier.tripservice.domain.TripRepositoryPort;
import com.magier.tripservice.domain.error.BusinessErrors;
import com.magier.tripservice.domain.error.BusinessException;
import org.springframework.stereotype.Repository;

//@Repository
public class TripRepositoryPortMockAdapter implements TripRepositoryPort {

    @Override
    public Trip findTripByDestination(final Destination destination) {

        Trip trip = new Trip();
        trip.setDestination(destination);

        switch (destination.getName()) {
            case "Paris":
                trip.setTravelFees(250);
                trip.setAgencyFees(25);
                break;
            case "Lille":
                trip.setTravelFees(0);
                trip.setAgencyFees(0);
                break;
            case "New-York":
            case "Tokyo":
            case "Beijing":
                trip.setTravelFees(1000);
                trip.setAgencyFees(100);
                break;
            default:
                throw new BusinessException(BusinessErrors.MISSING_DESTINATION);
        }

        return trip;
    }
}
