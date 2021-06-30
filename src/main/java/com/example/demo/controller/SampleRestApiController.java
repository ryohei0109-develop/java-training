package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API のサンプルコントローラ.
 * 
 * <p>
 * {@code application.properties#server.port = 8080} と設定していると仮定して、
 * {@code "localhost:8080/sample/api/test/*"} にアクセスする。
 * </p>
 */
@RestController
@RequestMapping("/sample/api")
public class SampleRestApiController {
    private static final Logger log = LoggerFactory.getLogger( SampleRestApiController.class );

	@RequestMapping("hello")
	private String hello() {
		return "SpringBoot!";
	}
	
    /*
     * エンドポイント: /sample/api/test/xxxx/
     */
    @RequestMapping("/test/{param}")
    private String testPathVariable( @PathVariable String param ) {
        log.info( param );
        return "受け取ったパラメータ：" + param;
    }

    /*
     * エンドポイント: /sample/api/test?param=xxxx
     */
    @RequestMapping("/test")
    private String testRequestParam( @RequestParam String param ) {
        log.info( param );
        return "受け取ったパラメータ：" + param;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    private String testRequestBody( @RequestBody String body ) {
        log.info( body );
        return "受け取ったリクエストボディ：" + body;
    }
}
