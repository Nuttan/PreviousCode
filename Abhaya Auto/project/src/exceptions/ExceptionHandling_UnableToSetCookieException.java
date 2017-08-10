package exceptions;

import org.openqa.selenium.UnableToSetCookieException;

/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "UnableToSetCookieException" exception
Dependencies	                    : --
Reviewed By                       : --
*/
@SuppressWarnings("serial")
public class ExceptionHandling_UnableToSetCookieException extends UnableToSetCookieException {

private static String message = null;
public ExceptionHandling_UnableToSetCookieException() {    
	super(message);
	message=" UnableToSetCookieException :Unable to set the Cookie";

}
@Override
public String getMessage() {
return message;
}
}