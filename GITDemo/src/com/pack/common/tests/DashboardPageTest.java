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
		
	@Test(alwaysRun=true, priority=2,enabled=true)
	public void validateRunningChillerCount() throws InterruptedException, IOException {	
		dashboardPage.validateRunningChillerCount();
	}
	
	@Test(alwaysRun=false, priority=3,enabled=true)
	public void validateAlarmsandAlertChillerCount() throws InterruptedException, IOException {	
		dashboardPage.validateAlarmsandAlertChillerCount();
	}
	
	@Test(alwaysRun=false, priority=4,enabled=true)
	public void validateNotRunningChillerCount() throws InterruptedException, IOException {	
		dashboardPage.validateNotRunningChillerCount();
	}
	
	@Test(alwaysRun=false, priority=5,enabled=true)
	public void validateOfflineChillerCount() throws InterruptedException, IOException {	
		dashboardPage.validateOfflineChillerCount();
	}
	
	@Test(alwaysRun=false, priority=6,enabled=true)
	public void validateDeviceLocationSearchFunctionality() throws InterruptedException, IOException {	
		dashboardPage.validateDeviceLocationSearchFunctionality();
	}
	
	@Test(alwaysRun=false, priority=7,enabled=true)
	public void validateSortingFunctionality() throws InterruptedException, IOException {	
		dashboardPage.validateSortingFunctionality();
	}


}


