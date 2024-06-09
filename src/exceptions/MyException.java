package exceptions;

public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	MyException (String errorMessage) {
		super(errorMessage);
	}
}