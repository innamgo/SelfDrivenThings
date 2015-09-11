package device.itself.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import device.itself.annotaion.ContextMethod;
import device.itself.annotaion.ContextParam;
import device.itself.annotaion.ContextType;
import device.itself.annotaion.ContextField;
import device.itself.annotaion.SearchEngine;
import device.itself.annotaion.SearchLanguage;

public class AnnotationReflectionUtil {

	private static final Logger LOGGER = LogManager.getRootLogger();

	private AnnotationReflectionUtil()
	{
	}
	public static Map<String, Object> getAnnotations(Object obj)
	{
		Map<String, Object> annotationMap=new HashMap<String, Object>();
		Map<String, String> annotationFieldMap=new HashMap<String, String>();
		Map<String, String> annotationMethodMap=new HashMap<String, String>();
		Annotation[] annotations = obj.getClass().getAnnotations();
		for(Annotation annotation : annotations)
		{
			if( annotation instanceof ContextType)
			{
				ContextType contextVariable=(ContextType)annotation;
				annotationMap.put(contextVariable.Key(), contextVariable.Value());
			}
			else if( annotation instanceof ContextField)
			{
				ContextField contextVariable=(ContextField)annotation;
				annotationFieldMap.put(contextVariable.Key(), contextVariable.Value());
				annotationMap.put("ContextField",annotationFieldMap);
			}
			else if( annotation instanceof ContextParam)
			{
				ContextParam contextVariable=(ContextParam)annotation;
				annotationFieldMap.put(contextVariable.Key(), contextVariable.Value());
				annotationMap.put("ContextParam",annotationFieldMap);
			}
			else if( annotation instanceof SearchEngine)
			{
				annotationMap.put("SearchEngine",getSearchEngineAddress(obj));
			}
			else if( annotation instanceof SearchLanguage)
			{
				annotationMap.put("SearchLanguage",getSearchLanguage(obj));
			}
			else if( annotation instanceof ContextMethod)
			{
				ContextMethod contextVariable=(ContextMethod)annotation;
				annotationMethodMap.put(contextVariable.Key(), contextVariable.Value());
				annotationMap.put("ContextMethod",annotationMethodMap);
			}
		}
		return annotationMap;
	}
	public static String getAnnotationType(Object obj)
	{
		String KeyValue="";
		Class<? extends Object> classObject=obj.getClass();
		if(classObject.isAnnotationPresent(ContextType.class))
		{
			Annotation annotation=classObject.getAnnotation(ContextType.class);
			ContextType contextVariable=(ContextType)annotation;
			KeyValue=contextVariable.Key()+contextVariable.Value();
		}
		
		return KeyValue;
	}
	public static Map<String, String> getAnnotationFields(Object obj)
	{
		Map<String, String> fieldMap=new HashMap<String, String>();
		Field[] fields=obj.getClass().getFields();
		try {
			for(Field lfield:fields)
			{
				lfield.setAccessible(true);
				if(lfield.isAnnotationPresent(ContextField.class))
				{
					Annotation annotation=lfield.getAnnotation(ContextField.class);
					ContextField contextVariable=(ContextField)annotation;
					LOGGER.debug("Key:"+contextVariable.Key()+", Value:"+lfield.get(obj));
					fieldMap.put(contextVariable.Key().toString(), lfield.get(obj).toString());
				}
				else if(lfield.isAnnotationPresent(SearchLanguage.class))
				{
					LOGGER.debug("Value:"+lfield.get(obj));
					fieldMap.put("SearchLanguage", lfield.get(obj).toString());
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fieldMap;
	}
	public static Map<String, String> getAnnotationMethods(Object obj)
	{
		Map<String, String> methodMap=new HashMap<String, String>();
		Method[] methods=obj.getClass().getMethods();
		try {
			for(Method lmethod:methods)
			{
				lmethod.setAccessible(true);
				if(lmethod.isAnnotationPresent(ContextMethod.class))
				{
					Annotation annotation=lmethod.getAnnotation(ContextMethod.class);
					ContextMethod contextVariable=(ContextMethod)annotation;
					LOGGER.debug("Key:"+contextVariable.Key()+", name:"+lmethod.getName());
					methodMap.put(contextVariable.Key().toString(), lmethod.getName());
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return methodMap;
	}
	public static String getSearchEngineAddress(Object obj)
	{
		String addressSearchEngine="";
		Field[] fields=obj.getClass().getFields();
		try {
			for(Field lfield:fields)
			{
				lfield.setAccessible(true);
				if(lfield.isAnnotationPresent(SearchEngine.class))
				{
					LOGGER.debug("Value:"+lfield.get(obj));
					addressSearchEngine=lfield.get(obj).toString();
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addressSearchEngine;
	}
	public static String getSearchLanguage(Object obj)
	{
		String addressSearchEngine="";
		Field[] fields=obj.getClass().getFields();
		try {
			for(Field lfield:fields)
			{
				lfield.setAccessible(true);
				if(lfield.isAnnotationPresent(SearchLanguage.class))
				{
					LOGGER.debug("Value:"+lfield.get(obj));
					addressSearchEngine=lfield.get(obj).toString();
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addressSearchEngine;
	}
	public static JSONObject getAnnotationJSON(Object obj)
	{
		JSONObject rtnObject=new JSONObject();
		rtnObject.put(getAnnotationType(obj), getAnnotationFields(obj));
		return rtnObject;
	}
}
