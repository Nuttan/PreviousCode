package com.pack.exceptions;

import org.openqa.selenium.NoSuchWindowException;

/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "NoSuchWindowException" exception
Dependencies	                    : --
Reviewed By                       : --
*/

@SuppressWarnings("serial")
public class ExceptionHandling_NoSuchWindowException extends NoSuchWindowException {

private static String message = "NoSuchWindowException :Unable to switch to the Window as no new Window is present";;
public ExceptionHandling_NoSuchWindowException() {    
	super(message);
   
}

@Override
public String getMessage() {
    return message;
}
}
