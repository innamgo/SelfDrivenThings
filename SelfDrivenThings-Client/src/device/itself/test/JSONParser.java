package device.itself.test;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import device.itself.util.RestClient;
import device.itself.util.ScriptRunner;

public class JSONParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JSONParser().pase();
	}	
	public void pase()
	{
		String test=RestClient.getForString("https://api.github.com/users/innamgo/gists");
		
		org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        //JSON데이터를 넣어 JSON Object 로 만들어 준다.
        try {
        	JSONArray jsonArray = (JSONArray) jsonParser.parse(test);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			JSONObject files = (JSONObject) jsonObject.get("files");
			JSONObject file = (JSONObject) files.get("hello.js");
			String raw_url = file.get("raw_url").toString();
//			System.out.println("raw_url:"+jsonObject.toJSONString());
//			System.out.println("files:"+files.toJSONString());
//			System.out.println("file:"+file.toJSONString());
//			System.out.println("file:"+raw_url);
			String result=RestClient.getForString(raw_url);
			//System.out.println("result:"+result);
			HashMap<String,String> parameter=new HashMap<String,String>();
			parameter.put("name", "kkkkk");
			//ScriptRunner.runScript(result,"javascript");
			ScriptRunner.runScript(result,parameter,"javascript");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
