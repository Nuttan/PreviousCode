package exceptions;

import org.openqa.selenium.UnhandledAlertException;

/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "UnhandledAlertException" exception
Dependencies	                    : --
Reviewed By                       : --
*/
@SuppressWarnings("serial")
class ExceptionHandling_UnhandledAlertException extends UnhandledAlertException {

private static String message = null;
public ExceptionHandling_UnhandledAlertException() {    
	super(message);
	message="Unhandled Alert has popped up";

}
@Override
public String getMessage() {
return message;
}
}
