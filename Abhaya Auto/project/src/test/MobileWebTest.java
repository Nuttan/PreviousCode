package test;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.android.ddmlib.AdbCommandRejectedException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.ExtentManager;
import businessFunctions.BusinessFunctions;
import properties.LoadAppConfig;
import utilities.DynamicWait;
import verification.Verify;
import wrapper.UserActions;

public class MobileWebTest
 {
	protected RemoteWebDriver driver = null;
	protected DesiredCapabilities caps;
	protected BusinessFunctions businessFunction;
	protected UserActions userActions;
	protected Verify verify;
	protected DynamicWait dynamicWait;
	ExtentReports extent;
	ExtentTest test;
	ExtentReports extentreport;
    LoadAppConfig appConfig=new LoadAppConfig();
    
    @BeforeSuite
      public void M1(){
        extent = ExtentManager.Instance();
    }
    
    // When running on Infy network
    @BeforeClass
    public void proxySetting(){
    	System.setProperty("http.proxyHost", "10.136.64.150");
		System.setProperty("http.proxyPort", "80");
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
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }

	  @Test
	  public void verifyLogin() throws InterruptedException, AdbCommandRejectedException {
		  test = extent.startTest("Verify Login to the Website", "");
		  driver.get(appConfig.getMobileTestUrl());
		  businessFunction.loginToWebsite();
		  dynamicWait.waitforvisibilityOfElementLocated("HomePageText");
	      verify.isTextPresent("HomePageText");
	      test.log(LogStatus.INFO, "Verify Login to the Website");
	      //test.log(LogStatus.PASS, "Successfully logged into the Website",test.addScreenCapture(ExtentManager.CaptureScreen(driver, ExtentManager.appConfig.getDeviceReportLocation()+"/LoginSuccess")));
	      test.log(LogStatus.PASS, "Successfully logged into the website");
	    }
	  
	  @Test
	  public void updateWebSiteLanguage() throws InterruptedException, AdbCommandRejectedException{
		  test = extent.startTest("Update Website language to English", "");
		  driver.get(appConfig.getMobileTestUrl());
		  businessFunction.loginToWebsite();
		  dynamicWait.waitforvisibilityOfElementLocated("Settings_Icon");
		  userActions.clickOn("Settings_Icon");
		  dynamicWait.waitforvisibilityOfElementLocated("Preffered_Language");
		  userActions.SelectByText("Preffered_Language", "English");
		  userActions.clickOn("Save_Language");
		  dynamicWait.waitforvisibilityOfElementLocated("LanguageSaveFeedback");
		  test.log(LogStatus.INFO, "Changing the website language");
		  verify.isTextPresent("LanguageSaveFeedback");
		  //test.log(LogStatus.PASS, "Updated Website language to English",test.addScreenCapture(ExtentManager.CaptureScreen(driver, ExtentManager.appConfig.getDeviceReportLocation()+"/LanguageSave")));
		  test.log(LogStatus.PASS, "Updated Website language to English");
	  }
	  
	  @Test
	  public void verifyProfilePic() throws InterruptedException{
		  test = extent.startTest("Check user profile picture", "");
		  driver.get(appConfig.getMobileTestUrl());
		  businessFunction.loginToWebsite();
		  dynamicWait.waitforvisibilityOfElementLocated("Dashboard_Link");
		  test.log(LogStatus.INFO, "Checking if the user has profile picture");
		  verify.verifyImagePresent("Smile.jpg","ProfilePicImage");
		  test.log(LogStatus.PASS, "Profile picture exists for the logged in user");
	  }
	  
	  @Test
	  public void verifyDashBoardLink() throws InterruptedException, AdbCommandRejectedException {
		  test = extent.startTest("Verify presence of Dashboard Link", "");
		  driver.get(appConfig.getMobileTestUrl());
		  businessFunction.loginToWebsite();
		  dynamicWait.waitforvisibilityOfElementLocated("Dashboard_Link");
		  verify.isElementDisplayed("Dashboard_Link");
		  test.log(LogStatus.INFO, "Verify presence of Dashboard tab");
	      //test.log(LogStatus.PASS, "Element with name Dashboard exists on the page",test.addScreenCapture(ExtentManager.CaptureScreen(driver, ExtentManager.appConfig.getDeviceReportLocation()+"/DashboardLink")));
	      test.log(LogStatus.PASS, "Element with name Dashboard exists on the page");
	  }
	  
	  @Test
	  public void verifyOnlineUsers() throws InterruptedException, AdbCommandRejectedException{
		  test = extent.startTest("Verify users who are Online", "");
		  driver.get(appConfig.getMobileTestUrl());
		  businessFunction.loginToWebsite();
		  dynamicWait.waitforvisibilityOfElementLocated("Online_Users");
		  userActions.clickOn("Online_Users");
		  dynamicWait.waitforvisibilityOfElementLocated("UsersSection");
		  WebElement parent = userActions.getElement("UsersSection");
		  List<WebElement> users = parent.findElements(By.tagName("a"));
		  test.log(LogStatus.INFO, "Verify users who are currently online");
		  for (int i=0,j=1; i < users.size(); i++,j++){
			  System.out.println("User " +j+ " - " +users.get(i).getText());
		  }
		  try{
			//test.log(LogStatus.PASS, "Online users are: ",test.addScreenCapture(ExtentManager.CaptureScreen(driver, ExtentManager.appConfig.getDeviceReportLocation()+"/OnlineUsers")));
			  test.log(LogStatus.PASS, "User +j+: "+users.get(100).getText());
		  }catch(Exception e){
			  test.log(LogStatus.ERROR, "Cannot get the 100th user details"+ e.getMessage());
		  }
	  }
	  
	  @Test
	  public void saveProfile() throws InterruptedException, AdbCommandRejectedException{
		  test = extent.startTest("Save User Profile", "");
		  driver.get(appConfig.getMobileTestUrl());
		  businessFunction.loginToWebsite();
		  dynamicWait.waitforvisibilityOfElementLocated("Content_Link");
		  userActions.clickOn("Content_Link");
		  dynamicWait.waitforvisibilityOfElementLocated("Profile_FirstName");
		  userActions.clearTextBox("Profile_FirstName");
		  userActions.enterText("Profile_FirstName", "Kitkat");
		  userActions.clearTextBox("Profile_LastName");
		  userActions.enterText("Profile_LastName", "Admin");
		  userActions.clearTextBox("Profile_StudentID");
		  userActions.enterText("Profile_StudentID", "11");
		  userActions.clearTextBox("Profile_DisplayName");
		  userActions.enterText("Profile_DisplayName", "Kitty");
		  userActions.clickOn("SaveProfile");
		  dynamicWait.waitforvisibilityOfElementLocated("SaveProfileFeedback");
		  verify.isTextPresent("SaveProfileFeedback");
		  test.log(LogStatus.INFO, "Save user profile");
		  //test.log(LogStatus.PASS, "Profile saved successfully",test.addScreenCapture(ExtentManager.CaptureScreen(driver, ExtentManager.appConfig.getDeviceReportLocation()+"/ProfileSave")));
		  test.log(LogStatus.PASS, "Profile saved successfully");
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
