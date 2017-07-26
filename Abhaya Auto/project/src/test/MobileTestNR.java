package test;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import properties.LoadAppConfig;
import utilities.DynamicWait;
import utilities.WebElementFactory;
import verification.Verify;
import wrapper.UserActions;
import businessFunctions.BusinessFunctions;

import com.android.ddmlib.AdbCommandRejectedException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MobileTestNR {

		protected RemoteWebDriver driver = null;
		protected DesiredCapabilities caps;
		protected BusinessFunctions businessFunction;
		protected UserActions userActions;
		protected Verify verify;
		protected DynamicWait dynamicWait;
		protected WebElementFactory webelementfactory;
		ExtentReports extent;
		ExtentTest test;
		
	    LoadAppConfig appConfig=new LoadAppConfig();
	    
	    @BeforeSuite
	    public void M1(){
	        extent = ExtentManager.Instance();
	    }
	    	  
	    @Parameters({"browser","platform","version"})
	    @BeforeMethod
		  public void startUp(String browser, String platform, String version) throws Exception{
			  try{
				  extent.addSystemInfo("Browser", browser);
				  extent.addSystemInfo("Platform", platform);
				  extent.addSystemInfo("Version", version);
				  if (browser.equalsIgnoreCase("AndroidDriverWebViewApp")){
					  caps = SelendroidCapabilities.android();
					  driver = new SelendroidDriver(caps);
					  }
				  else if (browser.equalsIgnoreCase("chrome")){				        
				        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
				        caps = DesiredCapabilities.chrome();
				        ChromeOptions options = new ChromeOptions();
				        options.addArguments("--disable-extensions");
				        options.addArguments("ignore-certificate-errors");
				        caps.setCapability(ChromeOptions.CAPABILITY, options);
				        
				        driver = new ChromeDriver(caps);
				        driver.manage().window().maximize();
				  }
				  businessFunction=new BusinessFunctions(driver);
				  userActions= new UserActions(driver);
				  verify=new Verify(driver);
				  dynamicWait= new DynamicWait(driver);
				  webelementfactory = new WebElementFactory(driver);
			  }catch(Exception e){
				  e.printStackTrace();
			  }
		  }

		  @Test
		  public void registerUser() throws InterruptedException, AdbCommandRejectedException {
			  test = extent.startTest("Register User to a Website", "");
			  driver.get(appConfig.getMobileNonResponsiveUrl());
			  userActions.clearTextBox("MercuryTours_UserName");
			  userActions.enterText("MercuryTours_UserName", "mercury");
			  userActions.clearTextBox("MercuryTours_Password");
			  userActions.enterText("MercuryTours_Password", "mercury");
			  userActions.clickOn("MercuryTours_LoginButton");
			  dynamicWait.waitforvisibilityOfElementLocated("MercurySupport_Link");
			  userActions.clickOn("MercurySupport_Link");
			  dynamicWait.waitforvisibilityOfElementLocated("MercuryRegister_Link");
			  userActions.clickOn("MercuryRegister_Link");
			  userActions.enterText("FirstName", "test");
			  userActions.enterText("LastName", "user");
			  userActions.enterText("Phone", "1234567899");
			  userActions.enterText("Email", "testuser@gmail.com");
			  userActions.enterText("Address", "Campbell Road");
			  userActions.enterText("City", "Houston");
			  userActions.SelectByText("Country", "INDIA ");
			  userActions.enterText("UserName", "testuser");
			  userActions.enterText("Password", "11223344");
			  userActions.enterText("ConfirmPassword", "11223344");
			  userActions.submitOn("RegisterUserSubmit");
			  dynamicWait.waitforvisibilityOfElementLocated("RegisterSuccessFeedback");
			  verify.isTextPresent("RegisterSuccessFeedback");
			  //test.log(LogStatus.PASS, "User is successfully registered",test.addScreenCapture(ExtentManager.CaptureScreen(driver, ExtentManager.appConfig.getDeviceReportLocation()+"/RegisterUser")));
			  test.log(LogStatus.PASS, "User is successfully registered");
		  }
		  
		 @AfterMethod
		  public void close() {
		    if (driver != null) {
		      driver.quit();
		  }
		}
		  
		  @AfterSuite(alwaysRun = true)
		    public void endReport(){
		          extent.endTest(test);
		          extent.flush();
		    }

	}
