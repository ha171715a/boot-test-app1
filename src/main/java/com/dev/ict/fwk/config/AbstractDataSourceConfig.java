package com.dev.fwk.config;

import javax.sql.DataSource;

import com.dev.fwk.common.properties.DatabaseProperties;
import com.zaxxer.hikari.HikariConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractDataSourceConfig {
    public abstract DataSource dataSource();

    protected HikariConfig configureDataSource(DatabaseProperties properties) {

		HikariConfig cfg = new HikariConfig();

		cfg.setDriverClassName(properties.getDriverClassName());
		cfg.setJdbcUrl(properties.getUrl());
		cfg.addDataSourceProperty("user", properties.getUserName());
		cfg.addDataSourceProperty("password", properties.getPassword());

		cfg.setPoolName(properties.getPoolName());
		cfg.setConnectionTestQuery("SELECT 1");

		cfg.setMinimumIdle(properties.getMinimumIde());
		cfg.setMaximumPoolSize(properties.getMaximumPoolSize());
		cfg.setMaxLifetime(properties.getMaxLifetime());

		cfg.setIdleTimeout(properties.getIdleTimeout());
		cfg.setConnectionTimeout(properties.getConnectionTimeout());
		cfg.setSchema(properties.getSchema());

		log.debug("Hikri CFG: " + cfg.toString());
		return cfg;
    }

    protected HikariConfig configureJndiDataSource(DatabaseProperties properties) {
		HikariConfig cfg = new HikariConfig();
		cfg.setPoolName(properties.getPoolName());
		cfg.setDataSourceJNDI(properties.getJndiName());
	
		log.debug("Hikri CFG: " + cfg.toString());
		return cfg;
    }
}
