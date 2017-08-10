package com.pack.common.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.pack.base.TestBaseSetUp;
import com.pack.common.pageobjects.AdminSectionPage;
import com.pack.common.pageobjects.DashBoardPage;
import com.pack.common.pageobjects.DeviceSectionDetailsPage;

public class AdminFunctionTest extends TestBaseSetUp {
	
	public WebDriver driver;
	private  DashBoardPage dashboardPage;
	private  AdminSectionPage adminPage;
	private static String userName="SwainN@UTCCGL.com";
	
	@Test(alwaysRun=true, priority=14,enabled=true)
	public void setUp() throws InterruptedException, IOException {
		driver=getDriver();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.enterUserNameChrome(userName);
	}
	
	@Test(alwaysRun=true, priority=15,enabled=true)
	public void addNewCustomer() throws InterruptedException, IOException {	
		adminPage.addNewCustomer(driver);
	}
	
	@Test(alwaysRun=true, priority=16,enabled=true)
	public void chillerRegistrationNewCustomer() throws InterruptedException, IOException {	
		adminPage.chillerRegistrationNewCustomer(driver);
		
	}
	
	@Test(alwaysRun=true, priority=17,enabled=true)
	public void tenantVerification() throws InterruptedException, IOException {	
		adminPage.tenantVerification(driver);
		
	}

}
