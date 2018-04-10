package com.magier.tripservice.domain.tu;

import com.magier.tripservice.domain.TravelPricer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class TravelPricerTest {

    @InjectMocks
    private TravelPricer travelPricer;


    @Test
    public void computeTravelPrice_should_return_an_invalid_argument_exception_if_destination_is_null() {
        assertThatThrownBy(() -> travelPricer.computeTravelPrice(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
