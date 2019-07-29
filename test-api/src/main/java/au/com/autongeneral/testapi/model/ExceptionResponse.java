package au.com.autongeneral.testapi.model;

import java.util.ArrayList;
import java.util.List;

public class ExceptionResponse {
	
	private String name;
	
	private List<Details> details;
	
	public ExceptionResponse(String name, Details detail) {
		super();
		this.name = name;
		if(this.details == null) {
			this.details = new ArrayList<Details>();
		}
		this.details.add(detail);
	}
	
	public ExceptionResponse(String name, List<Details> details) {
		super();
		this.name = name;
		this.details = details;
	}

	public ExceptionResponse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Details> getDetails() {
		return details;
	}

	public void addErrorDetails(Details detail) {
		if(this.details == null) {
			this.details = new ArrayList<Details>();
		}
		this.details.add(detail);
	}
}