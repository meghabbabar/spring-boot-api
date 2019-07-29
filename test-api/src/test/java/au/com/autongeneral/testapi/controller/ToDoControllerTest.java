package au.com.autongeneral.testapi.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import au.com.autongeneral.testapi.entities.ToDoItem;
import au.com.autongeneral.testapi.model.ToDoItemAddRequest;
import au.com.autongeneral.testapi.repository.TodoRepository;
import au.com.autongeneral.testapi.validator.InputValidator;

@RunWith(MockitoJUnitRunner.class)
public class ToDoControllerTest extends EasyMockSupport {

	@Mock
	private TodoRepository repository;

	@Mock
	private InputValidator inputValidator;

	@TestSubject
	private ToDoController toDoController = new ToDoController(repository, inputValidator);

	@Test
	public void shouldDelegateToRepositoryToAddTodo() {
		ToDoItemAddRequest addRequest = new ToDoItemAddRequest("First");
		ToDoItem t = new ToDoItem("First Todo Item");
		Mockito.when(repository.save(Mockito.any(ToDoItem.class))).thenReturn(t);
//		when(repository.save(any(ToDoItem.class))).thenReturn(new ToDoItem());
		ResponseEntity<ToDoItem> actual = toDoController.createTodoItem(addRequest);
		assertThat(actual.getStatusCode(), is(HttpStatus.OK));

	}

	@Test
	public void shouldDelegateToRepositoryToGetTodo() {

		

	}

}
