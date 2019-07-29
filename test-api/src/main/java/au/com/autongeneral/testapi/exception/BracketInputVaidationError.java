package au.com.autongeneral.testapi.exception;

public class BracketInputVaidationError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2015117209612015542L;
	
	private String paramName;
	
	private String message;
	
	public BracketInputVaidationError(String paramName, String message) {
		super(message);
		this.paramName = paramName;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

}
