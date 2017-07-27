package finalPackage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Properties.LoadAppConfig;
import Utility.TakeScreenshot;


public class FinalAutomation {
	static WebDriver driver;
	 static ExtentReports extent = new ExtentReports();
	 static ExtentTest test1,test2;
	
	 

static Random rand = new Random();
static int  n = rand.nextInt(485) + 1;
public static String customerName="CustomerHRDC"+"_"+n;
public static String ContactName="Dummy"+n;
public static String customerEmail=customerName+"@utc.com";
public static String serialNumber="505QH78J"+n;
static LoadAppConfig appConfig=new LoadAppConfig();

@Test(alwaysRun=true, priority=0,enabled=true)
public void temp() throws IOException, InterruptedException {
	
		 
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");
		
	        
	        // create ExtentReports and attach reporter(s)
	       
	        extent.attachReporter(htmlReporter);
	        // creates a toggle for the given test, adds all log events under it    
	        test1= extent.createTest("Carrier SMART DashboardAutomation(Regression Testing) -BasicUser Function").assignCategory("BasicUserFunction").assignAuthor("NuttanAbhijan");
	        test2= extent.createTest("Carrier SMART DashboardAutomation(Regression Testing)-Admin Function").assignCategory("AdminFunction").assignAuthor("NuttanAbhijan");;

	        	
	        	System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver_win32 (2)\\chromedriver.exe");
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
	        	  test1.log(Status.PASS, "Logged into Dashboard");
	        	  String extentReportImage1 = "D:\\CST-AutomationScreenshots" +System.currentTimeMillis() + ".png";
	        	  File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	  FileUtils.copyFile(src1, new File(extentReportImage1));
	        	  test1.log(Status.INFO,"Screenshot from : " + extentReportImage1).addScreenCaptureFromPath(extentReportImage1);
	        	  Thread.sleep(8000);
	        }
	        @Test(alwaysRun=true, priority=1,enabled=true )
	        public  void validateRunningChillerCount() throws InterruptedException, IOException
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
	        	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	        	//jse.executeScript("scroll(0, 250);");
	        	ExtentTest test3 = test1.createNode("RunningChiller Validation");
	        	//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
	        	test3.log(Status.PASS, "Running chiller count in gauge chart and actualdevice count in device list are matching");
	          String extentReportImage2 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	     	  File src2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     	  FileUtils.copyFile(src2, new File(extentReportImage2));
	     	 test3.log(Status.INFO,"Screenshot from : " + extentReportImage2).addScreenCaptureFromPath(extentReportImage2);

	        }
	        else
	        {
	        	test1.log(Status.FAIL, "Running chiller count in gauge chart and actualdevice count in device list are not  matching");
	        }

	        }
	        @Test(alwaysRun=true, priority=2,enabled=true)
	        public static void validateAlarmsandAlertChillerCount() throws InterruptedException, IOException, AWTException
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
	        	 //Robot robot = new Robot();
	        	//robot.keyPress(KeyEvent.VK_PAGE_UP);
	        	//robot.keyRelease(KeyEvent.VK_PAGE_UP);
	        	ExtentTest test4 = test1.createNode("Alerts and Alarms Chiller Validation");
	        	//test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
	        	
	        String extentReportImage3 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	     	  File src3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     	  FileUtils.copyFile(src3, new File(extentReportImage3));
	     	 test4.log(Status.INFO,"Screenshot from : " + extentReportImage3).addScreenCaptureFromPath(extentReportImage3);
	     	test4.log(Status.PASS, "Alarms/Alerts chiller count in gauge chart and actualdevice count in device list are matching");
	        }
	        else
	        	test1.log(Status.FAIL, "Alarms/Alerts chiller count in gauge chart and actualdevice count in device list are not matching");	
	        TakeScreenshot.ScreenShot(driver, "Alarms and Alert chillerCount");
	        }

	        @Test(alwaysRun=true, priority=3,enabled=true)
	        public static void validateNotRunningChillerCount() throws InterruptedException, IOException, AWTException
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
	        	
	        	 Robot robot = new Robot();
		        	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		        	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	            String extentReportImage4 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	            ExtentTest test5 = test1.createNode("NotRunning chiller Validation");
		     	  File src4=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     	  FileUtils.copyFile(src4, new File(extentReportImage4));
		     	 test5.log(Status.INFO,"Screenshot from : " + extentReportImage4).addScreenCaptureFromPath(extentReportImage4);
		     	test5.log(Status.PASS, "NotRunning chiller count in gauge chart and actualdevice count in device list are matching");
	        }
	        else
	        test1.log(Status.FAIL, "NotRunning chiller count in gauge chart and actualdevice count in device list are not matching");	
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
	            String extentReportImage5 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	            ExtentTest test6 = test1.createNode("Offline chiller Validation");
		     	  File src5=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     	  FileUtils.copyFile(src5, new File(extentReportImage5));
		     	 test6.log(Status.INFO,"Screenshot from : " + extentReportImage5).addScreenCaptureFromPath(extentReportImage5);
		     	test6.log(Status.PASS, "Offline chiller count in gauge chart and actualdevice count in device list are matching");
	        }
	        else
	        	test1.log(Status.FAIL, "Offline chiller count in gauge chart and actualdevice count in device list are matching");	
	        TakeScreenshot.ScreenShot(driver, "OfflineChillerCount");
	        }

	        @Test(alwaysRun=true, priority=5,enabled=true)
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
	        			 ExtentTest test7 = test1.createNode("validateDeviceLocationSearchFunctionality");
	        		      String extentReportImage6 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	        	     	  File src6=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	     	  FileUtils.copyFile(src6, new File(extentReportImage6));
	        	     	 test7.log(Status.INFO,"Screenshot from : " + extentReportImage6).addScreenCaptureFromPath(extentReportImage6);
	        			
	        	     	test7.log(Status.PASS, "device list filtered on the basis of location");
	        			//System.out.println("device list filtered on the basis of location");
	        			break;
	        		}
	        		break;
	        		
	        		
	        	}
	        	break;
	        }
	        //test1.log(LogStatus.INFO, "Snapshot below: " + test1.addScreenCapture("D:\\CST-AutomationScreenshots"));
	       // test1.log(Status.PASS, "device list filtered on the basis of location");
	        //TakeScreenshot.ScreenShot(driver, "SearchingLocationFunctionality");
	        }

	        @Test(alwaysRun=true, priority=6,enabled=true)
	        public static void differentiatechillerBasedonIndicator() throws IOException 
	        {
	        	
	        	List<WebElement> greenIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_normal.png')]"));
	        	
	        	test1.log(Status.PASS, "device list filtered on the basis of location" +greenIndicator.size());
	        	System.out.println("The number of running chiller in this location is " +greenIndicator.size());
	        	
	        	List<WebElement> redIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_abnormal.png')]"));
	        	System.out.println("The number of not running chiller in this location is " +redIndicator.size());
	        	
	        	List<WebElement> alertIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_alert.png')]"));
	        	System.out.println("The number of alarms/alerts chiller in this location is " +alertIndicator.size());
	        	
	        	List<WebElement> greyIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_offline.png')]"));
	        	System.out.println("The number of offline chiller in this location is " +greyIndicator.size());
	        	
	        	 ExtentTest test8 = test1.createNode("differentiatechillerBasedonIndicator");
	            String extentReportImage7 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
		     	  File src7=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     	  FileUtils.copyFile(src7, new File(extentReportImage7));
		     	 test8.log(Status.INFO,"Screenshot from : " + extentReportImage7).addScreenCaptureFromPath(extentReportImage7);
		     	test8.log(Status.PASS, "DifferentiatechillerBasedonIndicator");
	        		
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
	        	ExtentTest test9 = test1.createNode("validateSortingFunctionality");
	            String extentReportImage8 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
		     	  File src8=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     	  FileUtils.copyFile(src8, new File(extentReportImage8));
		     	 test9.log(Status.INFO,"Screenshot from : " + extentReportImage8).addScreenCaptureFromPath(extentReportImage8);
		     	test9.log(Status.PASS, "validateSortingFunctionality");
	        	
	        }

	        @Test(alwaysRun=true, priority=8,enabled=true)
	        public static void validateDeviceDetailsPage() throws InterruptedException, IOException
	        {
	        	List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
	        	WebElement element=deviceList.get(5);
	        	System.out.println("DEVICE identified from the device list");
	        	List<WebElement> childs = element.findElements(By.xpath("./child::*"));
	        	String serialDashboard=childs.get(4).getText();
	        	String updatedTimeDashboard=childs.get(5).getText();
	        	element.click();
	        	String titleDevice=driver.findElement(By.xpath("//div[@class='deviceNavigator']/span[2]")).getText();
	        	String[] serialDevicedetailarray=titleDevice.split("\\s+");
	        	String serialDevicedetail=serialDevicedetailarray[2];
	        	//if(serialDashboard.contains(serialDevicedetail))
	        	ExtentTest test10 = test1.createNode("validateDeviceDetailsPage");
      	      String extentReportImage9 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
  	     	  File src9=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  	     	  FileUtils.copyFile(src9, new File(extentReportImage9));
	        	if(serialDashboard.contains(serialDevicedetail))
	        	{
	        	
	    	     	 test10.log(Status.INFO,"Screenshot from : " + extentReportImage9).addScreenCaptureFromPath(extentReportImage9);
	    	     	test10.log(Status.PASS, "Validated DeviceDetailsPage successfully");
	        	}
	        	else
	        	{
	        		test1.log(Status.FAIL, "DeviceDetailsPage not Validated  successfully");
	        	}
	        	
	        	String titleInfo=driver.findElement(By.xpath("//div[@class='infoLine']")).getText();
	        	String[] dateDeviceArray=titleInfo.split("|");
	        	String dateDeviceDetail=dateDeviceArray[1];
	        	
	        }
	        @Test(alwaysRun=true, priority=9,enabled=true)
	        public static void verifyWeatherForecast() throws InterruptedException, IOException
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
	        		 ExtentTest test11 = test1.createNode("verifyWeatherForecast");
	        		 System.out.println("weatherforecast is correct");
	        	      String extentReportImage10 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	    	     	  File src10=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	     	  FileUtils.copyFile(src10, new File(extentReportImage10));
	    	     	 test11.log(Status.INFO,"Screenshot from : " + extentReportImage10).addScreenCaptureFromPath(extentReportImage10);
	    	     	test11.log(Status.PASS, "Weatherforecast is verified for next 5 days");
	        	 } 
	        	 else
	        	 {
	        		 test1.log(Status.FAIL, "Weatherforecast is not verified for next 5 days");
	        	 }
	        	driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
	        	 
	        	 WebElement weatherClose = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn'])[2]")));
	        	 weatherClose.click(); 
	        	
	        }	  
	        @Test(alwaysRun=true, priority=10,enabled=true)
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
	        	ExtentTest test12 = test1.createNode("validateSectionDetailsPage");
	            String extentReportImage11 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
		     	  File src11=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     	  FileUtils.copyFile(src11, new File(extentReportImage11));
		     	  test12.log(Status.INFO,"Screenshot from : " + extentReportImage11).addScreenCaptureFromPath(extentReportImage11);
	        	 test12.log(Status.PASS, "Validated the SectionDetails Page");
	        	 Thread.sleep(4000);
	        }

	        @Test(alwaysRun=true, priority=11,enabled=true)
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
	        	
	        	
//	        	WebElement dateField = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ng2-datetime-picker-wrapper']/input)[1]")));
//	        	dateField.click();
	        //	
