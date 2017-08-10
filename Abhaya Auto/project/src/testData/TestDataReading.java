package testData;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import properties.LoadFrameworkProp;



public class TestDataReading {
	
	public TestDataMap<String, String> ReadTestData() throws Exception 
	{
		LoadFrameworkProp config = new LoadFrameworkProp();
		TestDataMap<String, String> obj = new TestDataMap<String, String>();
		try
		{		
		InputStream inp = new FileInputStream(".\\TestBatch.xlsx");
		new WorkbookFactory();
		Workbook wb = WorkbookFactory.create(inp);		
		Sheet ws = wb.getSheetAt(Integer.parseInt(config.getTestDataSheetNo()));
		int i = ws.getLastRowNum();
		String key = null;
		for(int j=0;j<=i;j++)
		{
		  key = ws.getRow(j).getCell(0).getStringCellValue();
	      String  value= ws.getRow(j).getCell(1).toString().replace(".0","");
	      obj.put(key, value);
		
		}
		}
	
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return obj;
	
}
}
