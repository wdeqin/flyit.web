package com.github.wdeqin.flyit.web.experiment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wdeqin.flyit.data.dao.CityMapper;
import com.github.wdeqin.flyit.data.model.City;

public class CityBean implements RmiHandler {
	private Logger logger;
	private CityMapper cityMapper;

	public CityBean() {
		logger = LogManager.getLogger("com.flyit.web");
	}

	public void setCityMapper(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	@Transactional("transactionManager")
	public String handle(RmiPack pack) {
		try {
			logger.debug(pack);
			Integer id = (Integer) pack.getInput().get("id");
			City c = cityMapper.selectByPrimaryKey(id);
			ObjectMapper om = new ObjectMapper();
			return om.writeValueAsString(c);
		} catch (JsonProcessingException e) {
			logger.error(e);
			return e.toString();
		} catch (Exception e) {
			logger.error(e);
			return e.toString();
		}
	}
}
