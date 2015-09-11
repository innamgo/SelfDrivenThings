package device.itself.util.ScriptRunnerTest;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;

import device.itself.util.ScriptRunner;

public class ScriptRunnerTest {

	@Test
	public void ScriptRun()
	{
		// TODO Auto-generated method stub
		String script="function main(name) { println('Hello, ' + name); }";
		String script2="println('Hello, ' + name);";
		String psEngine="javascript";
		Map<String, String> psParameters=new HashMap<String, String>();
		psParameters.put("name", "kimhoon");
		ScriptRunner.runScript(script,psEngine);
		ScriptRunner.runScript(script2,psParameters,psEngine);
	}
	@Test
	public void ScriptRunJSON()
	{
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Engine", "javascript");
		jsonObject.put("Script", "function main(name) { println('Hello, '); }");
		ScriptRunner.runScript(jsonObject);
	}
}
