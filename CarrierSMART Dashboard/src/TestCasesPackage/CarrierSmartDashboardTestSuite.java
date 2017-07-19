package TestCasesPackage;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Properties.LoadAppConfig;
import Utility.TakeScreenshot;
import Utility.WebElementFactory;
import Wrapper.UserActions;

public class CarrierSmartDashboardTestSuite {
	//static ExtentReports report=new ExtentReports("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");	added steps
	static WebDriver driver ;

	static ExtentReports report=new ExtentReports("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");
	static ExtentTest test1=report.startTest("Carrier SMART DashboardAutomation").assignCategory("BasicUserFunction").assignAuthor("Nuttan Abhijan");
	static ExtentTest test2=report.startTest("Carrier SMART DashboardAutomation").assignCategory("AdminFunction").assignAuthor("Nuttan Abhijan");


	static Random rand = new Random();
	static int  n = rand.nextInt(485) + 1;
	public static String customerName="CustomerHRDC"+"_"+n;
	public static String ContactName="Dummy"+n;
	public static String customerEmail=customerName+"@utc.com";
	public static String serialNumber="505QH78J"+n;
	static LoadAppConfig appConfig=new LoadAppConfig();


	@Test(alwaysRun=true, priority=0,enabled=true,groups={"Smoke"})
	public static void LoginDasboard() throws InterruptedException, IOException 
	{  
		
	//LOGIN TO DASHBOARD
		
//		System.setProperty("webdriver.gecko.driver", "D:\\GeckoDriver\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.get("https://smartservicedev.carrier.com");
//		Runtime.getRuntime().exec("D:\\AutoitScript\\dashboardlogin.exe");
//		WebElement UsrnameField = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("cred_userid_inputtext")));
//		//System.out.println("Web element identified");
//		driver.findElement(By.id("cred_userid_inputtext")).sendKeys("SwainN@UTCCGL.com");           
//		UsrnameField.sendKeys(Keys.TAB);
//		//System.out.println("Pressed tab");
//		Thread.sleep(30000);
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
//		System.out.println("cookies accepted");
//		//Thread.sleep(10000);
//
//		test1.log(LogStatus.PASS, "LogIn to Carrier Dashboard Successful");
		
		  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver_win32 (2)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://smartservicedev.carrier.com");
		  WebElement UsrnameField = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("cred_userid_inputtext")));
		  driver.findElement(By.id("cred_userid_inputtext")).sendKeys("SwainN@UTCCGL.com ");           
		  UsrnameField.sendKeys(Keys.TAB);
		  Thread.sleep(30000);
		  driver.manage().window().maximize();
		  WebElement cookies = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]")));
		  cookies.click();
		  System.out.println("cookies accepted");
		  Thread.sleep(10000);
		
//		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver_win32 (2)\\chromedriver.exe");
//		  driver = new ChromeDriver(); 
//		  driver.get(appConfig.getAppUrl());
//		  String controlName1="CarrierSmart.LogIn.UsrnameField.Id";  
//		  WebElementFactory elementFactory=new WebElementFactory(driver);
//		  UserActions userActions = new UserActions(driver);
//		  WebElement ele=elementFactory.getElementById(controlName1);
//		  ele.sendKeys("SwainN@UTCCGL.com");
//		  ele.sendKeys(Keys.TAB);
//		  Thread.sleep(3000);
//		  driver.manage().window().maximize();
//		  String controlName2="CarrierSmart.Dashboard.Cookies.Xpath";   
//		  userActions.clickOn(controlName2);
//		  System.out.println("cookies accepted");
		  

		  //String screenshotBase64=TakeScreenshot.captureScreenshotAsBase64(driver);
		//  String imageInBase64 = test1.addScreenCapture(screenshotBase64);
		 
		  test1.log(LogStatus.PASS, "Logged into Dashboard");
