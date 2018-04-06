package com.magier.tripservice.domain;

public interface TripRepositoryPort {

    Trip findTripByDestination(final Destination destination);
}
