package com.dev.fwk.config;

import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.dev.fwk.common.interceptor.HttpClientInterceptor;
import com.dev.fwk.handler.RestTemplateResponseErrorHandler;
import com.dev.fwk.util.ConstantsUtil;

@Configuration
public class RestTemplateConfig {

    @Value("${http.client.max-conn-total:100}")
    private int maxConnTotal;

    @Value("${http.client.connection-time-to-live:30}")
    private int connectionTimeToLive;

    @Value("${target.domain.smp0:http://127.0.0.1:8000}")
    private String targetDomainSmp0;

    @Value("${target.domain.smp1:http://127.0.0.1:8000}")
    private String targetDomainSmp1;

    @Value("${target.domain.smp2:http://127.0.0.1:8000}")
    private String targetDomainSmp2;

    @Value("${target.domain.smp3:http://127.0.0.1:8000}")
    private String targetDomainSmp3;

    @Value("${target.domain.smp4:http://127.0.0.1:8000}")
    private String targetDomainSmp4;

    @Value("${target.domain.smp5:http://127.0.0.1:8000}")
    private String targetDomainSmp5;

    @Value("${target.domain.smp6:http://127.0.0.1:8000}")
    private String targetDomainSmp6;

    @Value("${target.domain.smp7:http://127.0.0.1:8000}")
    private String targetDomainSmp7;

    @Value("${target.domain.smp8:http://127.0.0.1:8000}")
    private String targetDomainSmp8;

    @Value("${target.domain.smp9:http://127.0.0.1:8000}")
    private String targetDomainSmp9;

    @Value("${target.domain.smp10:http://127.0.0.1:8000}")
    private String targetDomainSmp10;

    @Value("${target.domain.smp11:http://127.0.0.1:8000}")
    private String targetDomainSmp11;

    @Value("${target.domain.smp12:http://127.0.0.1:8000}")
    private String targetDomainSmp12;

    @Value("${target.domain.smp13:http://127.0.0.1:8000}")
    private String targetDomainSmp13;

    @Value("${target.domain.smp14:http://127.0.0.1:8000}")
    private String targetDomainSmp14;

    @Value("${target.domain.smp15:http://127.0.0.1:8000}")
    private String targetDomainSmp15;

    @Value("${target.domain.smp16:http://127.0.0.1:8000}")
    private String targetDomainSmp16;

    @Value("${target.domain.smp17:http://127.0.0.1:8000}")
    private String targetDomainSmp17;

    @Value("${target.domain.smp18:http://127.0.0.1:8000}")
    private String targetDomainSmp18;

    @Value("${target.domain.smp19:http://127.0.0.1:8000}")
    private String targetDomainSmp19;

    @Value("${target.domain.smp20:http://127.0.0.1:8000}")
    private String targetDomainSmp20;

    @Value("${target.domain.smp21:http://127.0.0.1:8000}")
    private String targetDomainSmp21;

    @Value("${target.domain.smp22:http://127.0.0.1:8000}")
    private String targetDomainSmp22;

    @Value("${target.domain.smp23:http://127.0.0.1:8000}")
    private String targetDomainSmp23;

    @Value("${target.domain.smp24:http://127.0.0.1:8000}")
    private String targetDomainSmp24;

    @Value("${target.domain.smp25:http://127.0.0.1:8000}")
    private String targetDomainSmp25;

    @Value("${target.domain.smp26:http://127.0.0.1:8000}")
    private String targetDomainSmp26;

    @Value("${target.domain.smp27:http://127.0.0.1:8000}")
    private String targetDomainSmp27;

    @Value("${target.domain.smp28:http://127.0.0.1:8000}")
    private String targetDomainSmp28;

    @Value("${target.domain.smp29:http://127.0.0.1:8000}")
    private String targetDomainSmp29;

    @Value("${target.domain.smp30:http://127.0.0.1:8000}")
    private String targetDomainSmp30;


