package com.github.wdeqin.flyit.web.expriment;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.wdeqin.flyit.data.FlyitSqlSessionFactory;
import com.github.wdeqin.flyit.data.dao.CityMapper;
import com.github.wdeqin.flyit.data.model.City;

@Controller
public class HelloWorldController {

	private static Logger logger;
	private static SqlSessionFactory factory;

	public HelloWorldController() {
		logger = LogManager.getLogger("com.flyit.web");
		factory = FlyitSqlSessionFactory.getFactory();
	}

	@RequestMapping("/city")
	public String hello(@RequestParam(value = "id", required = true) int id, Model model) {
		SqlSession session = factory.openSession();
		CityMapper cityMapper = session.getMapper(CityMapper.class);
		
		City city = cityMapper.selectByPrimaryKey(id);
		
		if (city == null) {
			logger.error("no city for id: " + id);
		}

		model.addAttribute("id", city.getId());
		model.addAttribute("name", city.getName());
		model.addAttribute("district", city.getDistrict());
		model.addAttribute("countryCode", city.getCountrycode());
		model.addAttribute("population", city.getPopulation());
		

		return "city";

	}

	@RequestMapping("/getString")
	@ResponseBody
	public String getString() {
		return "String";
	}

}
