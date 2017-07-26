package verification;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.testng.Assert;
import org.testng.Reporter;

import com.android.ddmlib.AdbCommandRejectedException;

import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;
import resources.VerifyImage;
import testData.TestDataFactory;
import testData.TestDataMap;
import utilities.Assertions;
import utilities.CMSWebElementFactory;
import utilities.DynamicWait;
import utilities.ScreenShots;
import utilities.WebElementFactory;
import wrapper.CMSUserActions;
import wrapper.UserActions;
import businessFunctions.CMSBusinessFunctions;

public class CMSVerify {

	private CMSWebElementFactory cmsElementFactory;
	private CMSUserActions cmsUserActions;
	ScreenShots screenshots;
	public  Alert alert = null;
	public  TestDataMap<String, String> dataMap;
	protected TestDataFactory dataFactory;
	protected RemoteWebDriver driver;
	protected DynamicWait dynamicWait;
	protected Assertions assertions;
	//protected CMSBusinessFunctions cmsBusinessFunctions;
	
	public CMSVerify(RemoteWebDriver driver) {
		
		cmsElementFactory = new CMSWebElementFactory(driver);
		cmsUserActions=new CMSUserActions(driver);
		dataFactory = new TestDataFactory();
		dataMap = dataFactory.createCMSTestDataMap();
		dynamicWait = new DynamicWait(driver);
		screenshots=new ScreenShots(driver);
		assertions = new Assertions(driver);
		this.driver = driver;
	}
	
	public void verifyText(String controlName,String expectedText)
	{
		cmsElementFactory.dynamicWait(controlName, 60);
		WebElement element = cmsElementFactory.getElement(controlName);
		if(!element.getText().trim().contains(dataMap.get(expectedText).trim()))
		{
			screenshots.takeScreenShots();
			Assert.fail("Expected value is not same as actual value, Expected "+dataMap.get(expectedText).trim()+" Actual "+element.getText().trim());
		}
		
	}
	
	public  void isElementDisplayed(String controlName)
	{
		cmsElementFactory.dynamicWait(controlName, 30);
		WebElement element = cmsElementFactory.getElement(controlName);
		if(!element.isDisplayed())
		{
			screenshots.takeScreenShots();
			Assert.fail(controlName+ " is not displayed on the page");
		}
		
	}
	
	public  void isElementNotPresent(String controlName)
	{
		List<WebElement> elements = cmsElementFactory.getElementNotPresent(controlName);
		if(elements.size()>0)
		{
			screenshots.takeScreenShots();
			Assert.fail(controlName+" is present on the page");				
			}			
	}
	
	public  void isTextPresent(String controlName, String expectedData) throws InterruptedException, AdbCommandRejectedException 
	{
		
		WebElement labelElement =cmsElementFactory.getElement(controlName);		
		String actual=labelElement.getText().trim();
		actual=actual.replaceAll("[^\\p{ASCII}]", " ");
		actual=actual.replace(".0", "");
		actual=actual.replaceAll(" ", "");
		String expected =dataMap.get(controlName).toString().trim();
		expected=expected.replaceAll("[^\\p{ASCII}]", " ");
		expected = expected.replaceAll(" ", "");
		assertions.str_Assertequals(expected,actual);
		
	}
	
	public void verifySavedAssetOnUI(String controlName,String Expected)
	{
		int count=0;
		List<WebElement> elements=cmsElementFactory.getElements(controlName);
		for(int i=0;i<elements.size();i++)
		{
			if(elements.get(i).getText().trim().equals(dataMap.get(Expected).trim()))
			{
				System.out.println(elements.get(i));
				count=count++;
			}
		}
		System.out.println("title "+count);
		if(count!=1)
		{
		screenshots.takeScreenShots();
		Assert.fail("The element "+dataMap.get(Expected)+ "is not available on the page");
		}
	}
	
	public void verifyAssetSaved(){
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cmsUserActions.switchToDefaultContent();
		cmsUserActions.switchToFrame("Main_Frame");
		List<WebElement> element = cmsElementFactory.getElementNotPresent("ErrorMessage");
		if(element.size() > 0){
			screenshots.takeScreenShots();
			Assert.fail("Asset was not saved, Due to "+element.get(0).getText()+" error");			
		}
	}
	
	public void verifyUpdatedData(String controlName, String displayedControlName)
	{
		WebElement labelElement =cmsElementFactory.getElement(displayedControlName);	
		String cmsData = dataMap.get(controlName);
		System.out.println("cmsData"+cmsData);
		String uiData = labelElement.getText().trim();
		System.out.println("uiData"+uiData);
		if(!(cmsData.equals(uiData)))
		{
			screenshots.takeScreenShots();
			Assert.fail("The "+cmsData+"is not being reflected in the UI");
		}
	}
	
	public void verifyEnabledElement(String controlName)
	{
		cmsElementFactory.dynamicWait(controlName, 30);
		List<WebElement> labelElements =cmsElementFactory.getElements(controlName);
		for(WebElement labelElement:labelElements)
		{
			System.out.println(labelElement.isEnabled());
		}
		
		
	}
}
