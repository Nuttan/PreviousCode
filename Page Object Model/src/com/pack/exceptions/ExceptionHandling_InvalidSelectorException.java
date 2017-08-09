package com.pack.exceptions;


import org.openqa.selenium.InvalidSelectorException;

@SuppressWarnings("serial")
public class ExceptionHandling_InvalidSelectorException extends InvalidSelectorException {

private static String message = null;
public ExceptionHandling_InvalidSelectorException(String controlname) {
	
	super(null);
	
	message="InvalidSelectorException:Unable to find Element with given ControlProperty : is not possible";
    
}

@Override
public String getMessage() {
    return message;
}
}