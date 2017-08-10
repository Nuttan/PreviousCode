package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import properties.LoadAppConfig;

import com.android.ddmlib.AdbCommandRejectedException;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtentManager {
	
	public static LoadAppConfig appConfig=new LoadAppConfig();
     
@SuppressWarnings("deprecation")
public static ExtentReports Instance()
       {
        ExtentReports extent;
        extent = new ExtentReports(appConfig.getDeviceReportLocation()+"ExtentReport.html", true);
        extent.config().documentTitle("Automation Report").reportName("Mobile Test");         
         return extent;
    }
public static String CaptureScreen(WebDriver driver, String ImagesPath) throws InterruptedException, AdbCommandRejectedException
{
	File oScnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File oDest = new File(ImagesPath+".jpg");
 try {
      FileUtils.copyFile(oScnShot, oDest);
 } catch (IOException e) {System.out.println(e.getMessage());}
 return ImagesPath+".jpg";
        }
}
