/**
 * 
 */
package wrapper;


import java.util.List;
import java.util.Set;

import objectRepository.ObjectFactory;
import objectRepository.UIControlObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import exceptions.ExceptionHandling_NoSuchWindowException;
import utilities.WebElementFactory;


/**
 *
 * @author pankaj_sharma32
 *
 */
public class UserActions {
	

	protected WebElementFactory elementFactory;
	private  String parentWindow=null;
	private  Alert alert = null;
	private RemoteWebDriver driver;
	private int timer = 1;	

	public UserActions(RemoteWebDriver driver)
	{
		elementFactory = new WebElementFactory(driver);
		this.driver=driver;
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to click on OK in alert.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	public  void clickAlertOk()
	{
		alert = driver.switchTo().alert();
		alert.accept();
			
	}
	
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 17/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to clear the text box.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	public  void clearTextBox(String controlName)
	{
		elementFactory.doMouseAction(controlName, "clear");
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to Click on a webElement
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void clickOn(String controlName)
	{
		elementFactory.doMouseAction(controlName, "click");
	}
	
	public  void submitOn(String controlName)
	{
		elementFactory.doMouseAction(controlName, "submit");
	}
	
	public  void tabOn(String controlName)
	{
		elementFactory.doMouseAction(controlName, "tab");
	}
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to Click and hold a webElement
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void clickandHold(String controlName)
	{
		elementFactory.doMouseAction(controlName, "clickandhold");
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to Double Click on a webElement
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void doubleClick(String controlName)
	{
		elementFactory.doMouseAction(controlName, "doubleclick");
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to perform Right Click mouse action over an element
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void contextClick(String controlName)
	{
		elementFactory.doMouseAction(controlName, "contextclick");
	}
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to hover on a HTML element
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void hoverOn(String controlName)
	{
		elementFactory.doMouseAction(controlName, "hover");
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to release the mouse on given HTML element
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void release(String controlName)
	{
		elementFactory.doMouseAction(controlName, "release");
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to enter text on a html Element like textbox
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void enterText(String controlName,String text)
	{
		elementFactory.enterText(controlName, text);
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to switch to child window
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void switchToChildWindow()
	{
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		Set<String> windows = driver.getWindowHandles();
		if(windows.size()!= 1)
		{
			parentWindow = driver.getWindowHandle();
			windows.remove(parentWindow);
			driver.switchTo().window(windows.iterator().next());
			driver.manage().window().maximize();
		}
		else
		{
			if(timer==1)
			{
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timer++;
			switchToChildWindow();
			}
			else
			{
				throw new ExceptionHandling_NoSuchWindowException();
			}
		}
		
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to switch back to parent window after working on child wiondow
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void switchToParentWindow()
	{
		driver.switchTo().window(parentWindow);
	}
	
	/**
	 * Author Name                       : Sowmya Mohanan
	 * Date of Preparation               : 18/07/2014
	 * Date of Modified                  : --
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to check if the child window is still open
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	public  boolean isChildWindowOpen(){
		
		Set<String> windows = driver.getWindowHandles();
		if(windows.size() == 1){
			return false;
		}
		return true;
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to close Child Window and switch back to parent window
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  void closeChildWindow()
	{
		if(parentWindow==null)
		{
			switchToChildWindow();
			driver.close();
			switchToParentWindow();
		}
		else
		{
			driver.quit();
			switchToParentWindow();
		}
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to get a List of HTML Elements of same type or having same properties
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  List<WebElement> getElements(String controlName)
	{
		return elementFactory.getElements(controlName);
	}
	
	public  WebElement getElement(String controlName)
	{
		return elementFactory.getElement(controlName);
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to get text from a given HTML element 
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  String getText(String controlName)
	{
		return elementFactory.getElement(controlName).getText();
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to get CSS property value for a given HTML element
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  String getCssProperty(String controlName, String cssAttribute)
	{
		 return elementFactory.getElement(controlName).getCssValue(cssAttribute);
		
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to get CSS property value for a given HTML element
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  String getCssProperty(WebElement uiControl, String cssAttribute)
	{
		return uiControl.getCssValue(cssAttribute);
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to get HTML attribute from a given HTML element
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	
	public  String getHtmlAttribute(String controlName, String htmlAttribute)
	{
		return elementFactory.getElement(controlName).getAttribute(htmlAttribute);
	}
	
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to get UIControlObject that has the properties given in UIMap.xlsx
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	public UIControlObject getUIControlObject(String controlName)
	{
		ObjectFactory factory = new ObjectFactory();
		factory.createObjectMap();
		return factory.getObjectMap().get(controlName);
	}
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to get Current Url of the webpage
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	public String  getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to switch to child frame inside a page
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	public void switchToFrame(String frameName)
	{
		WebElement frame = elementFactory.getElement(frameName);
		driver.switchTo().frame(frame);
	}
	/**
	 * Author Name                       : Pankaj Sharma
	 * Date of Preparation               : 26/05/2014
	 * Date of Modified                  : 05/06/2014
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to switch back from Child frame to parent
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	public void switchToDefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Author Name                       : Phanendra
	 * Date of Preparation               : 15/09/2014
	 * Date of Modified                  : 
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to close Child Window and switch back to parent window depending upon the browser.
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 **/
	public void closeChildWindowBrowserDependent() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if (browserName.contains("internet explorer")) {
			if (parentWindow == null) {
				switchToChildWindow();
				driver.close();
				switchToParentWindow();
			} else {
				driver.close();
				switchToParentWindow();
			}
		} else {

			driver.close();
			switchToParentWindow();
		}
	}
	/**
	 * Author Name                       : Aishwarya
	 * Date of Preparation               : 25/03/2015
	 * Date of Modified                  : 
	 * Methods Called                    : 
	 * Purpose of Method                 : 
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 **/
	
	public  void SelectByText(String controlName,String text)
    {
           new Select(elementFactory.getElement(controlName)).selectByVisibleText(text);;
    }

}
	

