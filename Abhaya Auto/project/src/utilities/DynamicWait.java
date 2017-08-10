package utilities;

import java.util.concurrent.TimeUnit;

import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import exceptions.ExceptionHandling_NoSuchElementException;
import exceptions.ExceptionHandling_TimeoutException;


public class DynamicWait {
	protected WebElementFactory elemFactory;
	protected  RemoteWebDriver driver;
	
	public DynamicWait(RemoteWebDriver driver)
	{
		elemFactory=new WebElementFactory(driver);
		this.driver=driver;
	}	
	
	public  void cmsWaittillpageloads(int num)
	  {
		int milisecs = num*1000;
		try {
			Thread.sleep(milisecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	 driver=DriverFactory.getRemoteDriver();
//	 driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
//	 new FluentWait<WebDriver>(driver)
//	 .withTimeout(240, TimeUnit.SECONDS)
//	 .pollingEvery(2,TimeUnit.MILLISECONDS);
	  }
	
 
	/**
  Author Name                       : Vinusha Tanuku
  Date of Preparation               : 14/05/2014
  Date of Modified                  : 01/7/2014
  Methods Called                    : ---
  Purpose of Method                 : Waits for max for 40 secs till Element is Clickable
  Dependencies	                    : --
  Reviewed By                       : --
*/
  public  void waitforElementtobeClickable(String controlName)
  {
	  ObjectFactory factory = new ObjectFactory();
	  factory.createObjectMap();
	  ObjectMap<String, UIControlObject> map = factory.getObjectMap();;
	  UIControlObject obj = map.get(controlName);
	  By by=elemFactory.getLocator(obj.getControlProperty().toString(),obj.getTypeOfProperty());
	  new FluentWait<WebDriver>(driver)
	            .withTimeout(40, TimeUnit.SECONDS)
	            .pollingEvery(5,TimeUnit.MILLISECONDS)
	            .ignoring(NoSuchElementException.class)	
	            .until(ExpectedConditions.elementToBeClickable(by));
	 
   }
  
  /**
  Author Name                       : Vinusha Tanuku
  Date of Preparation               : 14/05/2014
  Date of Modified                  : 01/07/2014
  Methods Called                    : ---
  Purpose of Method                 : Waits for max for 40 seconds until elementToBeSelected
  Dependencies	                    : --
  Reviewed By                       : --
*/
  
  public  void waitforElementToBeSelected(String controlName)
  {
	  ObjectFactory factory = new ObjectFactory();
	  factory.createObjectMap();
	  ObjectMap<String, UIControlObject> map = factory.getObjectMap();;
	  UIControlObject obj = map.get(controlName);
	  By by=elemFactory.getLocator(obj.getControlProperty().toString(),obj.getTypeOfProperty());
	  new FluentWait<WebDriver>(driver)
	        .withTimeout(40, TimeUnit.SECONDS)
	        .pollingEvery(5,TimeUnit.MILLISECONDS)
	        .ignoring(NoSuchElementException.class)	
	        .until(ExpectedConditions.elementToBeSelected(by));
		
		     
   }
  /**
  Author Name                       : Vinusha Tanuku
  Date of Preparation               : 14/05/2014
  Date of Modified                  : 01/07/2014
  Methods Called                    : ---
  Purpose of Method                 : Waits for max for 40 seconds until frameToBeAvailableAndSwitchToIt
  Dependencies	                    : --
  Reviewed By                       : --
*/
  
  public  void waitforFrameToBeAvailableAndSwitchToIt(String controlName)
  {
	  ObjectFactory factory = new ObjectFactory();
	  factory.createObjectMap();
	  ObjectMap<String, UIControlObject> map = factory.getObjectMap();;
	  UIControlObject obj = map.get(controlName);
	  By by=elemFactory.getLocator(obj.getControlProperty().toString(),obj.getTypeOfProperty());
	  new FluentWait<WebDriver>(driver)
	                .withTimeout(40, TimeUnit.SECONDS)
	                .pollingEvery(5,TimeUnit.MILLISECONDS)
	                .ignoring(NoSuchFrameException.class)	
	                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
		     
   }
  /** 
  Author Name                       : Vinusha Tanuku
  Date of Preparation               : 14/05/2014
  Date of Modified                  : 01/07/2014
  Methods Called                    : ---
  Purpose of Method                 : Waits for max for 40 seconds until presenceOfElementLocated
  Dependencies	                    : --
  Reviewed By                       : --
*/
  
  public  void waitforPresenceOfElementLocated(String controlName)
  {
	  ObjectFactory factory = new ObjectFactory();
	  factory.createObjectMap();
	  ObjectMap<String, UIControlObject> map = factory.getObjectMap();;
	  UIControlObject obj = map.get(controlName);
	  By by=elemFactory.getLocator(obj.getControlProperty().toString(),obj.getTypeOfProperty());
	  new FluentWait<WebDriver>(driver)
	                .withTimeout(40, TimeUnit.SECONDS)
	                .pollingEvery(5,TimeUnit.MILLISECONDS)
	                .ignoring( NoSuchElementException.class, StaleElementReferenceException.class)	
	                .until(ExpectedConditions.presenceOfElementLocated(by));
		     
   }
 
  /** 
  Author Name                       : Vinusha Tanuku
  Date of Preparation               : 14/05/2014
  Date of Modified                  : 01/07/2014
  Methods Called                    : ---
  Purpose of Method                 : Waits for max for 40 seconds until alertIsPresent
  Dependencies	                    : --
  Reviewed By                       : --
*/ 
  public  void waitforAlertIsPresent()
  {
	 new FluentWait<WebDriver>(driver)
	    .withTimeout(40, TimeUnit.SECONDS)
	    .pollingEvery(5,TimeUnit.MILLISECONDS)
	    .ignoring(NoSuchElementException.class)	
	    .until(ExpectedConditions.alertIsPresent());
	 
		     
   }
  /**
  Author Name                       : Vinusha Tanuku
  Date of Preparation               : 14/05/2014
  Date of Modified                  : 01/07/2014
  Methods Called                    : ---
  Purpose of Method                 : Waits for max for 40 seconds until visibilityOfElementLocated
  Dependencies	                    : --
  Reviewed By                       : --
*/
  public  void waitforvisibilityOfElementLocated(String controlName)
  {
	  ObjectFactory factory = new ObjectFactory();
	  factory.createObjectMap();
	  ObjectMap<String, UIControlObject> map = factory.getObjectMap();;
	  UIControlObject obj = map.get(controlName);
	  By by=elemFactory.getLocator(obj.getControlProperty().toString(),obj.getTypeOfProperty());
	  try
	  {
	  new FluentWait<WebDriver>(driver)
	                .withTimeout(60, TimeUnit.SECONDS)
	                .pollingEvery(5,TimeUnit.MILLISECONDS)
	                .ignoring(NoSuchElementException.class)	
	                .until(ExpectedConditions.visibilityOfElementLocated(by));
	  }
	  catch(TimeoutException time)
	  {
		  throw new ExceptionHandling_TimeoutException(controlName);
	  }
		     
   }
  /** 
  Author Name                       : Vinusha Tanuku
  Date of Preparation               : 14/05/2014
  Date of Modified                  : --
  Methods Called                    : ---
  Purpose of Method                 : Waits for max for 60 seconds until Page Loads completely
  Dependencies	                    : --
  Reviewed By                       : --
*/
  public  void waittillpageloads()
  {
	  if(!(driver.getCapabilities().getBrowserName().equalsIgnoreCase("Internet Explorer")))
	  {
	  new FluentWait<WebDriver>(driver)
	  .withTimeout(300, TimeUnit.SECONDS)
	  .pollingEvery(5,TimeUnit.MILLISECONDS)
	  .until(new com.google.common.base.Function<WebDriver, Boolean>() {
		  public Boolean apply(WebDriver driver) {
	     return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");}});
	  }
	  else
	  {
		  try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  }
  
  /** 
  Author Name                       : Sowmya Mohanan
  Date of Preparation               : 18/07/2014
  Date of Modified                  : --
  Methods Called                    : ---
  Purpose of Method                 : Waits util the attribute value matches as expected
  Dependencies	                    : --
  Reviewed By                       : --
*/
  public  void waitUtillAttributeChanges(final WebElement element){
	  WebDriverWait wait = new WebDriverWait(driver,10);

	  wait.until(new ExpectedCondition<Boolean>() {
	              public Boolean apply(WebDriver driver) {
	                           String active = element.getAttribute("class");
	                           if(active.contains("active")) 
	                        	   return true;
	                           else
	                              return false;
	                      }
	     });
  }
  
  /** 
  Author Name                       : Phanendra
  Date of Preparation               : 15/09/2014
  Date of Modified                  : --
  Methods Called                    : ---
  Purpose of Method                 : Static wait for webdriver to focus on child window.
  Dependencies	                    : --
  Reviewed By                       : --
*/
  
  public void waitForChildWindows()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
  /** 
  Author Name                       : Phanendra
  Date of Preparation               : 18/07/2014
  Date of Modified                  : --
  Methods Called                    : ---
  Purpose of Method                 : Waits util the invisibility of the element
  Dependencies	                    : --
  Reviewed By                       : --
 **/
  public void waitUntillProgressCompletes(String controlName)
  {
	  long timeoutInSeconds = 120;
	    new WebDriverWait(driver, timeoutInSeconds)
	  .until(ExpectedConditions.invisibilityOfElementLocated(By.className(controlName)));
  }
   
}
  
  

