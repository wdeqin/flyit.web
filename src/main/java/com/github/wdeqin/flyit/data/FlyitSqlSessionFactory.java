package com.github.wdeqin.flyit.data;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;

public class FlyitSqlSessionFactory implements ServletContextListener {
	
	private static SqlSessionFactory factory;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
		} catch (IOException e) {
			LogManager.getRootLogger().fatal(e);
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
