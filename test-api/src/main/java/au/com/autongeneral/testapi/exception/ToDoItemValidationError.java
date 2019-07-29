package au.com.autongeneral.testapi.exception;

public class ToDoItemValidationError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7724936773477983384L;

	private String message;
	
	public ToDoItemValidationError(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}
