/**
 * 
 */
package com.app.storyboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Charan kandula
 *
 */

@Setter
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingInputInfoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MissingInputInfoException(String message) {
		super(message);
	}
}
