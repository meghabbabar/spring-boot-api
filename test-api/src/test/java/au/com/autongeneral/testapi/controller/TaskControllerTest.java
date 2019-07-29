package au.com.autongeneral.testapi.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import au.com.autongeneral.testapi.model.BalanceTestResult;
import au.com.autongeneral.testapi.validator.InputValidator;

@RunWith(EasyMockRunner.class)
public class TaskControllerTest {
	
	@TestSubject
	private TaskController controller = new TaskController();
	
	@Mock
	private InputValidator inputValidator;
	
	@Test
	public void shouldReturnBracketsIfBalanced() {
		
		ResponseEntity<BalanceTestResult> result = controller.brackets("{}{}{}()");
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody().getIsBalanced(), is(true));
	}
	
	@Test
	public void shouldReturnFalseBracketsIfNotBalanced() {
		
		ResponseEntity<BalanceTestResult> result = controller.brackets("{{}{}()");
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody().getIsBalanced(), is(false));
	}
	
	@Test
	public void shouldReturnFalseBracketsIfOpeningBrackets() {
		
		ResponseEntity<BalanceTestResult> result = controller.brackets("{{[[[[((((");
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody().getIsBalanced(), is(false));
	}
	
	@Test
	public void shouldReturnFalseBracketsIfOnlyClosingBrackets() {
		
		ResponseEntity<BalanceTestResult> result = controller.brackets("}}}))]]]");
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
		assertThat(result.getBody().getIsBalanced(), is(false));
	}
	
}
