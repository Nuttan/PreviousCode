package utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import properties.LoadAppConfig;

import com.android.ddmlib.AdbCommandRejectedException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.ExtentManager;



public class Assertions {
   
	private ScreenShots screenshots;
	RemoteWebDriver driver = null;
	ExtentReports extent;
	ExtentTest test;
	ExtentReports extentreport;
    LoadAppConfig appConfig=new LoadAppConfig();

	
	public Assertions(RemoteWebDriver driver)
	{
	
		screenshots=new ScreenShots(driver);
	}
	
  public  void str_Assertequals(String str_actual,String str_expected){
	  try
	  {
		  //Ignores Case 
		Assert.assertTrue(str_actual.equalsIgnoreCase(str_expected));	
	  }
	  catch(AssertionError e)
	  {
		  screenshots.takeScreenShots();
		  //Assert.fail("Test Failed since Expected value is not equal to actual.Expected value:"+str_expected+" Actual value:"+str_actual);
		  
	  }
  }
	
 public  void int_Assertequals(int iactual,int iexpected) 
  {
	 try
	 {
		Assert.assertEquals(iactual,iexpected);	
	 }
	 catch(AssertionError e)
	 {
		 screenshots.takeScreenShots();
		 Assert.fail("Test Failed since Expected value is not equal to actual.Expected value:"+iexpected+" Actual value:"+iactual);
	 }
		 
  }
 
 public  void Assertequals_positionleft_cssvalue(String position)
 {
	 try
	 {
		 Assert.assertEquals(position,"left");
	 }
	 catch(AssertionError e)
	 {
		 screenshots.takeScreenShots();
		 Assert.fail("Test Failed since Position of the Element is not on left");
	 }
	 
	 
 }
 

public  void Assert_positionright_coordinates(WebElement elementleft,WebElement elementright,String relativeControlName,String controlName)
 {
	try
	{
		Assert.assertTrue((elementleft.getLocation().x)<(elementright.getLocation().x));	 
	}
	catch(AssertionError e)
	 {
		 screenshots.takeScreenShots();
		 Assert.fail("Test Failed since the Element "+controlName+" is not aligned to right side of the page");
	 }
 }
 
 
public  void Assert_positionleft_coordinates(WebElement elementleft,WebElement elementright,String relativeControlName,String controlName)
{
	try
	{
		Assert.assertTrue((elementleft.getLocation().x)<(elementright.getLocation().x));	 
	}
	catch(AssertionError e)
	 {
		 screenshots.takeScreenShots();
		 Assert.fail("Test Failed since Position of the Element "+ relativeControlName +" is not on left to the Position of the element "+controlName);
	 }
}

public  void Assert_positionequal_coordinates(WebElement elementabove,WebElement elementbelow, String relativeControlName,String controlName)
{
	try
	{
		Assert.assertEquals((elementabove.getLocation().x),(elementbelow.getLocation().x));	 
	}
	catch(AssertionError e)
	 {
		 screenshots.takeScreenShots();
		 Assert.fail("Test Failed since the Element "+ controlName +" is not aligned to left side of the page");
	 }
}
public void Assert_positionabove_coordinates(WebElement elementabove,WebElement elementbelow, String relativeControlName,String controlName)
{
	try
	{
		Assert.assertTrue((elementabove.getLocation().y)<(elementbelow.getLocation().y));	
	}
	catch(AssertionError e)
	{
		screenshots.takeScreenShots();
		Assert.fail("Test Failed since the Element "+ controlName +" is not placed in correct order");
	}
}

public void assertNotNull(WebElement element){
	try{
		Assert.assertNotEquals(element.getText(), "");
	}catch(AssertionError e){
		screenshots.takeScreenShots();
		Assert.fail("Test Failed since the Element "+element+" does not contain any value");		
	}
}

   
}
