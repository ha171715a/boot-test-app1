package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp13RestClient extends RestClient {

	public Smp13RestClient(@Qualifier("smp13RestTemplate") RestTemplate smp13RestTemplate) {
		super(smp13RestTemplate);
	}

}
