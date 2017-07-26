package com.pack.exceptions;


import org.openqa.selenium.ElementNotVisibleException;


@SuppressWarnings("serial")
public class ExceptionHandling_ElementNotVisisble extends ElementNotVisibleException {

private static String message = null;

public ExceptionHandling_ElementNotVisisble(String controlName) {
	
	super(null);
	
	message=" ElementNotVisibleException:Element with ControlProperty is not visible on the current page";
  
}
@Override
public String getMessage() {
    return message;
}
}