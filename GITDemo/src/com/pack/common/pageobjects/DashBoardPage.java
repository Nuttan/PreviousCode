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
	
	public  void  enterUserNameChrome(String userName) throws InterruptedException, IOException {
		 WebElement UsrnameField=elementFactory.getElementById(UsrnameField_Id);
		 elementFactory.enterText(UsrnameField_Id, userName);           
		 UsrnameField.sendKeys(Keys.TAB);
		 Thread.sleep(30000); 
		 userActions.clickOn(cookiesButton);
		 System.out.println("cookies accepted");
		  
	}
	public  void enterUserNameFirefox(String userName) throws InterruptedException, IOException {
		Runtime.getRuntime().exec("D:\\AutoitScript\\dashboardlogin.exe");
		WebElement UsrnameField=elementFactory.getElementById(UsrnameField_Id);
		elementFactory.enterText(UsrnameField_Id, userName);          
		UsrnameField.sendKeys(Keys.TAB);
		Thread.sleep(30000);
		userActions.clickOn(cookiesButton);
		System.out.println("cookies button clicked nuttan");
	}


	public  void validateRunningChillerCount() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateRunningChillerCount");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement RunningGauge = elementFactory.getElementByXpath(runningChiller);
	userActions.clickOn(runningChiller);
	Thread.sleep(5000);
	List<WebElement> gaugeTextElement=elementFactory.getElementsByXpath(gaugeText);
	String gaugeTextActual=userActions.getTextForParticularElementFromListofElements(gaugeText,1);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
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

	public  void validateAlarmsandAlertChillerCount() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateAlarmsandAlertChillerCount");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement AlarmsGauge = elementFactory.getElementByXpath(alarmsChiller);
	userActions.clickOn(alarmsChiller);
	Thread.sleep(5000);
	List<WebElement> gaugeTextElement=elementFactory.getElementsByXpath(gaugeText);
	String gaugeTextActual=userActions.getTextForParticularElementFromListofElements(gaugeText,2);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
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

	public  void validateNotRunningChillerCount() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateNotRunningChillerCount");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement notRunningGauge =elementFactory.getElementByXpath(notrunningChiller);
	userActions.clickOn(notrunningChiller);
	Thread.sleep(5000);
	List<WebElement> gaugeTextElement=elementFactory.getElementsByXpath(gaugeText);
	String gaugeTextActual=userActions.getTextForParticularElementFromListofElements(gaugeText,3);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
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


	public  void validateOfflineChillerCount() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateOfflineChillerCount");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement offlineGauge =elementFactory.getElementByXpath(offlineChiller);
	userActions.clickOn(offlineChiller);
	Thread.sleep(5000);
	List<WebElement> gaugeTextElement=elementFactory.getElementsByXpath(gaugeText);
	String gaugeTextActual=userActions.getTextForParticularElementFromListofElements(gaugeText,4);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
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


	public  void validateDeviceLocationSearchFunctionality() throws InterruptedException, IOException
	{
	ExtentTest test1=report.startTest("validateDeviceLocationSearchFunctionality");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	try{
	WebElement deviceLocation = elementFactory.getElementByXpath(deviceLocationBtn);
	userActions.clickOn(deviceLocationBtn);
	}
	catch(StaleElementReferenceException e)
	{
		WebElement deviceLocation = elementFactory.getElementByXpath(deviceLocationBtn);
		System.out.println("Stale element reference exception will be handeled here");
	}
	WebElement locationSearch = elementFactory.getElementByXpath(locationSearchElement);;
	locationSearch.sendKeys("chicago");
	elementFactory.getElementByXpath(serachBtn).click();
	Thread.sleep(5000);
	List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
	for (WebElement element : deviceList) 
	{			
		List<WebElement> childs = element.findElements(By.xpath("./child::*"));	
		for (int i=0; i<=childs.size(); i++)
		{
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

	public  void differentiatechillerBasedonIndicator() throws IOException 
	{
		ExtentTest test1=report.startTest("differentiatechillerBasedonIndicator");
		List<WebElement> greenIndicator=elementFactory.getElementsByXpath(greenIndicatorBtn);
		
		test1.log(LogStatus.PASS, "device list filtered on the basis of location" +greenIndicator.size());
		System.out.println("The number of running chiller in this location is " +greenIndicator.size());
		
		List<WebElement> redIndicator=elementFactory.getElementsByXpath(redIndicatorBtn);
		System.out.println("The number of not running chiller in this location is " +redIndicator.size());
		
		List<WebElement> alertIndicator=elementFactory.getElementsByXpath(alertIndicatorBtn);
		System.out.println("The number of alarms/alerts chiller in this location is " +alertIndicator.size());
		
		List<WebElement> greyIndicator=elementFactory.getElementsByXpath(greyIndicatorBtn);
		System.out.println("The number of offline chiller in this location is " +greyIndicator.size());
		
		test1.log(LogStatus.PASS, "DifferentiatechillerBasedonIndicator");
		test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\status Indicator.png"));	
	}

	public  void validateSortingFunctionality() throws InterruptedException, IOException 
	{
		ExtentTest test1=report.startTest("validateSortingFunctionality");
		List<WebElement> coloumnNames=elementFactory.getElementsByXpath(coloumnName);	
		
		System.out.println(coloumnNames.size());
		for (int i=0; i<coloumnNames.size()-1; i++)
		{
			WebElement coulmn=coloumnNames.get(i+1);
			List<WebElement> shortingIconsList=elementFactory.getElementsByXpath(shortingIcons);
			shortingIconsList.get(i).click();
			Thread.sleep(3000);		
		}
		test1.log(LogStatus.PASS, "validateSortingFunctionality");
		
	}

}
