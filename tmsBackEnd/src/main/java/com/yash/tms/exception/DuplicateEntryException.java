package com.yash.tms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DuplicateEntryException extends Exception
{
	public DuplicateEntryException(String exception)
	{
		super(exception);
	}

}
