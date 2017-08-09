

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;


public class ArpitAddUserAutomationScript {
	
    static WebDriver driver ;
    
    
    public static void main(String[] args) throws MalformedURLException, InterruptedException 
  {

          
///////////// Common steps starts here  //////////////////////
                 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver_win32 (2)\\chromedriver.exe");
                 driver = new ChromeDriver();
//                System.setProperty("webdriver.gecko.driver","D:\\Shared\\Selenium\\gecko_ver_11.0_compatible_with_Firefox50\\geckodriver.exe");
//                WebDriver driver = new FirefoxDriver();
                
                driver.get("https://smartservice.carrier.com/#/");
                WebElement UsrnameField = new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOfElementLocated(By.id("cred_userid_inputtext")));
                driver.findElement(By.id("cred_userid_inputtext")).sendKeys("SwainN@UTCCGL.com");
                Thread.sleep(2000);
                UsrnameField.sendKeys(Keys.TAB);
                driver.manage().window().maximize();
                Thread.sleep(2000);
                WebElement cookie = (new WebDriverWait(driver, 80)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]")));
                cookie.click();
                driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
                driver.findElement(By.xpath("//img[@alt='settings']")).click();
                WebElement userTab = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/smart-chiller-app/div/main/smart-chiller-dashboard/div/article[3]/div[1]/div[8]")));
                userTab.click();
                driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
//                
                
                
///////////// Common steps ends here  //////////////////////


//****** EXCEL READING ****** //

          List<String> Name = new ArrayList<>();
          List<String> Email = new ArrayList<>();
          List<String> Tenant = new ArrayList<>();
          List<String> Role = new ArrayList<>();
          

try
      {
          Workbook wrk1 = Workbook.getWorkbook((new File("D:\\NuttanModified.xls")));
          Sheet sheet1 = wrk1.getSheet(0);
          //i is the no. of excel rows that you want to read and iterate. We are skipping 0 index bcoz first row in excel is just the title of columns.
          for (int i=1; i <=180 ;i++)
            //use either of these - *for (int i=0; i < 5;i++)* //for (int i=0; i < sheet1.getRows();i++)
                {
                      if(sheet1.getCell(0, i).getContents()!= "")
                      {
//                          System.out.println(sheet1.getCell(1, i).getContents());
//                          System.out.println(sheet1.getCell(4, i).getContents());
//                          System.out.println(sheet1.getCell(5, i).getContents());

                            Name.add(sheet1.getCell(3, i).getContents());          
                            Email.add(sheet1.getCell(10, i).getContents());
                            Role.add(sheet1.getCell(8, i).getContents()); 
                            Tenant.add(sheet1.getCell(9, i).getContents());
                     
                                              
                      }
                }
      }
catch(Exception e)
          {
                e.printStackTrace();
          }



