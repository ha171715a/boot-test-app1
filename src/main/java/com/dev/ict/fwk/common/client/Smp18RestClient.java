package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp18RestClient extends RestClient {

	public Smp18RestClient(@Qualifier("smp18RestTemplate") RestTemplate smp18RestTemplate) {
		super(smp18RestTemplate);
	}

}
