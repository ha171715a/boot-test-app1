package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp21RestClient extends RestClient {

	public Smp21RestClient(@Qualifier("smp21RestTemplate") RestTemplate smp21RestTemplate) {
		super(smp21RestTemplate);
	}

}
