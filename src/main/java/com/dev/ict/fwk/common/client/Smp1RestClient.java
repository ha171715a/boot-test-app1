package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp1RestClient extends RestClient {

	public Smp1RestClient(@Qualifier("smp1RestTemplate") RestTemplate smp1RestTemplate) {
		super(smp1RestTemplate);
	}

}
