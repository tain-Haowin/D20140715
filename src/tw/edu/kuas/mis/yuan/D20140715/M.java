package tw.edu.kuas.mis.yuan.D20140715;
import com.jerrywu.http.HTTPConnection;
import com.jerrywu.http.HTTPMethod;
import com.jerrywu.http.HTTPRequestTag;
import com.jerrywu.http.HTTPResponseTag;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
public class M {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//------------------------------�n�J
    
	HTTPConnection con=new HTTPConnection();
	HTTPRequestTag request=new HTTPRequestTag("http://140.127.113.227/kuas/perchk.jsp",HTTPMethod.POST);
	request.pushAttributes("uid","1101137131");
	request.pushAttributes("pwd","8602");
	HTTPResponseTag response = con.getResult(request, "UTF-8");  
	//System.out.println(response.getResponse());
	//--------------------------------
	//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO�^���ӤH���
	/*
	HTTPRequestTag requestt=new HTTPRequestTag("http://140.127.113.227/kuas/ag_pro/ag007_rpt.jsp",HTTPMethod.POST);
	requestt.setCookies(response.getCookies());
	requestt.pushAttributes("year","102");
	requestt.pushAttributes("sms","2");
	requestt.pushAttributes("std_id","1101137235");
	HTTPResponseTag responset = con.getResult(requestt, "UTF-8");  
	System.out.println(responset.getResponse());
	*/
	//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	
	/*	
	HTTPRequestTag requestData=new HTTPRequestTag("http://140.127.113.227/kuas/ag_pro/ag003.jsp",HTTPMethod.POST);

		requestData.setCookies(response.getCookies());
		HTTPResponseTag responseStudentData = con.getResult(requestData, "UTF-8");  
		//System.out.println(responseStudentData.getResponse());
		
		String temp = responseStudentData.getResponse();
		//System.out.println(temp);
		//String[] names = SplitString.split("�Ǩ�");
		System.out.println(temp.split("�ǡ@�@��G")[1]);
		temp = temp.split("�ǡ@�@��G")[1];
		System.out.println("��t�G"+temp.split("</td><td>��@�@�t")[0]);
		*/
		/*HTTPRequestTag requestGrade=new HTTPRequestTag("http://140.127.113.227/kuas/ag_pro/ag008.jsp",HTTPMethod.POST);
		requestGrade.setCookies("JSESSIONID=AAAAAxlQ=GZC4frABCYEpg");
		requestGrade.pushAttributes("yms","102,1");
		requestGrade.pushAttributes("arg02","1");
		requestGrade.pushAttributes("arg01","102");
		HTTPResponseTag responseGrade = con.getResult(requestGrade, "UTF-8");  
		String Grade =responseGrade.getResponse();
		System.out.println(Grade+"<br/>");
		String Class=responseGrade.getResponse();
		//Class = Class.split("�Z�šG")[1];
		Class=Class.split("�@�@�@�@�Ǹ�")[0];
		System.out.println("�Z�šG"+Class+"�@�@�@�@�@�@");*/
	//---------------------------------------------------H
	/*�����^������HTML X
	HTTPRequestTag requestk=new HTTPRequestTag("http://122.146.229.210/xmlbus2/GetEstimateTime.xml?routeIds=0%E5%8C%97,1",HTTPMethod.POST);
	requestk.setCookies(response.getCookies());
	HTTPResponseTag responsek = con.getResult(requestk, "UTF-8");  
	
	try{
		JSONObject jo =XML.toJSONObject(responsek.getResponse());//�ϥ�JSONObject�M��NXML����JSONObject��
		//System.out.print(jo.toString());
		JSONObject busdyninfo = jo.getJSONObject("BusDynInfo");
		JSONObject businfo=busdyninfo.getJSONObject("BusInfo");
		JSONObject EstimateTime=businfo.getJSONObject("Route");
		JSONArray Array = EstimateTime.getJSONArray("EstimateTime");
		System.out.println(Array.toString());
		for(int i=0;i<Array.length();i++){
		JSONObject temp = Array.getJSONObject(i);
		System.out.println(temp.getString("StopName"));
		}
	}catch(JSONException e){}
	//System.out.println(responsek.getResponse()+"<br/>");
	*/
	//---------------------------------------------------E
	//---------------------------------------------------H0717�@�~1
	
	HTTPRequestTag requesteat=new HTTPRequestTag("http://khh.travel/foodxml.aspx?type=1",HTTPMethod.POST);
	requesteat.setCookies(response.getCookies());
	HTTPResponseTag responseeat = con.getResult(requesteat, "UTF-8");
	//System.out.println(responseeat.getResponse()+"<br/>"); //��lXML�ɮ榡
	try{
		JSONObject jo =XML.toJSONObject(responseeat.getResponse());
		System.out.println(jo.toString()+"<br/>");
		JSONObject infos = jo.getJSONObject("Infos");
		JSONArray Arrayeat=infos.getJSONArray("Info");
		//System.out.println(Arrayeat.toString());
		for(int i=0;i<Arrayeat.length();i++){
			JSONObject tempeat = Arrayeat.getJSONObject(i);
			System.out.print("���W:");
			System.out.println(tempeat.getString("Name"));
			System.out.print("�@�@����:");
			System.out.println(tempeat.getString("Description"));
			System.out.print("�@�@�q��:");
			System.out.println(tempeat.getString("Tel"));
			System.out.print("�@�@�a�}:");
			System.out.println(tempeat.getString("Add"));
			System.out.println("");
			
			}
	}catch(JSONException e){}
	
	
	//----------------------------------------------------E 
	//----------------------------------------------------H 0717�@�~2
	/*
	HTTPRequestTag requestaa=new HTTPRequestTag("http://khh.travel/foodxml.aspx?type=1",HTTPMethod.POST);
	requesteat.setCookies(response.getCookies());
	HTTPResponseTag responseaa = con.getResult(requestaa, "UTF-8");
	//System.out.println(responseeat.getResponse()+"<br/>"); //��lXML�ɮ榡
	try{
		JSONObject jo =XML.toJSONObject(responseeat.getResponse());
		//System.out.println(jo.toString()+"<br/>");
		JSONObject infos = jo.getJSONObject("Infos");
		JSONArray Arrayeat=infos.getJSONArray("Info");
		//System.out.println(Arrayeat.toString());
		for(int i=0;i<Arrayeat.length();i++){
			JSONObject tempaa = Arrayeat.getJSONObject(i);
			System.out.print("���W:");
			System.out.println(tempeat.getString("Name"));
			System.out.print("�@�@����:");
			System.out.println(tempeat.getString("Description"));
			System.out.print("�@�@�q��:");
			System.out.println(tempeat.getString("Tel"));
			System.out.print("�@�@�a�}:");
			System.out.println(tempeat.getString("Add"));
			System.out.println("");
			
			}
	}catch(JSONException e){}*/
	//----------------------------------------------------E
	}

}
