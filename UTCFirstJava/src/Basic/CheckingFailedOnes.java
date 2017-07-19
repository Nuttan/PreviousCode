package Basic;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CheckingFailedOnes {
	
	static WebDriver driver = null;
	static Actions actions = null;
	static WebElement ProtocolDropdown = null;
	
	static ExtentReports report=new ExtentReports("D:\\CST-AutomationScreenshots\\CSTAutomation.html");
	static ExtentTest logger=report.startTest("CarrierServiceTool-Automation"); 
	

		private static void ScreenShot(String scrnshtName) throws InterruptedException
	{
	                Thread.sleep(3000);                                                       
	                File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                // Now you can do whatever you need to do with it, for example copy somewhere for arpit
	                try {
	                            FileUtils.copyFile(screenShot, new File("D:\\CST-AutomationScreenshots\\"+scrnshtName+".png"));
	                    } 
	                catch (IOException e) 
	                {
	                                                                               
	                     e.printStackTrace();
	                }
	}
		
	
		
		
	@Test(alwaysRun=true, priority=0,enabled=true)
	public static void LoginAutomatic() throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();	    		
        driver.get("http://localhost:8081/#/login");
        driver.manage().window().maximize();
  	    Thread.sleep(4000);
	    
  	   // logger.log(LogStatus.INFO, "Application is up and running");
    
    
		//Explicit wait for input fields to be visible
		WebElement UsrnameField = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
		UsrnameField.sendKeys("Nuttanabhijan.swain@utc.com");
	    driver.findElement(By.id("input-pwd")).sendKeys("P@ssw0rd123");;
	    
	    driver.findElement(By.xpath("//div/div[2]/form[1]/button/div/span")).click();
	    Thread.sleep(8000);
	    logger.log(LogStatus.PASS, "LogIn Automatic Passed");
	    
	}
	
	@Test(alwaysRun=true, priority=1,enabled=true)
	public static void HomeScreenNoconnectioToDevice() throws InterruptedException
    {
		driver.manage().timeouts().implicitlyWait(50000,TimeUnit.MILLISECONDS);
      String getText = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='side']/div/div[2]/ul/li[4]/a[2]/img"))).getText();
      
      //logger.log(LogStatus.INFO, "Device not COnnected now hence - Chiller Info Tab is unavailable"+" "+ getText);
      System.out.println("Device not COnnected now hence - Chiller Info Tab is unavailable"+" "+ getText);
      
      
      String getText1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='content']/div/div/div[2]/div[2]/div[3]/div[1]"))).getText();
      
      //logger.log(LogStatus.INFO, "Device not COnnected now hence -  Alarms and Alerts Tab is unavailable"+" "+ getText);
      System.out.println("Device not COnnected now hence -  Alarms and Alerts Tab is unavailable"+" "+getText1);
      
      logger.log(LogStatus.PASS, "HomeScreenNoconnectioToDevice Passed");

    }
	
	@Test(alwaysRun=true, priority=2,enabled=true)
	public static void ConnectivityScreen() throws InterruptedException
	{
		//Explicit wait for Connectivity Icon on HomeScreen
		WebElement ConnectivityIcononHomeScreen = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='square col-md-4 connectivity']")));
		ConnectivityIcononHomeScreen.click();
	}
	
	@Test(alwaysRun=true, priority=3,enabled=true)
	public static void NativeBacnetLogin() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(50000,TimeUnit.MILLISECONDS);
		//Explicit wait for ProtocolDropdown
		ProtocolDropdown = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='dropdownMenu1' and contains(text(),'select')]//span")));
		ProtocolDropdown.click();
		
		WebElement ProtocolValue = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Native BACnet")));
		ProtocolValue.click();
		
		  driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);
		//driver.findElement(By.linkText("Native BACnet")).click();
		
		
		driver.findElement(By.xpath("//button[@id='dropdownMenu2']")).click();
		//Explicit wait for Selection of available devices
		WebElement Available_devices_drpdown = new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("30XV")));
		Available_devices_drpdown.click();
		//To click connect
		driver.findElement(By.xpath("//button[@class='btn btn-success connectbtn ng-binding']")).click();
		
		Thread.sleep(3000);
		
		logger.log(LogStatus.PASS, "NativeBacnetLogin Passed");
		
	}
	

	@Test(alwaysRun=true, priority=4,enabled=true,dependsOnMethods="NativeBacnetLogin")// below is for navigating the Chiller Overview and Related Tabs
	public static void ChillerOverviewRefresh() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='side']/div/div[2]/ul/li[3]/a[2]/img")).click();
		Thread.sleep(5000);
		//To Click on Refresh
		//driver.findElement(By.xpath("//a[@title='Refresh']")).click();
		//logger.log(LogStatus.INFO, "Clicked on Refresh !!");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//System.out.println("Clicked on Refresh !!"); 
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "ChillerOverviewRefresh Passed");
	}
	@Test(alwaysRun=true, priority=5, enabled=true)
	public static void TabNavigation() throws InterruptedException
{
                String[] myStringArray = {"Overview","Compressor","Heat Exchanger","Power VFD","Start up"}; 
                System.out.println(myStringArray.length);
               // ScreenShot(myStringArray[0]);
                for(int i=0; i<5; i++)
                {
                	Thread.sleep(5000);
                	driver.findElement(By.linkText(myStringArray[i])).click();
                	ScreenShot(myStringArray[i]);
                	
                }
                
                logger.log(LogStatus.PASS, "TabNavigation Passed");
                driver.findElement(By.linkText("Overview")).click();
                Thread.sleep(5000);
}
	@Test(alwaysRun=true, priority=6,enabled=true)
	public static void TraceRecording() throws InterruptedException
    {
		WebElement myDynamicElement = null;
	    myDynamicElement = (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable
                (By.xpath("//i[@class='material-icons' and contains(text(),'fiber')]")));  
                            
         myDynamicElement.click();        
         System.out.println("Clicked on record button!!"); 
         Thread.sleep(5000);
         
         Date date = new Date();
	      String strDateFormat = "h:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String formattedDate=sdf.format(date);
	      String[] totalPhase1=formattedDate.split(" ");
	      String Phase1=totalPhase1[0];
	      String median=totalPhase1[1];
	      String[] totalPhase2=Phase1.split(":");
	      String hour=totalPhase2[0];
	      String minute=totalPhase2[1];
	      
	      int j=Integer.parseInt(minute);
	      int l=j+1;
	      int k=j+15;
	      String minute1=String.valueOf(l);
	      String minute2=String.valueOf(k);
         driver.manage().timeouts().implicitlyWait(50000,TimeUnit.MILLISECONDS);   
         
         if(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateHours()'])[1]"))).isDisplayed()==true)
         {
        	 System.out.println("Web element hour1 identified");
        	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateHours()'])[1]"))).clear();
        	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateHours()'])[1]"))).sendKeys(hour);
         }
         Thread.sleep(3000);
         if(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateMinutes()'])[1]"))).isDisplayed()==true)
         {
        	 System.out.println("Web element minute1 identified");
        	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateMinutes()'])[1]"))).clear();
        	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateMinutes()'])[1]"))).sendKeys(minute1);
         }
         Thread.sleep(3000);
         
         
        if ( new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@ng-disabled='noToggleMeridian()'])[1]"))).getText().contains(median)==false)
        {
        	System.out.println("Web element median1 identified");
        	new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@ng-disabled='noToggleMeridian()'])[1]"))).click();
        }
        Thread.sleep(3000);
         
        if(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateHours()'])[2]"))).isDisplayed()==true)
        {
        	if(k<60)
        	{
       	 System.out.println("Web element hour2 identified");
       	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateHours()'])[2]"))).clear();
       	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateHours()'])[2]"))).sendKeys(hour);
        	}
        	
        	else if(k>60)
        	{
        		
        		 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='glyphicon glyphicon-chevron-up'])[4]"))).click();
//        		  int m=Integer.parseInt(hour);
//    	    	  m++;
//    	    	  String hour2=String.valueOf(m);
//        		 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateHours()'])[2]"))).clear();
//               	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateHours()'])[2]"))).sendKeys(hour2);
        	}
        }
        Thread.sleep(3000);
         
        if(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateMinutes()'])[2]"))).isDisplayed()==true)
        {
        	if(k<60)
        	{
        	
       	 System.out.println("Web element minute2 identified");
       	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateMinutes()'])[2]"))).clear();
       	 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@ng-change='updateMinutes()'])[2]"))).sendKeys(minute2);
        	}
        	else if(k>60)
        	{
        		System.out.println("Web element minute2 identified");
        	}
        }
         
        if ( new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@ng-disabled='noToggleMeridian()'])[2]"))).getText().contains(median)==false)
        {
        	System.out.println("Web element median2 identified");
        	new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@ng-disabled='noToggleMeridian()'])[2]"))).click();
        }
         new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='dropdownMenu2']/span"))).click(); 
         
         new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='traceconfiguration']/div/div/div[1]/div[2]/div/div/ul/li[2]/a"))).click();
         
         new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='traceconfiguration']/div/div/div[1]/div[2]/div/div/input"))).clear();
         
         new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='traceconfiguration']/div/div/div[1]/div[2]/div/div/input"))).sendKeys("3");
                       
                       myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated
                               (By.xpath("//button[contains(text(),'Save & Record')]")));                              
                       myDynamicElement.click();             
                       //Thread.sleep(8000);         
                       myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated
                               (By.xpath("//cst[@class='record-label ng-scope']")));  
                       Thread.sleep(13000);
                       if(myDynamicElement.getText().contains("Stop Recording"))
                       {
                    	   System.out.println("started Recording");
                    	   logger.log(LogStatus.PASS, "TraceRecording Passed");
                       }
    }
	
	
	@Test(alwaysRun=true, priority=7, enabled=true)
	public static void TrendReportsAddNewConfigurationAddDatapoints() throws InterruptedException 
    {
          driver.findElement(By.xpath("//*[@id='side']/div/div[2]/ul/li[5]")).click();
      Thread.sleep(3000);
      driver.findElement(By.linkText("Trend Configuration")).click();
      Thread.sleep(3000);
      driver.findElement(By.className("new-config")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id='trendReport']/div[6]/ng-include/div/div[1]/div/div[1]/ul/li[2]/input")).sendKeys("Configuration 1");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id='trendReport']/div[6]/ng-include/div/div[1]/div/div[3]/ul/li[2]/div/div[2]/table/tbody/tr[1]/td[3]/a")).click();
      Thread.sleep(3000);
      for(int i = 1; i <= 4; i++)
      {
      driver.findElement(By.xpath("//*[@id='trendReport']/div[6]/ng-include/div/div[3]/div/div[3]/div[1]/button")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id='display-text']")).sendKeys("t");
      Thread.sleep(3000);
      actions = new Actions(driver);
      actions.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER).build().perform();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id='insert-point-config']/div/div/div[2]/div[2]/div[2]/input")).sendKeys("10");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='insert-point-config']/div/div/div[3]/ul/li/a")).click();
      Thread.sleep(2000);
      }
      driver.findElement(By.xpath("//*[@id='trendReport']/div[6]/ng-include/div/div[3]/div/div[4]/ul/li[2]/button")).click();
      Thread.sleep(2000);
      
      logger.log(LogStatus.PASS, "TrendReportsAddNewConfigurationAddDatapoints Passed");
      
     Thread.sleep(4000);
      
    }
	@Test(alwaysRun=true, priority=10,enabled=true)
	public static void Alarms()throws InterruptedException
	{
	    
	      System.out.println("  Now Executing Alarms/Alerts....");
	      //below is to click on Alarms/Alerts icon in the side bar  (//img[contains(@title,'Alarms & Alerts')])[1]
	      WebElement AlarmsIcon = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='side']/div/div[2]/ul/li[4]/a[1]/img")));
	      AlarmsIcon.click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div[1]/ul/li[1]/a")).click();
	      //Calling Screenshot method to take the screen shot of current Tab
	      ScreenShot("CurrentAlarms");
	      
	      //Click on Historical Tab
	      driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/div[1]/ul/li[2]/a")).click();
	      //Calling Screenshot method to take the screen shot of Historical Tab
	      ScreenShot("HistoricalAlarms");
	      System.out.println("  Finished Alarms/Alerts....");
	    //  logger.log(LogStatus.INFO, "  Finished Alarms/Alerts....");
	      logger.log(LogStatus.PASS, "Alarms Passed");
	}
	@Test(alwaysRun=true, priority=11,enabled=true)
	public static void DisconnectDevice() throws InterruptedException
	{
		WebElement connectivityIcon = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='side']/div/div[2]/ul/li[1]/a/img")));
		
		connectivityIcon.click();
		//driver.findElement(By.xpath("//*[@id='side']/div/div[2]/ul/li[1]/a/img")).click();
		Thread.sleep(6000);
		//To Click on Disconnect
		
		WebElement disconnectIcon = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-success disConnectbtn ng-binding']")));
		
		disconnectIcon.click();
		//driver.findElement(By.xpath("//button[@class='btn btn-success disConnectbtn ng-binding']")).click();
		System.out.println("\n" + "\n" +"Device Disconnected"); 
		
		  //logger.log(LogStatus.INFO, "\n" + "\n" +"Device Disconnected");
		  logger.log(LogStatus.PASS, "DisconnectDevice");
	}
	@Test(alwaysRun=true, priority=12,enabled=true)
	public static void ReportsOffline() throws InterruptedException
	{
	      
		Thread.sleep(5000);
	  //method used to click on User Profile button.
		
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='dropdown profile-drop fliter-dropdown']/button/span"))).click();
	    //driver.findElement(By.xpath("//span[@class='dropdown profile-drop fliter-dropdown']/button/span")).click();
	     
	   //To select user temperature Preference.
	     driver.findElement(By.xpath("//*[@id='btnTemperature']/span")).click();
	     Thread.sleep(5000);
	   ////To select temperature as 'Fahrenheit'.
	     driver.findElement(By.linkText("Metric")).click();
	   //waiting thread for 5 second.
	     Thread.sleep(5000); 
	   //Clicking on save.
	    driver.findElement(By.xpath("//button[@ng-click='updateProfile()']")).click(); 
	   
	    
	     driver.navigate().refresh();
	     
	     Thread.sleep(10000);
	     //List <WebElement> li = driver.findElements(By.tagName("a"));
	     
	      //below is to click on Reports icon in the side bar
	     WebElement ReportsIcon = (new WebDriverWait(driver, 10)).
                 until(ExpectedConditions.elementToBeClickable(By.xpath
                             ("//*[@id='side']/div/div[2]/ul/li[5]/a[1]")));
	     //Clicking on Reports Tab
	     ReportsIcon.click();
	     Thread.sleep(5000);
	     
	     WebElement selectDevice = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//button[@id='dropdownMenu11']")));
	     selectDevice.click();
	     Thread.sleep(5000);
	     WebElement desiredDevice = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-menu device-menu']/li[2]/a/span")));
	     
	     //      //ul[@class='dropdown-menu device-menu']/li[2]/a/span
	     desiredDevice.click();
	     Thread.sleep(5000);
	     
	     
	     System.out.println("Before report select dropdown");
	     
	     WebElement selectReport = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//button[@id='dropdownMenu1']")));
           //    ((.//*[@id='dropdownMenu1'])[1]/span)[2]    //button[@class='btn btn-default dropdown-toggle second-div-btn']
	     selectReport.click();
	     Thread.sleep(5000);
	     
	     System.out.println("clicking arrow mark of select dropdown");

	     WebElement desiredReport = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("NuttanReport")));
	     desiredReport.click();
	     Thread.sleep(5000);

	     
	     System.out.println("selecting desired report");
	     Thread.sleep(5000);
	   //MouseOver
	      
	        List<String> barValues = new ArrayList<String>();
            Actions mousemove = new Actions(driver);
            WebElement chartSeriesGroup = driver.findElement(By.className("highcharts-series-group"));
            WebElement chartSeries = chartSeriesGroup.findElement(By.className("highcharts-series"));
            List<WebElement> rectTags = chartSeries.findElements(By.tagName("path")); 
            System.out.println(rectTags.size());
            
            for (int i=0;i<rectTags.size();i++ )
            {
            	try{
  	    		  mousemove.moveToElement(rectTags.get(i)).build().perform(); //Hover mouse on bar.
  	              System.out.println("Hovering performed");
  	  	        }
  	  	        catch(StaleElementReferenceException e)
  	  	        {
  	  	        	mousemove.moveToElement(rectTags.get(i)).perform(); //Hover mouse on bar.
  	  	        	System.out.println("Stale element reference exception will be handeled here");
  	  	        }
            }
       Thread.sleep(6000);
       ScreenShot("Metric");
	     
	     //Do the above thing for Celcius
	   //method used to click on User Profile button.
	     driver.findElement(By.xpath("//span[@class='dropdown profile-drop fliter-dropdown']/button/span")).click();
	      Thread.sleep(5000);
	    //To select user temperature Preference.
	      driver.findElement(By.xpath("//*[@id='btnTemperature']/span")).click();
	      Thread.sleep(5000);
	    ////To select temperature as 'Farhenhite'.
	      driver.findElement(By.linkText("Imperial")).click();
	    //waiting thread for 5 second.
	      Thread.sleep(5000); 
	    //Clicking on save.
	     driver.findElement(By.xpath("//button[@ng-click='updateProfile()']")).click(); 
	      Thread.sleep(5000); 
	      driver.navigate().refresh();
	      Thread.sleep(10000);
	      //below is to click on Reports icon in the side bar
	      WebElement ReportsIcon1 = (new WebDriverWait(driver, 10)).
	                 until(ExpectedConditions.elementToBeClickable(By.xpath
	                             ("//*[@id='side']/div/div[2]/ul/li[5]/a[1]")));
	      //Clicking on Reports Tab
	      ReportsIcon1.click();
	      WebElement selectDevice1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(
	                  By.xpath("//button[@id='dropdownMenu11']")));
	      selectDevice1.click();
	      WebElement Device1 = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("30XV")));
	      Device1.click();
	    //Select Report
	      WebElement selectReport1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(
	                  By.xpath("//button[@class='btn btn-default dropdown-toggle second-div-btn']")));
	      selectReport1.click();
	      WebElement Report1 = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("NuttanReport")));
	      Report1.click();
	      
	      List<String> barValues2 = new ArrayList<String>();
          Actions mousemove2 = new Actions(driver);
          WebElement chartSeriesGroup2 = driver.findElement(By.className("highcharts-series-group"));
          WebElement chartSeries2 = chartSeriesGroup2.findElement(By.className("highcharts-series"));
          List<WebElement> rectTags2 = chartSeries2.findElements(By.tagName("path")); 
          System.out.println(rectTags2.size());
	      
	      for (int i=0;i<rectTags2.size();i++ )
          {
	    	  
	    	  try{
	    		  mousemove2.moveToElement(rectTags2.get(i)).perform(); //Hover mouse on bar.
	              System.out.println("Hovering performed");
	  	        }
	  	        catch(StaleElementReferenceException e)
	  	        {
	  	        	mousemove.moveToElement(rectTags2.get(i)).perform(); 
	  	        	System.out.println("Stale element reference exception will be handeled here");
	  	        }

          }

	      ScreenShot("Imperial");
	      
	      logger.log(LogStatus.FAIL, "Reports Offline failed");
	}
	@Test(alwaysRun=true, priority=13, enabled=true)
	public static void UpdateProfile()throws InterruptedException
    {
      Thread.sleep(5000); //waiting thread for 5 second.
          driver.findElement(By.xpath("//span[@class='dropdown profile-drop fliter-dropdown']/button/span")).click();//method used to click on User Profile button.
      
      Thread.sleep(5000);
      driver.findElement(By.xpath("//*[@id='btnFontsize']")).click();//To select user font Preference.
      
      Thread.sleep(5000);
      driver.findElement(By.linkText("Medium")).click();// To select  font size as 'Medium'.
                        
      Thread.sleep(5000);
      driver.findElement(By.xpath("//*[@id='btnLanguage']")).click();//To select user language Preference.
      
      Thread.sleep(5000);
      driver.findElement(By.linkText("Chinese")).click();// To select language as 'Chinese'.
      
      Thread.sleep(5000);
      driver.findElement(By.xpath("//*[@id='btnTemperature']/span")).click();//To select user temperature Preference.
      //
      Thread.sleep(5000);
      driver.findElement(By.linkText("Metric")).click();// To select temperature as 'Celsius'.

      Thread.sleep(5000); //waiting thread for 5 second.
          driver.findElement(By.xpath("//button[@ng-click='updateProfile()']")).click(); //Clicking on save.
      
      Thread.sleep(5000); //waiting thread for 5 second.
      
      String changedLanngString = driver.findElement(By.xpath("//*[@id='mydiv']/div[2]/div[3]/div[1]/label")).getText(); //Clicking on save.
      System.out.println("Printing prefered language"+" "+ changedLanngString);
      
      logger.log(LogStatus.PASS, "UpdateProfile passed");
    }
	@Test(alwaysRun=true, priority=14,enabled=true)
	public static void Logout() throws InterruptedException

    {
          driver.findElement(By.xpath("//button[@ng-click='logoutWindow()']")).click();  
          Thread.sleep(10000);
          driver.close();
          
          logger.log(LogStatus.PASS, "Logout Sucessful");
    }
	@Test(alwaysRun=true, priority=15,enabled=true)
	public static void AboutScreen() throws InterruptedException
    {
		Thread.sleep(3000);
		CheckingFailedOnes.LoginAutomatic();
		Thread.sleep(6000);
		WebElement AboutScreeninfo =  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='help-ahc']")));    
		AboutScreeninfo.click();
		Thread.sleep(6000);	
		logger.log(LogStatus.PASS, "AboutScreen Sucessful");	    
    }
	
	 @AfterMethod
     public void tearDown(ITestResult result) throws IOException
     {
     if(result.getStatus()==ITestResult.FAILURE)
     {
    	 logger.log(LogStatus.FAIL, "Snapshot below: " + logger.addScreenCapture("D:\\CST-AutomationScreenshots"));
     System.out.println("failed");


     }
     }  
     
     @AfterTest
     public void close()
     {

    	 report.flush();
     	driver.get("D:\\CST-AutomationScreenshots\\CSTAutomation.html");
     }
	
	

	
	

}
