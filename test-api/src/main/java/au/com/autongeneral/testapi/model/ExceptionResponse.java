package au.com.autongeneral.testapi.model;

public class ExceptionResponse {
	
	private String name;
	
	private Details details;
	
	public ExceptionResponse(String name, Details details) {
		super();
		this.name = name;
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public Details getDetails() {
		return details;
	}

}