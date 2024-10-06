package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp10RestClient extends RestClient {

	public Smp10RestClient(@Qualifier("smp10RestTemplate") RestTemplate smp10RestTemplate) {
		super(smp10RestTemplate);
	}

}
