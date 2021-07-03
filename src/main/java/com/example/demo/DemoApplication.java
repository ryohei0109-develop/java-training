package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean("messageTemplateEngine")
	public SpringTemplateEngine messageTemplateEngine() {
		var resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode(TemplateMode.TEXT);
		resolver.setPrefix("templates/messages/"); // src/main/resources/templates/messages
		resolver.setSuffix(".message");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setCacheable(true);

		var engine = new SpringTemplateEngine();
		engine.setTemplateResolver(resolver);

		return engine;
	}
}
