package com.github.wdeqin.flyit.web.expriment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	private static final Logger logger = LogManager.getLogger("com.flyit.web");

	@RequestMapping("/hello")
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		logger.trace("hello: " + name);
		
		return "helloworld";

	}
	
	@RequestMapping("/getString")
	@ResponseBody
	public String getString() {
		return "String";
	}

}
