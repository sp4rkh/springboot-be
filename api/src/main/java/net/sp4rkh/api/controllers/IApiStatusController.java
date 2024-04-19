package net.sp4rkh.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@RequestMapping("/apiStatus")
public interface IApiStatusController {
	/**
	 * Used to get the current status of the API
	 *
	 * @return {@link org.springframework.http.ResponseEntity} of {@link java.lang.String}
	 */
	@GetMapping()
	ResponseEntity<String> status();

	/**
	 * Used to get the last API start up time
	 *
	 * @return {@link org.springframework.http.ResponseEntity} of {@link java.time.LocalDateTime}
	 */
	@GetMapping("/lastStartUp")
	ResponseEntity<LocalDateTime> lastStartUp();
}
