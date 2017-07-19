package TestCasesPackage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;


public class NWJSLauncher {

	public static void main(String[] args) throws InterruptedException {
File file=new File("C:\\Program Files (x86)\\UTC\\CST\\ClientApp\\nw_original.exe");
	    
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\UTC\\CST\\ClientApp\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.setBinary(file);
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    Thread.sleep(3000);
	    ChromeDriver driver = new ChromeDriver(capabilities);
	    Thread.sleep(6000);
		System.out.println("The Page Title is " + driver.getTitle());
		//driver.quit();

	}

}
