package exceptions;

import invoketest.StartExecution;
import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.NoSuchFrameException;

/* 
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "NoSuchFrameException" exception
Dependencies	                    : --
Reviewed By                       : --
*/
@SuppressWarnings("serial")
public class ExceptionHandling_NoSuchFrameException extends NoSuchFrameException {

private static  String message = null;
public ExceptionHandling_NoSuchFrameException(String controlName) {
	
	super(message);
	ObjectFactory factory = new ObjectFactory();
    factory.createObjectMap();
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlName);
	
	message=" NoSuchFrameException :Unable to switch to the Frams as no Frame is present  with FrameName:"+obj.getControlName();
   
}

@Override
public String getMessage() {
    return message;
}
}