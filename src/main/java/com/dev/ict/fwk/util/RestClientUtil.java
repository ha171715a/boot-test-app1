package com.dev.fwk.util;

import java.net.URI;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class RestClientUtil {

	public static URI getURI(RestTemplate restTemplate, HttpMethod method, String paramUri, Object paramVO) {

        UriComponentsBuilder builder = null;
        Map<String, String> paramMap = null;
        URI uri = null;
        String targetDomain = "";

        try {

	        RootUriTemplateHandler handler = (RootUriTemplateHandler) restTemplate.getUriTemplateHandler();
	        targetDomain = handler.getRootUri();

	        builder = UriComponentsBuilder.fromHttpUrl(targetDomain).path(paramUri);

	        if (method == HttpMethod.GET) {
	        	if (paramVO != null) {
		        	paramMap = BeanUtils.describe(paramVO);
	                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
	                    builder.queryParam(entry.getKey(), entry.getValue());
	                }
	        	}
	        }

            uri = builder.build().encode().toUri();

            if (log.isInfoEnabled()) {
                log.info("=======================================================");
                log.info(" url ================> {}", uri.toString());
                log.info("=======================================================");
            }

        }catch(Exception e) {
        	log.error("=============== RestClientUtil Exception ==================");
        	log.error(e.toString());
        	log.error("===========================================================");
        }

        return uri;
    }

}
