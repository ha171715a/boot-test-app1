package com.dev.ict.fwk.common.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.client.RestClient;

@Component
public class Smp28RestClient extends RestClient {

	public Smp28RestClient(@Qualifier("smp28RestTemplate") RestTemplate smp28RestTemplate) {
		super(smp28RestTemplate);
	}

}
