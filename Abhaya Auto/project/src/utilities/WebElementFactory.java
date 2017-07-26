package utilities;


import java.util.List;

import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import exceptions.ExceptionHandling_NoSuchElementException;
public class WebElementFactory {
       
	protected RemoteWebDriver driver;
       
       public WebElementFactory(RemoteWebDriver driver)
       {
    	   this.driver=driver;
             
       } 
       
       /**
     * @param controlName
     * @param typeOfAction
     */
    /**
     * @param controlName
     * @param typeOfAction
     */
    public void doMouseAction(String controlName, String typeOfAction)
       {
              WebElement element = getElement(controlName);
              Actions actions = new Actions(driver);
              Action action;
              switch (typeOfAction) {
              case "clear":
         	  	 	 element.clear();
         	  	 	 break;
              case "click":
                     element.click();
                     break;
              case "submit":
                  element.submit();
                  break;
              case "tab":
                  element.sendKeys(Keys.TAB);
                  break;
              case "clickandhold":
                     actions.clickAndHold(element);
                     action = actions.build();
                     action.perform();
                     break;
              case "doubleclick":
                     actions.doubleClick(element);
                     action = actions.build();
                     action.perform();
                     break;
              case "contextclick":
                     actions.contextClick(element);
                     action = actions.build();
                     action.perform();
                     break;
              case "hover":
                     actions.moveToElement(element);
                     action = actions.build();
                     action.perform();
                     //element.sendKeys("");
                     break;
              case "release":
                     actions.release(element);
                     action = actions.build();
                     action.perform();
                     break;
              default:
                     break;
              }
       }
       
       
       // This method modified by sivanag bcz if text is already present in the editbox its not removing.
       public void enterText(String controlName,String text)
       {
              WebElement element = getElement(controlName);
              element.clear();
              element.sendKeys(text);
       }
       
       
       
       /**
       * This method is used to select a value from drop down based on option value
       * @param controlName
       * @param optionToBeSelected
       */
       public void selectByValue(String controlName, String optionToBeSelected)
       {
              WebElement element = getElement(controlName);
              Select select = new Select(element);
              select.selectByValue(optionToBeSelected);
       }
       
       
       /**
        * This method is used to select a value from drop down based on text value
        * @param controlName
        * @param textValue
        *Updtaed by : Sivanag as on 7/7/2014(Its not able to select the value from dropdown)
        **/
        public void selectByText(String controlName, String textValue )
        {
               WebElement element = getElement(controlName);
               Select select = new Select(element);
               //select.selectByValue(textValue);
               List<WebElement> we = select.getOptions();              
               for(int i = 0;i<we.size();i++){            	  
             	  if(textValue.trim().equals(we.get(i).getText().trim())){
             		  we.get(i).click();
             		  break;
             	  }             	  
             	  
               }
        }
       
       
       /**
       * This method is used to select a value from drop down based on visible text
       * @param controlProperty
       * @param propertyType
       * @return void
       */
       
       
       public void selectByVisibleText(String controlName, String visibleText)
       {
              WebElement element = getElement(controlName);
              Select select = new Select(element);
              select.selectByValue(visibleText);
       }
       /**
       * This method is used to get the Locator for identifying the UI Elements uniquely
       * @param controlProperty
       * @param propertyType
       * @return By object
       */
       public By getLocator(String controlProperty, String propertyType)
       {
              
              switch (propertyType) {
              case "xpath":
                     return By.xpath(controlProperty);
              case "id":
                     return By.id(controlProperty);
              case "name":
                     return By.name(controlProperty);
              case "linktext":
                     return By.linkText(controlProperty);
              case "partiallinktext":
                     return By.partialLinkText(controlProperty);
              case "classname":
                     return By.className(controlProperty);
              case "cssSelector":
                     return By.cssSelector(controlProperty);
              case "tagname":
                     return By.tagName(controlProperty);
              default:
                     return null;
              }
       }
       
       /**
       * This method uses the control name to retrieve and identify the element uniquely. 
        * The method uses the depth first search algorithm to iteratively check each frame or iframe for element 
        * if it's not available at the root node
       * @param controlName
       * @return WebElement
       */
       
       public WebElement getElement(String controlName) 
       {
              ObjectFactory factory = new ObjectFactory();
              factory.createObjectMap();
              ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
              UIControlObject obj = map.get(controlName);            
              By elementLocator = getLocator(obj.getControlProperty(), obj.getTypeOfProperty());
              List<WebElement> element = driver.findElements(elementLocator);
              if(element.size()==0)
              {
                     throw new  ExceptionHandling_NoSuchElementException(controlName);
              }
              else
              {
                     return element.get(0);
              }
              
              
       }
       
