package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class ScreenShots {


	/**
	 * @param args
	 * @throws IOException 
	 */
	
      protected static String str_foldername_path;
      protected RemoteWebDriver driver;
      public ScreenShots(RemoteWebDriver driver)
      {
    	  this.driver=driver;
      }

	/* 
	   Author Name                       : Vinusha Tanuku
	   Date of Preparation               : 03/06/2014
	   Date of Modified                  : 04/06/2014
	   Methods Called                    : takeScreenShots
	   Purpose of Method                 : Take the screen shots
	   Dependencies	                     : --
	   Reviewed By                       : --
	*/
	
	
	public void  takeScreenShots()  
	{	
		
		Random rand=new Random();			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		String path=str_foldername_path+"\\ScreenShot_"+rand.nextInt()+".png";
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			new IOException("Unable to copy screen shot to the folder"+path);
		}
		Reporter.log(path);
		
	}	 

	/* 
	   Author Name                       : Vinusha Tanuku
	   Date of Preparation               : 03/06/2014
	   Date of Modified                  : 04/06/2014
	   Methods Called                    : createscreenshotfolder
	   Purpose of Method                 : Creates folder for Screen shots
	   Dependencies	                     : --
	   Reviewed By                       : --
	*/
	 public File createscreenshotfolder(String str_screenshotsfoldername)
	 {   		
	    File folder= new File("ScreenShots\\"+str_screenshotsfoldername);
	   	if(!folder.exists())
		 {
			 folder.mkdir();
		 }
	     str_foldername_path=folder.getAbsolutePath();
	    return folder;	
			    	
	 }
  

}
