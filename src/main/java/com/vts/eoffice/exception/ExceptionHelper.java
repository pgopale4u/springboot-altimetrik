package com.vts.eoffice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@Slf4j
public class ExceptionHelper {

	@ExceptionHandler(value = { InvalidInputException.class })
	public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex) {
		log.error("InvalidInputException Exception: ",ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Unauthorized.class })
	public ResponseEntity<Object> handleUnauthorizedException(Unauthorized ex) {
		log.error("Unauthorized Exception: ",ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { EmployeeNotFoundException.class })
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		log.error("EmployeeNotFoundException Exception: ",ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = { DepartmentNotFoundException.class })
	public ResponseEntity<Object> handleDepartmentNotFoundException(DepartmentNotFoundException ex) {
		log.error("DepartmentNotFoundException Exception: ",ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { ProjectNotFoundException.class })
	public ResponseEntity<Object> handleProjectNotFoundException(ProjectNotFoundException ex) {
		log.error("ProjectNotFoundException Exception: ",ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { BusinessException.class })
	public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
		log.error("Business Exception: ",ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {
		log.error("Exception: ",ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
