package tw.edu.kuas.mis.yuan.D20140715;

import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class Facebook extends TimerTask{
	
	public static void main(String args[])
	{
		Timer timer = new Timer();
		timer.schedule(new Facebook(), 1000,1000);
	//------------------------------------S新增
	/*
	HTTPConnection con=new HTTPConnection();
	HTTPRequestTag request=new HTTPRequestTag("https://graph.facebook.com/me/feed",HTTPMethod.POST);
	request.pushAttributes("access_token","");
	request.pushAttributes("message","011");
	HTTPResponseTag response = con.getResult(request, "UTF-8");  
	System.out.print(response.getResponse());*/
	
	//------------------------------------E
	//------------------------------------S刪除
	/*
	HTTPConnection con=new HTTPConnection();
	HTTPRequestTag request=new HTTPRequestTag("https://graph.facebook.com/[ID]",HTTPMethod.DELETE);
	request.pushAttributes("access_token","");
	HTTPResponseTag response = con.getResult(request, "UTF-8");  
	System.out.print(response.getResponse());
	*/
	//-------------------------------------E
	/*try{
		
	JSONObject jo = new JSONObject(response.getResponse());
	//System.out.print(jo.toString());
	JSONArray ja =jo.getJSONArray("data");

	//JSONObject birth=jo.getJSONObject("birthday");
	for(int i=0;i<ja.length();i++)
	{
	//System.out.print(ja.getJSONObject(i).getString("neme"));
	//System.out.println(ja.getJSONObject(i).getString("id"));
	}
	
	}
	catch(JSONException e){}*//*
		HTTPConnection con=new HTTPConnection();
		HTTPRequestTag request=new HTTPRequestTag("https://graph.facebook.com/100000239385688/posts",HTTPMethod.GET);
		request.pushAttributes("access_token","CAACEdEose0cBAEiL6IfNVvsKn1YjSvGxlhjPXI6P9effhZAJLb2YyEdD7oCbOIBMLSrEJP9n9Ql0GmkIhCfoGWaxWn0cMCibZBpW0KnaRuKrDBAOSiJj6lVNKl3vuH5jZCW4vpYiWM1QXNHz0zEXskmDcqmxyehzF0HiczfZBYMdYVKnTHc03usPjtXnQfOCjRRFZBum99uHaSn1a4QtP");
		//request.pushAttributes("message","011");
		HTTPResponseTag response = con.getResult(request, "UTF-8");  
		JSONObject jo=new JSONObject(response.getResponse());
		System.out.print(jo);*/
	}

	@Override
	public void run() {
	HTTPConnection con=new HTTPConnection();//----------------------------------------------------個人塗鴉牆資料擷取
	HTTPRequestTag request=new HTTPRequestTag("https://graph.facebook.com/me/feed",HTTPMethod.GET);
	request.pushAttributes("access_token","CAACEdEose0cBAEiL6IfNVvsKn1YjSvGxlhjPXI6P9effhZAJLb2YyEdD7oCbOIBMLSrEJP9n9Ql0GmkIhCfoGWaxWn0cMCibZBpW0KnaRuKrDBAOSiJj6lVNKl3vuH5jZCW4vpYiWM1QXNHz0zEXskmDcqmxyehzF0HiczfZBYMdYVKnTHc03usPjtXnQfOCjRRFZBum99uHaSn1a4QtP");
	//request.pushAttributes("message","CC");
	HTTPResponseTag response = con.getResult(request, "UTF-8");  
	//System.out.print(response.getResponse());
	try{
		//System.out.println(response.getResponse());
		JSONObject jo = new JSONObject(response.getResponse());
		JSONArray data = jo.getJSONArray("data");
		System.out.println(data.toString());
		
	for(int i=0;i<data.length();i++)
	{
		JSONObject d0=data.getJSONObject(i);
		//System.out.println(d0);
		if(d0.getString("message").equals(String.format("%s要不要放假",d0.getString("message").substring(0,2))))
		{
			HTTPConnection conw=new HTTPConnection();//--------------------------------------天氣預報資料擷取
			HTTPRequestTag requestw=new HTTPRequestTag("http://typhoon.ws/lifeinfo/stop_working",HTTPMethod.GET);
			requestw.pushAttributes("access_token","CAACEdEose0cBAEiL6IfNVvsKn1YjSvGxlhjPXI6P9effhZAJLb2YyEdD7oCbOIBMLSrEJP9n9Ql0GmkIhCfoGWaxWn0cMCibZBpW0KnaRuKrDBAOSiJj6lVNKl3vuH5jZCW4vpYiWM1QXNHz0zEXskmDcqmxyehzF0HiczfZBYMdYVKnTHc03usPjtXnQfOCjRRFZBum99uHaSn1a4QtP");
			HTTPResponseTag responsew = conw.getResult(requestw, "UTF-8");  
			String temp = responsew.getResponse();
			//System.out.println(temp);
			//System.out.println(d0.getString("message").substring(0,2));
			temp=temp.split(String.format("</td>	</tr>	<tr>		<td>%s",d0.getString("message").substring(0,2)))[1];
			//System.out.println(temp);
			String ct,day,a,b;
			//System.out.println(temp);
			ct=temp.substring(0,1);
			day=temp.substring(12,14);
			a=temp.substring(39,43);
			b=temp.substring(76,80);
			/*System.out.print(d0.getString("message").substring(0,2));
			System.out.print(ct);
			System.out.print(day);
			System.out.print(a);
			System.out.print("、");
			System.out.print(b);
			System.out.println("。");*/
			//------------------------------S搜尋是否回過文
			/*
			HTTPConnection con3=new HTTPConnection();
			HTTPRequestTag request3=new HTTPRequestTag(String.format("https://graph.facebook.com/%s/comments",d0.getString("id")),HTTPMethod.GET);
			request3.pushAttributes("access_token","CAACEdEose0cBAEiL6IfNVvsKn1YjSvGxlhjPXI6P9effhZAJLb2YyEdD7oCbOIBMLSrEJP9n9Ql0GmkIhCfoGWaxWn0cMCibZBpW0KnaRuKrDBAOSiJj6lVNKl3vuH5jZCW4vpYiWM1QXNHz0zEXskmDcqmxyehzF0HiczfZBYMdYVKnTHc03usPjtXnQfOCjRRFZBum99uHaSn1a4QtP");
			HTTPResponseTag response3 = con3.getResult(request3, "UTF-8");
			System.out.println(response.getResponse());
			JSONObject jo3=new JSONObject(response3.getResponse());
			//JSONArray jo4=new JSONArray("data");
			System.out.println(jo3);*/
			//System.out.println(jo3.getString("message"));
			//System.out.println(d0.getString("message").substring(0,2)+ct+day+a+"、"+b+"。");
			
			/*if((jo3.getString("message").equals(d0.getString("message").substring(0,2)+ct+day+a+"、"+b+"。" ))){}
			
			else{*/
			//-----------------------------E搜尋是否回過文
			//----------------------------------S回文
			HTTPConnection con2=new HTTPConnection();
			HTTPRequestTag request2=new HTTPRequestTag(String.format("https://graph.facebook.com/%s/comments",d0.getString("id")),HTTPMethod.POST);
			request2.pushAttributes("access_token","CAACEdEose0cBAEiL6IfNVvsKn1YjSvGxlhjPXI6P9effhZAJLb2YyEdD7oCbOIBMLSrEJP9n9Ql0GmkIhCfoGWaxWn0cMCibZBpW0KnaRuKrDBAOSiJj6lVNKl3vuH5jZCW4vpYiWM1QXNHz0zEXskmDcqmxyehzF0HiczfZBYMdYVKnTHc03usPjtXnQfOCjRRFZBum99uHaSn1a4QtP");
			request2.pushAttributes("message",d0.getString("message").substring(0,2)+ct+day+a+"、"+b+"。");
			HTTPResponseTag response2 = con2.getResult(request2, "UTF-8");
			System.out.println(d0.getString("message").substring(0,2)+ct+day+a+"、"+b+"。");
			//----------------------------------E回文
			}//else結束
			
	}
		//System.out.println(d0.getString("message"));
		//System.out.println(dd.getString("id"));
	//}
	//System.out.print(data);
	}catch(JSONException e){}
		
	}
	
	
}
