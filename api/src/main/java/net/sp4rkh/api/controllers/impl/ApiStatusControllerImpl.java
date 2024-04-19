package net.sp4rkh.api.controllers.impl;

import lombok.extern.slf4j.Slf4j;
import net.sp4rkh.api.controllers.IApiStatusController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class ApiStatusControllerImpl implements IApiStatusController {
	private final LocalDateTime startUp = LocalDateTime.now();

	@Override
	public ResponseEntity<String> status() {
		return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.getReasonPhrase());
	}

	@Override
	public ResponseEntity<LocalDateTime> lastStartUp() {
		return ResponseEntity.status(HttpStatus.OK).body(this.startUp);
	}
}
