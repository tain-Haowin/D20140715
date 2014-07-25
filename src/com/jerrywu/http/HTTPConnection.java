package com.jerrywu.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.jerrywu.log.MessageFactory;


//基礎 HTTP 連線類別
//Base HTTP Connection
public class HTTPConnection {

	//設定底層的header
	protected static void setOtherHeader(HttpURLConnection urlConn)
	{
		urlConn.setRequestProperty("Connection", "keep-alive");
		urlConn.setRequestProperty("Cache-Control", "max-age=0");
		urlConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		urlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_3) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
		//urlConn.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
		urlConn.setRequestProperty("Accept-Language", "zh-TW,zh;q=0.8,en-US;q=0.6,en;q=0.4");
		urlConn.setRequestProperty("Accept-Charset","Big5,utf-8;q=0.7,*;q=0.3");
	}
		
	//取得伺服器回傳原始資訊
	public static InputStream getInputStream(HTTPRequestTag requestTag,String urlEncode)
	{
		try{
			
			//設定目標網址
			URL url = null;
			
			if(requestTag.getHttpMethod() == HTTPMethod.GET)
			{//用GET方法來傳送參數
				String targetAddress = "";
				if(requestTag.getAttributes() != null && requestTag.getAttributes().length() > 0)
				{
					targetAddress = String.format("%s?%s", requestTag.getTargetAddress(),requestTag.getAttributes());
				}
				else
				{
					targetAddress = requestTag.getTargetAddress();
				}
				url = new URL(targetAddress);
			}
			else
			{//用其他方法來傳遞參數
				String targetAddress = requestTag.getTargetAddress();
				url = new URL(targetAddress);
			}
			
			//建立urlConnection
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			
			//設定httpMethod
			urlConn.setRequestMethod(requestTag.getHttpMethod().toString());

			//設定其他的Header
			setOtherHeader(urlConn);

			//設定Cookies
			if(requestTag.getCookies() != null)
			{
				urlConn.setRequestProperty("Cookie", requestTag.getCookies());
			}
			
			urlConn.setDoOutput(true);
			
			//設定POST 的 Body
			if( requestTag.getHttpMethod() == HTTPMethod.POST||requestTag.getHttpMethod()==HTTPMethod.DELETE||requestTag.getHttpMethod()==HTTPMethod.PUT)
			{
			  OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
			  writer.write(requestTag.getAttributes());
			  writer.close();			
			}
			
						
			//取得Server回傳的setCookies
			String setCookies = requestTag.getCookies();
			for(int i=1;urlConn.getHeaderField(i)!=null;i++)
			{
				if(urlConn.getHeaderFieldKey(i).equals("set-cookie") || urlConn.getHeaderFieldKey(i).equals("Set-Cookie") )
				{	
					
					String[] arrayData = urlConn.getHeaderField(i).replace(" ", "").split(";");
					
					for(String temp : arrayData)
					{
						if(!temp.contains("path="))
						{
							if(setCookies != null)
							{
								setCookies = String.format("%s; %s", setCookies,temp);
							}
							else
							{
								setCookies = temp;
							}
						}
						
					}
				}
			}
			
			//回傳伺服器的資訊
			return urlConn.getInputStream();
			        	
		}catch(Exception e)
		{
			MessageFactory.error().print(e.toString());
		}
		return null;
	}
	
	//取得responseTag
	public static HTTPResponseTag getResult(HTTPRequestTag requestTag,String urlEncode)
	{
		try{
			
			//設定目標網址
			URL url = null;
			if(requestTag.getHttpMethod() == HTTPMethod.GET){
				String targetAddress = "";
				if(requestTag.getAttributes() != null && requestTag.getAttributes().length() > 0)
				{
					targetAddress = String.format("%s?%s", requestTag.getTargetAddress(),requestTag.getAttributes());
				}
				else
				{
					targetAddress = requestTag.getTargetAddress();
				}
				url = new URL(targetAddress);
			}
			else
			{
				String targetAddress = requestTag.getTargetAddress();
				url = new URL(targetAddress);
			}
			
			//建立urlConnection
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			
			//設定httpMethod
			urlConn.setRequestMethod(requestTag.getHttpMethod().toString());
			
			//設定其他的Header
			setOtherHeader(urlConn);
			
			//設定Cookies
			if(requestTag.getCookies() != null)
			{
				urlConn.setRequestProperty("Cookie", requestTag.getCookies());
			}
			
			
			
			
			urlConn.setDoOutput(true);
			
			//設定POST 的 Body
			if( requestTag.getHttpMethod() == HTTPMethod.POST||requestTag.getHttpMethod()==HTTPMethod.DELETE||requestTag.getHttpMethod()==HTTPMethod.PUT){
			  OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
			  writer.write(requestTag.getAttributes());
			  writer.close();			
			}
			
			//本次查詢的狀態
			int httpCode = urlConn.getResponseCode();
			
			//伺服器回傳的setCookies
			String setCookies = requestTag.getCookies();
			for(int i=1;urlConn.getHeaderField(i)!=null;i++){
				
				if(urlConn.getHeaderFieldKey(i).equals("set-cookie") || urlConn.getHeaderFieldKey(i).equals("Set-Cookie") ){	

					String[] arrayData = urlConn.getHeaderField(i).replace(" ", "").split(";");
			

					if(setCookies != null)
					{
						setCookies = String.format("%s; %s", setCookies,arrayData[0]);
					}
					else
					{
						setCookies = arrayData[0];
					}					
				}
			}
			
			
			
			
			
			
			
			//查詢的結果
			StringBuilder sbLines = new StringBuilder("");
           	BufferedReader reader = new BufferedReader(
        			new InputStreamReader(urlConn.getInputStream(),urlEncode)
        	);


        	String lines = "";
        	while ((lines=reader.readLine()) != null){
        		sbLines.append(lines);
        	}

        	
        	HTTPResponseTag response = new HTTPResponseTag(null,setCookies,httpCode,sbLines.toString());
			
        	return response;
        	
		}catch(Exception e){
			HTTPResponseTag response = new HTTPResponseTag(null,"",999,e.toString());
        	return response;
		}

	}
}
