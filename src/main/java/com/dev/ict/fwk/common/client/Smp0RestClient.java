package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp0RestClient extends RestClient {

	public Smp0RestClient(@Qualifier("smp0RestTemplate") RestTemplate smp0RestTemplate) {
		super(smp0RestTemplate);
	}

}
