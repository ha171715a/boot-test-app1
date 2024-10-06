package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp12RestClient extends RestClient {

	public Smp12RestClient(@Qualifier("smp12RestTemplate") RestTemplate smp12RestTemplate) {
		super(smp12RestTemplate);
	}

}
