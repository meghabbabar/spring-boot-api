package au.com.autongeneral.testapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToDoItemNotFoundError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 162727655132806507L;
	
	private String id;
	
	public ToDoItemNotFoundError(String id) {
		super(String.format(" Item with '%s' not found", id));
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
