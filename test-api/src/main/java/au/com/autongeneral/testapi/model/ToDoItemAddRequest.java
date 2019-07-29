package au.com.autongeneral.testapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ToDoItemAddRequest {
	
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public ToDoItemAddRequest() {}

	public ToDoItemAddRequest(String text) {
		super();
		this.text = text;
	}
	
	

}
