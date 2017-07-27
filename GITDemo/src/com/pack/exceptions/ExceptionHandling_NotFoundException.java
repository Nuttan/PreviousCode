package com.pack.exceptions;
import org.openqa.selenium.NotFoundException;
/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "NotFoundException" exception
Dependencies	                    : --
Reviewed By                       : --
*/

@SuppressWarnings("serial")
public class ExceptionHandling_NotFoundException extends NotFoundException {

private static  String message = null;
public ExceptionHandling_NotFoundException(String controlname) {
	
	super(message);
	message="NotFoundException :Unable to find the Element for given ControlProperty";
   
}


@Override
public String getMessage() {
    return message;
}
}