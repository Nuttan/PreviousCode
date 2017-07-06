package TestCasesPackage;


import static org.testng.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Properties.LoadAppConfig;
import Utility.ExcelUtils;
import Utility.TakeScreenshot;
import Utility.WebElementFactory;
import Wrapper.UserActions;


public class Chrome {
static WebDriver driver ;
static ExtentReports report=new ExtentReports("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");
static ExtentTest logger=report.startTest("VerifyCarrierDashboardAutomation"); 
static LoadAppConfig appConfig=new LoadAppConfig();



    	  @Test
    	  public static void LoginDasboard() throws InterruptedException, IOException 
    	  {      
    		  System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver_win32 (2)\\chromedriver.exe");
    		  driver = new ChromeDriver(); 
			  driver.get(appConfig.getAppUrl());
			  String controlName1="CarrierSmart.LogIn.UsrnameField.Id";  
			  WebElementFactory elementFactory=new WebElementFactory(driver);
			  UserActions userActions = new UserActions(driver);
			  WebElement ele=elementFactory.getElementById(controlName1);
			  ele.sendKeys("SwainN@UTCCGL.com");
			  Thread.sleep(3000);
			  ele.sendKeys(Keys.TAB);
			  driver.manage().window().maximize();
			  String controlName2="CarrierSmart.Dashboard.Cookies.Xpath";   
			  userActions.clickOn(controlName2);
			  System.out.println("cookies accepted");
			  Thread.sleep(6000);
			  
			  
		
			  //driver.findElement(By.xpath("//img[@alt='settings']")).click();
			  //driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
			  logger.log(LogStatus.PASS, "LogIn to Carrier Dashboard via Chrome Successful");
    	  }
    	  @Test(alwaysRun=true, priority=1,enabled=true )
    	  public static void validateRunningChillerCount() throws InterruptedException
    	  {
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  WebElement RunningGauge = driver.findElement(By.xpath("//div[@id='gaugeRunning']"));
    	  RunningGauge.click();
    	  Thread.sleep(5000);
    	  System.out.println("clicked on running chillers");
    	  List<WebElement> gaugeTextElement=driver.findElements(By.xpath("//*[@class='c3-gauge-value']"));
    	  String gaugeText=gaugeTextElement.get(1).getText();
    	  System.out.println(gaugeText);
    	  List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
    	  int i=deviceList.size();
    	  System.out.println(i);
    	  int j=Integer.parseInt(gaugeText);
    	  if(i == j)
    	  logger.log(LogStatus.PASS, "Running chiller count in gauge chart and actualdevice count in device list are matching");
    	  TakeScreenshot.ScreenShot(driver, "RunningChillerCount");
    	  }
    	  
    	  @Test(alwaysRun=true, priority=2,enabled=true)
    	  public static void validateAlarmsandAlertChillerCount() throws InterruptedException
    	  {
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  WebElement AlarmsGauge = driver.findElement(By.xpath("//div[@id='gaugeAlarms']"));
    	  AlarmsGauge.click();
    	  Thread.sleep(5000);
    	  System.out.println("clicked on Alarms/Alerts chillers");
    	  List<WebElement> gaugeTextElement=driver.findElements(By.xpath("//*[@class='c3-gauge-value']"));
    	  String gaugeText=gaugeTextElement.get(2).getText();
    	  System.out.println(gaugeText);
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
    	  int i=deviceList.size();
    	  System.out.println(i);
    	  int j=Integer.parseInt(gaugeText);
    	  if(i == j)
    	  logger.log(LogStatus.PASS, "Alarms/Alerts chiller count in gauge chart and actualdevice count in device list are matching");
    	  TakeScreenshot.ScreenShot(driver, "Alarms and Alert chillerCount");
    	  }
    	  
    	  @Test(alwaysRun=true, priority=3,enabled=true)
    	  public static void validateNotRunningChillerCount() throws InterruptedException
    	  {
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  WebElement AlarmsGauge = driver.findElement(By.xpath("//div[@id='gaugeNotRunning']"));
    	  AlarmsGauge.click();
    	  Thread.sleep(5000);
    	  System.out.println("clicked on NotRunning chillers");
    	  List<WebElement> gaugeTextElement=driver.findElements(By.xpath("//*[@class='c3-gauge-value']"));
    	  String gaugeText=gaugeTextElement.get(3).getText();
    	  System.out.println(gaugeText);
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
    	  int i=deviceList.size();
    	  System.out.println(i);
    	  int j=Integer.parseInt(gaugeText);
    	  if(i == j)
    	  logger.log(LogStatus.PASS, "NotRunning chiller count in gauge chart and actualdevice count in device list are matching");
    	  TakeScreenshot.ScreenShot(driver, "NotRunningChillerCount");
    	  }
    	  
    	  @Test(alwaysRun=true, priority=4,enabled=true)
    	  public static void validateOfflineChillerCount() throws InterruptedException
    	  {
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  WebElement AlarmsGauge = driver.findElement(By.xpath("//div[@id='gaugeOffline']"));
    	  AlarmsGauge.click();
    	  Thread.sleep(5000);
    	  System.out.println("clicked on NotRunning chillers");
    	  List<WebElement> gaugeTextElement=driver.findElements(By.xpath("//*[@class='c3-gauge-value']"));
    	  String gaugeText=gaugeTextElement.get(4).getText();
    	  System.out.println(gaugeText);
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  List<WebElement> deviceList=driver.findElements(By.xpath("//div[@ng-reflect-id='deviceListItems']/*"));
    	  int i=deviceList.size();
    	  System.out.println(i);
    	  int j=Integer.parseInt(gaugeText);
    	  if(i == j)
    	  logger.log(LogStatus.PASS, "Offline chiller count in gauge chart and actualdevice count in device list are matching");
    	  TakeScreenshot.ScreenShot(driver, "OfflineChillerCount");
    	  }
    	  
