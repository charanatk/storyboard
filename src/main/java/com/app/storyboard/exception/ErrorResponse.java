/**
 * 
 */
package com.app.storyboard.exception;

import java.util.Map;

import io.swagger.annotations.ApiModelProperty;
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
	 	@ApiModelProperty(notes = "The message of the ErrorResponse", required = true)
	    private String message;
	 	@ApiModelProperty(notes = "The error details key,value of the ErrorResponse", required = true)
	    private Map<String,String> details;

}
