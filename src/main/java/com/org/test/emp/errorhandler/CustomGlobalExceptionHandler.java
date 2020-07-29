package com.org.test.emp.errorhandler;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.org.test.emp.dto.ValidationNotification;

import lombok.extern.slf4j.Slf4j; 

@ControllerAdvice
@Slf4j
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorMessage> handleException(CustomException ex, HttpServletRequest req){
		CustomError errorCode = ex.getCustomError();
		List<String> errors = null;
		if (ex.getErrors() != null) {
			errors = ex.getErrors().stream().map(ValidationNotification::getMessage).collect(Collectors.toList());
		}
		ErrorMessage error = new ErrorMessage(errorCode.getResponseError(), ex.getMessage(), errors,
				req.getRequestURI(), "");
		return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.valueOf(errorCode.getResponseError()));
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(e -> e.getField() + " " + e.getDefaultMessage()).collect(Collectors.toList());

		ErrorMessage exceptionResponse = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), "Validation Failed", errors,
				request.getDescription(false), "");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
    
    @ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception ex, WebRequest request,
			HttpServletRequest req) {
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Error",
				ex.getMessage(), req.getRequestURI(),
				"");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@ExceptionHandler(AccessDeniedException.class)
	public final ResponseEntity<ErrorMessage> handleAccessDeniedException(Exception ex, WebRequest request,
			HttpServletRequest req) {
		ErrorMessage error = new ErrorMessage(HttpStatus.UNAUTHORIZED.value(), "Unauthorized",
				ex.getMessage(), req.getRequestURI(),
				"");
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}

}
