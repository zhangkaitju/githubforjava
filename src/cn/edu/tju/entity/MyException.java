package cn.edu.tju.entity;

public class MyException extends RuntimeException {
	private static final long serialVersionUID = -3563928567447310893L;

	public MyException() {
		super();
	}

	public MyException(String msg) {
		super(msg);
	}

	public MyException(Throwable cause) {
		super(cause);
	}

	public MyException(String msg, Throwable cause) {
		super(msg, cause);
	}
}