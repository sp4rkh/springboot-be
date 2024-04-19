package net.sp4rkh.api.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@SpringBootTest
@Import({ApiControllersConfiguration.class})
@ActiveProfiles({"test"})
public class ApiStatusControllerTest {
	@Autowired
	private IApiStatusController apiStatusController;

	@Test
	@DisplayName("ContextLoad test")
	@Description("Verify if the context is well loaded before starting all the tests.")
	public void contextLoads() {
		Assertions.assertNotNull(this.apiStatusController);
	}

	@Test
	@DisplayName("Test status function")
	void statusTest() {
		ResponseEntity<String> result = this.apiStatusController.status();

		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assertions.assertEquals(HttpStatus.OK.getReasonPhrase(), result.getBody());
	}

	@Test
	@DisplayName("Test lastApiStartUp function")
	void lastApiStartUpTest() {
		ResponseEntity<LocalDateTime> result = this.apiStatusController.lastStartUp();

		Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
		Assertions.assertTrue(LocalDateTime.now().isAfter(result.getBody()));
	}
}
