package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import properties.LoadFrameworkProp;

public class CreateGridConfig {
	private static ArrayList<Systems> gridSystemSet = new ArrayList<Systems>();
	private static ArrayList<Systems> localSystemSet = new ArrayList<Systems>();
	private static ArrayList<Systems> cmsSystemSet = new ArrayList<Systems>();
	private static ArrayList<Systems> mobileSystemSet = new ArrayList<Systems>();

	
	public static void createConfig()
	{
		LoadFrameworkProp config = new LoadFrameworkProp();
		try {
			InputStream inp = new FileInputStream(config.getTestDataFile());
		    Workbook wb = WorkbookFactory.create(inp);
		    Sheet sheet = wb.getSheetAt(Integer.parseInt(config.getGridConfigSheetNo()));
		    int rowNum = sheet.getLastRowNum();
		    for (int i=1; i<=rowNum;i++)
	    	{
		    	Row row = sheet.getRow(i);
		    	Systems system = new Systems();
		    	if(row.getCell(5).getStringCellValue().equalsIgnoreCase("yes"))
		    	{
		    		if((row.getCell(1).getStringCellValue().startsWith("Windows") || row.getCell(1).getStringCellValue().equalsIgnoreCase("Mac")))
		    		{
		    			system.setTestType(row.getCell(1).getStringCellValue());
		    			system.setPlatform(row.getCell(2).getStringCellValue());
		    			system.setBrowser(row.getCell(3).getStringCellValue());
		    			system.setVersion(row.getCell(4).getStringCellValue());
		    			gridSystemSet.add(system);
		    		}
		    		if (row.getCell(1).getStringCellValue().startsWith("Local System Test")) {
						
		    			system.setTestType(row.getCell(1).getStringCellValue());
		    			system.setPlatform(row.getCell(2).getStringCellValue());
		    			system.setBrowser(row.getCell(3).getStringCellValue());
		    			system.setVersion(row.getCell(4).getStringCellValue());
		    			localSystemSet.add(system);
					}
		    		else if (row.getCell(1).getStringCellValue().startsWith("Mobile Test")) {
						
		    			system.setTestType(row.getCell(1).getStringCellValue());
		    			system.setPlatform(row.getCell(2).getStringCellValue());
		    			system.setBrowser(row.getCell(3).getStringCellValue());
		    			system.setVersion(row.getCell(4).getStringCellValue());
		    			mobileSystemSet.add(system);
					}
		    		else if(row.getCell(1).getStringCellValue().startsWith("CMS"))
		    		{
		    			system.setTestType(row.getCell(1).getStringCellValue());
		    			system.setPlatform(row.getCell(2).getStringCellValue());
		    			system.setBrowser(row.getCell(3).getStringCellValue());
		    			system.setVersion(row.getCell(4).getStringCellValue());
		    			cmsSystemSet.add(system);
		    		}
		    	}
	    	}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static ArrayList<Systems> getGridSystemSet() {
		return gridSystemSet;
	}
	
	public static ArrayList<Systems> getCmsSystemSet() {
		return cmsSystemSet;
	}

	public static ArrayList<Systems> getLocalSystemSet() {
		return localSystemSet;
	}
	
	public static ArrayList<Systems> getMobileSystemSet() {
		return mobileSystemSet;
	}

}
