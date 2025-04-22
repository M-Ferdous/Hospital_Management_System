package com.hospitalAPI.hospitalManagementSystem.dbConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "thirdDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.third")
    public DataSource thirdDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "thirdJdbcTemplate")
    public JdbcTemplate thirdJdbcTemplate(@Qualifier("thirdDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}

