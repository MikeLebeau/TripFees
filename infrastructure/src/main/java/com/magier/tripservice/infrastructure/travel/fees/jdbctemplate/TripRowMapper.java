package com.magier.tripservice.infrastructure.travel.fees.jdbctemplate;

import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.domain.Trip;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TripRowMapper implements RowMapper<Trip> {
    @Override
    public Trip mapRow(ResultSet row, int i) throws SQLException {
        Destination destination = new Destination();
        destination.setName(row.getString("destination"));

        Trip trip = new Trip();
        trip.setDestination(destination);
        trip.setAgencyFees(row.getInt("agency_fees"));
        trip.setTravelFees(row.getInt("travel_fees"));

        return trip;
    }
}
