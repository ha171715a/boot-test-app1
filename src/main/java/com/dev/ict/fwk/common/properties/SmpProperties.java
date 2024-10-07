package com.dev.fwk.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "smp.datasource")
@Data
public class SmpProperties implements DatabaseProperties {
    private String driverClassName;
	private String url;
	private String userName;
	private String password;
	private String poolName;
	private int minimumIde;
	private int maximumPoolSize;
	private int maxLifetime;
	private int idleTimeout;
	private int connectionTimeout;
	private String jndiName;
	private String schema;
}
