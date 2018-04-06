package com.magier.tripservice.domain;

public interface Priceable {
    Integer calculatePrice(final Destination destination);
}
