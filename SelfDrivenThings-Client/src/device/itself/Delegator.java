package device.itself;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;
import device.itself.util.AnnotationReflectionUtil;
import device.itself.util.RestClient;
import device.itself.util.ScriptRunner;

public class Delegator {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private Delegator()
	{
	}
	public static void DoItSelf(Object obj)
	{
		LOGGER.debug("[DIY] Request JSON data.");
		JSONObject searchResult=RestClient.postForObject(AnnotationReflectionUtil.getSearchEngineAddress(obj), AnnotationReflectionUtil.getAnnotationJSON(obj));
		
		if(searchResult != null)
		{
			LOGGER.debug("[DIY] Run received code.");
			ScriptRunner.runScript(searchResult.toString(), AnnotationReflectionUtil.getSearchLanguage(obj));
		}
		else
		{
			searchResult=new JSONObject();
			searchResult.put("Engine", "javascript");
			searchResult.put("Script", "function main(name) { println('Hello, It's Test Script.' ); }");
			ScriptRunner.runScript(searchResult);
		}
	}
	public static void DoItSelfGet(Object obj)
	{
		LOGGER.debug("[DIY] Request JSON data.");
		JSONObject searchResult=RestClient.getForObject(AnnotationReflectionUtil.getSearchEngineAddress(obj), AnnotationReflectionUtil.getAnnotationJSON(obj));
		
		if(searchResult != null)
		{
			LOGGER.debug("[DIY] Run received code.");
			ScriptRunner.runScript(searchResult.toString(), AnnotationReflectionUtil.getSearchLanguage(obj));
		}
		else
		{
			searchResult=new JSONObject();
			searchResult.put("Engine", "javascript");
			searchResult.put("Script", "function main(name) { println('Hello, It's Test Script.' ); }");
			ScriptRunner.runScript(searchResult);
		}
	}
}