       public List<WebElement> getElementNotPresent(String controlName) 
       {
              
              ObjectFactory factory = new ObjectFactory();
              factory.createObjectMap();
              ObjectMap<String, UIControlObject> map = factory.getObjectMap();           
              UIControlObject obj = map.get(controlName);            
              By elementLocator = getLocator(obj.getControlProperty(), obj.getTypeOfProperty());
              List<WebElement> element = driver.findElements(elementLocator);
              if(element.size()==0)
              {
              }
              else
              {
                     return element;
              }
              return element;
              
       }
       
       public List<WebElement> getChildElements(WebElement parent, String childControls)
       {
              ObjectFactory factory = new ObjectFactory();
              factory.createObjectMap();
              ObjectMap<String, UIControlObject> map = factory.getObjectMap();
              UIControlObject obj = map.get(childControls);
              By locator = getLocator(obj.getControlProperty(), obj.getTypeOfProperty());
               List<WebElement> element = parent.findElements(locator);
              if(element.size()==0)
              {
            	  throw new  ExceptionHandling_NoSuchElementException(childControls);
              }
              else
              {
                     return element;
              }
       }
       
       public List<WebElement> getElements(String controlName)
       {
              ObjectFactory factory = new ObjectFactory();
              factory.createObjectMap();
              ObjectMap<String, UIControlObject> map = factory.getObjectMap();;
              UIControlObject obj = map.get(controlName);
              By locator = getLocator(obj.getControlProperty(), obj.getTypeOfProperty());
              List<WebElement> element = driver.findElements(locator);
              if(element.size()==0)
              {
            	  throw new  ExceptionHandling_NoSuchElementException(controlName);
              }
              else
              {
                     return element;
              }
              
       }
       public List<WebElement> getOptionalElements(String controlName)
       {
              ObjectFactory factory = new ObjectFactory();
              factory.createObjectMap();
              ObjectMap<String, UIControlObject> map = factory.getObjectMap();;
              UIControlObject obj = map.get(controlName);
              By locator = getLocator(obj.getControlProperty(), obj.getTypeOfProperty());
              List<WebElement> element = driver.findElements(locator);
              if(element.size()==0)
              {
            	  
              }
              else
              {
                     return element;
              }
			return element;
              
       }
       public Boolean isFramePresent()
       {
              if(driver.findElements(By.tagName("frame")).size()==0)
              {
                     return false;
              }
              else
              {
                     return true;
              }
              
        }
       
       public List<WebElement> findElementsByXpath(String elementLocator){
    	   List<WebElement> element = driver.findElements(By.xpath(elementLocator));
    	   return element;
       }
       
       public List<WebElement> verifyContainsChildElements(WebElement parent, String childControls)
       {
    	   ObjectFactory factory = new ObjectFactory();
    	   factory.createObjectMap();
    	   ObjectMap<String, UIControlObject> map = factory.getObjectMap();
    	   UIControlObject obj = map.get(childControls);
    	   By locator = getLocator(obj.getControlProperty(), obj.getTypeOfProperty());
    	   List<WebElement> element = parent.findElements(locator);     
    	   return element;
       }
       
       public WebElement getChildElement(WebElement parent, String childControls)
       {
              ObjectFactory factory = new ObjectFactory();
              factory.createObjectMap();
              ObjectMap<String, UIControlObject> map = factory.getObjectMap();
              UIControlObject obj = map.get(childControls);
              By locator = getLocator(obj.getControlProperty(), obj.getTypeOfProperty());
              List<WebElement> element = parent.findElements(locator);
              if(element.size()==0)
              {
            	  throw new ExceptionHandling_NoSuchElementException(childControls);
              }
              else
              {
            	  return element.get(0);
              }
              
       }
       public WebElement getOptionalChildElement(WebElement parent, String childControls)
       {
              ObjectFactory factory = new ObjectFactory();
              factory.createObjectMap();
              ObjectMap<String, UIControlObject> map = factory.getObjectMap();
              UIControlObject obj = map.get(childControls);
              By locator = getLocator(obj.getControlProperty(), obj.getTypeOfProperty());
              List<WebElement> element = parent.findElements(locator);
              if(element.size()==0)
              {
            	  
              }
              else
              {
            	  return element.get(0);
              }
              return element.get(0);
              
       }

}


