package device.itself.test;

import device.itself.util.AnnotationReflectionUtil;
import device.itself.util.RestClient;

public class ReflectionHelperTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationTest test=new AnnotationTest();

		
		//System.out.println(AnnotationReflectionUtil.getAnnotationType(test));
		//System.out.println(AnnotationReflectionUtil.getAnnotationFields(test));
		//test.Test();
		//System.out.println(AnnotationReflectionUtil.getAnnotationJSON(test));
		RestClient.postForObject(AnnotationReflectionUtil.getSearchEngineAddress(test), AnnotationReflectionUtil.getAnnotationJSON(test));
		
		
	}

}
