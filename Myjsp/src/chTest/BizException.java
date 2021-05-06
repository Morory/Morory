package chTest;

public class BizException extends Exception {
	private static final long serialVersionUID = 1L;
	public BizException() {
		super("BizException");
	}
	
	public BizException(String msg) {
		super(msg); // == Exception(msg)
	}
}
