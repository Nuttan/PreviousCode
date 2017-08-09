package com.pack.exceptions;


import org.openqa.selenium.TimeoutException;

@SuppressWarnings("serial")
public class ExceptionHandling_TimeoutException extends TimeoutException {

private  String message = null;
public ExceptionHandling_TimeoutException(String controlName) {   
	
	super("");
	message=" TimeoutException :Unable to find the Element with in the Time Limit of 60 sec";


}
@Override
public String getMessage() {
  return message;
}
}