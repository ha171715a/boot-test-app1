package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp6RestClient extends RestClient {

	public Smp6RestClient(@Qualifier("smp6RestTemplate") RestTemplate smp6RestTemplate) {
		super(smp6RestTemplate);
	}

}
