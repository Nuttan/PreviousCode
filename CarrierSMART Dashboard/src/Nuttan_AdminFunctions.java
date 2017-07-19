import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TimesPanel;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Nuttan_AdminFunctions {
	
static WebDriver driver ;
static ExtentReports report=new ExtentReports("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");
static ExtentTest logger=report.startTest("VerifyCarrierDashboardAutomation"); 

static Random rand = new Random();
static int  n = rand.nextInt(485) + 1;
public static String customerName="CustomerHRDC"+"_"+n;
public static String ContactName="Dummy"+n;
public static String customerEmail=customerName+"@utc.com";
public static String serialNumber="505QH78J"+n;


@Test(alwaysRun=true, priority=0,enabled=true)
public static void LoginDasboard() throws InterruptedException, IOException 
{  
	
//LOGIN TO DASHBOARD
	
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver_win32 (2)\\chromedriver.exe");
driver = new ChromeDriver();
driver.get("https://smartservicedev.carrier.com");
WebElement UsrnameField = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("cred_userid_inputtext")));
driver.findElement(By.id("cred_userid_inputtext")).sendKeys("SwainN@UTCCGL.com ");           
UsrnameField.sendKeys(Keys.TAB);
Thread.sleep(30000);
driver.manage().window().maximize();
WebElement cookies = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]")));
cookies.click();
System.out.println("cookies accepted");
Thread.sleep(10000);
driver.findElement(By.xpath("//img[@alt='settings']")).click();
driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
logger.log(LogStatus.PASS, "LogIn to Carrier Dashboard Successful");
}

//ADDNEWCUSTOMER
@Test(alwaysRun=true, priority=1,enabled=true)
public static void addNewCustomer() throws InterruptedException, IOException 
{
WebElement customerTab = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Customers')]")));
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
WebElement cName = (new WebDriverWait(driver,50)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Customer Name')]/parent::node()/td[2]/input)[1]")));
cName.sendKeys(customerName);
Thread.sleep(2000);
WebElement cEmail= (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Contact Email')]/parent::node()/td[2]/input)[1]")));
cEmail.sendKeys(customerEmail);
Thread.sleep(2000);
WebElement clocationstreet = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Location Street')]/parent::node()/td[2]/input)[1]")));
clocationstreet.sendKeys("ChruchStreet");
Thread.sleep(2000);
WebElement clocationState = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Location State')]/parent::node()/td[2]/input)[1]")));
clocationState.sendKeys("Ch");
Thread.sleep(2000);
Select cTimezone = new Select(driver.findElement(By.xpath("//option[contains(text(),'Africa/Bangui')]/parent::node()")));
cTimezone.selectByVisibleText("America/Chicago");
WebElement contactName = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Contact Name')]/parent::node()/td[5]/input)[1]")));
contactName.sendKeys(ContactName);
WebElement contactPhone = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Contact Phone')]/parent::node()/td[5]/input)[1]")));
contactPhone.sendKeys(phoneNumber);
WebElement locationCity = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Location City')]/parent::node()/td[5]/input)[1]")));
locationCity.sendKeys("Chicago");
WebElement locationZip = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Location Zip')]/parent::node()/td[5]/input)[1]")));
locationZip.sendKeys("788451");
WebElement saveDetails = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),'Enter a new customer or choose one to update')]/parent::node()/td[6]/div/img)[1]")));
//System.out.println("Save details button identified");
saveDetails.click();
(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Close')]"))).click();
System.out.println("Popup closed and customer added successfully");
logger.log(LogStatus.PASS, "New Customer Added Successfully");
Thread.sleep(4000);
}

