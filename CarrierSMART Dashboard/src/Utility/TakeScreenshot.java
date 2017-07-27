package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	
	public static void ScreenShot(WebDriver  driver, String scrnshtName) throws InterruptedException
	{
			
	                Thread.sleep(3000);                                                       
	                File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                // Now you can do whatever you need to do with it, for example copy somewhere
	                try {
	                            FileUtils.copyFile(screenShot, new File("D:\\CST-AutomationScreenshots\\"+scrnshtName+".png"));
	                    } 
	                catch (IOException e) 
	                {
	                                                                               
	                     e.printStackTrace();
	                }
	}

	public static String captureScreenshotAsBase64(WebDriver  driver) {

        String screenshotBase64 = ((TakesScreenshot) driver)

                        .getScreenshotAs(OutputType.BASE64);

        screenshotBase64 = "data:image/gif;base64," + screenshotBase64;

        //String imageInBase64 = logger.addScreenCapture(screenshotBase64);

        return screenshotBase64;

}


}
