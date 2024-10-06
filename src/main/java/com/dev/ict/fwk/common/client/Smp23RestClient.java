package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp23RestClient extends RestClient {

	public Smp23RestClient(@Qualifier("smp23RestTemplate") RestTemplate smp23RestTemplate) {
		super(smp23RestTemplate);
	}

}
