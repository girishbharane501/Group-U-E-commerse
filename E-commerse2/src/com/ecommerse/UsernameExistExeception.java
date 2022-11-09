package com.ecommerse;

public class UsernameExistExeception extends Exception
{
	private static final long serialVersionUID = 1L;
	public UsernameExistExeception (String message) {
		super(message);
	}
}