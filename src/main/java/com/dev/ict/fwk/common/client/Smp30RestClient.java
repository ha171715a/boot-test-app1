package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp30RestClient extends RestClient {

	public Smp30RestClient(@Qualifier("smp30RestTemplate") RestTemplate smp30RestTemplate) {
		super(smp30RestTemplate);
	}

}