//	        	WebElement exactdateChoice = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='month']/b[contains(@class,'prev_next next')])[2]")));
//	        	exactdateChoice.click();
	        	ExtentTest test13 = test1.createNode("validateExportToExcel");
	            String extentReportImage12 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
		     	  File src12=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     	  FileUtils.copyFile(src12, new File(extentReportImage12));
		     	  test13.log(Status.INFO,"Screenshot from : " + extentReportImage12).addScreenCaptureFromPath(extentReportImage12);
	        	WebElement closeIcon = new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src,'dist/assets/images/Button_Export.png')]")));
	        	closeIcon.click();
	        	Thread.sleep(12000);
	        	test13.log(Status.PASS, "Validate ExportToExcel functionality");
	        	
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
	        
	      	ExtentTest test14 = test2.createNode("addNewCustomer");
	        String extentReportImage13 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	     	  File src13=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     	  FileUtils.copyFile(src13, new File(extentReportImage13));
	     	 test14.log(Status.INFO,"Screenshot from : " + extentReportImage13).addScreenCaptureFromPath(extentReportImage13);
	        (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Close')]"))).click();
	        //System.out.println("Customer: " +customerName+ "added successfully");

	        //test2.log(LogStatus.INFO, "Snapshot below: " + test2.addScreenCapture("D:\\CST-AutomationScreenshots"));
	        test14.log(Status.PASS, "Customer: " +customerName+ "added successfully");
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
	        	//tenant.selectByVisibleText("john");
	        	Thread.sleep(6000);
	        	
	        	WebElement saveDetails = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@src,'dist/assets/images/Button_SaveDetails.png')])[4]")));
	        	saveDetails.click();
	        	
	        	
	        	WebElement success = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Success')]")));
	            if(success.isDisplayed())
	            {
	            	ExtentTest test15 = test2.createNode("chillerRegistrationNewCustomer");
	                String extentReportImage14 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	  	     	  File src14=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  	     	  FileUtils.copyFile(src14, new File(extentReportImage14));
	  	     	test15.log(Status.INFO,"Screenshot from : " + extentReportImage14).addScreenCaptureFromPath(extentReportImage14);
	  	     	test15.log(Status.PASS, "Chiller: " +serialNumber+ " added successfully ");
	            	//System.out.println("Chiller:" +serialNumber+ "added successfully");
	            }
	            else
	            {
	            	test2.log(Status.FAIL, "Chiller: " +serialNumber+ " is not added successfully ");
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
	        	//WebElement tenantParticular= (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'john')]")));
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
	        			  ExtentTest test16 = test2.createNode("tenantVerification");
	        		      String extentReportImage15 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
	        	     	  File src15=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	     	  FileUtils.copyFile(src15, new File(extentReportImage15));
	        	     	 test16.log(Status.INFO,"Screenshot from : " + extentReportImage15).addScreenCaptureFromPath(extentReportImage15);
	        	     	test16.log(Status.PASS, "Newly added chiller is registred under desired tenant");
	        			break;
	        		}
	        		
	        	}
	        }
	        
	        @AfterMethod
	        public void tearDown(ITestResult result) throws IOException
	        {
	        if(result.getStatus()==ITestResult.FAILURE)
	        {
	            test1.log(Status.FAIL, "Snapshot below: " + test1.addScreenCaptureFromPath("D:\\CST-AutomationScreenshots"));
	        System.out.println("failed");


	        }
	        }  
	        
	        @AfterTest
	        public void close()
	        {

	            extent.flush();
	        	driver.get("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");
	        }
	      

      
}
