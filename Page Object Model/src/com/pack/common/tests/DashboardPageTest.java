package com.pack.common.tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.pack.base.TestBaseSetUp;
import com.pack.common.pageobjects.DashBoardPage;


public class DashboardPageTest extends TestBaseSetUp  {
	
	public WebDriver driver;
	private  DashBoardPage dashboardPage;
	private static String userName="SwainN@UTCCGL.com";

	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Verify the launching of the Carrier Smart Dashboard Page
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=true, priority=1,enabled=true)
	public void setUp() throws InterruptedException{
		driver=getDriver();
		System.out.println("Dashboard page details...");
		dashboardPage = new DashBoardPage(driver);
		try {
			dashboardPage.enterUserNameChrome(userName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Verify the Count of Running Chiller
  	Dependencies                      : --
  	Reviewed By                       : --
  **/	
	@Test(alwaysRun=true, priority=2,enabled=true)
	public void validateRunningChillerCount() throws InterruptedException, IOException {	
		dashboardPage.validateRunningChillerCount();
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Verify the Count of Alarms/Alerts Chiller
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=false, priority=3,enabled=true)
	public void validateAlarmsandAlertChillerCount() throws InterruptedException, IOException {	
		dashboardPage.validateAlarmsandAlertChillerCount();
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Verify the Count of Not Running Chiller
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=false, priority=4,enabled=true)
	public void validateNotRunningChillerCount() throws InterruptedException, IOException {	
		dashboardPage.validateNotRunningChillerCount();
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Verify the Count of Offline Chiller
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=false, priority=5,enabled=true)
	public void validateOfflineChillerCount() throws InterruptedException, IOException {	
		dashboardPage.validateOfflineChillerCount();
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Verify the device location search Functionality
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=false, priority=6,enabled=true)
	public void validateDeviceLocationSearchFunctionality() throws InterruptedException, IOException {	
		dashboardPage.validateDeviceLocationSearchFunctionality();
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Verify the Sorting Functionality in device list grid
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=false, priority=7,enabled=true)
	public void validateSortingFunctionality() throws InterruptedException, IOException {	
		dashboardPage.validateSortingFunctionality();
	}


}


