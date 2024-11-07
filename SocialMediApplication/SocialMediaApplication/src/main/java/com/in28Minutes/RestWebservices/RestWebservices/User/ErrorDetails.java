package com.in28Minutes.RestWebservices.RestWebservices.User;

import java.time.LocalDate;

public class ErrorDetails {
	
	private String message;
	private String details;
	private LocalDate timestamp;
	
	public ErrorDetails(String message, String details, LocalDate timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}


}
