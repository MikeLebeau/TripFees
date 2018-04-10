package com.magier.tripservice.domain.cucumber.steps;

import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.domain.TravelPricer;
import com.magier.tripservice.domain.Trip;
import com.magier.tripservice.domain.TripRepositoryPort;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTravelFeesSteps {

    private Trip trip = new Trip();
    private Destination destination = new Destination();
    private TripRepositoryPort tripRepositoryPort;
    private TravelPricer travelPricer;

    private Integer computedPrice;

    @Before
    public void setup() {
        tripRepositoryPort = Mockito.mock(TripRepositoryPort.class);
        travelPricer = Mockito.spy(new TravelPricer(tripRepositoryPort));
    }

    @Given("^the customer want to travel to \"([^\"]*)\"$")
    public void the_customer_want_to_travel_to(String dest) {
        destination.setName(dest);
        trip.setDestination(destination);
        Mockito.when(tripRepositoryPort.findTripByDestination(destination)).thenReturn(trip);
    }

    @Given("^the travel fees are (\\d+)€$")
    public void the_travel_fees_are_€(Integer travelFees) {
        trip.setTravelFees(travelFees);
    }

    @Given("^the agency fees are (\\d+)€$")
    public void the_agency_fees_are_€(Integer agencyFees) {
        trip.setAgencyFees(agencyFees);
    }

    @When("^the system calculate the trip price")
    public void the_system_calculate_the_trip_price() {
        computedPrice = travelPricer.computeTravelPrice(destination);
    }

    @Then("^the trip price is (\\d+)€$")
    public void the_trip_price_is_€(Integer expectedPrice) {
        assertThat(expectedPrice).isEqualTo(computedPrice);
    }
}
