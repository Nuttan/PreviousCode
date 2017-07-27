package exceptions;

import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.TimeoutException;

/**
Author Name                       : Vinusha Tanuku
Date of Preparation               : 13/05/2014
Date of Modified                  : --
Methods Called                    : ---
Purpose of Method                 : Handles "TimeoutException" exception
Dependencies	                    : --
Reviewed By                       : --
**/
@SuppressWarnings("serial")
public class ExceptionHandling_TimeoutException extends TimeoutException {

private  String message = null;
public ExceptionHandling_TimeoutException(String controlName) {   
	
	super("");
	ObjectFactory factory = new ObjectFactory();
    factory.createObjectMap();
	ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
    UIControlObject obj = map.get(controlName);
	
	message=" TimeoutException :Unable to find the Element :" +obj.getControlName()+"  with in the Time Limit of 60 sec";


}
@Override
public String getMessage() {
  return message;
}
}