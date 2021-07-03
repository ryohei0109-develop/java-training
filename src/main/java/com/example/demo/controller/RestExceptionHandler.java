package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// コントローラーを横断した集約例外ハンドラ
// ※ただし、コントローラー内に個別に集約例外ハンドラが存在する場合は、
// そちらが優先される
@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler
	private ResponseEntity<ErrorResponse> onError(Exception ex) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.message = "API エラー2";
		errorResponse.detail = ex.getMessage();
		errorResponse.status = status.value();

		return new ResponseEntity<ErrorResponse>(errorResponse, status);
	}
}
