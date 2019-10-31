/**
 * 
 */
package com.app.storyboard.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.app.storyboard.util.Constants;

/**
 * @author Charan kandula
 *
 */
@ControllerAdvice
@RestController
public class StoryBoardExceptionHandler extends ExceptionHandlerExceptionResolver {

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex,
			WebRequest request) {
		Map<String, String> hm = new HashMap<>();

		hm.put(Constants.DATE, LocalDateTime.now() + "");
		hm.put(Constants.ERROR, ex.getLocalizedMessage());
		hm.put(Constants.REQUEST, request.getDescription(false));
		ErrorResponse error = new ErrorResponse(Constants.INCORRECT_REQUEST, hm);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MissingHeaderInfoException.class)
	public final ResponseEntity<ErrorResponse> handleInvalidTraceIdException(MissingHeaderInfoException mhie,
			WebRequest request) {

		Map<String, String> hm = new HashMap<>();
		hm.put(Constants.DATE, LocalDateTime.now() + "");
		hm.put(Constants.ERROR, mhie.getLocalizedMessage());
		hm.put(Constants.REQUEST, request.getDescription(false));
		ErrorResponse error = new ErrorResponse(Constants.BAD_REQUEST, hm);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e) {
		Logger.getLogger(getClass().getName()).log(Level.SEVERE,
				"Request: " + request.getRequestURL() + " raised " + e.getMessage());
		return new ModelAndView("404");
	}

 
	  @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	  @ExceptionHandler(HttpMediaTypeNotSupportedException.class) 
	  public ResponseEntity<ErrorResponse> handleUnsupportedMediaTypeException(HttpMediaTypeNotSupportedException
	  ex,WebRequest request) {
		  Logger.getLogger(getClass().getName()).log(Level.SEVERE,"Request: " + request.getContextPath() + " raised " + ex.getMessage()); 
		  Map<String, String> hm = new HashMap<>(); 
			  hm.put(Constants.DATE, LocalDateTime.now() + "");
			  hm.put(Constants.ERROR, ex.getLocalizedMessage()); 
			  hm.put(Constants.REQUEST,
		  request.getDescription(false)); 
		  ErrorResponse error = new ErrorResponse(Constants.BAD_REQUEST, hm);
		  return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); 
	  }
	 
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleBaseException(Exception ex, WebRequest request) {
		Logger.getLogger(getClass().getName()).log(Level.SEVERE,
				"Request: " + request.getContextPath() + " raised " + ex.getMessage());
		Map<String, String> hm = new HashMap<>();
		hm.put(Constants.DATE, LocalDateTime.now() + "");
		hm.put(Constants.ERROR, ex.getLocalizedMessage());
		hm.put(Constants.REQUEST, request.getDescription(false));
		ErrorResponse error = new ErrorResponse(Constants.INTERNAL_SERVER_ERROR, hm);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
