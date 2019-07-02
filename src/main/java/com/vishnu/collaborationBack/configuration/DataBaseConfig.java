package com.vishnu.collaborationBack.configuration;

import java.util.Properties;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;


@Configuration
public class DataBaseConfig {
	@Bean(name="dataSource")
	public DataSource getDatasource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/var");
		dataSource.setUsername("var");
		dataSource.setPassword("var");
		return dataSource;
	}
	@Bean
	public Properties getProperties()
	{
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
		
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(getDatasource());
		builder.addProperties(getProperties());
		builder.scanPackages("com.vishnu");
		return builder.buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager()
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(getSessionFactory());	
	
				return hibernateTransactionManager;
	}
}
