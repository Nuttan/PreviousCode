package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import properties.LoadFrameworkProp;
import businessFunctions.CMSBusinessFunctions;
import utilities.CMSWebElementFactory;
import utilities.DynamicWait;
import verification.CMSVerify;
import verification.Verify;
import wrapper.CMSUserActions;


public class CMSBase {
	protected InheritableThreadLocal<RemoteWebDriver> threadDriver = null;
	protected DesiredCapabilities caps;
	protected RemoteWebDriver driver = null;
	protected InheritableThreadLocal<CMSBusinessFunctions> cmsBusinessFunction = new InheritableThreadLocal<CMSBusinessFunctions>();
	protected InheritableThreadLocal<CMSUserActions> cmsUserActions = new InheritableThreadLocal<CMSUserActions>();
	protected InheritableThreadLocal<CMSWebElementFactory> cmsElementFactory = new InheritableThreadLocal<CMSWebElementFactory>();
	protected InheritableThreadLocal<CMSVerify> cmsVerify = new InheritableThreadLocal<CMSVerify>();
	protected InheritableThreadLocal<DynamicWait> cmsDynamicWait = new InheritableThreadLocal<DynamicWait>();
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
	  
	  caps = new DesiredCapabilities();
	  
	// Setting Up Platforms
	  if(platform.equalsIgnoreCase("Windows"))
	  caps.setPlatform(org.openqa.selenium.Platform.
	  WINDOWS);
	  else if(platform.equalsIgnoreCase("MAC"))
	  caps.setPlatform(org.openqa.selenium.Platform.MAC);
	  
	// Setting Up Browsers
	 
	 
 // caps=DesiredCapabilities.internetExplorer();
	 // caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	  /*caps.setBrowserName("iexplorer");
	  caps.setPlatform(Platform.WINDOWS);
	  caps.setVersion("11");*/
	  caps=DesiredCapabilities.chrome();
	  
	// Setting Up Version
	  //caps.setVersion(version);
	  //System.setProperty("webdriver.ie.driver", "D:\\BMW\\IEDriverServer.exe");
	 //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
	  threadDriver = new InheritableThreadLocal<RemoteWebDriver>();
	  threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
	  cmsBusinessFunction.set(new CMSBusinessFunctions(threadDriver.get()));
	  cmsVerify.set(new CMSVerify(threadDriver.get()));
	  cmsUserActions.set(new CMSUserActions(threadDriver.get()));
	  cmsDynamicWait.set(new DynamicWait(threadDriver.get()));
	  cmsElementFactory.set(new CMSWebElementFactory(threadDriver.get()));
  }
  public WebDriver getDriver(){
	  RemoteWebDriver driver = threadDriver.get();
	  driver.manage().window().maximize();
	  System.out.println(driver.getSessionId());
		//driver.setRemoteDriver(driver);
		if(driver.getSessionId()==null)
		{
			threadDriver = new InheritableThreadLocal<RemoteWebDriver>();
			  try {
				threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			 
		}
		return driver;
}
		
	@AfterMethod
	public void teardown()
	{
		
		//getDriver().manage().deleteAllCookies();
		getDriver().quit();
		
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