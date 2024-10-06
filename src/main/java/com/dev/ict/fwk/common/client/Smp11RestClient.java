package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp11RestClient extends RestClient {

	public Smp11RestClient(@Qualifier("smp11RestTemplate") RestTemplate smp11RestTemplate) {
		super(smp11RestTemplate);
	}

}
