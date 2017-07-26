package com.pack.common.pageobjects;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.pack.base.TestBaseSetUp;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminSectionPage extends TestBaseSetUp {
	
	public static WebDriver driver;
	
	
	//Customer Tab Elements
	static By settingIcon = By.xpath("//img[@alt='settings']");	
	static By customerTabIcon = By.xpath("//div[contains(text(),'Customers')]");
	static By customerNameElement = By.xpath("(//td[contains(text(),'Customer Name')]/parent::node()/td[2]/input)[1]");
	static By customerEmailElement = By.xpath("(//td[contains(text(),'Contact Email')]/parent::node()/td[2]/input)[1]");
	static By customerLocationStreetElement = By.xpath("(//td[contains(text(),'Location Street')]/parent::node()/td[2]/input)[1]");
	static By customerLocationStateElement = By.xpath("(//td[contains(text(),'Location State')]/parent::node()/td[2]/input)[1]");
	static By customerContactNameElement = By.xpath("(//td[contains(text(),'Contact Name')]/parent::node()/td[5]/input)[1]");
	static By customerContactPhoneElement = By.xpath("(//td[contains(text(),'Contact Phone')]/parent::node()/td[5]/input)[1]");
	static By customerLocationCityElement = By.xpath("(//td[contains(text(),'Location City')]/parent::node()/td[5]/input)[1]");
	static By customerLocationZipElement = By.xpath("(//td[contains(text(),'Location Zip')]/parent::node()/td[5]/input)[1]");
	static By customerTimeZoneElement = By.xpath("//option[contains(text(),'Africa/Bangui')]/parent::node()");
	static By customerSaveDetailsElement = By.xpath("(//td[contains(text(),'Enter a new customer or choose one to update')]/parent::node()/td[6]/div/img)[1]");
	static By customerCloseIcon = By.xpath("//button[contains(text(),'Close')]");
	
	
	//Chiller Registration Elements
	static By chillerTabIcon = By.xpath("//div[contains(text(),'Chillers')]");
	static By cstDropDwn = By.xpath("(//option[contains(text(),'CustomerHRDC_')]/parent::node())[2]");
	static By serialNumElement = By.xpath("(//div[contains(text(),'Serial Number')]/parent::node()/div[2]/input)[1]");
	static By cityElement = By.xpath("(//div[contains(text(),'Location City')]/parent::node()/div[2]/input)[1]");
	static By postalCodeElement = By.xpath("(//div[contains(text(),'Location Postal Code')]/parent::node()/div[2]/input)[1]");
	static By chillerModelElement = By.xpath("(//div[contains(text(),'Chiller Model')]/parent::node()/div[2]/input)[1]");
	static By refreigerentTypeElement = By.xpath("(//option[contains(text(),'HCFC-22')]/parent::node())[1]");
	static By modemAddressElement = By.xpath("(//div[contains(text(),'Modem Address')]/parent::node()/div[2]/input)[1]");
	static By locStreetElement = By.xpath("(//div[contains(text(),'Location Street')]/parent::node()/div[2]/input)[1]");
	static By locStateElement = By.xpath("(//div[contains(text(),'Location State')]/parent::node()/div[2]/input)[1]");
	static By customerTimeZneElement = By.xpath("(//option[contains(text(),'Africa/Bangui')]/parent::node())[2]");
	static By chillerVersionElement = By.xpath("//option[contains(text(),'23XRV PIC3')]/parent::node()");
	static By tenantElement = By.xpath("//option[contains(text(),'south')]/parent::node()");
	static By saveChillerElement = By.xpath("(//img[contains(@src,'dist/assets/images/Button_SaveDetails.png')])[4]");
	static By successElement = By.xpath("//h3[contains(text(),'Success')]");
	
	
	//Tenant Verification Elements
	static By tenantTabIcon = By.xpath("//div[contains(text(),'Tenants')]");
	static By tenantListElement = By.xpath("(//div[@class='role-list'])[2]/child::*/div[1]");
	static By tenantParticularElement = By.xpath("//div[contains(text(),'hrdcqa.com')]");
	static By deviceTabElement = By.xpath("(//div[@class='modeSelector'])[2]/div/div[2]");
	static By userTabElement = By.xpath("(//div[@class='modeSelector'])[2]/div/div[1]");
	static By othertenantParticularElement = By.xpath("//div[contains(text(),'new york')]");
	static By deviceListElement = By.xpath("(//div[@class='modeData'])[2]/div/div[2]//div[contains(text(),'QH')]");

	static Random rand = new Random();
	static int  n = rand.nextInt(485) + 1;
	public static String customerName="CustomerHRDC"+"_"+n;
	public static String ContactName="Dummy"+n;
	public static String customerEmail=customerName+"@utc.com";
	public static String serialNumber="505QH78J"+n;

	public AdminSectionPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public  void addNewCustomer(WebDriver driver) throws InterruptedException, IOException 
	{
	ExtentTest test1=report.startTest("addNewCustomer");
	WebElement setting= (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(settingIcon));
	setting.click();
	WebElement customerTab = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(customerTabIcon));
	customerTab.click();
	System.out.println("clicked on Customer Tab");
	driver.manage().timeouts().implicitlyWait(8000,TimeUnit.MILLISECONDS);
	int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
	int num2 = rand.nextInt(743);
	int num3 = rand.nextInt(10000);
	DecimalFormat df3 = new DecimalFormat("000"); 
	DecimalFormat df4 = new DecimalFormat("0000"); 
	String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
	Thread.sleep(6000);
	WebElement cName = (new WebDriverWait(driver,50)).until(ExpectedConditions.presenceOfElementLocated(customerNameElement));
	cName.sendKeys(customerName);
	Thread.sleep(2000);
	WebElement cEmail= (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(customerEmailElement));
	cEmail.sendKeys(customerEmail);
	Thread.sleep(2000);
	WebElement clocationstreet = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(customerLocationStreetElement));
	clocationstreet.sendKeys("ChruchStreet");
	Thread.sleep(2000);
	WebElement clocationState = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(customerLocationStateElement));
	clocationState.sendKeys("Ch");
	Thread.sleep(2000);
	Select cTimezone = new Select(driver.findElement(customerTimeZoneElement));
	cTimezone.selectByVisibleText("America/Chicago");
	WebElement contactName = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(customerContactNameElement));
	contactName.sendKeys(ContactName);
	WebElement contactPhone = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(customerContactPhoneElement));
	contactPhone.sendKeys(phoneNumber);
	WebElement locationCity = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(customerLocationCityElement));
	locationCity.sendKeys("Chicago");
	WebElement locationZip = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(customerLocationZipElement));
	locationZip.sendKeys("788451");
	WebElement saveDetails = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(customerSaveDetailsElement));
	saveDetails.click();
	(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(customerCloseIcon)).click();
	test1.log(LogStatus.PASS, "Customer: " +customerName+ "added successfully");
	Thread.sleep(4000);
	}

	//CHILLER REGISTRATION
	@Test(alwaysRun=true, priority=13,enabled=true)
	public  void chillerRegistrationNewCustomer(WebDriver driver) throws InterruptedException, IOException 
	{
		ExtentTest test1=report.startTest("chillerRegistrationNewCustomer");
		WebElement chillerTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(chillerTabIcon));
		chillerTab.click();
		Thread.sleep(6000);
		Select custDropdown = new Select(driver.findElement(cstDropDwn));
		List<WebElement> customerList =custDropdown.getOptions();
		Thread.sleep(2000);
		custDropdown.selectByVisibleText(customerName);
		Thread.sleep(2000);
		WebElement serialNumberText = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(serialNumElement));
		serialNumberText.sendKeys(serialNumber);
		Thread.sleep(2000);
		WebElement city = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(cityElement));
		city.sendKeys("chicago");
		Thread.sleep(2000);
		WebElement postalCode = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(postalCodeElement));
		postalCode.sendKeys("788451");
		Thread.sleep(2000);
		WebElement chillerModel = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(chillerModelElement));
		chillerModel.sendKeys("19XR");
		Thread.sleep(4000);
		Select refrigerantType = new Select(driver.findElement(refreigerentTypeElement));
		refrigerantType.selectByVisibleText("HFC-134a");
		Thread.sleep(2000);
		WebElement modemAddress = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(modemAddressElement));
		modemAddress.sendKeys("worldbanksite"+n);
		Thread.sleep(2000);
		WebElement locStreet = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(locStreetElement));
		locStreet.sendKeys("worldbanksite"+n);
		Thread.sleep(2000);
		WebElement locState = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(locStateElement));
		locState.sendKeys("Ch");
		Thread.sleep(2000);
		Select cTimezone = new Select(driver.findElement(customerTimeZneElement));
		cTimezone.selectByVisibleText("America/Chicago");
		Thread.sleep(2000);
		Select chillerVersion = new Select(driver.findElement(chillerVersionElement));
		chillerVersion.selectByVisibleText("19XR PIC5");
		Thread.sleep(2000);
		Select tenant = new Select(driver.findElement(tenantElement));
		tenant.selectByVisibleText("hrdcqa.com");
		Thread.sleep(6000);
		WebElement saveDetails = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(saveChillerElement));
		saveDetails.click();
		WebElement success = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(successElement));
	    if(success.isDisplayed())
	    {
	    	test1.log(LogStatus.PASS, "Chiller: " +serialNumber+ " added successfully ");
	    }
	    else
	    {
	    	test1.log(LogStatus.FAIL, "Chiller: " +serialNumber+ " is not added successfully ");
	    } 
	    driver.findElement(customerCloseIcon).click();
	    Thread.sleep(4000);
	}
	//TENANT VERIFICATION

	@Test(alwaysRun=true, priority=14,enabled=true)
	public  void tenantVerification(WebDriver driver) throws InterruptedException, IOException 
	{
		ExtentTest test1=report.startTest("tenantVerification");
		WebElement tenantTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(tenantTabIcon));
		tenantTab.click();
		List<WebElement> tenantList=driver.findElements(tenantListElement);
		WebElement tenantParticular= (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(tenantParticularElement));
		tenantParticular.click();
		WebElement dvTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(deviceTabElement));
		dvTab.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement userTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(userTabElement));
		userTab.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement OthertenantParticular= (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(othertenantParticularElement));
		OthertenantParticular.click();
		WebElement deviceTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(deviceTabElement));
		deviceTab.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(40000);
		WebElement tenantParticularAgain= (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(tenantParticularElement));
		tenantParticularAgain.click();
		Thread.sleep(40000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement deviceTab1 = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(deviceTabElement));
		deviceTab1.click();	
		List<WebElement> deviceList = driver.findElements(deviceListElement);
		String s=serialNumber.toLowerCase();
		for (int i=0;i<=deviceList.size()-1;i++) 
		{
			if(deviceList.get(i).getText().contains(serialNumber))
			{
			      String extentReportImage15 = "D:\\CST-AutomationScreenshots" + System.currentTimeMillis() + ".png";
		     	  String src15=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		     	  src15 = "data:image/gif;base64," + src15;
		     	  String imageInBase64 = test1.addScreenCapture(src15);
		     	  test1.log(LogStatus.PASS, "Newly added chiller is registred under desired tenant");
				  break;
			}
			
		}
	}
		

}
