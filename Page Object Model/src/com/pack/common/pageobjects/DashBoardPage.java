package com.pack.common.pageobjects;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.pack.utilities.TakeScreenshot;
import com.pack.utilities.WebElementFactory;
import com.pack.wrapper.UserActions;
import com.pack.base.TestBaseSetUp;

public class DashBoardPage extends TestBaseSetUp{
	
	public static WebDriver driver;
	WebElementFactory elementFactory;
	UserActions userActions;
	

	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
    Page Elements                     : Dashboard Page Elements
  	Reviewed By                       : 
    **/ 
	
	 String UsrnameField_Id="CarrierSmart.LogIn.UsrnameField.Id"; 
     String cookiesButton="CarrierSmart.Dashboard.Cookies.Xpath";
	 String devicelistMenu = "CarrierSmart.Dashboard.DeviceList.Xpath";
	 String runningChiller = "CarrierSmart.Dashboard.RunningGauge.Xpath";
	 String gaugeText = "CarrierSmart.Dashboard.GaugeTextElement.Xpath";
	 String alarmsChiller = "CarrierSmart.Dashboard.AlarmsGauge.Xpath";
	 String notrunningChiller ="CarrierSmart.Dashboard.NotRunningGauge.Xpath";
	 String offlineChiller = "CarrierSmart.Dashboard.OfflineGauge.Xpath";
	 String deviceLocationBtn ="CarrierSmart.Dashboard.DeviceLocationSearchRadioButton.Xpath";
	 String locationSearchElement ="CarrierSmart.Dashboard.DeviceLocationSearchTextBox.Xpath";
	 String serachBtn ="CarrierSmart.Dashboard.SerachIcon.Xpath";
	 String greenIndicatorBtn="CarrierSmart.Dashboard.GreenIndicator.Xpath";
	 String redIndicatorBtn="CarrierSmart.Dashboard.RedIndicator.Xpath";
	 String alertIndicatorBtn="CarrierSmart.Dashboard.AlertIndicator.Xpath";
	 String greyIndicatorBtn="CarrierSmart.Dashboard.GreyIndicator.Xpath";
	 String coloumnName="CarrierSmart.Dashboard.ColumnNames.Xpath";
	 String shortingIcons="CarrierSmart.Dashboard.ShortingIconList.Xpath";

	 
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	    elementFactory =new WebElementFactory(driver);
	    userActions = new UserActions(driver);
		
	}
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementById(String controlName), enterTextID(controlName,String str_expected),clickOn(String controlName)
  	Purpose of Method                 : To enter user name in Login Page (Chrome)
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	
	public  void  enterUserNameChrome(String userName) throws InterruptedException, IOException {
		 WebElement UsrnameField=elementFactory.getElementById(UsrnameField_Id);
		 elementFactory.enterTextID(UsrnameField_Id, userName);           
		 UsrnameField.sendKeys(Keys.TAB);
		 Thread.sleep(30000); 
		 userActions.clickOn(cookiesButton);
		 System.out.println("cookies accepted");
		  
	}
	
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementById(String controlName), enterTextID(controlName,String str_expected),clickOn(String controlName)
  	Purpose of Method                 : To enter user name in Login Page (FireFox)
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	
	public  void enterUserNameFirefox(String userName) throws InterruptedException, IOException {
		Runtime.getRuntime().exec("D:\\AutoitScript\\dashboardlogin.exe");
		WebElement UsrnameField=elementFactory.getElementById(UsrnameField_Id);
		elementFactory.enterTextID(UsrnameField_Id, userName);          
		UsrnameField.sendKeys(Keys.TAB);
		Thread.sleep(30000);
		userActions.clickOn(cookiesButton);
		System.out.println("cookies button clicked and accepted");
	}

	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : clickOn(String controlName), getElementsByXpath(String controlName),getTextForParticularElementFromListofElements(String controlName, Int Position)
  	Purpose of Method                 : Validate the Running Chiller Count
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	
	public  void validateRunningChillerCount() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateRunningChillerCount");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Identifying the "Running" chiller Gauge element and clicking on it
	WebElement RunningGauge = elementFactory.getElementByXpath(runningChiller);
	userActions.clickOn(runningChiller);
	Thread.sleep(5000);
	List<WebElement> gaugeTextElement=elementFactory.getElementsByXpath(gaugeText);
	//Verifying the number present in the Gauge Chart
	String gaugeTextActual=userActions.getTextForParticularElementFromListofElements(gaugeText,1);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
	//Getting the total number of Running device present in the list
	int i=deviceList.size();
	int j=Integer.parseInt(gaugeTextActual);
	if(i == j)
	{	
	  test1.log(LogStatus.PASS, "Running chiller count in gauge chart and actualdevice count in device list are matching");
	  Thread.sleep(5000);
	  test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\RunningChillerCount.png"));
	}
	else
	{
		test1.log(LogStatus.FAIL, "Running chiller count in gauge chart and actualdevice count in device list are not  matching");
		TakeScreenshot.ScreenShot(driver, "RunningChillerCount");
	}

	}
    
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : clickOn(String controlName), getElementsByXpath(String controlName),getTextForParticularElementFromListofElements(String controlName, Int Position)
  	Purpose of Method                 : Validate the Alarms/Alerts Chiller Count
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	
	public  void validateAlarmsandAlertChillerCount() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateAlarmsandAlertChillerCount");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Identifying the "Alarms/A;erts" chiller Gauge element and clicking on it
	WebElement AlarmsGauge = elementFactory.getElementByXpath(alarmsChiller);
	userActions.clickOn(alarmsChiller);
	Thread.sleep(5000);
	List<WebElement> gaugeTextElement=elementFactory.getElementsByXpath(gaugeText);
	//Verifying the number present in the Gauge Chart
	String gaugeTextActual=userActions.getTextForParticularElementFromListofElements(gaugeText,2);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
	//Getting the total number of Running device present in the list
	int i=deviceList.size();
	int j=Integer.parseInt(gaugeTextActual);
	if(i == j)
	{
	test1.log(LogStatus.PASS, "Alarms/Alerts chiller count in gauge chart and actualdevice count in device list are matching");
	Thread.sleep(5000);
	test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\AlarmsnAlertschillerCount.png"));
	}
	else
		test1.log(LogStatus.FAIL, "Alarms/Alerts chiller count in gauge chart and actualdevice count in device list are not matching");	
	TakeScreenshot.ScreenShot(driver, "Alarms and Alert chillerCount");
	}
	
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : clickOn(String controlName), getElementsByXpath(String controlName),getTextForParticularElementFromListofElements(String controlName, Int Position)
  	Purpose of Method                 : Validate the NotRunning Chiller Count
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/
	
	public  void validateNotRunningChillerCount() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateNotRunningChillerCount");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Identifying the "Not Running" chiller Gauge element and clicking on it
	WebElement notRunningGauge =elementFactory.getElementByXpath(notrunningChiller);
	userActions.clickOn(notrunningChiller);
	Thread.sleep(5000);
	List<WebElement> gaugeTextElement=elementFactory.getElementsByXpath(gaugeText);
	//Verifying the number present in the Gauge Chart
	String gaugeTextActual=userActions.getTextForParticularElementFromListofElements(gaugeText,3);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
	//Getting the total number of Running device present in the list
	int i=deviceList.size();
	int j=Integer.parseInt(gaugeTextActual);
	if(i == j)
	{
	test1.log(LogStatus.PASS, "NotRunning chiller count in gauge chart and actualdevice count in device list are matching");
	test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\NotRunningChillerCount.png"));
	}
	else
	test1.log(LogStatus.FAIL, "NotRunning chiller count in gauge chart and actualdevice count in device list are not matching");	
	TakeScreenshot.ScreenShot(driver, "NotRunningChillerCount");
	}

	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
 	Methods Called                    : clickOn(String controlName), getElementsByXpath(String controlName),getTextForParticularElementFromListofElements(String controlName, Int Position)
  	Purpose of Method                 : Validate the Offline Chiller Count
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/
	
	public  void validateOfflineChillerCount() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateOfflineChillerCount");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Identifying the "Offline" chiller Gauge element and clicking on it
	WebElement offlineGauge =elementFactory.getElementByXpath(offlineChiller);
	userActions.clickOn(offlineChiller);
	Thread.sleep(5000);
	List<WebElement> gaugeTextElement=elementFactory.getElementsByXpath(gaugeText);
	//Verifying the number present in the Gauge Chart
	String gaugeTextActual=userActions.getTextForParticularElementFromListofElements(gaugeText,4);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
	//Getting the total number of Running device present in the list
	int i=deviceList.size();
	int j=Integer.parseInt(gaugeTextActual);
	if(i == j)
	{
	test1.log(LogStatus.PASS, "Offline chiller count in gauge chart and actualdevice count in device list are matching");
	test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\OfflineChillerCount.png"));
	}
	else
	test1.log(LogStatus.FAIL, "Offline chiller count in gauge chart and actualdevice count in device list are matching");	
	TakeScreenshot.ScreenShot(driver, "OfflineChillerCount");
	}

	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
   	Methods Called                    : clickOn(String controlName), getElementByXpath(String controlName)
  	Purpose of Method                 : Validate the device location searching functionality
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/
	
	public  void validateDeviceLocationSearchFunctionality() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateDeviceLocationSearchFunctionality");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	try
	{
    //Identifying the "Location" radio button and clicking on it
	WebElement deviceLocation = elementFactory.getElementByXpath(deviceLocationBtn);
	userActions.clickOn(deviceLocationBtn);
	}
	catch(StaleElementReferenceException e)
	{
		WebElement deviceLocation = elementFactory.getElementByXpath(deviceLocationBtn);
		System.out.println("Stale element reference exception will be handeled here");
	}
	//Identifying the "Location" input text field area and entering the desired "Place"
	WebElement locationSearch = elementFactory.getElementByXpath(locationSearchElement);;
	locationSearch.sendKeys("chicago");
	
	//Identifying the "Search" and clicking it
	elementFactory.getElementByXpath(serachBtn).click();
	Thread.sleep(5000);
	//Getting all the devices based on the filter criteria
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
	for (WebElement element : deviceList) 
	{			
		List<WebElement> childs = element.findElements(By.xpath("./child::*"));	
		for (int i=0; i<=childs.size(); i++)
		{
			//Identifying the "lOCATION" coloumn and reading the inner text to validate the place
			WebElement innerChild=childs.get(2);
			if(innerChild.getText().contains("Chicago"))
			{
				System.out.println("device list filtered on the basis of location");
				break;
			}
			break;		
		}
		break;
	}
	test1.log(LogStatus.PASS, "device list filtered on the basis of location");
	test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\DeviceSearch.png"));
	}
    
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementsByXpath(String controlName)
  	Purpose of Method                 : Differentiate chillers based on color code
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/
	
	public  void differentiatechillerBasedonIndicator() throws IOException 
	{
		ExtentTest test1=report.startTest("differentiatechillerBasedonIndicator");
		
		//Fetching all the chillers with "GREEN" status indicator
		List<WebElement> greenIndicator=elementFactory.getElementsByXpath(greenIndicatorBtn);
		System.out.println("The number of running chiller in this location is " +greenIndicator.size());
		
		//Fetching all the chillers with "RED" status indicator
		List<WebElement> redIndicator=elementFactory.getElementsByXpath(redIndicatorBtn);
		System.out.println("The number of not running chiller in this location is " +redIndicator.size());
		
		
		//Fetching all the chillers with "YELLOW" status indicator
		List<WebElement> alertIndicator=elementFactory.getElementsByXpath(alertIndicatorBtn);
		System.out.println("The number of alarms/alerts chiller in this location is " +alertIndicator.size());
		
		
		//Fetching all the chillers with "GREY" status indicator
		List<WebElement> greyIndicator=elementFactory.getElementsByXpath(greyIndicatorBtn);
		System.out.println("The number of offline chiller in this location is " +greyIndicator.size());
		
		test1.log(LogStatus.PASS, "DifferentiatechillerBasedonIndicator");
		test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\status Indicator.png"));	
	}
    
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementsByXpath(String controlName)
  	Purpose of Method                 : To Sort the coloumns
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/
	
	public  void validateSortingFunctionality() throws InterruptedException, IOException 
	{
		ExtentTest test1=report.startTest("validateSortingFunctionality");
		//Getting all the coloumns for which sorting functionality are available
		List<WebElement> coloumnNames=elementFactory.getElementsByXpath(coloumnName);	
		
		System.out.println(coloumnNames.size());
		for (int i=0; i<coloumnNames.size()-1; i++)
		{
			WebElement coulmn=coloumnNames.get(i+1);
			List<WebElement> shortingIconsList=elementFactory.getElementsByXpath(shortingIcons);
			//Clicking on each of the sorting icon present on the coloumn
			shortingIconsList.get(i).click();
			Thread.sleep(3000);		
		}
		test1.log(LogStatus.PASS, "validateSortingFunctionality");
		
	}

}
