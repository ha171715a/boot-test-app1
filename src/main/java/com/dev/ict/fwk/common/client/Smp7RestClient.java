package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp7RestClient extends RestClient {

	public Smp7RestClient(@Qualifier("smp7RestTemplate") RestTemplate smp7RestTemplate) {
		super(smp7RestTemplate);
	}

}
