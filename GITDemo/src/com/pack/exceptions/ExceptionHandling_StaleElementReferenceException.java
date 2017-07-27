package com.pack.exceptions;


import org.openqa.selenium.StaleElementReferenceException;



@SuppressWarnings("serial")
public class ExceptionHandling_StaleElementReferenceException extends StaleElementReferenceException {

private static String message = null;
public ExceptionHandling_StaleElementReferenceException(String controlname) { 
	super(null);
	
	message=" StaleElementReferenceException :Element with ControlProperty : is currently Stale[the element no longer appears on the DOM of the page.";
  
}
@Override
public String getMessage() {
    return message;
}
}