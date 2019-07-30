package au.com.autongeneral.testapi.controller;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

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
		

	}

	@Test
	public void shouldDelegateToRepositoryToGetTodo() {

		

	}

}
