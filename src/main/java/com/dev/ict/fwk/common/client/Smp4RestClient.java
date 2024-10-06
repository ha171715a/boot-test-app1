package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp4RestClient extends RestClient {

	public Smp4RestClient(@Qualifier("smp4RestTemplate") RestTemplate smp4RestTemplate) {
		super(smp4RestTemplate);
	}

}
