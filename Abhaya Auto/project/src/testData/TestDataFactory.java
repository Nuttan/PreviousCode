package testData;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import properties.LoadFrameworkProp;


public class TestDataFactory {
	
	public  TestDataMap<String, String> testDataMap;
	public TestDataMap<String, String> createTestDataMap() {
		try
		{
		testDataMap = new TestDataMap<String, String>();
		LoadFrameworkProp prop = new LoadFrameworkProp();
		InputStream inp = new FileInputStream(prop.getTestDataFile());
	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(Integer.parseInt(prop.getTestDataSheetNo()));
	    int rowNum = sheet.getLastRowNum();
	    for(int i=1;i<=rowNum;i++)
	    {
	    	Row row = sheet.getRow(i);
	    	String key = row.getCell(1).getStringCellValue();
	    	String value=row.getCell(2).toString().replace(".0","");
	    	testDataMap.put(key, value);
	    }
	    
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return testDataMap;
	}
	
	public TestDataMap<String, String> createCMSTestDataMap() {
		try
		{
		testDataMap = new TestDataMap<String, String>();
		LoadFrameworkProp prop = new LoadFrameworkProp();
		InputStream inp = new FileInputStream(prop.getTestDataFile());
	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(Integer.parseInt(prop.getCmsTestDataSheetNo()));
	    int rowNum = sheet.getLastRowNum();
	    for(int i=1;i<=rowNum;i++)
	    {
	    	Row row = sheet.getRow(i);
	    	String key = row.getCell(1).getStringCellValue();
	    	String value=row.getCell(2).toString().replace(".0","");
	    	testDataMap.put(key, value);
	    }
	    
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return testDataMap;
	}
	public TestDataMap<String, String> getTestMap()
	{
		return testDataMap;
	}
	
}

