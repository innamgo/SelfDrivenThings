package device.itself.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import net.sf.json.JSONObject;


public class RestClient {

	public static JSONObject postForObject(String url, JSONObject json)
	{
		JSONObject oJSONResponse=null;
		
		DefaultHttpClient httpClient=null;
		try {
			httpClient = new DefaultHttpClient();

			httpClient.getParams().setParameter("http.socket.linger", 0);

			httpClient.getParams().setParameter("http.socket.timeout", 30000);
			

			HttpPost postRequest = new HttpPost(url);
			StringEntity input = new StringEntity(json.toString());
			

			input.setContentType("application/json");
			postRequest.setEntity(input);
 
			HttpResponse response = httpClient.execute(postRequest);
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			
			
			String output = br.readLine();
			//Convert string to jsonobject
			if(output.startsWith("{") && output.endsWith("}"))
				oJSONResponse = fromJson(output);
			httpClient.getConnectionManager().shutdown();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return oJSONResponse;
	}
	public static JSONObject getForObject(String url, JSONObject json)
	{
		JSONObject oJSONResponse=null;
		
		DefaultHttpClient httpClient=null;
		try {
			httpClient = new DefaultHttpClient();

			httpClient.getParams().setParameter("http.socket.linger", 0);

			httpClient.getParams().setParameter("http.socket.timeout", 3000);
			

			HttpGet postRequest = new HttpGet(url);
			StringEntity input = new StringEntity(json.toString());
			

			input.setContentType("application/json");
			//postRequest.setEntity(input);
 
			HttpResponse response = httpClient.execute(postRequest);
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			
			
			String output = br.readLine();
			System.out.println("output:"+output);
			//Convert string to jsonobject
			if(output.startsWith("{") && output.endsWith("}"))
				oJSONResponse = fromJson(output);
			else
			{
				oJSONResponse = fromJson(output);
			}
			httpClient.getConnectionManager().shutdown();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return oJSONResponse;
	}
	public static String getForString(String url)
	{
		String output="";
		DefaultHttpClient httpClient=null;
		try {
			httpClient = new DefaultHttpClient();

			httpClient.getParams().setParameter("http.socket.linger", 0);

			httpClient.getParams().setParameter("http.socket.timeout", 3000);
			

			HttpGet postRequest = new HttpGet(url);
			

			//postRequest.setEntity(input);
 
			HttpResponse response = httpClient.execute(postRequest);
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String temp="";
			while((temp=br.readLine()) !=null)
			{
				output+=temp;
			}
//			output = br.readLine();
//			System.out.println("output:"+output);
			//Convert string to jsonobject
			httpClient.getConnectionManager().shutdown();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return output;
	}
	
	public void postForNoReturn(String url, JSONObject json) {
		
		DefaultHttpClient httpClient=null;
		try {
			httpClient = new DefaultHttpClient();
			httpClient.getParams().setParameter("http.socket.linger", 0);
			httpClient.getParams().setParameter("http.socket.timeout", 30000);
			
			HttpPost postRequest = new HttpPost(url);
			StringEntity input = new StringEntity(json.toString());
			
			input.setContentType("application/json");
			postRequest.setEntity(input);
 
			httpClient.execute(postRequest);
			httpClient.getConnectionManager().shutdown();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static JSONObject fromJson(String json) {
		JSONObject garima=null;
		try {
			garima = JSONObject.fromObject( json ); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return garima;
		}

}
