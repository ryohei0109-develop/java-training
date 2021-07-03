package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * テンプレートファイルからの文字列生成処理
	 * @return
	 */
	@Primary
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
	
	/**
	 * 文字列からの文字列生成処理
	 * @return
	 */
    @Bean("stringTemplateEngine")
    public SpringTemplateEngine stringTemplateEngine() {
     
     var resolver = new StringTemplateResolver();
     resolver.setTemplateMode( TemplateMode.TEXT );
     
        var engine = new SpringTemplateEngine();
        engine.setTemplateResolver( resolver );
  
        return engine;     
    }
}
