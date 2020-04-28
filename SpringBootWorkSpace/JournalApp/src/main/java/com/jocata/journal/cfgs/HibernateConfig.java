package com.jocata.journal.cfgs;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()	{
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setPackagesToScan("com.jocata.journal.entity");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.put("hibernate.show_sql", true);
		hibernateProperties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		hibernateProperties.put("hibernate.connection.username", "root");
		hibernateProperties.put("hibernate.connection.password", "root123");
		hibernateProperties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/journal_app");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		// connection pooling properties
		hibernateProperties.put("hibernate.connection.provider_class", "com.zaxxer.hikari.hibernate.HikariConnectionProvider");
		hibernateProperties.put("hibernate.hikari.connectionTimeout", "10000");
		hibernateProperties.put("hibernate.hikari.minimumIdle", "20");
		hibernateProperties.put("hibernate.hikari.maximumPoolSize", "300");
		hibernateProperties.put("hibernate.hikari.idleTimeout", "200000");
		// connection pooling properties
		
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getTxnManager()	{
		HibernateTransactionManager txnManager = new HibernateTransactionManager();
		txnManager.setSessionFactory(getSessionFactory().getObject());
		return txnManager; 
	}
}
