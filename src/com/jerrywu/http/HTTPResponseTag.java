package com.jerrywu.http;

public class HTTPResponseTag {
	
	public HTTPResponseTag(String sourceAddress, String setCookies,int httpCode, String response) {
		super();
		this.sourceAddress = sourceAddress;
		this.setCookies = setCookies;
		this.httpCode = httpCode;
		this.response = response;
	}
	
	//來源網址
	private String sourceAddress;
		
	//回傳 set-cookies
	private String setCookies;
	
	//查詢的 httpCode
	private int httpCode;
	
	//查詢的結果
	private String response;
	
	//取得來源網址
	public String getSourceAddress()
	{
		return sourceAddress;
	}
	
	//取得setCookies
	public String getCookies()
	{
		return setCookies;
	}
	
	//取得查詢是否成功
	public int getHttpCode()
	{
		return httpCode;
	}
	
	//取得查詢的結果
	public String getResponse()
	{
		return response;
	}
	
	
	
}
