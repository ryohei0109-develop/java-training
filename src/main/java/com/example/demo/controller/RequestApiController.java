package com.example.demo.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/request")
public class RequestApiController {
	private final RestTemplate rest = new RestTemplate();

	/**
	 * SpringBootからAPIへのGetアクセス処理
	 * 
	 * @return
	 */
	@RequestMapping(value = "call", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	private String call() {
		RestTemplate restTemplate = new RestTemplate();

		final String param = "param=hogehoge";
		final String endpoint = "http://localhost:8080/sample/api/test";
		final String url = endpoint + "?" + param;

		// 直接Beanクラスにマップ出来るけど今回はめんどくさいのでStringで。
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		String json = response.getBody();

		return json;
	}

	/**
	 * POST実装例.
	 * 
	 * 指定したエンドポイントに対して {@code json} データをPOSTし、結果を返す。
	 * 
	 * @param url     エンドポイント
	 * @param headers リクエストヘッダ
	 * @param json    送信するJSON文字列
	 * @return 正常に通信出来た場合はレスポンスのJSON文字列を、<br>
	 *         正常に通信出来なかった場合は {@code null} を返す。
	 */
	public String post(String url, Map<String, String> headers, String json) {
		RequestEntity.BodyBuilder builder = RequestEntity.post(uri(url));

		for (String name : headers.keySet()) {
			String header = headers.get(name);
			builder.header(name, header);
		}

		RequestEntity<String> request = builder.contentType(MediaType.APPLICATION_JSON).body(json);

		ResponseEntity<String> response = this.rest.exchange(request, String.class);

		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
	}

	private static final URI uri(String url) {
		try {
			return new URI(url);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
