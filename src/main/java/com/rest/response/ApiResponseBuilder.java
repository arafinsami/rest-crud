package com.rest.response;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class ApiResponseBuilder implements ApiResponse {

	private Object data;

	private Object error;

	private ResponseType responseType;

	private ApiResponseBuilder(ResponseType responseType) {
		this.responseType = responseType;
	}

	public static ApiResponse success(Object data) {

		ApiResponseBuilder response = new ApiResponseBuilder(ResponseType.DATA);
		response.data = data;
		return response;
	}

	public static ApiResponse error(Object error) {
		ApiResponseBuilder response = new ApiResponseBuilder(ResponseType.ERROR);
		response.error = error;
		return response;
	}

	@Override
	public JSONObject getJsonResponse() {

		Map<String, Object> map = new HashMap<>();

		switch (this.responseType) {
		case DATA  -> map.put("data", data);
		case ERROR -> map.put("errors", error);
		}
		return new JSONObject(map);
	}
}
