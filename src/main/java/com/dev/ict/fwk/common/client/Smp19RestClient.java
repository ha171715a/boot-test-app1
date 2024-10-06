package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp19RestClient extends RestClient {

	public Smp19RestClient(@Qualifier("smp19RestTemplate") RestTemplate smp19RestTemplate) {
		super(smp19RestTemplate);
	}

}
