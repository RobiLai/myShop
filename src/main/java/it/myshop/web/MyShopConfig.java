package it.myshop.web;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import it.myshop.dao.CategoriaDao;
import it.myshop.dao.ClienteDao;
import it.myshop.dao.ProdottoDao;
import it.myshop.dao.impl.CategoriaDaoImpl;
import it.myshop.dao.impl.ClienteDaoImpl;
import it.myshop.dao.impl.ProdottoDaoImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "it.myshop.controller")
public class MyShopConfig {

	@Bean
	public FreeMarkerViewResolver configureResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		
		resolver.setCache(true);
		resolver.setPrefix("");
		resolver.setSuffix(".ftl");
		
		return resolver;
	}
	
	@Bean
	public FreeMarkerConfigurer configureFreeMarker() {
	
	FreeMarkerConfigurer config = new FreeMarkerConfigurer();
	
	config.setTemplateLoaderPath("/WEB-INF/view/");
	
	return config;
	
	
	}
	
	@Bean
	public DataSource getDbConnection() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		//ds.setPassword(null);//non c'è
		ds.setUrl("jdbc:mysql://127.0.0.1/corso_spring");
		
		return ds;
		
	}
	
	
	@Bean
	public ClienteDao getClienteService() {
		return new ClienteDaoImpl(getDbConnection());
	}
	
	@Bean
	public ProdottoDao getProdottoService() {
		return new ProdottoDaoImpl(getDbConnection());
	}
	
	@Bean
	public CategoriaDao getCategoriaService() {
		return new CategoriaDaoImpl(getDbConnection());
	}
	
	
}
