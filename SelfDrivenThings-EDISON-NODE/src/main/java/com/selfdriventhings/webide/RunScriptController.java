package com.selfdriventhings.webide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/EdisonWebIDE/*")
public class RunScriptController {

	@RequestMapping(value="Run", method=RequestMethod.POST)
	public @ResponseBody String withEntity(@RequestParam("scriptTextArea") String pScript) {
		String result="";
		try {
			result=NodeJSControl(pScript);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	private String NodeJSControl(String psText) throws Exception {
		String result="";
		try{
			fileMake("temp.js", psText);
			List<String> cmdList = new ArrayList<String>();
			cmdList.add("C:\\Program Files\\nodejs\\node.exe");		
			cmdList.add("E:\\stsworkspace\\SelfDrivenThings-EDISON-NODE\\temp.js");		
			
			ProcessBuilder pb=new ProcessBuilder(cmdList);
			pb.directory(new File("C:\\Program Files\\nodejs\\"));
			Process pr = pb.start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			
			String currLine = null;
			try {
			    while((currLine = br.readLine()) != null) {
			        System.out.println(currLine);
			        result+=currLine+"\r\n";
			    }
			} catch (IOException e) {
			    System.out.println("Couldn't read the output.");
			    e.printStackTrace();
			}
			pr.waitFor();
			pr.destroy();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new Exception(ex);
		}
		return result;
	}
	//������ �����ϴ� �޼ҵ�
	 public void fileMake(String makeFileName,String psText) {
		 try
	        {
	            FileWriter fw = new FileWriter("E:\\stsworkspace\\SelfDrivenThings-EDISON-NODE\\"+makeFileName); // �����ּ� ��� ����
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(psText);
	            bw.newLine(); // �ٹٲ�
	            bw.close();
	        }
	        catch (IOException e)
	        {
	            System.err.println(e); // ������ �ִٸ� �޽��� ���
	            System.exit(1);
	        }
	 }
	 public static void main(String args[])
	 {
		 RunScriptController test=new RunScriptController();
		 try {
			 System.out.println("start");
			test.NodeJSControl("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
