package exceptions;

import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

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


public ExceptionHandling_NoSuchElementException(String controlname) {
	
	super(null);
	ObjectFactory factory = new ObjectFactory();
    factory.createObjectMap();
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlname);
	
	message=" NoSuchElementException :Element with ControlName :" +obj.getControlName()+"  is not present on the current page";

}

@Override
public String getMessage() {
    return message;
}
}
