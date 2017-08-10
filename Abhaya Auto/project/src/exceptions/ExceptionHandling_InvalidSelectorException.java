package exceptions;

import invoketest.StartExecution;
import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.InvalidSelectorException;

/**
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "InvalidSelectorException" exception
Dependencies	                    : --
Reviewed By                       : --
**/
@SuppressWarnings("serial")
public class ExceptionHandling_InvalidSelectorException extends InvalidSelectorException {

private static String message = null;
public ExceptionHandling_InvalidSelectorException(String controlname) {
	
	super(null);
	ObjectFactory factory = new ObjectFactory();
    factory.createObjectMap();
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlname);
	
	message="InvalidSelectorException:Unable to find Element with given ControlProperty :"+obj.getControlProperty()+" and TypeofProperty :"+obj.getTypeOfProperty()+" is not possible";
    
}

@Override
public String getMessage() {
    return message;
}
}