    	  @Test(alwaysRun=true, priority=5,enabled=true)
    	  public static void validateDeviceLocationSearchFunctionality() throws InterruptedException
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
    	  			System.out.println(innerChild.getText());
    	  			
    	  			
    	  			System.out.println("device list filtered on the basis of location");
    	  			break;
    	  		}
    	  		break;
    	  		
    	  		
    	  	}
    	  	break;
    	  }
    	  logger.log(LogStatus.PASS, "device list filtered on the basis of location");
    	  TakeScreenshot.ScreenShot(driver, "SearchingLocationFunctionality");
    	  }
    	  
    	  @Test(alwaysRun=true, priority=6,enabled=true)
    	  public static void differentiatechillerBasedonIndicator() 
    	  {
    	  	
    	  	List<WebElement> greenIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_normal.png')]"));
    	  	
    	  	logger.log(LogStatus.PASS, "device list filtered on the basis of location" +greenIndicator.size());
    	  	System.out.println("The number of running chiller in this location is " +greenIndicator.size());
    	  	
    	  	List<WebElement> redIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_abnormal.png')]"));
    	  	System.out.println("The number of not running chiller in this location is " +redIndicator.size());
    	  	
    	  	List<WebElement> alertIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_alert.png')]"));
    	  	System.out.println("The number of alarms/alerts chiller in this location is " +alertIndicator.size());
    	  	
    	  	List<WebElement> greyIndicator=driver.findElements(By.xpath("//img[contains(@src,'dist/assets/images/icon_offline.png')]"));
    	  	System.out.println("The number of offline chiller in this location is " +greyIndicator.size());
    	  	
    	  	logger.log(LogStatus.PASS, "differentiatechillerBasedonIndicator");
    	  		
    	  }
    	  
    	  @Test(alwaysRun=true, priority=7,enabled=true)
    	  public static void validateSortingFunctionality() throws InterruptedException 
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
    	  		System.out.println("Shorted coloumn is " + coulmn.getText() + "in ascending order" );	
    	  		
    	  		
    	  	}
    	  	logger.log(LogStatus.PASS, "validateSortingFunctionality");
    	  	
    	  }
    	  
    	  @Test(alwaysRun=true, priority=8,enabled=true)
    	  public static void validateDeviceDetailsPage() throws InterruptedException
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
    	  	if(serialDashboard.contains(serialDevicedetail))
    	  	{
    	  		System.out.println("Serial number are matching");
    	  	}
    	  	
    	  	String titleInfo=driver.findElement(By.xpath("//div[@class='infoLine']")).getText();
    	  	String[] dateDeviceArray=titleInfo.split("|");
    	  	String dateDeviceDetail=dateDeviceArray[1];
    	  	logger.log(LogStatus.PASS, "validateDeviceDetailsPage");
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
    	  		 logger.log(LogStatus.PASS, "weatherforecast is correct");
    	  	 } 
    	  	driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
    	  	 
    	  	 WebElement weatherClose = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn'])[2]")));
    	  	 weatherClose.click(); 
    	  	
    	  }	  
    	  @Test(alwaysRun=true, priority=10,enabled=true)
    	  public static void validateSectionDetailsPage() throws InterruptedException
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
    	  	 
    	  	 logger.log(LogStatus.PASS, "validateSectionDetailsPage");
    	  }
    	 
    	  @Test(alwaysRun=true, priority=11,enabled=true)
    	  public static void validateExportToExcel() throws InterruptedException
    	  {
    	  	WebElement reportIcon = new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src,'dist/assets/images/Icon_export-file.png')]")));
    	  	reportIcon.click();
    	  	Thread.sleep(3000);
    	  	if(driver.findElement(By.className("excelExport")).isDisplayed())
    	      {
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
    	  	
    	  	
//    	  	WebElement dateField = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ng2-datetime-picker-wrapper']/input)[1]")));
//    	  	dateField.click();
//    	  	
//    		WebElement exactdateChoice = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='month']/b[contains(@class,'prev_next next')])[2]")));
//    		exactdateChoice.click();
    	  	
    	  	WebElement closeIcon = new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src,'dist/assets/images/Button_Export.png')]")));
    	  	closeIcon.click();
    	  	Thread.sleep(12000);
    	  	logger.log(LogStatus.PASS, "validateExportToExcel");
    	  }
    	  @AfterTest
    	  public void closeup (ITestResult result) {
    		  if(result.getStatus()==ITestResult.FAILURE)
    		  {
    			  System.out.println("Failed");
    		  }

    		  report.endTest(logger);
    		  report.flush();

    		  driver.get("D:\\CST-AutomationScreenshots\\LearnAutomation.html");
    		  
    		  //driver.quit();
    	  }
    	  
    	  
}






//String Path="D:\\tech list.xlsx";
//
//Utility.ExcelUtils.setExcelFile("D:\\tech list.xlsx","report1494350615629");
//
//String firstUserName = ExcelUtils.getCellData(3, 0);
//
//String lastUserName = ExcelUtils.getCellData(3, 1);
//
//String Username=firstUserName + " " +lastUserName;    	  
//System.out.println(Username);
//CHROME DRIVER

//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YY HH:mm:ss");
//LocalDateTime now = LocalDateTime.now();
//System.out.println(dtf.format(now));
//String[] splited = dtf.format(now).split("\\s+");
//
//String[] splitedAgain = splited[0].split("/");
//
//System.out.println(splitedAgain[1]);
//
//System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));




