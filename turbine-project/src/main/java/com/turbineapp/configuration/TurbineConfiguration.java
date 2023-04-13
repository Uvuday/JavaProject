package com.turbineapp.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.turbineapp")
public class TurbineConfiguration {

	public TurbineConfiguration() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}

	@Bean
	public ViewResolver resolver() {
		System.out.println("Registering ViewResolver");	
		return new InternalResourceViewResolver("/",".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		System.out.println("registering localContainerEntityManagerFactoryBean");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com.turbineapp.entity");
		bean.setDataSource(dataSource());
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;
	}
	public DataSource dataSource() {
		
		System.out.println("registering datasource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/aeroplanedatabase");
		dataSource.setUsername("root");
		dataSource.setPassword("Uday@123");
		return dataSource;
		
	}
}
