package cn.edu.tju.http;

import cn.edu.tju.entity.MyException;

public class HttpException extends MyException {
	private static final long serialVersionUID = 5824357504573919990L;

	public HttpException(String msg) {
		super(msg);
	}

	public HttpException(Throwable cause) {
		super(cause);
	}

	public HttpException(String msg, Throwable cause) {
		super(msg, cause);
	}
}