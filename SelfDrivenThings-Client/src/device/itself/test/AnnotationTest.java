package device.itself.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import net.sf.json.JSONObject;

import device.itself.Delegator;
import device.itself.annotaion.ContextField;
import device.itself.annotaion.ContextMethod;
import device.itself.annotaion.ContextType;
import device.itself.annotaion.ContextParam;
import device.itself.annotaion.SearchEngine;
import device.itself.annotaion.SearchLanguage;



@ContextType(Key="camerakh")
public class AnnotationTest {
	
	public @ContextField(Key="SensorField1")  String SensorValue1="Test Value 1";
	public @ContextField(Key="SensorField2")  String SensorValue2="Test Value 2";
	public @SearchEngine()  String SearchEngine="http://localhost:8080/SelfDrivenThings-Server/simple";
	public @SearchLanguage()  String SearchLanguage="javascript";
	
	@ContextMethod(Key="SensorMethod")
	String Test(@ContextParam(Key="localVariable") String testParam)
	{
		@ContextField(Key="localVariable")
		String Sensor=testParam;
		SensorValue1="After Value";
		return Sensor;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationTest test=new AnnotationTest();
		String testValue="abc";
		if(testValue.equals("a"))
			System.out.println("a");
		else if(testValue.equals("b"))
			System.out.println("b");
		else
			Delegator.DoItSelfGet(test);
		
		try {
			throw new Exception();
		}catch(Exception e)
		{
			e.printStackTrace();
			Delegator.DoItSelfGet(test);
		}

	}
	
}
