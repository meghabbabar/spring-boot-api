package au.com.autongeneral.testapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.com.autongeneral.testapi.model.StatusResponse;

@RestController
@RequestMapping("/test/1.0")
public class SystemController {

	@GetMapping("/status")
	public ResponseEntity<StatusResponse> getSystemStatus() {
		RestTemplate restTemplate = new RestTemplate();
		String healthURL = "http://localhost:8080/actuator/health";
		ResponseEntity<String> response = restTemplate.getForEntity(healthURL , String.class);
		StatusResponse statusResponse = new StatusResponse();
		if(response.getStatusCode() == HttpStatus.OK) {
			statusResponse.setStatus("healthy");
		}
		return new ResponseEntity(statusResponse, HttpStatus.OK);
	}

}
