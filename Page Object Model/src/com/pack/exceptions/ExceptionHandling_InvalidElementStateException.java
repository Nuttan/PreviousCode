package com.pack.exceptions;


import org.openqa.selenium.InvalidElementStateException;

@SuppressWarnings("serial")
public class ExceptionHandling_InvalidElementStateException extends InvalidElementStateException {

private static String message = null;
public ExceptionHandling_InvalidElementStateException(String controlname) {
	super(message);
	message=" InvalidElementStateException:Action on Element with ControlProperty  is not possible";
   
}

@Override
public String getMessage() {
    return message;
}
}