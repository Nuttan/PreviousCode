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
		adminPage=new AdminSectionPage(driver);
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Adding a new customer
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=true, priority=15,enabled=true)
	public void addNewCustomer() throws InterruptedException, IOException {	
		adminPage.addNewCustomer(driver);
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Registering a chiller for the newly added customer
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=true, priority=16,enabled=true)
	public void chillerRegistrationNewCustomer() throws InterruptedException, IOException {	
		adminPage.chillerRegistrationNewCustomer(driver);
		
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Validate The Tenant assigned to the customer
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=true, priority=17,enabled=true)
	public void tenantVerification() throws InterruptedException, IOException {	
		adminPage.tenantVerification(driver);
		
	}

}