    //****** EXCEL READING OVER****** //
//// Entering users details STARTS /////////
for (int j=0; j<180; j++)
          {
	
	            
                WebElement nameField = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/smart-chiller-app/div/main/smart-chiller-dashboard/div/article[3]/div[2]/div[8]/admin-users/div/article[1]/div[2]/img[1]")));
                nameField.click();
                Thread.sleep(3000);
    
                driver.findElement(By.xpath("/html/body/smart-chiller-app/div/admin-add-user/div/div/div[2]/input")).sendKeys(Name.get(j));
                driver.findElement(By.xpath("/html/body/smart-chiller-app/div/admin-add-user/div/div/div[3]/input")).sendKeys(Email.get(j));
                Thread.sleep(2000);
                //Add button click
                driver.findElement(By.xpath("/html/body/smart-chiller-app/div/admin-add-user/div/div/div[4]/div/button")).click();
                Thread.sleep(2000);
                System.out.println(Name.get(j));
                //Exception close
                WebElement exceptionclose = (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/smart-chiller-app/div/smart-chiller-error/div/div/div[3]/div/button")));
                exceptionclose.click();
                //Relative xpath for Role - //label[contains(text(),'carrier service technician')]
                Thread.sleep(5000);
                List<WebElement> RolelabelList=driver.findElements(By.xpath("(//label[contains(text(),'super')])[1]/parent::node()/parent::node()/*/label"));
                
                List<WebElement> RolecheckBoxList=driver.findElements(By.xpath("(//label[contains(text(),'super')])[1]/parent::node()/parent::node()/*/input"));
                
//                for (int m=0; m<=RolecheckBoxList.size()-1; m++)
//                {
//                	RolecheckBoxList.get(m).click();
//                }
                // System.out.println("The number of available roles are " +RolelabelList.size());
        	  	     for (int i=0; i<=RolelabelList.size()-1; i++)
        	  	     {

 	
        	  		       if(RolelabelList.get(i).getText().equalsIgnoreCase(Role.get(j)))
        	  		       {
        	  		    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
        	  		    	RolecheckBoxList.get(i).click();
        	  		         break;
        	  		       }
        	  		       
        	  		       else
        	  		       {
        	  		    	   System.out.println("No role Is Present for this User" +Name.get(j));
        	  		       }
        	  		
        	  	     }
                
                
//                WebElement RoleSelection = (new WebDriverWait(driver,70)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[contains(text(),'carrier service technician')]/parent::node()/input)")));
//                RoleSelection.click();
               // System.out.println(tenant.get(j));
                Thread.sleep(5000);
                
                //Click save Details
               try
               {
                WebElement ClickOnSaveRole = (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/smart-chiller-app/div/main/smart-chiller-dashboard/div/article[3]/div[2]/div[8]/admin-users/div/article[1]/div[2]/img[2]")));
                
                ClickOnSaveRole.click();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);   
                String savedeactiveRole=ClickOnSaveRole.getAttribute("class");      
                while (!(savedeactiveRole.equals("disabled")))
                {
                	Thread.sleep(5000);
                	savedeactiveRole=ClickOnSaveRole.getAttribute("class");
                	//System.out.println("indide role while loop" +savedeactiveRole);

                }
                
                System.out.println("Role added for user" + ":" + Email.get(j));
                //Switch to tenant tab
                WebElement SwitchToTenantTab = (new WebDriverWait(driver,60)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/smart-chiller-app/div/main/smart-chiller-dashboard/div/article[3]/div[2]/div[8]/admin-users/div/article[2]/div[2]/div[1]/div/div[2]")));
                SwitchToTenantTab.click();;
                Thread.sleep(5000);		
               List<WebElement> labelList=driver.findElements(By.xpath("(//label[contains(text(),'northeast')])[1]/parent::node()/parent::node()/*/label"));
               
               List<WebElement> checkBoxList=driver.findElements(By.xpath("(//label[contains(text(),'northeast')])[1]/parent::node()/parent::node()/*/input"));
              // System.out.println(labelList.size());
       	  	     for (int i=0; i<=labelList.size()-1; i++)
       	  	     {

	
       	  		       if(labelList.get(i).getText().equalsIgnoreCase(Tenant.get(j)))
       	  		       {
       	  		    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  
       	  		         checkBoxList.get(i).click();
       	  		         break;
       	  		       }
       	  		       else if(Tenant.get(j).equals("No tenant needed"))
       	  		       {
       	  		    	  System.out.println("No Tenant Needed for user " +Name.get(j));
       	  		       }
       	  		       else
       	  		       {
       	  		    	System.out.println("No Tenant is present for user " +Name.get(j));
       	  		       }
       	  		
       	  	     }

                WebElement ClickOnSaveTenant= driver.findElement(By.xpath("/html/body/smart-chiller-app/div/main/smart-chiller-dashboard/div/article[3]/div[2]/div[8]/admin-users/div/article[1]/div[2]/img[2]"));
                ClickOnSaveTenant.click();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);   
                String savedeactiveTenant=ClickOnSaveTenant.getAttribute("class");      
                while (!(savedeactiveTenant.equals("disabled")))
                {
                	Thread.sleep(5000);
                	savedeactiveTenant=ClickOnSaveRole.getAttribute("class");
                	//System.out.println("indide tenent while loop" +savedeactiveTenant);
                }
                
                System.out.println("Tenant" + Tenant.get(j) + "added for user" + ":" + Email.get(j));
                
                driver.findElement(By.xpath("//div[contains(text(),'roles')]")).click();
                Thread.sleep(3000);
               }
               catch(Exception e)
               {
            	   System.out.println(Email.get(j));
            	   e.printStackTrace();
               }
                
          }
    // Entering User Details iterate
    
}


}

