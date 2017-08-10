package exceptions;

import org.openqa.selenium.UnsupportedCommandException;

/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "UnsupportedCommandException" exception
Dependencies	                    : --
Reviewed By                       : --
*/
@SuppressWarnings("serial")
public class ExceptionHandling_UnsupportedCommandException extends UnsupportedCommandException {

private static String message = null;
public ExceptionHandling_UnsupportedCommandException() {    
	super(message);
	message="UnsupportedCommandException:Command used by the webdriver is unsupported.";

}
@Override
public String getMessage() {
return message;
}
}