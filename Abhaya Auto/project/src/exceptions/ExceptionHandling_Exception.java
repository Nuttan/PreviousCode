package exceptions;


/** 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles Exceptions
Dependencies	                    : --
Reviewed By                       : --
**/
@SuppressWarnings("serial")
public class ExceptionHandling_Exception extends Exception {

private String message = "Unknow Error";
public ExceptionHandling_Exception() {    
	super();
    
}
@Override
public String getMessage() {
    return message;
}
}