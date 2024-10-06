package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp20RestClient extends RestClient {

	public Smp20RestClient(@Qualifier("smp20RestTemplate") RestTemplate smp20RestTemplate) {
		super(smp20RestTemplate);
	}

}
