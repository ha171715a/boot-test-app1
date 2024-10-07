package com.dev.fwk.common.client;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.exception.RestClientException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestClient extends AbstractRestClient {

	public RestClient(RestTemplate restTemplate) {
		super(restTemplate);
	}

	@Override
    public <T> T sendGET(String paramUri) throws RestClientException {
		return sendGET(paramUri, null);
	}

	@Override
    public <T> T sendGET(String paramUri, Class<?> responseType) throws RestClientException {
		return sendGET(paramUri, null, responseType);
	}

	@Override
    @SuppressWarnings("unchecked")
	public <T> T sendGET(String paramUri, Object paramVO, Class<?> responseType) throws RestClientException {
		if (log.isDebugEnabled()) {
			log.debug("{} -> sendGet", this.getClass().getName());
		}

		T obj = null;
		try {
			obj = (T) sendRest(paramUri, paramVO, HttpMethod.GET, responseType);
		} catch (Exception e) {
			log.error("sendGet error: {}", e.toString());
			throw e;
		}
		return obj;
	}

	@Override
    public void sendPOST(String paramUri) throws RestClientException {
		sendPOST(paramUri, null);
	}

	@Override
    public void sendPOST(String paramUri, Object paramVO) throws RestClientException {
		if (log.isDebugEnabled()) {
			log.debug("{} -> sendPOST", this.getClass().getName());
		}
		sendRest(paramUri, paramVO, HttpMethod.POST, Void.class);
	}

	@Override
    @SuppressWarnings("unchecked")
	public <T> T sendPOST(String paramUri, Object paramVO, Class<?> responseType) throws RestClientException {
		if (log.isDebugEnabled()) {
			log.debug("{} -> sendPOST", this.getClass().getName());
		}
		T obj = null;
		try {
			obj = (T) sendRest(paramUri, paramVO, HttpMethod.POST, responseType);
		} catch (Exception e) {
			log.error("sendPOST error: {}", e.toString());
			throw e;
		}
		return obj;
	}
}
