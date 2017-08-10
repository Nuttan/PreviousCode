package exceptions;

import org.openqa.selenium.SessionNotCreatedException;

/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "SessionNotCreatedException" exception
Dependencies	                    : --
Reviewed By                       : --
*/
@SuppressWarnings("serial")
public class ExceptionHandling_SessionNotCreatedException extends SessionNotCreatedException {

private static  String message = "Unable to Create Session";
public ExceptionHandling_SessionNotCreatedException() {    
	super(message);
  
}

@Override
public String getMessage() {
    return message;
}
}