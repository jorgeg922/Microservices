package com.jorgegonzales.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {
	//timestamp
	//errror message
	//details
	private LocalDate timeStamp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDate timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
}
