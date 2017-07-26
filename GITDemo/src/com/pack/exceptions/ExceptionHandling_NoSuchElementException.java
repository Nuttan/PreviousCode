package com.pack.exceptions;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@SuppressWarnings("serial")
public class ExceptionHandling_NoSuchElementException extends NoSuchElementException {

private String message = null;
private static File src=new File("D:\\NuttanEclipseWorkSpace\\Page Object Model\\config.properties");
protected WebDriver driver;  


public ExceptionHandling_NoSuchElementException(String controlname) throws IOException {
	
	  

	
	super(null);
	   FileInputStream inp=new FileInputStream(src);
	   Properties pro=new Properties();
	   pro.load(inp);
	   WebElement ele = null;
	   ele=driver.findElement(By.id(pro.getProperty(controlname)));
	
	message=" NoSuchElementException :Element with ControlName :" +controlname+"  is not present on the current page";

}

@Override
public String getMessage() {
    return message;
}
}
