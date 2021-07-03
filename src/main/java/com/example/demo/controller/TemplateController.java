package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * Tyhmeleafエンジンを使用して文字列を生成する処理を実装したクラスです。
 * 
 * @author ryohei
 *
 */
@RestController
@RequestMapping("template")
public class TemplateController {
	@Qualifier("messageTemplateEngine") 
	@Autowired()
	SpringTemplateEngine engine;

	@GetMapping("test")
	public String test() {
		LocalDateTime now = LocalDateTime.now();

		String hour = now.getHour() + "時";
		String timestamp = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(now);
		return process(hour, timestamp);
	}

	private String process(String hour, String time) {
	    var context = new Context();
	    context.setVariable( "hour", hour );
	    context.setVariable( "timestamp", time );

	    final String message = this.engine.process( "hoge", context );

	    return message;
	}
	
	@Qualifier("stringTemplateEngine")
    @Autowired
    SpringTemplateEngine string;
	
    @GetMapping("test/string/{message}") 
    public String test_string_template(@PathVariable String message) {

        final String template = "path var message＜[[${message}]]＞, by string template engine.";

        var context = new Context();
        context.setVariable( "message", message );

        return this.string.process( template, context );  
    }
}
