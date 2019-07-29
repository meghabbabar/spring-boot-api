package au.com.autongeneral.testapi.exception;

public class ToDoItemValidationError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7724936773477983384L;

	private String paramName;
	
	public ToDoItemValidationError(String paramName) {
		super(paramName);
		this.paramName = paramName;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	
}
