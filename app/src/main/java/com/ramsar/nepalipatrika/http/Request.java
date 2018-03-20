package com.ramsar.nepalipatrika.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aayushsubedi on 8/8/17.
 */

public class Request {
	private List<String> path;
	private String endpoint;
	private HttpRequestType type;
	
	private Map<String, String> headers;
	private Map<String, String> data;
	
	private Request(){
		path = new ArrayList<>();
		headers = new HashMap<>();
		data = new HashMap<>();
		
		endpoint = "";
		type = HttpRequestType.GET;
	}
	
	private long dispatched;
	
	private void setData(Map<String, String> data) {
		this.data = data;
	}
	
	private void addHeader(String header, String value) {
		headers.put(header, value);
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}
	
	public Map<String, String> getData() {
		return data;
	}
	
	private void setType(HttpRequestType type) {
		this.type = type;
	}
	
	public long getDispatchedTime() {
		return dispatched;
	}
	
	protected void setDispatchedTime(long dispatched) {
		this.dispatched = dispatched;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public List<String> getPath() {
		return path;
	}
	
	public void setPath(List<String> path) {
		this.path = path;
	}
	
	public HttpRequestType getType() {
		return type;
	}
	
	private void addPathSegment(String pathSegment) {
		this.path.add(pathSegment);
	}
	
	
	
	public static class RequestBuilder {
		Request request;
		public RequestBuilder(){
			request = new Request();
		}
		public RequestBuilder addHeader(String header, String value) {
			request.addHeader(header, value);
			return this;
		}
		
		public RequestBuilder setData(Map<String, String> data) {
			request.setData(data);
			return this;
		}
		
		public RequestBuilder addDataPath(String key, String value) {
			request.addDataPath(key, value);
			return this;
		}
		
		public RequestBuilder setType(HttpRequestType type) {
			request.setType(type);
			return this;
		}
		
		public RequestBuilder setEndpoint(String endpoint){
			request.setEndpoint(endpoint);
			return this;
		}
		
		public RequestBuilder addPath(String pathSegment){
			request.addPathSegment(pathSegment);
			return this;
		}
		
		public Request build() {
			return request;
		}
	}
	
	private void addDataPath(String key, String value) {
		data.put(key, value);
	}
	
}
