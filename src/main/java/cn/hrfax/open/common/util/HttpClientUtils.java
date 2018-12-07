/**
 * Copyright (C) 2014-2016, hrfax and/or its affiliates. All rights reserved.
 * hrfax PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package cn.hrfax.open.common.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dante
 * @Date 2016年11月14日
 */
public class HttpClientUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	public static String doPost(String url, HttpEntity httpEntity) {

		HttpPost request = new HttpPost(url);
		request.setEntity(httpEntity);
		
		return executeInternal(request);
	}
	
	public static String executeInternal(HttpUriRequest request) {

		try (CloseableHttpClient httpclient = HttpClients.custom().build();) {
			try (CloseableHttpResponse response = httpclient.execute(request);) {
				int statusCode = response.getStatusLine().getStatusCode();
				logger.info("请求【{}】返回状态吗【{}】", request.getURI(), statusCode);
				if (HttpStatus.SC_OK == statusCode) {
					String result =  IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8.name());
					logger.info("请求【{}】返回结果:{}", request.getURI(),result);
					return result;
				}
				throw new RuntimeException(String.format("请求【%s】返回状态吗【%s】", request.getURI(), statusCode));
			}
		} catch (Exception e) {
			throw new RuntimeException(String.format("请求%s异常", request.getURI()),e);
		}
	}

	/**
	 * @param url
	 * @param params 参数
	 * @return
	 */
	public static String doPost(String url, Map<String, Object> params) {
		List<BasicNameValuePair> nvps = new ArrayList<>(params.size());
		for (String key : params.keySet()) {
			Object value = params.get(key);
			if (value != null) {
				nvps.add(new BasicNameValuePair(key, value.toString()));
			}
		}
		return doPost(url, new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));
	}
	
	public static String get(String url) {
		
		HttpGet request = new HttpGet(url);
		return executeInternal(request);
	}

	public static String post(String url, String data) {
		
		logger.info("请求[{}],数据:{}",url,data);
		
		HttpEntity httpEntity = new StringEntity(data, StandardCharsets.UTF_8);
		return doPost(url, httpEntity);
	}

	/**
	 * E分期使用
	 * @param url
	 * @param data
	 * @return
	 */
	public static String postICBC(String url, String data) {
		
		logger.info("请求[{}],数据:{}",url,data);
		
		HttpEntity httpEntity = new StringEntity(data, ContentType.APPLICATION_JSON);
		return doPost(url, httpEntity);
	}

}
