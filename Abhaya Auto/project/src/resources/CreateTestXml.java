package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.testng.Reporter;

public class CreateTestXml {
	private File configXML;
	private FileOutputStream output;
	private PrintStream stream;
	private String path = getClass().getClassLoader().getResource(".")
			.getPath();

	public void generateTestBatch(ArrayList<String> mobileTestCases, ArrayList<Systems> systems) throws FileNotFoundException {
		path=path.replace("/target/classes", "");
		System.out.println(path + "testng1.xml");
		configXML = new File(path + "testng1.xml");
		output = new FileOutputStream(configXML);
		stream = new PrintStream(output);
		stream.println("<?xml version=" + "\"" + "1.0" + "\"" + " encoding="
				+ "\"UTF-8\"?>");
		stream.println("<!DOCTYPE suite SYSTEM"
				+ " \"http://testng.org/testng-1.0.dtd\">");
		stream.println("<suite-name=" + "\"Regression\"" +" verbose="+"\""+"1"+"\""+" thread-count="+"\""+"10"+"\""+ " parallel=" + "\"tests\" >");
		
		if(systems.isEmpty())
			Reporter.log("Please Specify Grid Systems Configuration in Test Batch Excel sheet;");
		for(int i=0; i<systems.size();i++)
		{
			stream.println("<tests>");
			Systems system = systems.get(i);
			stream.println("<test-name=" + "\"" + system.getTestType() + "\">");
			stream.println("<parameters>");
			stream.println("<parameter name="+"\"platform\""+" value="+"\""+system.getPlatform()+"\""+" />");
			stream.println("<parameter name="+"\"browser\""+" value="+"\""+system.getBrowser()+"\""+" />");
			stream.println("<parameter name="+"\"version\""+" value="+"\""+system.getVersion()+"\""+" />");
			stream.println("</parameters>");
			stream.println("<classes>");
		
		if (!(mobileTestCases.isEmpty())) {
			
			stream.println("<class name=" + "\"" + "test.MobileWebTest" + "\"" + " >");
			stream.println("<methods>");
			for (int k = 0; k < mobileTestCases.size(); k++) {
				stream.println("<include name=" + "\""+mobileTestCases.get(k)+"\""+ " />");
			}
			stream.println("</methods>");
			stream.println("</class>");
			
		}
		stream.println("</classes>");
		stream.println("</test>");
		stream.println("</tests>");
		}
		stream.println("</suite>");
	}

}
