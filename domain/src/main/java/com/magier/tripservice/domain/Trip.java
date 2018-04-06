package com.magier.tripservice.domain;

public class Trip {

    Destination destination;
    Integer agencyFees;
    Integer travelFees;

    public Trip() {
    }

    public Trip(Destination destination, Integer agencyFees, Integer travelFees) {
        this.destination = destination;
        this.agencyFees = agencyFees;
        this.travelFees = travelFees;
    }

    public Destination destination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Integer agencyFees() {
        return agencyFees;
    }

    public void setAgencyFees(Integer agencyFees) {
        this.agencyFees = agencyFees;
    }

    public Integer travelFees() {
        return travelFees;
    }

    public void setTravelFees(Integer travelFees) {
        this.travelFees = travelFees;
    }
}
