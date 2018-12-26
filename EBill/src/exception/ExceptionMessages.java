package exception;

public class ExceptionMessages extends Exception{

	public static String MESSAGE1=" error message";

	public ExceptionMessages() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionMessages(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionMessages(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionMessages(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionMessages(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
