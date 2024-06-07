package com.conference.application.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

@Configuration
public class PersistenceConfig {

	@Bean
	DataSource dataSource() {
		DataSource dataSource = DataSourceBuilder.create()
									.url("jdbc:postgresql://localhost:5432/postgres")
									.username("postgres")
									.password("Welcome")
									.build();
		return dataSource;
	}

}
