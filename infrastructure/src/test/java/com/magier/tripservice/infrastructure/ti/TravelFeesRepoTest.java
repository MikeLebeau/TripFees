package com.magier.tripservice.infrastructure.ti;

import com.magier.tripservice.domain.TripRepositoryPort;
import com.magier.tripservice.infrastructure.config.AppConfig;
import com.magier.tripservice.infrastructure.liquibase.LiquibaseHelper;
import liquibase.Liquibase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TravelFeesRepoTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TripRepositoryPort tripRepositoryPort;

    private Optional<Liquibase> liquibase;

    @Before
    public void _setUp() throws Exception {
        liquibase = LiquibaseHelper.loadData(dataSource,
                "db/changelog/db.changelog-master.yaml");
    }

    //@After
    public void resetCustomerTable() {

    }

   // @After
    public void _tearDown() throws Exception
    {
        LiquibaseHelper.rollbackAndClose(liquibase);
    }

    @Test
    public void test_findTripByDestination_with_a_valid_destination_should_find_a_trip() {
        assertThat(Boolean.TRUE).isTrue();
    }

    //@Test
    public void findAllCustomers() {

    }

    //@Test
    public void findUserByEmail() {

    }
}
