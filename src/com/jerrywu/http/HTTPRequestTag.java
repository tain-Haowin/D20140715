package com.jerrywu.http;

import java.net.URLEncoder;


//一個HTTP Request Tag
public class HTTPRequestTag {
	
	//目標網址
	private String targetAddress;
	
	//查詢方法
	private HTTPMethod httpMethod;
	
	//查詢相關屬性
	private StringBuilder attributes;
	
	//使用cookies
	private String cookies;
	
	//目標網址 請求方法 
	public HTTPRequestTag(String targetAddress,HTTPMethod httpMethod)
	{
		this.targetAddress = targetAddress;
		this.httpMethod = httpMethod;
		this.attributes = new StringBuilder();
	}
	
	
	//取得目標網址
	public String getTargetAddress() {
		return targetAddress;
	}

	//取得查詢方法
	public HTTPMethod getHttpMethod() {
		return httpMethod;
	}

	//取得查詢參數
	public String getAttributes() {
		return attributes.toString();
	}

	//新增查詢參數
	public void pushAttributes(String attributesName,String attributesValue,String urlEncode) {
		if(this.attributes.length()>0){
			this.attributes.append("&");
		}
		
		try{
			attributesName = URLEncoder.encode(attributesName,urlEncode);
			attributesValue = URLEncoder.encode(attributesValue,urlEncode);
			this.attributes.append(String.format("%s=%s", attributesName,attributesValue));
		}catch(Exception e){
			
		}
	}
	
	//新增查詢參數
	public void pushAttributes(String attributesName,String attributesValue) {
		pushAttributes(attributesName,attributesValue,"utf-8");	
	}

	//取得查詢Cookies
	public String getCookies() {
		return cookies;
	}

	//設定查詢Cookies
	public void setCookies(String cookies) {
		this.cookies = cookies;
	}
	
}
