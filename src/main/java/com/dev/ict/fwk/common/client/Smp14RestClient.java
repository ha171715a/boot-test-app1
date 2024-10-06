package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp14RestClient extends RestClient {

	public Smp14RestClient(@Qualifier("smp14RestTemplate") RestTemplate smp14RestTemplate) {
		super(smp14RestTemplate);
	}

}
