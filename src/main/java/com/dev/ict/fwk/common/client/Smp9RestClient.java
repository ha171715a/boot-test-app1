package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp9RestClient extends RestClient {

	public Smp9RestClient(@Qualifier("smp9RestTemplate") RestTemplate smp9RestTemplate) {
		super(smp9RestTemplate);
	}

}
