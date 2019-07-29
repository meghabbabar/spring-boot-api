package au.com.autongeneral.testapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Details {
	
	private String location;
	
	private String param;
	
	private String message;
	
	private Object value;
	
	public Details() {}

	public Details(String location, String params, Object value, String msg) {
		super();
		this.location = location;
		this.param = params;
		this.message = msg;
		this.value = value;
	}

	public Details(String message) {
		this.message = message;
	}

	public String getLocation() {
		return location;
	}

	public String getParam() {
		return param;
	}

	public String getMessage() {
		return message;
	}

	public Object getValue() {
		return value;
	}
	
	
	
	

}
