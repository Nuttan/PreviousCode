package exceptions;

import invoketest.StartExecution;
import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.StaleElementReferenceException;

/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "StaleElementReferenceException" exception
Dependencies	                    : --
Reviewed By                       : --
*/

@SuppressWarnings("serial")
public class ExceptionHandling_StaleElementReferenceException extends StaleElementReferenceException {

private static String message = null;
public ExceptionHandling_StaleElementReferenceException(String controlname) { 
	super(null);
	ObjectFactory factory = new ObjectFactory();
    factory.createObjectMap();
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlname);
	
	message=" StaleElementReferenceException :Element with ControlProperty :"+obj.getControlProperty()+" and TypeofProperty :"+obj.getTypeOfProperty()+" is currently Stale[the element no longer appears on the DOM of the page.]";
  
}
@Override
public String getMessage() {
    return message;
}
}