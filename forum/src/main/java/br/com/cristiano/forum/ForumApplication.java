package br.com.cristiano.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
//Caso queira gerar um arquivo .war é necessário fazer as alterações no pom.xml e essa classe deve herdar de SpringBootServletInitializer
//public class ForumApplication extends SpringBootServletInitializer {
public class ForumApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}
	
//	Metodo sobrescrito de SpringBootServletInitializer para gerar o .war
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(ForumApplication.class);
//	}

}
