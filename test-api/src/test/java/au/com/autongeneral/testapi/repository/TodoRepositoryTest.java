package au.com.autongeneral.testapi.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import au.com.autongeneral.testapi.entities.ToDoItem;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	TodoRepository todoRepository;

	@Test
	public void shouldCreateTodoItem() {
		ToDoItem toDoItem = new ToDoItem("First Task", false, new Date());
		toDoItem = entityManager.persistAndFlush(toDoItem);
		assertThat(todoRepository.findById(toDoItem.getId()).get()).isEqualTo(toDoItem);
	}
	
	@Test
	public void shouldGetTodoById() {
		ToDoItem toDoItem = new ToDoItem("First Task", false, new Date());
		toDoItem = entityManager.persistAndFlush(toDoItem);
		Optional<ToDoItem> expected = todoRepository.findById(toDoItem.getId());
		assertNotNull(toDoItem);
		assertEquals(expected.isPresent(), true);
	}
}