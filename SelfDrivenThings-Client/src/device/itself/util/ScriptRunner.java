package device.itself.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

public class ScriptRunner {
	private static final Logger LOGGER = LogManager.getRootLogger();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String script="function main(name) { println('Hello, ' + name); }";
		String script2="println('Hello, ' + name);";
		String psEngine="javascript";
		Map<String, String> psParameters=new HashMap<String, String>();
		psParameters.put("name", "kimhoon");
		runScript(script,psEngine);
		runScript(script2,psParameters,psEngine);
	}
	public static void runScript(JSONObject psJsonObject)
	{
		String scriptEngine=psJsonObject.getString("Engine");
		String script=psJsonObject.getString("Script");
		ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName(scriptEngine);
        try {
        	LOGGER.debug("[DIY] Start code.");
			engine.eval(script);
			Invocable inv = (Invocable) engine;
			inv.invokeFunction("main");
			LOGGER.debug("[DIY] end code.");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void runScript(String psScript, String psEngine)
	{
		ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName(psEngine);
        // evaluate JavaScript code from String
        try {
        	LOGGER.debug("[DIY] Start code.");
			engine.eval(psScript);
			Invocable inv = (Invocable) engine;
			inv.invokeFunction("main");
			LOGGER.debug("[DIY] end code.");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void runScript(String psScript,Map<String, String> psParameters, String psEngine)
	{
		ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName(psEngine);
        //Set Parameters
        if(psParameters != null)
        {
        	 Set<String> keyList=psParameters.keySet();
        	for(String keyName:keyList)
        	{
        		engine.put(keyName, psParameters.get(keyName));
        		LOGGER.debug("Key:"+keyName+", Value:"+psParameters.get(keyName));
        	}
        }
        // evaluate JavaScript code from String
        try {
        	LOGGER.debug("[DIY] Start code.");
			engine.eval(psScript);
//			Invocable inv = (Invocable) engine;
//			inv.invokeFunction("main");
			LOGGER.debug("[DIY] end code.");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	

}
