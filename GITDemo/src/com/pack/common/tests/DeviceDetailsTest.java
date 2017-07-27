package com.pack.common.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pack.base.TestBaseSetUp;
import com.pack.common.pageobjects.DashBoardPage;
import com.pack.common.pageobjects.DeviceDetailsPage;
import com.pack.utilities.WebElementFactory;
import com.pack.wrapper.UserActions;

public class DeviceDetailsTest extends TestBaseSetUp {
	
	public WebDriver driver;
	private  DeviceDetailsPage deviceDetailsPage;	
	private  DashBoardPage dashboardPage;
	private static String userName="SwainN@UTCCGL.com";
	

	@Test(alwaysRun=true, priority=8,enabled=true)
	public void setUp() throws InterruptedException {
		driver=getDriver();
		dashboardPage = new DashBoardPage(driver);
		try {
			dashboardPage.enterUserNameChrome(userName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		deviceDetailsPage=new DeviceDetailsPage(driver);
	}
	
	@Test(alwaysRun=true, priority=9,enabled=true)
	public void validateDeviceDetailsPage() throws InterruptedException, IOException {	
		deviceDetailsPage.validateDeviceDetailsPage(driver);
	}
	
	@Test(alwaysRun=true, priority=10,enabled=true)
	public void verifyWeatherForecast() throws InterruptedException, IOException {	
		deviceDetailsPage.verifyWeatherForecast(driver);
		
	}


}
