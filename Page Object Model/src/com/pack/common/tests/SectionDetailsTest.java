package com.pack.common.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pack.base.TestBaseSetUp;
import com.pack.common.pageobjects.DashBoardPage;
import com.pack.common.pageobjects.DeviceDetailsPage;
import com.pack.common.pageobjects.DeviceSectionDetailsPage;

public class SectionDetailsTest extends TestBaseSetUp {
	
	public WebDriver driver;
	private  DeviceDetailsPage deviceDetailsPage;	
	private  DashBoardPage dashboardPage ;
	private  DeviceSectionDetailsPage sectionDetailsPage;
	private static String userName="SwainN@UTCCGL.com";
	
	@Test(alwaysRun=true, priority=11,enabled=true)
	public void setUp() throws InterruptedException, IOException {
		driver=getDriver();
		dashboardPage = new DashBoardPage(driver);
		dashboardPage.enterUserNameChrome(userName);
		deviceDetailsPage=new DeviceDetailsPage(driver);
		deviceDetailsPage.selectOneDevice(driver);
		sectionDetailsPage=new DeviceSectionDetailsPage(driver);
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Validate subsection details of a chiller
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=true, priority=12,enabled=true)
	public void validateSectionDetailsPage() throws InterruptedException, IOException {	
		sectionDetailsPage.validateSectionDetailsPage(driver);
	}
	/** 
   	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 07/08/2017
  	Date of Modified                  : 
  	Methods Called                    : 
   	Purpose of Method                 : Validate the export excel functionality
  	Dependencies                      : --
  	Reviewed By                       : --
  **/
	@Test(alwaysRun=true, priority=13,enabled=true)
	public void validateExportToExcel() throws InterruptedException, IOException {	
		sectionDetailsPage.validateExportToExcel(driver);
		
	}

}