    @Bean
    HttpClient httpClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, acceptingTrustStrategy).build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        return HttpClientBuilder.create()
							    .setMaxConnTotal(maxConnTotal) // 최대 오픈되는 커넥션 수
 							    .setMaxConnPerRoute(ConstantsUtil.HttpClient.MAX_CONN_PER_ROUTE) // IP, 포트 1쌍에 대해 수행할 커넥션 수
							    .setConnectionTimeToLive(connectionTimeToLive, TimeUnit.SECONDS) // keep - alive
								.setSSLSocketFactory(csf).build();
    }

    @Bean
    HttpComponentsClientHttpRequestFactory factory(HttpClient httpClient) {
    	HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    	httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(1* ConstantsUtil.HttpClient.CONNECT_TIMEOUT);
    	httpComponentsClientHttpRequestFactory.setConnectTimeout(1000 * ConstantsUtil.HttpClient.CONNECT_TIMEOUT);
    	httpComponentsClientHttpRequestFactory.setReadTimeout(1000 * ConstantsUtil.HttpClient.READ_TIMEOUT);
        return httpComponentsClientHttpRequestFactory;
    }

    protected RestTemplateBuilder restTemplateBasicConfigurer(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory){
        return restTemplateBuilder
                .additionalMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8), new MappingJackson2HttpMessageConverter())
                .setConnectTimeout(Duration.ofSeconds(ConstantsUtil.HttpClient.CONNECT_TIMEOUT))
                .setReadTimeout(Duration.ofSeconds(connectionTimeToLive))
                .interceptors(new HttpClientInterceptor())
                .errorHandler(new RestTemplateResponseErrorHandler())
                .customizers(restTemplate -> restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(factory)));
    }

    @Bean("smp0RestTemplate")
    RestTemplate smp0RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp0), factory).build();
    }

    @Bean("smp1RestTemplate")
    RestTemplate smp1RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp1), factory).build();
    }

    @Bean("smp2RestTemplate")
    RestTemplate smp2RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp2), factory).build();
    }

    @Bean("smp3RestTemplate")
    RestTemplate smp3RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp3), factory).build();
    }

    @Bean("smp4RestTemplate")
    RestTemplate smp4RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp4), factory).build();
    }

    @Bean("smp5RestTemplate")
    RestTemplate smp5RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp5), factory).build();
    }

    @Bean("smp6RestTemplate")
    RestTemplate smp6RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp6), factory).build();
    }

    @Bean("smp7RestTemplate")
    RestTemplate smp7RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp7), factory).build();
    }

    @Bean("smp8RestTemplate")
    RestTemplate smp8RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp8), factory).build();
    }

    @Bean("smp9RestTemplate")
    RestTemplate smp9RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp9), factory).build();
    }

    @Bean("smp10RestTemplate")
    RestTemplate smp10RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp10), factory).build();
    }

    @Bean("smp11RestTemplate")
    RestTemplate smp11RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp11), factory).build();
    }

    @Bean("smp12RestTemplate")
    RestTemplate smp12RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp12), factory).build();
    }

    @Bean("smp13RestTemplate")
    RestTemplate smp13RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp13), factory).build();
    }

    @Bean("smp14RestTemplate")
    RestTemplate smp14RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp14), factory).build();
    }

    @Bean("smp15RestTemplate")
    RestTemplate smp15RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp15), factory).build();
    }

    @Bean("smp16RestTemplate")
    RestTemplate smp16RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp16), factory).build();
    }

    @Bean("smp17RestTemplate")
    RestTemplate smp17RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp17), factory).build();
    }

    @Bean("smp18RestTemplate")
    RestTemplate smp18RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp18), factory).build();
    }

    @Bean("smp19RestTemplate")
    RestTemplate smp19RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp19), factory).build();
    }

    @Bean("smp20RestTemplate")
    RestTemplate smp20RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp20), factory).build();
    }

    @Bean("smp21RestTemplate")
    RestTemplate smp21RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp21), factory).build();
    }

    @Bean("smp22RestTemplate")
    RestTemplate smp22RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp22), factory).build();
    }

    @Bean("smp23RestTemplate")
    RestTemplate smp23RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp23), factory).build();
    }

    @Bean("smp24RestTemplate")
    RestTemplate smp24RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp24), factory).build();
    }

    @Bean("smp25RestTemplate")
    RestTemplate smp25RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp25), factory).build();
    }

    @Bean("smp26RestTemplate")
    RestTemplate smp26RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp26), factory).build();
    }

    @Bean("smp27RestTemplate")
    RestTemplate smp27RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp27), factory).build();
    }

    @Bean("smp28RestTemplate")
    RestTemplate smp28RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp28), factory).build();
    }

    @Bean("smp29RestTemplate")
    RestTemplate smp29RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp29), factory).build();
    }

    @Bean("smp30RestTemplate")
    RestTemplate smp30RestTemplate(RestTemplateBuilder restTemplateBuilder, HttpComponentsClientHttpRequestFactory factory) {
        return restTemplateBasicConfigurer(restTemplateBuilder.rootUri(targetDomainSmp30), factory).build();
    }


}
