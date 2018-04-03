package com.magier.tripservice.domain;

public interface PriceComputor {
    Integer calculatePrice(final Destination destination);
}
