package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp8RestClient extends RestClient {

	public Smp8RestClient(@Qualifier("smp8RestTemplate") RestTemplate smp8RestTemplate) {
		super(smp8RestTemplate);
	}

}
