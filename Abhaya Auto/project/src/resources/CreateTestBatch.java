package resources;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import properties.LoadFrameworkProp;

public class CreateTestBatch {
	
	private static ArrayList<String> uiTestCases = new ArrayList<String>();
	private static ArrayList<String> cmsTestCases= new ArrayList<String>();
	private static ArrayList<String> mobileTestCases= new ArrayList<String>();
	
	private static ArrayList<Systems> gridSystem = new ArrayList<>();
	public static void createBatch()
	{
		LoadFrameworkProp config = new LoadFrameworkProp();
	try {
			gridSystem = CreateGridConfig.getMobileSystemSet();
			InputStream inp = new FileInputStream(config.getTestDataFile());
	
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(Integer.parseInt(config.getTestExecutionSheetNo()));
			int rowNum = sheet.getLastRowNum();
   
			for (int i=1; i<=rowNum;i++)
    	{
    		Row row = sheet.getRow(i);
    		String batchRun = row.getCell(4).getStringCellValue();
    		if(batchRun.equalsIgnoreCase("Yes"))
    		{
    			if(row.getCell(3).getStringCellValue().equalsIgnoreCase("UI"))
    				uiTestCases.add(row.getCell(2).getStringCellValue());
    			else if(row.getCell(3).getStringCellValue().equalsIgnoreCase("MobileWebTest"))
    				mobileTestCases.add(row.getCell(2).getStringCellValue());
    			else
    				cmsTestCases.add(row.getCell(2).getStringCellValue());
    		}
    		else
    			continue;
    	}
		
    CreateTestXml testNGXml = new CreateTestXml();
  //  testNGXml.generateTestBatch(uiTestCases,gridSystem);
    testNGXml.generateTestBatch(mobileTestCases,gridSystem);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	}    
}
