/**
 * 
 */
package com.pack.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;



public class LoadAppConfig {
	private String appUrl;
	private String invUrl;
	private String adminUsername;
	private String adminPassword;
	private String username;
	private String password;



    
	public String getAdminUserName() {
		return adminUsername;
	}
	
	public String getAppUrl() {
		return appUrl;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

	
	
	
	public LoadAppConfig()
	{
		Properties prop = new Properties();
		InputStream is = null;
		
		try
		{
			
			File config = new File("app-config.properties");
			is = new FileInputStream(config);
			
		}
		catch(Exception e)
		{
			is = null;
		}
		try
		{
			if(is==null)
			{
				is = getClass().getResourceAsStream("app-config.properties");
			}
			prop.load(is);
			appUrl = prop.getProperty("app-url");
		    adminUsername = prop.getProperty("AdminUser");
			adminPassword = prop.getProperty("AdminPassword");

		}
		catch(Exception e)
		{
			
		}
		
	}
	
	

}
