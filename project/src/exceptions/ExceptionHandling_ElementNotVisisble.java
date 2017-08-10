package exceptions;

import invoketest.StartExecution;
import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.ElementNotVisibleException;

/**
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "ElementNotVisibleException" exception
Dependencies	                    : --
Reviewed By                       : --
**/
@SuppressWarnings("serial")
public class ExceptionHandling_ElementNotVisisble extends ElementNotVisibleException {

private static String message = null;

public ExceptionHandling_ElementNotVisisble(String controlName) {
	
	super(null);
	ObjectFactory factory = new ObjectFactory();
    factory.createObjectMap();
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlName);
	
	message=" ElementNotVisibleException:Element with ControlProperty :"+obj.getControlProperty()+" and TypeofProperty :"+obj.getTypeOfProperty()+" is not visible on the current page";
  
}
@Override
public String getMessage() {
    return message;
}
}