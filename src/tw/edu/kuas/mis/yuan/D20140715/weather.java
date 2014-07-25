package tw.edu.kuas.mis.yuan.D20140715;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

public class weather {
	public static void main(String args[])
	{
		HTTPConnection conw=new HTTPConnection();
		HTTPRequestTag requestw=new HTTPRequestTag("http://typhoon.ws/lifeinfo/stop_working",HTTPMethod.GET);
		requestw.pushAttributes("access_token","CAACEdEose0cBAGcOngH4FUoRwupEYeUbPaFklxReISDG2c5RPLHmwxVCk5uc6WtrbwmjWJqZAbVafi1B4e4TxbMMXvtsPGZC7ranB9YExSvWatk5PorPrKYvjZCddfGm9eYw7qeefBEDsx1MvUL5yUkbEzS9CHPaPYjFz7kOZBi5wQyrcmhJJp7ChZBz8adDiSL6nvGLq484KDDGeKMr6");
		HTTPResponseTag responsew = conw.getResult(requestw, "UTF-8");  
			String temp = responsew.getResponse();
			String city="°ª¶¯";
			temp=temp.split(String.format("</td>	</tr>	<tr>		<td>%s",city))[1];
			String ct,day,a,b;
			System.out.println(temp);
			ct=temp.substring(0,1);
			day=temp.substring(12,14);
			a=temp.substring(39,43);
			b=temp.substring(76,80);
			System.out.print(city);
			System.out.print(ct);
			System.out.print(day);
			System.out.print(a);
			System.out.println(b);
			
		
		
	
	}
}
