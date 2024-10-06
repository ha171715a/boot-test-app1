package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp22RestClient extends RestClient {

	public Smp22RestClient(@Qualifier("smp22RestTemplate") RestTemplate smp22RestTemplate) {
		super(smp22RestTemplate);
	}

}
