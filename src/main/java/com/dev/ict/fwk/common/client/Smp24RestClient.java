package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp24RestClient extends RestClient {

	public Smp24RestClient(@Qualifier("smp24RestTemplate") RestTemplate smp24RestTemplate) {
		super(smp24RestTemplate);
	}

}
