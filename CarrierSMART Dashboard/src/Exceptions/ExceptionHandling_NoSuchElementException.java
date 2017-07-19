package Exceptions;

import ObjectRepository.ObjectFactory;
import ObjectRepository.ObjectMap;
import ObjectRepository.UIControlObject;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;

/** 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "NoSuchElementException" exception
Dependencies	                    : --
Reviewed By                       : --
**/
@SuppressWarnings("serial")
public class ExceptionHandling_NoSuchElementException extends NoSuchElementException {

private String message = null;


public ExceptionHandling_NoSuchElementException(String controlname) throws IOException {
	
	super(null);
	ObjectFactory factory = new ObjectFactory(null);
    factory.createObjectMap(controlname);
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlname);
	
	message=" NoSuchElementException :Element with ControlName :" +obj.getControlName()+"  is not present on the current page";

}

@Override
public String getMessage() {
    return message;
}
}
