package test;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import businessFunctions.BusinessFunctions;
import utilities.DynamicWait;
import verification.Verify;

public class BaseTest {
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	public static DynamicWait wait;
	public static Verify verify;
	protected RemoteWebDriver driver;
	public static BusinessFunctions businessFunction;
	//public static ScreenShots screenshots;
	@Parameters({"platform","browser","version"})
	@BeforeMethod
	public void setUp()  {
		try
		{
		
		threadDriver = new ThreadLocal<RemoteWebDriver>();		
		DesiredCapabilities dc = new DesiredCapabilities();
		//FirefoxProfile fp = new FirefoxProfile();
		//dc.setCapability(FirefoxDriver.PROFILE, fp);
		//dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
		dc.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
		//dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
		threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
		getDriver().manage().window().maximize();
		businessFunction = new BusinessFunctions(getDriver());
		wait = new DynamicWait(getDriver());
		verify = new Verify(getDriver());	
		}
		catch(MalformedURLException e)
		{
			new MalformedURLException("The protocol given in the address as URL may not be a correct (valid) one for the job orThe address given in the URL constructor may not be evaluated successfully (due to wrong format etc) by the networking software.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			new IOException("Error in Clearing the browser cookies");
		}
		
		}
	
	public RemoteWebDriver getDriver(){
	
		
		driver = threadDriver.get();
		 ((JavascriptExecutor) driver).executeScript("window.focus();");
		//DriverFactory.setRemoteDriver(driver);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;
	}
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
