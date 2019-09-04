/**
 * 
 */
package com.app.storyboard.exception;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Lenovo
 *
 */

@Setter
@Getter
public class ErrorResponse {
	 public ErrorResponse(String message, Map<String,String> details) {
	        super();
	        this.message = message;
	        this.details = details;
	    }
	  
	    private String message;
	    private Map<String,String> details;

}
