package com.nhfc99.template.Utils;

public class RestfulResponse<T> {
	
	static int code_SUCCESS = 0;
	static int code_FAILED = 1;

	int code;

	String msg;

	T data;

	public static <T> RestfulResponse<T> success(T data) {
		return success(data, "成功");
	}
	
	public static <T> RestfulResponse<T> success(T data, String msg) {
		return new RestfulResponse<>(code_SUCCESS, msg, data);
	}
	
	public static <T> RestfulResponse<T> failed() {
		return new RestfulResponse<>(code_FAILED, "空数据", null);
	}
	
	public static <T> RestfulResponse<T> failed(String msg) {
		return new RestfulResponse<>(code_FAILED, msg, null);
	}

	public RestfulResponse(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public RestfulResponse() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[code=" + code + ", msg=" + msg + "]";
	}
}
