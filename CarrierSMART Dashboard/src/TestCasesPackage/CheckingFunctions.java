package TestCasesPackage;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;

 

public class CheckingFunctions {

	public static void main(String[] args) throws  IOException {
		

//		
//		 String[] myStringArray = {"Overview","Compressor","Heat Exchanger","Power VFD","Start Up"}; 
//         System.out.println(myStringArray.length);
//         System.out.println(myStringArray[0]);
		
	    Date date = new Date();
	      String strDateFormat = "h:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String formattedDate=sdf.format(date);
	      String[] totalPhase1=formattedDate.split(" ");
	      String Phase1=totalPhase1[0];
	      String median=totalPhase1[1];
	      String[] totalPhase2=Phase1.split(":");
	      String hour=totalPhase2[0];
	      String minute=totalPhase2[1];
	      System.out.println(hour);
	      System.out.println(minute);
	      System.out.println(median);
		
		Runtime.getRuntime().exec("D:\\AutoitScript\\sample.exe");
	      
	      
//        List<String> Name = new ArrayList<>();
//        List<String> email = new ArrayList<>();
//        List<String> tenant = new ArrayList<>();
//        List<String> Role = new ArrayList<>();
//        
//     
//        //i is the no. of excel rows that you want to read and iterate. We are skipping 0 index bcoz first row in excel is just the title of columns.
//        try
//        {
//        	
//            Workbook wrk1 = Workbook.getWorkbook((new File("D:\\NuttanModified.xls")));
//            Sheet sheet1 = wrk1.getSheet(0);
//            //i is the no. of excel rows that you want to read and iterate. We are skipping 0 index bcoz first row in excel is just the title of columns.
//            for (int i=1; i <=3 ;i++)
//              //use either of these - *for (int i=0; i < 5;i++)* //for (int i=0; i < sheet1.getRows();i++)
//                  {
//                        if(sheet1.getCell(0, i).getContents()!= "")
//                        {
////                            System.out.println(sheet1.getCell(1, i).getContents());
////                            System.out.println(sheet1.getCell(4, i).getContents());
////                            System.out.println(sheet1.getCell(5, i).getContents());
//
//                              Name.add(sheet1.getCell(0, i).getContents());
//                              Role.add(sheet1.getCell(2, i).getContents());
//                              email.add(sheet1.getCell(1, i).getContents());
//                              tenant.add(sheet1.getCell(3, i).getContents());
//                              
//                             
//                        }
//                  }
//        }
//  catch(Exception e)
//            {
//                  e.printStackTrace();
//            }
//
//	}

}
}

//Random rand = new Random();
//
//int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
//int num2 = rand.nextInt(743);
//int num3 = rand.nextInt(10000);
//
//DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
//DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
//String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
//System.out.println(phoneNumber);

//try{
//	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//Connection con=DriverManager.getConnection("jdbc:sqlserver://smartchillerdev.database.windows.net:1433;database=smartchillerperformancedev;user=hrdc_ro_usr;password=Developer@123;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
//
//
//
//Statement stmt=con.createStatement();
//ResultSet rs=stmt.executeQuery("Select top 10 * from Device");
//while(rs.next())
//	System.out.println(rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getString(3));
//con.close();		
//
//	
//}
//catch(Exception e)
//{
//	System.out.println(e);
//}

//Logger logger=Logger.getLogger("Google");

 
   // configure log4j properties file
//   PropertyConfigurator.configure("D:\\NuttanEclipseWorkSpace\\LatestSelenium\\src\\TestCasesPackage\\log4j.properties");
//
//
//    // Open browser
//   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver_win32 (2)\\chromedriver.exe");
//    WebDriver driver ;
//	  driver = new ChromeDriver();
//    logger.info("Browser Opened");
//  
//    // Set implicit wait
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    logger.info("Implicit wait given");
//    
//  
//
//    // Load application
//    driver.get("https://www.google.co.in/");
//    logger.info("Url opened");
//  
//
//    // type Selenium
//    driver.findElement(By.name("q")).sendKeys("Selenium");
//    logger.info("keyword type"); 
