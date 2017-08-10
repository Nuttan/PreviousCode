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
	
	static String sectionDetailBtn="CarrierSmart.DeviceDetails.SectionDetailsButton.Xpath"; 
	static String sectionlistBtn ="CarrierSmart.DeviceDetails.SubSectionList.Xpath";
	static String reportBtn ="CarrierSmart.SectionDetails.ReportIcon.Xpath";
	static String radioBtnList ="CarrierSmart.SectionDetails.IntervalCheckList.Xpath";
	static String fourHourIntervalBtn ="CarrierSmart.SectionDetails.FourHourIntervalCheckList.Xpath";
	static String reportPopUpClose ="CarrierSmart.SectionDetails.ReportPopupClose.Xpath";

	public DeviceSectionDetailsPage(WebDriver driver) {
		this.driver=driver;
		elementFactory =new WebElementFactory(driver);
		userActions = new UserActions(driver);
	}
	

	public  void validateSectionDetailsPage(WebDriver driver) throws InterruptedException, IOException
	{
		ExtentTest test1=report.startTest("validateSectionDetailsPage");
		userActions.clickOn(sectionDetailBtn);
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		List<WebElement> sectionlist =elementFactory.getElementsByXpath(sectionlistBtn); 
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);	  	
		for (int i=0; i<=sectionlist.size()-1; i++)
		{
		 WebElement section=sectionlist.get(i);
		 section.click();
			 String sectionText=section.getText();
			 System.out.println("Clicked on " +sectionText+ "section of the chiller");
			 Thread.sleep(4000);	
		}
		 test1.log(LogStatus.PASS, "Validated the SectionDetails Page");
		 Thread.sleep(4000);
	}


	public  void validateExportToExcel(WebDriver driver) throws InterruptedException, IOException
	{
		ExtentTest test1=report.startTest("validateExportToExcel");
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
				 button.click();
			 }
			 Thread.sleep(2000);
		 }	 
		userActions.clickOn(fourHourIntervalBtn);	
		userActions.clickOn(reportPopUpClose);
		Thread.sleep(12000);
		test1.log(LogStatus.PASS, "Validate ExportToExcel functionality");	
		driver.navigate().refresh();
		Thread.sleep(12000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

}
