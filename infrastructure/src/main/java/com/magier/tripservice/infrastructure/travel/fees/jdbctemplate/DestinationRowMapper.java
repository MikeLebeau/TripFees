package com.magier.tripservice.infrastructure.travel.fees.jdbctemplate;

import com.magier.tripservice.domain.Destination;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DestinationRowMapper implements RowMapper<Destination> {
    @Override
    public Destination mapRow(ResultSet row, int i) throws SQLException {
        Destination destination = new Destination();
        destination.setName(row.getString("name"));

        return destination;
    }
}
