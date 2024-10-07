package com.dev.fwk.common.properties;

public interface DatabaseProperties {
    public String getDriverClassName();
	public String getUrl();
	public String getUserName();
	public String getPassword();
	public String getPoolName();
	public int getMinimumIde();
	public int getMaximumPoolSize();
	public int getMaxLifetime();
	public int getIdleTimeout();
	public int getConnectionTimeout();
	public String getJndiName();
	public String getSchema();
}
