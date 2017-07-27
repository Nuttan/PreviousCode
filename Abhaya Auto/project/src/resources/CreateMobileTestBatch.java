package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import properties.LoadFrameworkProp;

public class CreateMobileTestBatch {
	
	private static ArrayList<String> localTestCases = new ArrayList<String>();
	private static ArrayList<Systems> localSystems = new ArrayList<Systems>();
	private static ArrayList<String> cmsTestCases = new ArrayList<String>();
	private static ArrayList<Systems> cmsSystems = new ArrayList<Systems>();
	private static ArrayList<String> mobileTestCases = new ArrayList<String>();
	private static ArrayList<Systems> mobileSystems = new ArrayList<Systems>();
	
	public static void createMobileBatch()
	{
		mobileSystems = CreateGridConfig.getMobileSystemSet();
		
		LoadFrameworkProp frameworkConfig = new LoadFrameworkProp();
		try{
			InputStream inp = new FileInputStream(frameworkConfig.getTestDataFile());
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(Integer.parseInt(frameworkConfig.getMobileTestCaseSheet()));
			int rowNum = sheet.getLastRowNum();
			for(int i=1; i<=rowNum;i++)
			{
				Row row = sheet.getRow(i);
				String BatchRun = row.getCell(4).getStringCellValue();
				if(BatchRun.equalsIgnoreCase("Yes"))
				{
					
					if(row.getCell(3).getStringCellValue().equalsIgnoreCase("UI"))
						localTestCases.add(row.getCell(2).getStringCellValue());
					else if(row.getCell(3).getStringCellValue().equalsIgnoreCase("MobileWebTest") || row.getCell(3).getStringCellValue().equalsIgnoreCase("MobileTestNR"))
						mobileTestCases.add(row.getCell(2).getStringCellValue());
					else
	    				cmsTestCases.add(row.getCell(2).getStringCellValue());
				}
			}
			CreateLocalTextXml localTCXml= new CreateLocalTextXml();
			localTCXml.generateLocalTestBatch(localTestCases, localSystems, cmsTestCases, cmsSystems, mobileTestCases, mobileSystems);
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}

}
