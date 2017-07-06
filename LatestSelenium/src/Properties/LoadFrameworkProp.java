/**
 * 
 */
package Properties;

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
	private String testNGPlugin;
	private String dbUrl;
	private String dbLibPath;
	private String tableName;
	private String masterDataSheetNo;
	private String testDataSheetNo;
	private String testExecutionSheetNo;
	private String gridConfigSheetNo;
	private String htmlReport;
	private String testNgResultsXML;
	private String localTestCaseSheet;
	private String dbDriverUrl;
	private String dbHostName;
	private String dbPortNo;
	private String dbName;
	private String dbUserName;
	private String dbPassword;
	private String dbConnectionUrl;
	private String cmsTestDataSheetNo;
	private String mobileTestCaseSheet;
	
	public String getCmsTestDataSheetNo() {
		return cmsTestDataSheetNo;
	}
	public String getDbConnectionUrl() {
		return dbConnectionUrl;
	}

	public String getDbDriverUrl() {
		return dbDriverUrl;
	}

	public String getDbHostName() {
		return dbHostName;
	}

	public String getDbPortNo() {
		return dbPortNo;
	}

	public String getDbName() {
		return dbName;
	}

	public String getDbUserName() {
		return dbUserName;
	}

	public String getDbPassword() {
		return dbPassword;
	}
	public String getMasterDataSheetNo() {
		return masterDataSheetNo;
	}

	public String getTestDataSheetNo() {
		return testDataSheetNo;
	}

	public String getTestExecutionSheetNo() {
		return testExecutionSheetNo;
	}

	public String getGridConfigSheetNo() {
		return gridConfigSheetNo;
	}

	public String getTestDataFile() {
		return testDataFile;
	}

	public String getLocalTestCaseSheet() {
		return localTestCaseSheet;
	}
	
	public String getMobileTestCaseSheet() {
		return mobileTestCaseSheet;
	}

	public String getObjectRepository() {
		return objectRepository;
	}

	public String getTestNGPlugin() {
		return testNGPlugin;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public String getDbLibPath() {
		return dbLibPath;
	}

	public String getTableName() {
		return tableName;
	}
	public String getHtmlReport() {
		return htmlReport;
	}
	public String getTestNgResultsXML() {
		return testNgResultsXML;
	}
	


	public LoadFrameworkProp()
	{
		Properties prop = new Properties();
		InputStream is = null;
		
		try
		{
			
			File config = new File("D:\\NuttanEclipseWorkSpace\\LatestSelenium\\config.properties");
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
				is = getClass().getResourceAsStream("D:\\NuttanEclipseWorkSpace\\LatestSelenium\\config.properties");
			}
			prop.load(is);
			testDataFile = prop.getProperty("TestDataFile");
			objectRepository = prop.getProperty("ObjectRepository");
			testNGPlugin = prop.getProperty("TestNGPlugin");
			dbUrl = prop.getProperty("dbURL");
			dbLibPath = prop.getProperty("libPath");
			tableName = prop.getProperty("tableName");
			masterDataSheetNo=prop.getProperty("MasterDataSheetNo");
			testDataSheetNo=prop.getProperty("TestDataSheetNo");
			testExecutionSheetNo=prop.getProperty("TestExecutionSheetNo");
			gridConfigSheetNo=prop.getProperty("GridConfigSheetNo");
			htmlReport=prop.getProperty("HTMLReports");
			testNgResultsXML=prop.getProperty("TestNgResultsXML");	
			localTestCaseSheet =prop.getProperty("LocalTestCase");
			dbDriverUrl = prop.getProperty("DB_DriverUrl");
			dbHostName = prop.getProperty("DB_Host_Name");
			dbPortNo = prop.getProperty("DB_Port_No");
			dbName = prop.getProperty("DB_Name");
			dbUserName = prop.getProperty("DB_User_Name");
			dbPassword = prop.getProperty("DB_Pass_word");
			dbConnectionUrl = prop.getProperty("DB_ConnectionUrl");
			cmsTestDataSheetNo = prop.getProperty("CMSTestDataSheetNo");
			mobileTestCaseSheet = prop.getProperty("MobileTestCase");
		}
		catch(Exception e)
		{
			
		}
		
	}

}
