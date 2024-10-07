package com.dev.fwk.common.client;

import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.apache.coyote.BadRequestException;
import org.apache.http.conn.HttpHostConnectException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.exception.BizException;
import com.dev.fwk.common.exception.ExceptionCode;
import com.dev.fwk.common.exception.RestClientException;
import com.dev.fwk.common.exception.ServiceException;
import com.dev.fwk.util.RestClientUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class AbstractRestClient {

	private final RestTemplate restTemplate;

	AbstractRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;

//		GsonHttpMessageConverter converter = new GsonHttpMessageConverter(new Gson());
//		List<HttpMessageConverter<?>> converters = new ArrayList<>();
//		converters.add(converter);
//		restTemplate.setMessageConverters(converters);
	}


    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8);
        headers.setContentType(mediaType);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    private HttpEntity<?> createHttpEntity(Object paramVO, HttpMethod method) {
    	HttpHeaders headers = this.createHeaders();
		HttpEntity<?> httpEntity = null;
		if (method == HttpMethod.GET) {
			httpEntity = new HttpEntity<>(headers);

		} else {
			httpEntity = new HttpEntity<>(paramVO, headers);

		}
		return httpEntity;
	}

    protected <T> Object sendRest( String paramUri,
								   Object paramVO,
								   HttpMethod method,
								   Class<T> responseType )throws RestClientException {

		HttpEntity<?> httpEntity = null;
		ResponseEntity<?> responseEntity = null;
		Object result = null;

		try {

			httpEntity = createHttpEntity(paramVO, method);

			responseEntity = restTemplate.exchange( RestClientUtil.getURI(restTemplate, method, paramUri, paramVO),
													method,
													httpEntity,
													responseType );

			if (responseEntity.getStatusCode() == HttpStatus.OK || responseEntity.getStatusCode() == HttpStatus.CREATED) {
				if (log.isDebugEnabled()) {
					log.debug("Status Code => {}", responseEntity.getStatusCode());
				}
				if(responseEntity.getBody() != null) {
					result = responseEntity.getBody();
				}
			}

		} catch (HttpClientErrorException he) {
			log.error("================== sendRest HttpClientErrorException ==============================");
			log.error("HttpClientErrorException: {}", he.toString());
			log.error("HttpClientErrorException getStatusCode: {}", he.getStatusCode().value());
			log.error("===================================================================================");

		} catch (Exception ex) {
			log.error("================== sendRest Exception ==============================");
			log.error("Exception: {}", ex.toString());
            log.error("===================================================================================");

			if(isThrowException(ex)) {
				throw ex;

			}else if(ex instanceof ResourceAccessException) {
				if( ex.getCause() instanceof HttpHostConnectException ) {
					throw new RestClientException(ExceptionCode.ClientError.REST_CONNECTION_TIMEOUT_EXCEPTION.getCd(), ExceptionCode.ClientError.REST_CONNECTION_TIMEOUT_EXCEPTION.getInfo());
				}else if( ex.getCause() instanceof SocketTimeoutException ) {
					throw new RestClientException(ExceptionCode.ClientError.REST_READ_TIMEOUT_EXCEPTION.getCd(), ExceptionCode.ClientError.REST_READ_TIMEOUT_EXCEPTION.getInfo());
				}

			}

			//TODO TEST 코드
//	        String jsonStr = "{\"header\":{\"ifId\":\"CRI10000135_CUSTOM\",\"svrType\":\"D\",\"sndRcvType\":\"R\",\"srcSysCode\":\"com\",\"tgtSysCode\":\"cri\",\"rcvSvcUri\":\"/com/api/moduls/retrieve-sample-fep-psn-info\",\"sndAuthInfo\":\"sndAuthInfo\",\"rcvAuthInfo\":\"rcvAuthInfo\",\"privInfoInclYn\":\"N\",\"extlDvsnCode\":\"2\",\"globalTxNo\":\"36m9a38720164d61608\",\"syncType\":\"\"},\"payload\":{\"ifCode\":\"0135\",\"ctmNm\":\"이순신\",\"ctmDscNo\":\"20040831\",\"carNo\":\"123가4567\",\"rsNo\":\"1234561234567\",\"assoCompCode\":\"N69\",\"ifKindCode\":\"1010\"}}";
//	        try {
//	            result = JacksonUtil.fromJson(jsonStr, responseType);
//
//	            return result;
//	        } catch(Exception e) {
//	            log.error("", e);
//	        }

			throw new RestClientException(ExceptionCode.ClientError.REST_UNKNOWN_EXCEPTION.getCd(), ExceptionCode.ClientError.REST_UNKNOWN_EXCEPTION.getInfo());
		}

		return result;
	}

	private boolean isThrowException(Exception ex) {
		return ex instanceof BizException || ex instanceof BadRequestException || ex instanceof ServiceException;
	}



	public abstract <T> T sendGET(String paramUri) throws RestClientException;

	public abstract <T> T sendGET(String paramUri, Class<?> responseType) throws RestClientException;

	public abstract <T> T sendGET(String paramUri, Object paramVO, Class<?> responseType) throws RestClientException;

	public abstract void sendPOST(String paramUri) throws RestClientException;

	public abstract void sendPOST(String paramUri, Object paramVO) throws RestClientException;

	public abstract <T> T sendPOST(String paramUri, Object paramVO, Class<?> responseType) throws RestClientException;
}
