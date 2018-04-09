package com.magier.tripservice.infrastructure.travel.fees;

import com.magier.tripservice.domain.Destination;
import com.magier.tripservice.domain.Trip;
import com.magier.tripservice.domain.TripRepositoryPort;
import com.magier.tripservice.infrastructure.travel.fees.jdbctemplate.TripRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class TripRepositoryJdbcTemplateAdapter implements TripRepositoryPort {

    private JdbcTemplate jdbcTemplate;

    public TripRepositoryJdbcTemplateAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Trip findTripByDestination(Destination destination) {
        String sql = "SELECT destination, agency_fees, travel_fees FROM trip WHERE destination = ?";
        RowMapper<Trip> rowMapper = new TripRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, destination.getName());
    }
}
