/**
 * 
 */
package com.pack.wrapper;


import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.pack.exceptions.ExceptionHandling_NoSuchWindowException;
import com.pack.utilities.WebElementFactory;


/**
 *
 * @author pankaj_sharma32
 *
 */
public class UserActions {
	

	protected WebElementFactory elementFactory;
	private  String parentWindow=null;
	private  Alert alert = null;
	private WebDriver driver;
	private int timer = 1;	

	public UserActions(WebDriver driver)
	{
		elementFactory = new WebElementFactory(driver);
		this.driver=driver;
	}

	
	public  void clickAlertOk()
	{
		alert = driver.switchTo().alert();
		alert.accept();
			
	}

	
	public  void clearTextBox(String controlName)
	{
		try {
			elementFactory.doMouseAction(controlName, "clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public  void clickOn(String controlName) 
	{
		try {
			elementFactory.doMouseAction(controlName, "click");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void submitOn(String controlName)
	{
		try {
			elementFactory.doMouseAction(controlName, "submit");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void tabOn(String controlName)
	{
		try {
			elementFactory.doMouseAction(controlName, "tab");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public  void clickandHold(String controlName)
	{
		try {
			elementFactory.doMouseAction(controlName, "clickandhold");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public  void doubleClick(String controlName)
	{
		try {
			elementFactory.doMouseAction(controlName, "doubleclick");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  void contextClick(String controlName)
	{
		try {
			elementFactory.doMouseAction(controlName, "contextclick");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public  void hoverOn(String controlName)
	{
		try {
			elementFactory.doMouseAction(controlName, "hover");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  void release(String controlName)
	{
		try {
			elementFactory.doMouseAction(controlName, "release");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public  void enterTextXpath(String controlName,String text)
	{
		try {
			elementFactory.enterTextXpath(controlName, text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void enterTextID(String controlName,String text)
	{
		try {
			elementFactory.enterTextID(controlName, text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
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

	
	public  void switchToParentWindow()
	{
		driver.switchTo().window(parentWindow);
	}

	public  boolean isChildWindowOpen(){
		
		Set<String> windows = driver.getWindowHandles();
		if(windows.size() == 1){
			return false;
		}
		return true;
	}

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

	
	public  String getTextFromsingleElement(String controlName) throws IOException
	{
	
		return elementFactory.getElementByXpath(controlName).getText();
		
		
	}
	
	public  String getTextForParticularElementFromListofElements(String controlName,int num) throws IOException
	{
	
		return (elementFactory.getElementsByXpath(controlName)).get(num).getText();
		
		
	}

	

	

	public  String getCssProperty(WebElement uiControl, String cssAttribute)
	{
		return uiControl.getCssValue(cssAttribute);
	}
	

	
	
	public String  getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}


	public void switchToDefaultContent()
	{
		driver.switchTo().defaultContent();
	}

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

	
	public  void SelectByText(String controlName,String text)
    {
           try {
			new Select(elementFactory.getElementByXpath(controlName)).selectByVisibleText(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    }

}
	

