import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport {
	WebDriver driver;
	 ExtentReports extent = new ExtentReports();
	 ExtentTest test;
	 @Test
    public void temp() throws IOException
    {
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");
        
        // create ExtentReports and attach reporter(s)
       
        extent.attachReporter(htmlReporter);
        // creates a toggle for the given test, adds all log events under it    
        test= extent.createTest("MyFirstTest", "Sample description");
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
         test.log(Status.PASS, "started");
      
        driver.get("http://www.learn-automation.com");
        
        String extentReportImage = "D:\\CST-AutomationScreenshots\\pic1" + System.currentTimeMillis() + ".png";
  	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  	  FileUtils.copyFile(src, new File(extentReportImage));
  	  test.log(Status.INFO,"Screenshot from : " + extentReportImage).addScreenCaptureFromPath(extentReportImage);
      String title=driver.getTitle();
      System.out.println(title);
      Assert.assertTrue(title.contains("WebDriver")); 
  	 driver.get("https://netbanking.hdfcbank.com/netbanking/CCLogin.html");

        // calling flush writes everything to the log file
   
    }
    
    
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
    if(result.getStatus()==ITestResult.FAILURE)
    {
        test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath("D:\\CST-AutomationScreenshots"));
    System.out.println("failed");


    }

    //report.endTest(logger);
    extent.flush();

    driver.get("D:\\CST-AutomationScreenshots\\DashboardAutomation.html");
    }

    

}
