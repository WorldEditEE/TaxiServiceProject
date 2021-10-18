package ru.digitalleague.taxi_company.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder =  DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/taxi_service?currentSchema=test");
        dataSourceBuilder.username("aleksandrukolov");
        dataSourceBuilder.password("1707");
        return dataSourceBuilder.build();
    }

}
