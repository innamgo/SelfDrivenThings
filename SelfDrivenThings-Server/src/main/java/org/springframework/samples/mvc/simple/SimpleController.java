package org.springframework.samples.mvc.simple;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.selfdriventhings.dao.SDTDBCommon;

@Controller
public class SimpleController {

	@Inject
	SDTDBCommon sdtDBCommon;
	static Logger logger = Logger.getLogger(SimpleController.class);
	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		HashMap<String, Object> lhmCondition = new HashMap<String, Object>();
		logger.info("===================  ==================");
		lhmCondition.put("user_id", "innamgo");
		List llUserInfo = (List)sdtDBCommon.list("com.sdt.getUserID", lhmCondition);
		return "function main() { println('Hello, It's Test Script.' ); }"+llUserInfo.get(0).toString();
	}

}
