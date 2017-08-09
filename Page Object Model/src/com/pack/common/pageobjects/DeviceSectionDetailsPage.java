package com.pack.common.pageobjects;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetUp;
import com.pack.utilities.WebElementFactory;
import com.pack.wrapper.UserActions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DeviceSectionDetailsPage extends TestBaseSetUp {
	
	public static WebDriver driver;
	WebElementFactory elementFactory;
	UserActions userActions;
	
	
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
    Page Elements                     : Device Section Details Page Elements
  	Reviewed By                       : 
    **/ 
	
	static String sectionDetailBtn="CarrierSmart.DeviceDetails.SectionDetailsButton.Xpath"; 
	static String sectionlistBtn ="CarrierSmart.DeviceDetails.SubSectionList.Xpath";
	static String reportBtn ="CarrierSmart.SectionDetails.ReportIcon.Xpath";
	static String radioBtnList ="CarrierSmart.SectionDetails.IntervalCheckList.Xpath";
	static String fourHourIntervalBtn ="CarrierSmart.SectionDetails.FourHourIntervalCheckList.Xpath";
	static String reportExport ="CarrierSmart.SectionDetails.ReportExport.Xpath";

	public DeviceSectionDetailsPage(WebDriver driver) {
		this.driver=driver;
		elementFactory =new WebElementFactory(driver);
		userActions = new UserActions(driver);
	}
	
	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementsByXpath(String controlName)
  	Purpose of Method                 : To select each subsection of the chiller and validate its name
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	
	public  void validateSectionDetailsPage(WebDriver driver) throws InterruptedException, IOException
	{
		ExtentTest test1=report.startTest("validateSectionDetailsPage");
		//Clicking on the "SECTION DETAILS' button on the device details page and navigation to section details page
		userActions.clickOn(sectionDetailBtn);
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		//Getting all the subsection list of the chiller
		List<WebElement> sectionlist =elementFactory.getElementsByXpath(sectionlistBtn); 
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	  	
		for (int i=0; i<=sectionlist.size()-1; i++)
		{
			
			 //Taking each subsection of the device and clicking on it.
		     WebElement section=sectionlist.get(i);
		     section.click();
		     //Getting the inner text of each subsection
			 String sectionText=section.getText();
			 System.out.println("Clicked on " +sectionText+ "section of the chiller");
			 Thread.sleep(4000);	
		}
		 test1.log(LogStatus.PASS, "Validated the SectionDetails Page");
		 Thread.sleep(4000);
	}

	/**
	Author Name                       : Nuttan Abhijan Swain
  	Date of Preparation               : 06/06/2017
  	Date of Modified                  : 21/07/2017 
  	Methods Called                    : getElementsByXpath(String controlName),clickon(String controlName)
  	Purpose of Method                 : To check the export to excel functionality
  	Dependencies	                  : --
  	Reviewed By                       : 
    **/ 
	public  void validateExportToExcel(WebDriver driver) throws InterruptedException, IOException
	{
		ExtentTest test1=report.startTest("validateExportToExcel");
		//clicking on the "Export Icon"
	    userActions.clickOn(reportBtn);
		Thread.sleep(3000);
		if(driver.findElement(By.className("excelExport")).isDisplayed())
	    {
			System.out.println("Report Pop up opened");
	    }
		else
		{
			System.out.println("Report Pop up is absent");
		}
		List<WebElement> radioButtonList =elementFactory.getElementsByXpath(radioBtnList);
		
		 for (WebElement button : radioButtonList) 
		 {
			 if(button.isSelected())
			 {
				 //Unchecking the already checked interval list
				 button.click();
			 }
			 Thread.sleep(2000);
		 }	
		 
		//Clicking on the "4-Hour" interval check list button and clicking on "Export" button
		userActions.clickOn(fourHourIntervalBtn);	
		userActions.clickOn(reportExport);
		Thread.sleep(12000);
		test1.log(LogStatus.PASS, "Validate ExportToExcel functionality");	
		driver.navigate().refresh();
		Thread.sleep(12000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

}