//		  String extentReportImage = "../extentReport/screenshots/" + System.currentTimeMillis() + ".png";
//		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		  FileUtils.copyFile(src, new File(extentReportImage));
//		  test1.log(Status.INFO,"Screenshot from : " + extentReportImage).addScreenCaptureFromPath(extentReportImage);
//		  test1.addScreenCapture("D:\\CST-AutomationScreenshots\\LoginDashboard.png");
//		  test1.addScreencast("D:\\CST-AutomationScreenshots\\LoginDashboard.png");
		  
		


		    Thread.sleep(8000);
	}
	@Test(alwaysRun=true, priority=1,enabled=true,groups="Regression" )
	public static void validateRunningChillerCount() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement RunningGauge = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='gaugeRunning']")));
	//WebElement RunningGauge = driver.findElement(By.xpath("//div[@id='gaugeRunning']"));
	RunningGauge.click();
	Thread.sleep(5000);
	//System.out.println("clicked on running chillers");
	List<WebElement> gaugeTextElement=driver.findElements(By.xpath("//*[@class='c3-gauge-value']"));
	String gaugeText=gaugeTextElement.get(1).getText();
	//System.out.println(gaugeText);
	List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
	int i=deviceList.size();
	//System.out.println(i);
	int j=Integer.parseInt(gaugeText);
	if(i == j)
	{
		//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
	  test1.log(LogStatus.PASS, "Running chiller count in gauge chart and actualdevice count in device list are matching");
	  TakeScreenshot.ScreenShot(driver, "RunningChillerCount");
	  test1.addScreenCapture("D:\\CST-AutomationScreenshots\\RunningChillerCount.png");

	}
	else
	{
		test1.log(LogStatus.FAIL, "Running chiller count in gauge chart and actualdevice count in device list are not  matching");
	}

	}

	@Test(alwaysRun=true, priority=2,enabled=true,groups="Regression")
	public static void validateAlarmsandAlertChillerCount() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement AlarmsGauge = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='gaugeAlarms']")));
	//WebElement AlarmsGauge = driver.findElement(By.xpath("//div[@id='gaugeAlarms']"));
	AlarmsGauge.click();
	Thread.sleep(5000);
	//System.out.println("clicked on Alarms/Alerts chillers");
	List<WebElement> gaugeTextElement=driver.findElements(By.xpath("//*[@class='c3-gauge-value']"));
	String gaugeText=gaugeTextElement.get(2).getText();
	//System.out.println(gaugeText);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
	int i=deviceList.size();
	//System.out.println(i);
	int j=Integer.parseInt(gaugeText);
	if(i == j)
	{
		//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
	test1.log(LogStatus.PASS, "Alarms/Alerts chiller count in gauge chart and actualdevice count in device list are matching");
	}
	else
		test1.log(LogStatus.FAIL, "Alarms/Alerts chiller count in gauge chart and actualdevice count in device list are not matching");	
	TakeScreenshot.ScreenShot(driver, "Alarms and Alert chillerCount");
	}

	@Test(alwaysRun=true, priority=3,enabled=true,groups="Regression")
	public static void validateNotRunningChillerCount() throws InterruptedException, IOException
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement AlarmsGauge = driver.findElement(By.xpath("//div[@id='gaugeNotRunning']"));
	AlarmsGauge.click();
	Thread.sleep(5000);
	//System.out.println("clicked on NotRunning chillers");
	List<WebElement> gaugeTextElement=driver.findElements(By.xpath("//*[@class='c3-gauge-value']"));
	String gaugeText=gaugeTextElement.get(3).getText();
	//System.out.println(gaugeText);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
	int i=deviceList.size();
	//System.out.println(i);
	int j=Integer.parseInt(gaugeText);
	if(i == j)
	{
		//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
	test1.log(LogStatus.PASS, "NotRunning chiller count in gauge chart and actualdevice count in device list are matching");
	}
	else
	test1.log(LogStatus.FAIL, "NotRunning chiller count in gauge chart and actualdevice count in device list are not matching");	
	TakeScreenshot.ScreenShot(driver, "NotRunningChillerCount");
	}

	@Test(alwaysRun=true, priority=4,enabled=true)
	public static void validateOfflineChillerCount() throws InterruptedException, IOException
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement AlarmsGauge = driver.findElement(By.xpath("//div[@id='gaugeOffline']"));
	AlarmsGauge.click();
	Thread.sleep(5000);
	//System.out.println("clicked on NotRunning chillers");
	List<WebElement> gaugeTextElement=driver.findElements(By.xpath("//*[@class='c3-gauge-value']"));
	String gaugeText=gaugeTextElement.get(4).getText();
	//System.out.println(gaugeText);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
	int i=deviceList.size();
	//System.out.println(i);
	int j=Integer.parseInt(gaugeText);
	if(i == j)
	{
		//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
	test1.log(LogStatus.PASS, "Offline chiller count in gauge chart and actualdevice count in device list are matching");
	}
	else
		test1.log(LogStatus.FAIL, "Offline chiller count in gauge chart and actualdevice count in device list are matching");	
	TakeScreenshot.ScreenShot(driver, "OfflineChillerCount");
	}

	@Test(alwaysRun=true, priority=5,enabled=true,groups="Smoke")
	public static void validateDeviceLocationSearchFunctionality() throws InterruptedException, IOException
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	try{
	WebElement deviceLocation = driver.findElement(By.xpath("//input[@type='radio' and @value='location']"));
	deviceLocation.click();
	}
	catch(StaleElementReferenceException e)
	{
		WebElement deviceLocation = driver.findElement(By.xpath("//input[@type='radio' and @value='location']"));
		System.out.println("Stale element reference exception will be handeled here");
	}
	//System.out.println("clicked on Search Radio Button");
	WebElement locationSearch = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@ng-reflect-auto-complete-placeholder='Select a location']")));
	locationSearch.sendKeys("chicago");
	driver.findElement(By.xpath("//div[@class='search']")).click();
	Thread.sleep(5000);
	List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
	for (WebElement element : deviceList) 
	{			
		List<WebElement> childs = element.findElements(By.xpath("./child::*"));
		//System.out.println(childs.size());
		
		for (int i=0; i<=childs.size(); i++)
		{
			WebElement innerChild=childs.get(2);
			if(innerChild.getText().contains("Chicago"))
			{
				//System.out.println(innerChild.getText());
				
				//test1.log(LogLogStatus.PASS, "device list filtered on the basis of location");
				System.out.println("device list filtered on the basis of location");
				break;
			}
			break;
			
			
		}
		break;
	}
	//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
	test1.log(LogStatus.PASS, "device list filtered on the basis of location");
	//TakeScreenshot.ScreenShot(driver, "SearchingLocationFunctionality");
	}

	@Test(alwaysRun=true, priority=6,enabled=true,groups="Smoke")
	public static void differentiatechillerBasedonIndicator() 
	{
		
		List<WebElement> greenIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_normal.png')]"));
		
		test1.log(LogStatus.PASS, "device list filtered on the basis of location" +greenIndicator.size());
		System.out.println("The number of running chiller in this location is " +greenIndicator.size());
		
		List<WebElement> redIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_abnormal.png')]"));
		System.out.println("The number of not running chiller in this location is " +redIndicator.size());
		
		List<WebElement> alertIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_alert.png')]"));
		System.out.println("The number of alarms/alerts chiller in this location is " +alertIndicator.size());
		
		List<WebElement> greyIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_offline.png')]"));
		System.out.println("The number of offline chiller in this location is " +greyIndicator.size());
		
		//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
		test1.log(LogStatus.PASS, "DifferentiatechillerBasedonIndicator");
			
	}

	@Test(alwaysRun=true, priority=7,enabled=true)
	public static void validateSortingFunctionality() throws InterruptedException, IOException 
	{
		List<WebElement> coloumnNames=driver.findElements(By.xpath("//article[@class='simpleGrid']/div[1]/*"));	
		
		System.out.println(coloumnNames.size());
		for (int i=0; i<coloumnNames.size()-1; i++)
		{
			WebElement coulmn=coloumnNames.get(i+1);
			//System.out.println(coulmn.getText());
			List<WebElement> shortingIconsList=driver.findElements(By.xpath("//article[@class='simpleGrid']/div[1]//child::*//img"));
			//System.out.println("total number of shorting icons is "+shortingIconsList.size());
			shortingIconsList.get(i).click();
			Thread.sleep(3000);	
			//System.out.println("Shorted coloumn is " + coulmn.getText() + "in ascending order" );	
			
			
		}
		//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
		test1.log(LogStatus.PASS, "validateSortingFunctionality");
		
	}

	@Test(alwaysRun=true, priority=8,enabled=true,groups="Smoke")
	public static void validateDeviceDetailsPage() throws InterruptedException, IOException
	{
		List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
		WebElement element=deviceList.get(5);
		System.out.println("DEVICE identified from the device list");
		List<WebElement> childs = element.findElements(By.xpath("./child::*"));
		String serialDashboard=childs.get(4).getText();
		String updatedTimeDashboard=childs.get(5).getText();
		element.click();
		Thread.sleep(7000);	
		String titleDevice=driver.findElement(By.xpath("//div[@class='deviceNavigator']/span[2]")).getText();
		String[] serialDevicedetailarray=titleDevice.split("\\s+");
		String serialDevicedetail=serialDevicedetailarray[2];
		//if(serialDashboard.contains(serialDevicedetail))
		if(serialDashboard.contains(serialDevicedetail))
		{
			//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
			test1.log(LogStatus.PASS, "Validated DeviceDetailsPage successfully");
		}
		else
		{
			test1.log(LogStatus.FAIL, "DeviceDetailsPage not Validated  successfully");
		}
		
		String titleInfo=driver.findElement(By.xpath("//div[@class='infoLine']")).getText();
		String[] dateDeviceArray=titleInfo.split("|");
		String dateDeviceDetail=dateDeviceArray[1];
		
	}
	@Test(alwaysRun=true, priority=9,enabled=true)
	public static void verifyWeatherForecast() throws InterruptedException
	{
		  
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YY HH:mm:ss");
		  LocalDateTime now = LocalDateTime.now();
		  String[] splited = dtf.format(now).split("\\s+"); 
		  String[] splitedAgain = splited[0].split("/");
		  int i=Integer.parseInt(splitedAgain[1]);
		  System.out.println(i); 
		  driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MICROSECONDS);
		  driver.findElement(By.xpath("//div[@class='topRow']/div[1]/div[1]/img[2]")).click(); 
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  WebElement weatherForecast = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='weatherForecast']")));
		  //WebElement date1 = driver.findElement(By.xpath("//html/body/smart-chiller-app/div/smart-chiller-weather-forecast/div/div/div[3]/div[2]/div[1]/div[2]"));
		  WebElement date1 = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='infoValue large'])[1]")));
		  //(//div[@class='infoValue large'])[1]
		  String firstDate=date1.getText();
		 // System.out.println(firstDate);
		  String[] firstDateRefine =firstDate.split("\\s+"); 
		  int j=Integer.parseInt(firstDateRefine[1]); 
		  System.out.println(j);
		  
		  
		  WebElement date5 = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='infoValue large'])[5]")));
		  //WebElement date5 = driver.findElement(By.xpath("//html/body/smart-chiller-app/div/smart-chiller-weather-forecast/div/div/div[3]/div[6]/div[1]/div[2]"));
		  String lastDate=date5.getText();
		  //System.out.println(lastDate);
		  String[] lastDateRefine =lastDate.split("\\s+"); 
		  int k=Integer.parseInt(lastDateRefine[1]); 
		  System.out.println(k);
		 if (((i+1) ==j) && ((i+5) ==k))
		 {
			 System.out.println("weatherforecast is correct");
			 //test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
			 test1.log(LogStatus.PASS, "Weatherforecast is verified for next 5 days");
		 } 
		 else
		 {
			 test1.log(LogStatus.FAIL, "Weatherforecast is not verified for next 5 days");
		 }
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		 
		 WebElement weatherClose = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn'])[2]")));
		 weatherClose.click(); 
		
	}	  
	@Test(alwaysRun=true, priority=10,enabled=true,groups="Smoke")
	public static void validateSectionDetailsPage() throws InterruptedException, IOException
	{
		WebElement sectionDetail = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'SECTION DETAILS')]")));
		sectionDetail.click();
		System.out.println("section details button clicked and about to navigate to section details page");
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		List<WebElement> sectionlist = driver.findElements(By.xpath("//div[@class='sectionList']//div/span")); 
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	  	
		for (int i=0; i<=sectionlist.size()-1; i++)
		{
		 WebElement section=sectionlist.get(i);
		 section.click();
			 String sectionText=section.getText();
			 System.out.println("Clicked on " +sectionText+ "section of the chiller");
			 Thread.sleep(4000);	
		}
		//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
		 test1.log(LogStatus.PASS, "Validated the SectionDetails Page");
		 Thread.sleep(4000);
	}

	@Test(alwaysRun=true, priority=11,enabled=true,groups="Smoke")
	public static void validateExportToExcel() throws InterruptedException, IOException
	{
		  // WebElement exceptionclose = (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/smart-chiller-app/div/smart-chiller-error/div/div/div[3]/div/button")));
	       //exceptionclose.click();
		WebElement reportIcon = new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src,'dist/assets/images/Icon_export-file.png')]")));
		reportIcon.click();
		Thread.sleep(3000);
		if(driver.findElement(By.className("excelExport")).isDisplayed())
	    {
			//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
			System.out.println("Report Pop up opened");
	    }
		else
		{
			System.out.println("Report Pop up is absent");
		}
		List<WebElement> radioButtonList = driver.findElements(By.xpath("//div[@class='check']//input"));
		
		 for (WebElement button : radioButtonList) 
		 {
			 if(button.isSelected())
			 {
				 button.click();
			 }
			 Thread.sleep(2000);
		 }
		 
		WebElement fourHour = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='check']//input)[4]")));
		fourHour.click();
		
		//(//input[contains(@ng-reflect-max-date,'India Standard Time')])[2]
		
		
