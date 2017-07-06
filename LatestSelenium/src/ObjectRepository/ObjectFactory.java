package ObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.UIControlObject;
import Properties.LoadFrameworkProp;



public class ObjectFactory {
	
	protected WebDriver driver;
    
    public ObjectFactory(WebDriver driver)
    {
 	   this.driver=driver;
          
    } 
	
	public  ObjectMap<String, UIControlObject> objMap;
	public void createObjectMap(String controlName) throws IOException {
		File src=new File("D:\\NuttanEclipseWorkSpace\\LatestSelenium\\src\\ObjectRepository\\config.properties");
		FileInputStream inp=new FileInputStream(src);
		Properties pro=new Properties();
		pro.load(inp);
		System.out.println("Property class loaded");	
		try
		{
		WebElement ele=driver.findElement(By.xpath(pro.getProperty(controlName)));
		objMap = new ObjectMap<String, UIControlObject>();
	
	    inp.close();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
		public void createCMSObjectMap() {
			try
			{
			
			}
			catch(Exception e)
			{
				System.out.println("123"+e.getMessage());
			}
		}
	
	public ObjectMap<String, UIControlObject> getObjectMap()
	{
		return objMap;
	}
	
}

