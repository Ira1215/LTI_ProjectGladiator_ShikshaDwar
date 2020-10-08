package com.lti.customException;

public class FileTypeException extends Exception {
	@Override
	public String getMessage() {
		return "Only pdf files allowed";
	}
	
}