//		WebElement dateField = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ng2-datetime-picker-wrapper']/input)[1]")));
//		dateField.click();
	//	
//		WebElement exactdateChoice = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='month']/b[contains(@class,'prev_next next')])[2]")));
//		exactdateChoice.click();
		
		WebElement closeIcon = new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src,'dist/assets/images/Button_Export.png')]")));
		closeIcon.click();
		Thread.sleep(12000);
		test1.log(LogStatus.PASS, "Validate ExportToExcel functionality");
		
		driver.navigate().refresh();
		Thread.sleep(12000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	//ADDNEWCUSTOMER
	@Test(alwaysRun=true, priority=12,enabled=true)
	public static void addNewCustomer() throws InterruptedException, IOException 
	{
	WebElement setting= (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='settings']")));
	setting.click();
	WebElement customerTab = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Customers')]")));
	customerTab.click();
	System.out.println("clicked on Customer Tab");
	driver.manage().timeouts().implicitlyWait(8000,TimeUnit.MILLISECONDS);
	int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
	int num2 = rand.nextInt(743);
	int num3 = rand.nextInt(10000);
	DecimalFormat df3 = new DecimalFormat("000"); 
	DecimalFormat df4 = new DecimalFormat("0000"); 
	String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
	Thread.sleep(6000);
	WebElement cName = (new WebDriverWait(driver,50)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Customer Name')]/parent::node()/td[2]/input)[1]")));
	cName.sendKeys(customerName);
	Thread.sleep(2000);
	WebElement cEmail= (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Contact Email')]/parent::node()/td[2]/input)[1]")));
	cEmail.sendKeys(customerEmail);
	Thread.sleep(2000);
	WebElement clocationstreet = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Location Street')]/parent::node()/td[2]/input)[1]")));
	clocationstreet.sendKeys("ChruchStreet");
	Thread.sleep(2000);
	WebElement clocationState = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Location State')]/parent::node()/td[2]/input)[1]")));
	clocationState.sendKeys("Ch");
	Thread.sleep(2000);
	Select cTimezone = new Select(driver.findElement(By.xpath("//option[contains(text(),'Africa/Bangui')]/parent::node()")));
	cTimezone.selectByVisibleText("America/Chicago");
	WebElement contactName = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Contact Name')]/parent::node()/td[5]/input)[1]")));
	contactName.sendKeys(ContactName);
	WebElement contactPhone = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Contact Phone')]/parent::node()/td[5]/input)[1]")));
	contactPhone.sendKeys(phoneNumber);
	WebElement locationCity = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Location City')]/parent::node()/td[5]/input)[1]")));
	locationCity.sendKeys("Chicago");
	WebElement locationZip = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Location Zip')]/parent::node()/td[5]/input)[1]")));
	locationZip.sendKeys("788451");
	WebElement saveDetails = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Enter a new customer or choose one to update')]/parent::node()/td[6]/div/img)[1]")));
	//System.out.println("Save details button identified");
	saveDetails.click();
	(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Close')]"))).click();
	//System.out.println("Customer: " +customerName+ "added successfully");

	//test2.log(LogStatus.INFO, "Snapshot below: " + test2.addScreenCapture("D:\\CST-AutomationScreenshots"));
	test2.log(LogStatus.PASS, "Customer: " +customerName+ "added successfully");
	Thread.sleep(4000);
	}

	//CHILLER REGISTRATION
	@Test(alwaysRun=true, priority=13,enabled=true)
	public static void chillerRegistrationNewCustomer() throws InterruptedException, IOException 
	{
		WebElement chillerTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Chillers')]")));
		chillerTab.click();
		Thread.sleep(6000);
		//System.out.println(customerName);
		
		Select custDropdown = new Select(driver.findElement(By.xpath("(//option[contains(text(),'CustomerHRDC_')]/parent::node())[2]")));
		List<WebElement> customerList =custDropdown.getOptions();
		//System.out.println(customerList.size());
		
		//WebElement custDropdown=driver.findElement(By.xpath("(//option[contains(text(),'CustomerHRDC_')]/parent::node())[2]"));
		//custDropdown.click();
		Thread.sleep(2000);
		
		//To select one value from the drop down having similar text
		//WebElement custDropdownElement=driver.findElement(By.xpath("(//option[contains(text(),'CustomerHRDC_')]/parent::node())[2]//option[contains(text(),'CustomerHRDC')]"));
		//custDropdownElement.click();

		custDropdown.selectByVisibleText(customerName);
		Thread.sleep(2000);
		
		WebElement serialNumberText = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Serial Number')]/parent::node()/div[2]/input)[1]")));
		serialNumberText.sendKeys(serialNumber);
		//System.out.println("Serial Number Of the Chiller is " + serialNumber);
		Thread.sleep(2000);
		
		WebElement city = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Location City')]/parent::node()/div[2]/input)[1]")));
		city.sendKeys("chicago");
		Thread.sleep(2000);
		
		WebElement postalCode = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Location Postal Code')]/parent::node()/div[2]/input)[1]")));
		postalCode.sendKeys("788451");
		Thread.sleep(2000);
		
		WebElement chillerModel = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Chiller Model')]/parent::node()/div[2]/input)[1]")));
		chillerModel.sendKeys("19XR");
		Thread.sleep(4000);
		
		Select refrigerantType = new Select(driver.findElement(By.xpath("(//option[contains(text(),'HCFC-22')]/parent::node())[1]")));
		refrigerantType.selectByVisibleText("HFC-134a");
		Thread.sleep(2000);
		
		WebElement modemAddress = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Modem Address')]/parent::node()/div[2]/input)[1]")));
		modemAddress.sendKeys("worldbanksite"+n);
		Thread.sleep(2000);
		
		WebElement locStreet = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Location Street')]/parent::node()/div[2]/input)[1]")));
		locStreet.sendKeys("worldbanksite"+n);
		Thread.sleep(2000);
		
		WebElement locState = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Location State')]/parent::node()/div[2]/input)[1]")));
		locState.sendKeys("Ch");
		Thread.sleep(2000);
		
		Select cTimezone = new Select(driver.findElement(By.xpath("(//option[contains(text(),'Africa/Bangui')]/parent::node())[2]")));
		cTimezone.selectByVisibleText("America/Chicago");
		Thread.sleep(2000);
		
		Select chillerVersion = new Select(driver.findElement(By.xpath("//option[contains(text(),'23XRV PIC3')]/parent::node()")));
		chillerVersion.selectByVisibleText("19XR PIC5");
		Thread.sleep(2000);
		
		Select tenant = new Select(driver.findElement(By.xpath("//option[contains(text(),'south')]/parent::node()")));
		tenant.selectByVisibleText("hrdcqa.com");
		Thread.sleep(6000);
		
		WebElement saveDetails = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@src,'dist/assets/images/Button_SaveDetails.png')])[4]")));
		saveDetails.click();
		
		
		WebElement success = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Success')]")));
	    if(success.isDisplayed())
	    {
	    	//test2.log(LogStatus.INFO, "Snapshot below: " + test2.addScreenCapture("D:\\CST-AutomationScreenshots"));
	    	test2.log(LogStatus.PASS, "Chiller: " +serialNumber+ " added successfully ");
	    	//System.out.println("Chiller:" +serialNumber+ "added successfully");
	    }
	    else
	    {
	    	test2.log(LogStatus.FAIL, "Chiller: " +serialNumber+ " is not added successfully ");
	    }
	    
	    driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
	    Thread.sleep(4000);
	}


	//TENANT VERIFICATION

	@Test(alwaysRun=true, priority=14,enabled=true)
	public static void tenantVerification() throws InterruptedException, IOException 
	{
		
		WebElement tenantTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Tenants')]")));
		tenantTab.click();
		List<WebElement> tenantList=driver.findElements(By.xpath("(//div[@class='role-list'])[2]/child::*/div[1]"));
		//System.out.println(tenantList.size());
		WebElement tenantParticular= (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'hrdcqa.com')]")));
		tenantParticular.click();
		
		WebElement dvTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='modeSelector'])[2]/div/div[2]")));
		dvTab.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement userTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='modeSelector'])[2]/div/div[1]")));
		userTab.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement OthertenantParticular= (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'new york')]")));
		OthertenantParticular.click();
		WebElement deviceTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='modeSelector'])[2]/div/div[2]")));
		deviceTab.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(40000);
		WebElement tenantParticularAgain= (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'hrdcqa.com')]")));
		tenantParticularAgain.click();
		Thread.sleep(40000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement deviceTab1 = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='modeSelector'])[2]/div/div[2]")));
		deviceTab1.click();
		
		//devices list in a prticular tenant
		
		//List<WebElement> deviceList=driver.findElements(By.xpath("(//div[@class='userRow']/parent::node())[3]/child::*/div"));
		//List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='datepicker']/div/table/tbody/tr/td/table/tbody[2]/tr/td[@class='' or @class='datepickerSaturday' or @class='datepickerSunday']/a/span"));
		
		List<WebElement> deviceList = driver.findElements(By.xpath("(//div[@class='modeData'])[2]/div/div[2]//div[contains(text(),'QH')]"));
		//System.out.println(deviceList.size());
		String s=serialNumber.toLowerCase();
		
		for (int i=0;i<=deviceList.size()-1;i++) 
		{
			//System.out.println(deviceList.get(i).getText());
			
			//System.out.println("entered into a loop ");
			if(deviceList.get(i).getText().contains(serialNumber))
			{
				//tenant.click();
				//System.out.println("Newly added chiller is registred under desired tenant");
				//test2.log(LogStatus.INFO, "Snapshot below: " + test2.addScreenCapture("D:\\CST-AutomationScreenshots"));
				
			      String extentReportImage15 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
		     	  String src15=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		     	 src15 = "data:image/gif;base64," + src15;
		     	String imageInBase64 = test2.addScreenCapture(src15);

				test2.log(LogStatus.PASS, "Newly added chiller is registred under desired tenant");
				break;
			}
			
		}
		
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{

		try 
		{
		// Create refernce of TakesScreenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		 
		// Call method to capture screenshot
		File source=ts.getScreenshotAs(OutputType.FILE);
		 
		// Copy files to specific location here it will save all screenshot in our project home directory and
		// result.getName() will return name of test case so that screenshot name will be same
		FileUtils.copyFile(source, new File("D:\\CST-AutomationScreenshots"+result.getName()+".png"));
		 
		System.out.println("Screenshot taken");
		} 
		catch (Exception e)
		{
		 
		System.out.println("Exception while taking screenshot "+e.getMessage());
		} 


	}

	}
	@AfterTest(alwaysRun=true,groups={"Regression","Smoke"})
	public void close()
	{
		  report.endTest(test1);
		  report.endTest(test2);
		  report.flush();

		  driver.get("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");
	}
}
