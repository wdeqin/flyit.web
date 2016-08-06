package com.github.wdeqin.flyit.web.experiment;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

@Controller
public class RmiController {

	@Autowired
	private ApplicationContext applicationContext;

	private static Logger logger;
	private static ObjectReader reader;

	public RmiController() {
		logger = LogManager.getLogger("com.flyit.web");
		reader = new ObjectMapper().readerFor(RmiPack.class);
	}

	@RequestMapping(value = "/rmi.do", method = RequestMethod.POST)
	@ResponseBody
	public String rmi(@RequestParam(value = "rmi_pack", required = true) String rmiPack) {

		RmiPack pack;
		RmiHandler handler;
		try {
			pack = reader.readValue(rmiPack);
			handler = (RmiHandler) applicationContext.getBean(pack.getProcessCode());
		} catch (IOException e) {
			logger.error(e);
			return "parse rmi pack error";
		} catch (NoSuchBeanDefinitionException e) {
			logger.error(e);
			return "process code unavailable";
		}

		return handler.handle(pack);
	}

}
