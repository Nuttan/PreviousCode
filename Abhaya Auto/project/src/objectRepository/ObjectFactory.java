package objectRepository;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import objectRepository.UIControlObject;
import properties.LoadFrameworkProp;


public class ObjectFactory {
	
	public  ObjectMap<String, UIControlObject> objMap;
	public void createObjectMap() {
		InputStream inp;
		Workbook wb ;
		try
		{
		objMap = new ObjectMap<String, UIControlObject>();
		LoadFrameworkProp prop = new LoadFrameworkProp();
		inp = new FileInputStream(prop.getObjectRepository());
	    wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    int rowNum = sheet.getLastRowNum();
	    for(int i=1;i<=rowNum;i++)
	    {
	    	Row row = sheet.getRow(i);
	    	String key = row.getCell(1).getStringCellValue();
	    	UIControlObject uiControl = new UIControlObject();
	    	uiControl.setControlName(row.getCell(1).getStringCellValue());
	    	uiControl.setTypeOfProperty(row.getCell(2).getStringCellValue());
	    	uiControl.setControlProperty(row.getCell(3).getStringCellValue());
	    	objMap.put(key, uiControl);
	    }
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
			objMap = new ObjectMap<String, UIControlObject>();
			LoadFrameworkProp prop = new LoadFrameworkProp();
			InputStream inp = new FileInputStream(prop.getObjectRepository());
		    Workbook wb = WorkbookFactory.create(inp);
		    Sheet sheet = wb.getSheetAt(0);
		    int rowNum = sheet.getLastRowNum();
		    for(int i=1;i<=rowNum;i++)
		    {
		    	Row row = sheet.getRow(i);
		    	String key = row.getCell(1).getStringCellValue();
		    	UIControlObject uiControl = new UIControlObject();
		    	uiControl.setControlName(row.getCell(1).getStringCellValue());
		    	uiControl.setTypeOfProperty(row.getCell(2).getStringCellValue());
		    	uiControl.setControlProperty(row.getCell(3).getStringCellValue());
		    	objMap.put(key, uiControl);
		    }
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

