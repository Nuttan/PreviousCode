package com.pack.exceptions;


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