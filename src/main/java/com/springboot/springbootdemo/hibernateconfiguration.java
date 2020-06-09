package com.springboot.springbootdemo;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.springboot.hibernate.Country;
import com.springboot.hibernate.Employee;

@Configuration
@PropertySource("classpath:application.properties")
//@ComponentScan("com.springboot.hibernate")
public class hibernateconfiguration 
{
	
	@Autowired
	Environment env;
	
	public DataSource getDatasource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()  
	{
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDatasource());
		//factoryBean.setAnnotatedClasses(Employee.class,Country.class);
		factoryBean.setPackagesToScan("com.springboot.hibernate");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
       // hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        factoryBean.setHibernateProperties(hibernateProperties);
		return factoryBean;
	}
}
