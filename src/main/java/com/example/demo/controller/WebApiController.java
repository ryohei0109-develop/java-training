package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api")
public class WebApiController {

	@RequestMapping("hello")
	private String hello() {
		return "SpringBoot!";
	}
    
	// JavaBeansを返すと自動的にJSONに変換される。
    @RequestMapping("hoge")
    public TestModel hoge() {
        return new TestModel( "ほげ", 1234 );
    }
    
    // 手動でJSONに変換して返す。
    @RequestMapping(
            value = "hoge2", 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String string() throws Exception {
    	String json = "";
    	try {
            TestModel bean = new TestModel("もげ", 297);
            json = new ObjectMapper().writeValueAsString(bean);    		
    	}catch(Exception e) {
    		System.out.println(e);
    	}

        return json;
    }
}
