package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		return new TestModel("ほげ", 1234);
	}

	// 手動でJSONに変換して返す。
	@RequestMapping(value = "hoge2", produces = MediaType.APPLICATION_JSON_VALUE)
	public String string() throws Exception {
		String json = "";
		try {
			TestModel bean = new TestModel("もげ", 297);
			json = new ObjectMapper().writeValueAsString(bean);
		} catch (Exception e) {
			System.out.println(e);
		}

		return json;
	}

	// Mapで返すことも可能。
	@RequestMapping("hoge3")
	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<>();
		map.put("hoge", "ぴよ");
		map.put("age", 999);
		return map;
	}

	// エラー発生用エンドポイント
	@RequestMapping("error")
	public String testException() throws Exception {
		throw new RuntimeException("エラー発生");
	}

	// 集約例外ハンドラ
	// WebApiControllerのエラーを集約
	@ExceptionHandler
	private ResponseEntity<ErrorResponse> onError(Exception ex) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.message = "API エラー";
		errorResponse.detail = ex.getMessage();
		errorResponse.status = status.value();
		
		return new ResponseEntity<ErrorResponse>(errorResponse, status);
	}
}
