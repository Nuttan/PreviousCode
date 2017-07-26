package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.xml.sax.SAXException;

import connection.DBConnection;
import properties.LoadFrameworkProp;
import report.TestReport;
import businessFunctions.BusinessFunctions;
import utilities.DynamicWait;
import verification.Verify;
import wrapper.UserActions;

public class Base {
	protected InheritableThreadLocal<RemoteWebDriver> threadDriver = null;
	protected DesiredCapabilities caps;
	protected RemoteWebDriver driver = null;
	protected InheritableThreadLocal<BusinessFunctions> businessFunction = new InheritableThreadLocal<BusinessFunctions>();
	protected InheritableThreadLocal<UserActions> userActions = new InheritableThreadLocal<UserActions>();
	protected InheritableThreadLocal<Verify> verify = new InheritableThreadLocal<Verify>();
	protected InheritableThreadLocal<DynamicWait> dynamicWait = new InheritableThreadLocal<DynamicWait>();
	protected InheritableThreadLocal<DBConnection> dbConnection = new InheritableThreadLocal<DBConnection>();
	LoadFrameworkProp frameworkConfig=new LoadFrameworkProp();

  @BeforeTest
  public void beforeTest() {
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  
  @Parameters({"platform","browser","version"})
  @BeforeMethod
  public void setup(String platform,String browser, String version) throws MalformedURLException {
	  try{
	  DesiredCapabilities caps = new DesiredCapabilities();
	  
	// Setting Up Platforms
	  if(platform.equalsIgnoreCase("Windows"))
	  caps.setPlatform(org.openqa.selenium.Platform.
	  WINDOWS);
	  else if(platform.equalsIgnoreCase("MAC"))
	  caps.setPlatform(org.openqa.selenium.Platform.MAC);
	  
	// Setting Up Browsers
	  if(browser.equalsIgnoreCase("iexplorer"))
	  {
			  caps = new DesiredCapabilities();
			  caps.setBrowserName("iexplorer");
	  //caps.setBrowserName(browser);
	  //caps.setVersion(version);
	  caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	  caps.setVersion(version);
	 
	  }
	  else if(browser.equalsIgnoreCase("Firefox")){
		  caps = new DesiredCapabilities();
		  FirefoxProfile fp = new FirefoxProfile();
		   //fp.setPreference("network.proxy.http", "10.136.71.165");
		  //fp.setPreference("network.proxy.http_port", "80");
		  caps.setCapability("FirefoxProfile", fp);
	  caps.setBrowserName(browser);
	  caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	  }
	  else if(browser.equalsIgnoreCase("Chrome"))
	  {
		  caps=DesiredCapabilities.chrome();
		  caps.setCapability("chrome.switches", Arrays.asList("--incognito"));
		  ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			caps.setCapability("chrome.binary",
					"C:/Users/vtanuku/Desktop/GridExecutables/chromedriver.exe");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
		  
	  }
	// Setting Up Version
	 
	  //System.setProperty("webdriver.ie.driver", "D:\\BMW\\IEDriverServer.exe");
	 //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
	  threadDriver = new InheritableThreadLocal<RemoteWebDriver>();
	  threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
	  businessFunction.set(new BusinessFunctions(threadDriver.get()));
	  verify.set(new Verify(threadDriver.get()));
	  userActions.set(new UserActions(threadDriver.get()));
	  dynamicWait.set(new DynamicWait(threadDriver.get()));
	  dbConnection.set(new DBConnection());
	  }
	  catch(Exception e)
	  {
		  Reporter.log("Browser Setup Failure");
	  }
  }
  public WebDriver getDriver(){
	  RemoteWebDriver driver = threadDriver.get();
	   driver.manage().window().maximize();
	  System.out.println(driver.getSessionId());
	  return driver;
}
		
	@AfterMethod
	public void teardown()
	{
		try{
		//getDriver().manage().deleteAllCookies();
		getDriver().quit();
		}
		catch(Exception e)
		{
			Reporter.log("Browser tear down failure");
		}
	}
  @AfterTest
  public void afterTest() {
	  
	
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
	}
  
  }


