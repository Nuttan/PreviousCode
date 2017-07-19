package UTCTestNGPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	static WebDriver driver = null;
	static Actions actions = null;
	static WebElement ProtocolDropdown = null;
	private static void ScreenShot(String scrnshtName) throws InterruptedException
	{
	                Thread.sleep(3000);                                                       
	                File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                // Now you can do whatever you need to do with it, for example copy somewhere
	                try {
	                            FileUtils.copyFile(screenShot, new File("D:\\CST-AutomationScreenshots\\"+scrnshtName+".png"));
	                    } 
	                catch (IOException e) 
	                {
	                                                                               
	                     e.printStackTrace();
	                }
	}
  
  
	@Test(alwaysRun=true, priority=0)
	public static void LoginAutomatic() throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();	    		
        driver.get("http://localhost:8081/#/login");
        driver.manage().window().maximize();
  	    Thread.sleep(4000);
	    
	    System.out.println(driver.getTitle()+ "      Running in Progress ....");
    
    
		//Explicit wait for input fields to be visible
		WebElement UsrnameField = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
		UsrnameField.sendKeys("devutc@utc.com");
	    driver.findElement(By.id("input-pwd")).sendKeys("Welcome@123");;
	    
	    driver.findElement(By.xpath("//div/div[2]/form[1]/button/div/span")).click();
	    
	}
	@Test(alwaysRun=true, priority=2)
	public static void ConnectivityScreen() throws InterruptedException
	{
		//Explicit wait for Connectivity Icon on HomeScreen
		WebElement ConnectivityIcononHomeScreen = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='square col-md-4 connectivity']")));
		ConnectivityIcononHomeScreen.click();
	}
	@Test(alwaysRun=true, priority=3)
	public static void NativeBacnetLogin() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(50000,TimeUnit.MILLISECONDS);
		//Explicit wait for ProtocolDropdown
		ProtocolDropdown = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='dropdownMenu1' and contains(text(),'select')]//span")));
		ProtocolDropdown.click();
		
		WebElement ProtocolValue = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Native BACnet")));
		ProtocolValue.click();
		//driver.findElement(By.linkText("Native BACnet")).click();
		
		
		driver.findElement(By.xpath("//button[@id='dropdownMenu2']")).click();
		//Explicit wait for Selection of available devices
		WebElement Available_devices_drpdown = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.partialLinkText("19XRPIC5")));
		Available_devices_drpdown.click();
		//To click connect
		driver.findElement(By.xpath("//button[@class='btn btn-success connectbtn ng-binding']")).click();
		
		Thread.sleep(3000);
		
	}
	@Test(alwaysRun=true, priority=4)
	// below is for reading device connection info
	public static void ReadDeviceInfo() throws InterruptedException
	{
		Thread.sleep(15);
		String Deviceinfo = driver.findElement(By.xpath("//div/ng-include/div/div/div/ul")).getText();
		System.out.println("\n" + "\n" +"We are currently Connected to below device" + "\n" + "\n" +Deviceinfo);
		
	}
	
	@Test(alwaysRun=true, priority=6)// below is for navigating the Chiller Overview and Related Tabs
	public static void ChillerOverviewRefresh() throws InterruptedException
	{
		Thread.sleep(5000);
		List <WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("\n" + "\n" + "No. of links Before going to Overview Screen  "+li.size());
		driver.findElement(By.xpath("//*[@id='side']/div/div[2]/ul/li[3]/a[2]/img")).click();
		Thread.sleep(5000);
		//To Click on Refresh
		driver.findElement(By.xpath("//a[@title='Refresh']")).click();
		
		System.out.println("Clicked on Refresh !!"); 
		Thread.sleep(5000);
	}
	
	@Test(alwaysRun=true, priority=6)
	public static void TraceRecording() throws InterruptedException
    {
		WebElement myDynamicElement = null;
		driver.manage().timeouts().implicitlyWait(80000,TimeUnit.MILLISECONDS);
                    
                   myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated
                                                    (By.xpath("//cst[@ng-if='!recordingInprogress']")));                       
                    myDynamicElement.click();
                    
                    System.out.println("Clicked on record button!!"); 
                    
                
                    
                    Thread.sleep(5000);
                    driver.manage().timeouts().implicitlyWait(50000,TimeUnit.MILLISECONDS);
                 
                  
                    myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated
                     (By.xpath("//input[@ng-disabled='noIncrementMinutes()']")));
           
                                  String test=myDynamicElement.getAttribute("value");
                                  System.out.println(test);
                                  int foo = Integer.parseInt(test);
                                  
                                  if (foo >= 0 & foo <= 9){
                                	  ++foo;
                                	  
                                	  String check= "o".concat(Integer.toString(foo));
                                	  foo = Integer.parseInt(check);
                                	  
                                  }
                                  else  
                                  foo++;
                                  String fa=Integer.toString(foo);
                                  myDynamicElement.clear();
                                  myDynamicElement.sendKeys(fa);
                                  
                                  myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated
                                          (By.xpath("//button[contains(text(),'Save & Record')]")));                              
                                  myDynamicElement.click();
                  
                   
    }
	
	@Test(alwaysRun=true, priority=7)
	public static void TabNavigation() throws InterruptedException
    {
                String[] myStringArray = {"Overview","Compressor","Heat Exchanger","Power VFD","Start Up"}; 
                ScreenShot(myStringArray[0]);
                for(int i=1; i<5; i++)
                {
                	Thread.sleep(5000);
                	driver.findElement(By.linkText(myStringArray[i])).click();
                	ScreenShot(myStringArray[i]);
                	
                }
     }
	
	@Test(alwaysRun=true, priority=8)
	public static void Alarms()throws InterruptedException
	{

	      List <WebElement> li = driver.findElements(By.tagName("a"));
	      System.out.println("  Now Executing Alarms/Alerts....");
	      //below is to click on Alarms/Alerts icon in the side bar
	      WebElement AlarmsIcon = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='side']/div/div[2]/ul/li[4]/a[2]")));
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
	}
	@Test(alwaysRun=true, priority=9)
	public static void DisconnectDevice() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//*[@id='side']/div/div[2]/ul/li[1]/a/img")).click();
		Thread.sleep(2000);
		//To Click on Disconnect
		driver.findElement(By.xpath("//button[@class='btn btn-success disConnectbtn ng-binding']")).click();
		System.out.println("\n" + "\n" +"Device Disconnected"); 
	}
	

}
