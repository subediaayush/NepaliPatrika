package com.ramsar.nepalipatrika.http;

/**
 * Created by aayushsubedi on 8/8/17.
 */

public class Response {
	private Request request;
	private String message;
	private int code;
	private boolean parsadi;
	private String data;
	
	private long received;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public boolean isParsadi() {
		return parsadi;
	}
	
	public void setParsadi(boolean parsadi) {
		this.parsadi = parsadi;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public Request getRequest() {
		return request;
	}
	
	public void setRequest(Request request) {
		this.request = request;
	}
	
	public long getReceivedTime() {
		return received;
	}
	
	protected void setReceivedTime(long received) {
		this.received = received;
	}
}
