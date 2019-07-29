package au.com.autongeneral.testapi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import au.com.autongeneral.testapi.exception.ToDoItemNotFoundError;
import au.com.autongeneral.testapi.exception.ToDoItemValidationError;
import au.com.autongeneral.testapi.model.Details;
import au.com.autongeneral.testapi.model.ExceptionResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ToDoItemNotFoundError.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(ToDoItemNotFoundError ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("NotFoundError", new Details(ex.getMessage()));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ToDoItemValidationError.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequest(ToDoItemValidationError ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("ValidationError", new Details(ex.getMessage()));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}