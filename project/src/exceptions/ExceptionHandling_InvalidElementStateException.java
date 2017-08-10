package exceptions;

import invoketest.StartExecution;
import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.InvalidElementStateException;

/** 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "InvalidElementStateException" exception
Dependencies	                    : --
Reviewed By                       : --
**/
@SuppressWarnings("serial")
public class ExceptionHandling_InvalidElementStateException extends InvalidElementStateException {

private static String message = null;
public ExceptionHandling_InvalidElementStateException(String controlname) {
	super(message);
	ObjectFactory factory = new ObjectFactory();
    factory.createObjectMap();
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlname);
	
	message=" InvalidElementStateException:Action on Element with ControlProperty :"+obj.getControlProperty()+" and TypeofProperty :"+obj.getTypeOfProperty()+" is not possible";
   
}

@Override
public String getMessage() {
    return message;
}
}