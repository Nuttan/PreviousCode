package wrapper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.testng.Assert;

import testData.TestDataFactory;
import testData.TestDataMap;
import utilities.CMSWebElementFactory;
import utilities.DynamicWait;
import utilities.ScreenShots;


/**
*
* @author Phanendra_k01
*
*/
public class CMSUserActions 
{
	protected CMSWebElementFactory element;
	protected DynamicWait cmsDynamicWait;
	private RemoteWebDriver driver;
	private  Alert alert = null;
	public  TestDataMap<String, String> dataMap;
	ScreenShots screenshots;
	
	public CMSUserActions(RemoteWebDriver driver)
	{
		element = new CMSWebElementFactory(driver);
		cmsDynamicWait=new DynamicWait(driver);
		this.driver=driver;
		TestDataFactory dataFactory = new TestDataFactory();
		dataMap = dataFactory.createCMSTestDataMap();
		screenshots=new ScreenShots(driver);
	}
	
	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to click on webelement.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void clickOn(String controlname) {
		element.dynamicWait(controlname,65);
		element.doMouseAction(controlname, "click");
	}
	
	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to double click on webelement.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void doubleClickOn(String controlname) {
		element.dynamicWait(controlname,60);
		element.doMouseAction(controlname, "doubleclick");
	}
	
	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to hover on webelement.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void hoverOn(String controlname) {
		element.dynamicWait(controlname,30);
		element.doMouseAction(controlname, "hover");
	}
	
	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to enter text into text box.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void enterText(String controlname, String text) {
		element.dynamicWait(controlname,40);
		String inputText=dataMap.get(text);
		element.enterText(controlname, inputText);
	}

	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used switch the focus to Parent window.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void switchToParent() {
		driver.switchTo().parentFrame();
	}

	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to clear text in text boxes.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void clearText(String controlname) {
		element.dynamicWait(controlname,30);
		element.clearTextBox(controlname);
	}

	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to select a value from dropdown list.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void selectDropdownValue(String controlName, int value) {
		element.selectDropdownValue(controlName, value);
	}

	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to select value from multi selectbox.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void selectFromSourecMultiselectBox(String controlName,
			String category) {
		element.selectFromSelectBox(controlName, category);
	}
	/**
	 * Author Name                       : Phanendra
	 * Date of Preparation               : 23/07/2014
	 * Date of Modified                  : 
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to switch to child frame inside a page
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	public void switchToFrame(String frameName) {
		element.dynamicWait(frameName,30);
		WebElement frame = element.getElement(frameName);
		element.dynamicWait(frameName,20);
		driver.switchTo().frame(frame);
		
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//  new FluentWait<WebDriver>(driver)
		//  .withTimeout(120, TimeUnit.SECONDS)
		//  .pollingEvery(2,TimeUnit.MILLISECONDS)
		//  .ignoring(NoSuchElementException.class);
	}
	
	/**
	 * Author Name                       : Phanendra
	 * Date of Preparation               : 23/07/2014
	 * Date of Modified                  : 
	 * Methods Called                    : 
	 * Purpose of Method                 : The method is used to switch back from Child frame to parent
	 * Dependencies	                     : --
	 * Reviewed By                       : --
	 * @param controlName
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to click on OK button of alert messages.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public void clickAlertOk() {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	/**
	  Author Name                       : phanendra_k01 
	  Date of Preparation               : 11/8/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to click on a control element using sikuli
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	public void clickOnElementUsingImage(String uiControlImage) 
	{
		try{			
			ScreenRegion s = new DesktopScreenRegion();
			Target target = new ImageTarget(new File(".//UIControlImages//"+uiControlImage));
			ScreenRegion r = s.find(target);
			ScreenLocation location =r.getCenter();
			int x =location.getX();
			int y = location.getY();
			Robot robot = new Robot();
			robot.mouseMove(x, y);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}
		catch(NullPointerException | AWTException e)
		{
			screenshots.takeScreenShots();
			Assert.fail("Not able to find Image on Screen.");
		}
	}
	
	public  void clickandHold(String controlName)
	{
		element.doMouseAction(controlName, "clickandhold");
		
	}
}
