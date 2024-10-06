package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp17RestClient extends RestClient {

	public Smp17RestClient(@Qualifier("smp17RestTemplate") RestTemplate smp17RestTemplate) {
		super(smp17RestTemplate);
	}

}
