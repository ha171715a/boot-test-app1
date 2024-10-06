package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp3RestClient extends RestClient {

	public Smp3RestClient(@Qualifier("smp3RestTemplate") RestTemplate smp3RestTemplate) {
		super(smp3RestTemplate);
	}

}
