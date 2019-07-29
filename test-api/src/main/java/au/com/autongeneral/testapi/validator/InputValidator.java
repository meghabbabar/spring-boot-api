package au.com.autongeneral.testapi.validator;

import org.springframework.stereotype.Component;

import au.com.autongeneral.testapi.exception.ToDoItemValidationError;
import au.com.autongeneral.testapi.model.ToDoItemAddRequest;
import au.com.autongeneral.testapi.model.ToDoItemUpdateRequest;

@Component
public class InputValidator {

	public void validateAddRequest(ToDoItemAddRequest toDoItemAddRequest) {
		if (toDoItemAddRequest == null) {
			throw new ToDoItemValidationError("request body");
		}
	}

	public void validateUpdateRequest(ToDoItemUpdateRequest toDoItemUpdateRequest, Long id) {
		if (toDoItemUpdateRequest == null) {
			throw new ToDoItemValidationError("request body");
		}
		if (id == null || id < 0) {
			throw new ToDoItemValidationError("Id can not be empty or negative");
		}
	}

	public void validateBracketInput(String input) {
		if(input == null || input.isEmpty()) {
			throw new ToDoItemValidationError("Input string is required");
		}
		if(input.length() > 50) {
			throw new ToDoItemValidationError("Must be between 1 and 50 chars long");
		}
	}

}
