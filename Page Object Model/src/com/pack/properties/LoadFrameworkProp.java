/**
 * 
 */
package com.pack.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author pankaj_sharma32
 *
 */
public class LoadFrameworkProp {
	private String testDataFile;
	private String objectRepository;

	public LoadFrameworkProp()
	{
		Properties prop = new Properties();
		InputStream is = null;
		
		try
		{
			
			File config = new File("D:\\NuttanEclipseWorkSpace\\Page Object Model\\config.properties");
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
				is = getClass().getResourceAsStream("D:\\NuttanEclipseWorkSpace\\Page Object Model\\config.properties");
			}
			prop.load(is);
			testDataFile = prop.getProperty("TestDataFile");
			objectRepository = prop.getProperty("ObjectRepository");

		}
		catch(Exception e)
		{
			
		}
		
	}

}
