package pet.store.controller.error;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {
	  
	  
@ExceptionHandler(NoSuchElementException.class)
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public Map<String, String> handleNoSuchElementException(
		NoSuchElementException ex) {
	log.error("Exception: {}", ex.toString());
return Map.of("message", ex.toString());
		
//The handler method should specify a response status of 404 (Not Found). 
//It should return Map<String, String> and take a NoSuchElementException as a parameter. 


}
}



// creating our first handler for the NoSuchElementException:
//@ExceptionHandler(NoSuchElementException.class)
//@ResponseStatus(code = HttpStatus.NOT_FOUND)
//public ExceptionMessage handleNoSuchElementException(
//		  NoSuchElementException ex, WebRequest webRequest) {
//	  return buildExceptionMessage(ex, HttpStatus.NOT_FOUND, webRequest, 
//			  LogStatus.MESSAGE_ONLY); 
