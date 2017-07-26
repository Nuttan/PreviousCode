package objectRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import properties.LoadFrameworkProp;

public class Testing {
	private static ObjectMap<String, UIControlObject> objMap;
	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		ObjectFactory factory = new ObjectFactory();
		factory.createObjectMap();
		objMap=factory.getObjectMap();
		System.out.println(objMap.size());
		System.out.println(objMap.get("Services").getControlProperty());
}
}
