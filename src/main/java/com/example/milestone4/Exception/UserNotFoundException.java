package com.example.milestone4.Exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message)
	{
		super(message);
	}
}
