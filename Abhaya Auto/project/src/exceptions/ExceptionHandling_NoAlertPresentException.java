package exceptions;

import org.openqa.selenium.NoAlertPresentException;

/** 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "NoAlertPresentException" exception
Dependencies	                    : --
Reviewed By                       : --
**/
@SuppressWarnings("serial")
public class ExceptionHandling_NoAlertPresentException extends NoAlertPresentException {

private static String message = "No Alert or pop-up is displayed";
public ExceptionHandling_NoAlertPresentException() {    
	super();	    
}

@Override
public String getMessage() {
    return message;
}
}
