package com.example.demo.controller;

public class ErrorResponse {
	public String message;
	public String detail;
	public int status;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
}
