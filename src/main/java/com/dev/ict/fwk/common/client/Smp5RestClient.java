package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp5RestClient extends RestClient {

	public Smp5RestClient(@Qualifier("smp5RestTemplate") RestTemplate smp5RestTemplate) {
		super(smp5RestTemplate);
	}

}
