package com.org.test.emp.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariDataSource;


public class DataSourceConfig {
	
@Bean
@ConfigurationProperties(prefix="spring.datasource")
public DataSource dataSource() {
	return new HikariDataSource();
}
}
