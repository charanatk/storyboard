package com.app.storyboard.exception;

import java.time.LocalDate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ExceptionResponse extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LocalDate date;
	String message;
	String description;
 
	public ExceptionResponse(LocalDate now, String msg, String desc) {
		this.date = now;
		this.message = msg;
		this.description = desc;
	}

}
