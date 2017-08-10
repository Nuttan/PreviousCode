package com.pack.common.pageobjects;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pack.base.TestBaseSetUp;
import com.pack.utilities.TakeScreenshot;
import com.pack.utilities.WebElementFactory;
import com.pack.wrapper.UserActions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class DeviceDetailsPage extends TestBaseSetUp {
	
	public static WebDriver driver;
	WebElementFactory elementFactory;
	UserActions userActions;
	
	
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
    Page Elements                     : Device Details Page Elements
  	Reviewed By                       : 
    **/ 
	
	static By childList = By.xpath("./child::*");
	static String devicelistMenu="CarrierSmart.Dashboard.DeviceList.Xpath"; 
	static String elementDevice ="CarrierSmart.DeviceDetails.DeviceTitle.Xpath";
	static String titleInfoElement ="CarrierSmart.DeviceDetails.TitleInfo.Xpath";
	static String weatherIcon ="CarrierSmart.DeviceDetails.WeatherIcon.Xpath";
	static String weatherForecastPopUp ="CarrierSmart.DeviceDetails.WeatherList.Xpath";
	static String weatherForecastfirstDate ="CarrierSmart.DeviceDetails.WeatherListDate1.Xpath";
	static String weatherForecastlastDate ="CarrierSmart.DeviceDetails.WeatherListDate5.Xpath";
	static String weatherForecastcloseButton ="CarrierSmart.DeviceDetails.WeatherPopupClose.Xpath";

	public DeviceDetailsPage(WebDriver driver) {
		this.driver=driver;
		elementFactory =new WebElementFactory(driver);
		userActions = new UserActions(driver);
	}
	
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementsByXpath(String controlName)
  	Purpose of Method                 : To select any device from the grid
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	
	public  void selectOneDevice(WebDriver driver) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
		WebElement element=deviceList.get(5);
		element.click();
		Thread.sleep(8000);
	}
	
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementsByXpath(String controlName),ScreenShot(Driver,Title)
  	Purpose of Method                 : To validate Device Serial Number,Customer Name and Location
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	
	
	public  void validateDeviceDetailsPage(WebDriver driver) throws InterruptedException, IOException
	{
		ExtentTest test1=report.startTest("validateDeviceDetailsPage");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Getting the number of devices present in the list 
		List<WebElement> deviceList=elementFactory.getElementsByXpath(devicelistMenu);
		WebElement element=deviceList.get(5);
		List<WebElement> childs = element.findElements(childList);
		//Fetching the serial number and Last Updated time of the device
		String serialDashboard=childs.get(4).getText();
		String updatedTimeDashboard=childs.get(5).getText();
		//Clicking on any one of the device from the list and going to the device detail page
		element.click();
		Thread.sleep(7000);	
		//Fetching the Title of the device
		String titleDevice=elementFactory.getElementByXpath(elementDevice).getText();
		String[] serialDevicedetailarray=titleDevice.split("\\s+");
		String serialDevicedetail=serialDevicedetailarray[2];
		if(serialDashboard.contains(serialDevicedetail))
		{
			test1.log(LogStatus.PASS, "Validated DeviceDetailsPage successfully");
			test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\DeviceDetails.png"));
		}
		else
		{
			test1.log(LogStatus.FAIL, "DeviceDetailsPage not Validated  successfully");
			TakeScreenshot.ScreenShot(driver, "DeviceDetail");
		}	
		String titleInfo=elementFactory.getElementByXpath(titleInfoElement).getText();
		String[] dateDeviceArray=titleInfo.split("|");
		String dateDeviceDetail=dateDeviceArray[1];	
	}
    
	
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementsByXpath(String controlName),ScreenShot(Driver,Title)
  	Purpose of Method                 : To verify the weather forecast for the upcoming 5 days
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	
	public  void verifyWeatherForecast(WebDriver driver) throws InterruptedException, IOException
	{ 
		  ExtentTest test1=report.startTest("verifyWeatherForecast");
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YY HH:mm:ss");
		  LocalDateTime now = LocalDateTime.now();
		  String[] splited = dtf.format(now).split("\\s+"); 
		  String[] splitedAgain = splited[0].split("/");
		  int i=Integer.parseInt(splitedAgain[1]); 
		  driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MICROSECONDS);
		  //Finding the "Weather" Icon and clicking on it.
		  elementFactory.getElementByXpath(weatherIcon).click(); 
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  //Verify the weather pop-up to be opened
		  WebElement weatherForecast = elementFactory.getElementByXpath(weatherForecastPopUp);
		  //Getting the First Date from the List
		  WebElement date1 =elementFactory.getElementByXpath(weatherForecastfirstDate);
		  String firstDate=date1.getText();
		  String[] firstDateRefine =firstDate.split("\\s+"); 
		  int j=Integer.parseInt(firstDateRefine[1]);
		  //Getting the Last Date from the List
		  WebElement date5 =elementFactory.getElementByXpath(weatherForecastlastDate);
		  String lastDate=date5.getText();
		  String[] lastDateRefine =lastDate.split("\\s+"); 
		  int k=Integer.parseInt(lastDateRefine[1]); 
		  if (((i+1) ==j) && ((i+5) ==k))
		  {
			 System.out.println("weatherforecast is correct");
			 test1.log(LogStatus.PASS, "Weatherforecast is verified for next 5 days");
			 test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots\\WeatherForecast.png"));
		  } 
		  else
		  {
			 test1.log(LogStatus.FAIL, "Weatherforecast is not verified for next 5 days");
			 TakeScreenshot.ScreenShot(driver, "WeatherForecast");
		  }
		  driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		  //Clicking on the "CLOSE" icon on the weather pop-up
		  WebElement weatherClose =elementFactory.getElementByXpath(weatherForecastcloseButton);
		  userActions.clickOn(weatherForecastcloseButton); 
		
	}	  

}
