package exceptions;

import invoketest.StartExecution;
import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.NotFoundException;
/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "NotFoundException" exception
Dependencies	                    : --
Reviewed By                       : --
*/

@SuppressWarnings("serial")
public class ExceptionHandling_NotFoundException extends NotFoundException {

private static  String message = null;
public ExceptionHandling_NotFoundException(String controlname) {
	
	super(message);
	ObjectFactory factory = new ObjectFactory();
    factory.createObjectMap();
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlname);
	message=" NotFoundException :Unable to find the Element for given ControlProperty :"+obj.getControlProperty()+" and TypeofProperty :"+obj.getTypeOfProperty();
   
}


@Override
public String getMessage() {
    return message;
}
}