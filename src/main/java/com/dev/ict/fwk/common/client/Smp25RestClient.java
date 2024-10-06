package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp25RestClient extends RestClient {

	public Smp25RestClient(@Qualifier("smp25RestTemplate") RestTemplate smp25RestTemplate) {
		super(smp25RestTemplate);
	}

}
