package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp16RestClient extends RestClient {

	public Smp16RestClient(@Qualifier("smp16RestTemplate") RestTemplate smp16RestTemplate) {
		super(smp16RestTemplate);
	}

}
