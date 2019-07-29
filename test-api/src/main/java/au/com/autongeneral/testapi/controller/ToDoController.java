package au.com.autongeneral.testapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.autongeneral.testapi.entities.ToDoItem;
import au.com.autongeneral.testapi.exception.ToDoItemNotFoundError;
import au.com.autongeneral.testapi.model.ToDoItemAddRequest;
import au.com.autongeneral.testapi.model.ToDoItemUpdateRequest;
import au.com.autongeneral.testapi.repository.TodoRepository;
import au.com.autongeneral.testapi.validator.InputValidator;

@RestController
@RequestMapping("/test/1.0")
public class ToDoController {

	private TodoRepository todoRpository;

	private InputValidator inputValidator;

	@Autowired
	public ToDoController(TodoRepository todoRepository, InputValidator inputValidator) {
		this.todoRpository = todoRepository;
		this.inputValidator = inputValidator;
	}

	@PostMapping("/todo")
	public ResponseEntity<ToDoItem> createTodoItem(@RequestBody ToDoItemAddRequest toDoItemAddRequest) {

		inputValidator.validateAddRequest(toDoItemAddRequest);
		ToDoItem target = new ToDoItem();
		BeanUtils.copyProperties(toDoItemAddRequest, target);
		ToDoItem todoResponse = todoRpository.save(target);
		return new ResponseEntity(todoResponse, HttpStatus.OK);
	}

	@GetMapping("/todo/{id}")
	public ResponseEntity<ToDoItem> retriveToDoTask(@PathVariable Long id) throws ToDoItemNotFoundError {

		Optional<ToDoItem> todoTask = todoRpository.findById(id);

		if (!todoTask.isPresent()) {
			throw new ToDoItemNotFoundError("" + id);
		}
		return new ResponseEntity(todoTask, HttpStatus.OK);
	}

	@PatchMapping("/todo/{id}")
	public ResponseEntity<ToDoItem> updateToDoItem(@RequestBody ToDoItemUpdateRequest toDoItemUpdateRequest,
			@PathVariable Long id) {

		inputValidator.validateUpdateRequest(toDoItemUpdateRequest, id);
		Optional<ToDoItem> toDoOptional = todoRpository.findById(id);
		if (!toDoOptional.isPresent()) {
			throw new ToDoItemNotFoundError("" + id);
		}
		ToDoItem target = new ToDoItem();
		BeanUtils.copyProperties(toDoItemUpdateRequest, target);
		ToDoItem response = todoRpository.save(target);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@GetMapping("/todo")
	public ResponseEntity<List<ToDoItem>> retriveToDoTasks() throws ToDoItemNotFoundError {
		List<ToDoItem> todoTasks = todoRpository.findAll();
		return new ResponseEntity(todoTasks, HttpStatus.OK);
	}

}