//CHILLER REGISTRATION
@Test(alwaysRun=true, priority=2,enabled=true)
public static void chillerRegistrationNewCustomer() throws InterruptedException, IOException 
{
	WebElement chillerTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Chillers')]")));
	chillerTab.click();
	Thread.sleep(6000);
	System.out.println(customerName);
	
	Select custDropdown = new Select(driver.findElement(By.xpath("(//option[contains(text(),'CustomerHRDC_')]/parent::node())[2]")));
	List<WebElement> customerList =custDropdown.getOptions();
	System.out.println(customerList.size());
	
	//WebElement custDropdown=driver.findElement(By.xpath("(//option[contains(text(),'CustomerHRDC_')]/parent::node())[2]"));
	//custDropdown.click();
	Thread.sleep(1000);
	
	//To select one value from the drop down having similar text
	//WebElement custDropdownElement=driver.findElement(By.xpath("(//option[contains(text(),'CustomerHRDC_')]/parent::node())[2]//option[contains(text(),'CustomerHRDC')]"));
	//custDropdownElement.click();

	custDropdown.selectByVisibleText(customerName);
	Thread.sleep(2000);
	
	WebElement serialNumberText = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Serial Number')]/parent::node()/div[2]/input)[1]")));
	serialNumberText.sendKeys(serialNumber);
	System.out.println("Serial Of the Chiller is " + serialNumber);
	Thread.sleep(2000);
	
	WebElement city = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Location City')]/parent::node()/div[2]/input)[1]")));
	city.sendKeys("chicago");
	Thread.sleep(2000);
	
	WebElement postalCode = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Location Postal Code')]/parent::node()/div[2]/input)[1]")));
	postalCode.sendKeys("788451");
	Thread.sleep(2000);
	
	WebElement chillerModel = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Chiller Model')]/parent::node()/div[2]/input)[1]")));
	chillerModel.sendKeys("19XR");
	Thread.sleep(4000);
	
	Select refrigerantType = new Select(driver.findElement(By.xpath("(//option[contains(text(),'HCFC-22')]/parent::node())[1]")));
	refrigerantType.selectByVisibleText("HFC-134a");
	Thread.sleep(2000);
	
	WebElement modemAddress = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Modem Address')]/parent::node()/div[2]/input)[1]")));
	modemAddress.sendKeys("worldbanksite"+n);
	Thread.sleep(2000);
	
	WebElement locStreet = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Location Street')]/parent::node()/div[2]/input)[1]")));
	locStreet.sendKeys("worldbanksite"+n);
	Thread.sleep(2000);
	
	WebElement locState = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(text(),'Location State')]/parent::node()/div[2]/input)[1]")));
	locState.sendKeys("Ch");
	Thread.sleep(2000);
	
	Select cTimezone = new Select(driver.findElement(By.xpath("(//option[contains(text(),'Africa/Bangui')]/parent::node())[2]")));
	cTimezone.selectByVisibleText("America/Chicago");
	Thread.sleep(2000);
	
	Select chillerVersion = new Select(driver.findElement(By.xpath("//option[contains(text(),'23XRV PIC3')]/parent::node()")));
	chillerVersion.selectByVisibleText("19XR PIC5");
	Thread.sleep(2000);
	
	Select tenant = new Select(driver.findElement(By.xpath("//option[contains(text(),'carrier.com')]/parent::node()")));
	tenant.selectByVisibleText("hrdcqa.com");
	Thread.sleep(6000);
	
	WebElement saveDetails = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@src,'dist/assets/images/Button_SaveDetails.png')])[4]")));
	saveDetails.click();
	
	
	WebElement success = (new WebDriverWait(driver, 50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Success')]")));
    if(success.isDisplayed())
    {
    	System.out.println("Chiller added successfully");
    }
    
    driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
    Thread.sleep(4000);
}


//TENANT VERIFICATION

@Test(alwaysRun=true, priority=3,enabled=true)
public static void tenantVerification() throws InterruptedException, IOException 
{
	
	WebElement tenantTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Tenants')]")));
	tenantTab.click();
	List<WebElement> tenantList=driver.findElements(By.xpath("(//div[@class='role-list'])[2]/child::*/div[1]"));
	System.out.println(tenantList.size());
	WebElement tenantParticular= (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'hrdcqa.com')]")));
	tenantParticular.click();
	WebElement deviceTab = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='modeSelector'])[2]/div/div[2]")));
	deviceTab.click();
	Thread.sleep(4000);
	
	//devices list in a prticular tenant
	
	//List<WebElement> deviceList=driver.findElements(By.xpath("(//div[@class='userRow']/parent::node())[3]/child::*/div"));
	//List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='datepicker']/div/table/tbody/tr/td/table/tbody[2]/tr/td[@class='' or @class='datepickerSaturday' or @class='datepickerSunday']/a/span"));
	
	List<WebElement> deviceList = driver.findElements(By.xpath("(//div[@class='modeData'])[2]/div/div[2]//div[contains(text(),'qh')]"));
	System.out.println(deviceList.size());
//	Iterator<WebElement> itr = deviceList.iterator();
//	while(itr.hasNext()) {
//	    System.out.println(itr.next());
//	}
	//driver.close();

	String s=serialNumber.toLowerCase();
	
	for (int i=1;i<=deviceList.size();i++) 
	{
		
		System.out.println("entered into a loop ");
		if(deviceList.get(i).getText().contains(s))
		{
			//tenant.click();
			System.out.println("Newly added chiller is registred under desired tenant");
			break;
		}
		break;
	}
	
}


}




//ADDUSER

//driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
//WebElement userTab = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Users')]")));
////System.out.println("identify");
//userTab.click();
////

//driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
////driver.findElement(By.xpath("//div[contains(text(),'Users')]")).click();
//WebElement addNewUser = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='users']//article[1]//div[2]/img[1]")));
//addNewUser.click();
//WebElement nameField = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Name']")));
//nameField.sendKeys("Hyderabad");
//WebElement loginField = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Login']")));
//loginField.sendKeys("hello@utc.com");
//Select dropdown= new org.openqa.selenium.support.ui.Select(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='ng-pristine ng-valid ng-touched']")));
//Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='ng-pristine ng-valid ng-touched']")));
