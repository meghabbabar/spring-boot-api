package au.com.autongeneral.testapi.controller;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.autongeneral.testapi.model.BalanceTestResult;
import au.com.autongeneral.testapi.validator.InputValidator;

@RestController
@RequestMapping("/test/1.0")
public class TaskController {

	@Autowired
	public InputValidator inputValidator;

	@GetMapping(value="/tasks/validateBrackets")
	public ResponseEntity<BalanceTestResult> brackets(@RequestParam(name="input") String input)   {
		inputValidator.validateBracketInput(input);
		BalanceTestResult response = validateBrackets(input);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	private BalanceTestResult validateBrackets(String input) {
		Boolean isValid = validateInput(input);
		return new BalanceTestResult(input, isValid);
	}

	private Boolean validateInput(String input) {
		Stack stack = new Stack();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
				stack.push(input.charAt(i));
			}
			if (input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']') {
				if (stack.empty()) {
					return false;
				}
				char top_char = (char) stack.pop();

				if ((top_char == '(' && input.charAt(i) != ')') || (top_char == '{' && input.charAt(i) != '}')
						|| (top_char == '[' && input.charAt(i) != ']')) {
					return false;
				}
			}
		}
		return stack.empty();
	}
		
	  
}
