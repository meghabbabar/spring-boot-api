package au.com.autongeneral.testapi.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import au.com.autongeneral.testapi.entities.ToDoItem;
import au.com.autongeneral.testapi.model.ToDoItemAddRequest;
import au.com.autongeneral.testapi.repository.TodoRepository;
import au.com.autongeneral.testapi.validator.InputValidator;

@RunWith(MockitoJUnitRunner.class)
public class ToDoControllerTest {

	@Mock
	TodoRepository repository;

	@Mock
	private InputValidator inputValidator = new InputValidator();
	
	@Mock
	private ToDoController controller;
	
	@Before
    public void setup(){
        // init mocks
		controller = new ToDoController(repository, inputValidator);
    }

	@Test
	public void shouldDelegateToRepositoryToAddTodo() {
		ToDoItemAddRequest request = new ToDoItemAddRequest("First");
		ToDoItem item = new ToDoItem("First");
		Mockito.when(repository.saveAndFlush(item)).thenReturn(item);
		ResponseEntity<ToDoItem> response = controller.createTodoItem(request);
		assertNotNull(response);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		ToDoItem actual = repository.saveAndFlush(item);
		assertThat(actual, is(item));

	}

	@Test
	public void shouldDelegateToRepositoryToGetTodo() {

		ToDoItem item = new ToDoItem("First");
		Mockito.when(repository.findById(1l)).thenReturn(Optional.of(item));
		ResponseEntity<ToDoItem> response = controller.retriveToDoTask(1l);
		assertNotNull(response);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));

	}

}
