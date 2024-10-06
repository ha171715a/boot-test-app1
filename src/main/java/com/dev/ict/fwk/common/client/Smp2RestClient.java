package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp2RestClient extends RestClient {

	public Smp2RestClient(@Qualifier("smp2RestTemplate") RestTemplate smp2RestTemplate) {
		super(smp2RestTemplate);
	}

}
