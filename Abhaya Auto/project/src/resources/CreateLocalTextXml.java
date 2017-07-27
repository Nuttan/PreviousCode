package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class CreateLocalTextXml {
	private File configXML;
	private FileOutputStream output;
	private PrintStream stream;
	private String path = getClass().getClassLoader().getResource(".").getPath();
	
	public void generateLocalTestBatch(ArrayList<String> localTestCases, ArrayList<Systems> localSystems, ArrayList<String> cmsTestCases, ArrayList<Systems> cmsSystems, ArrayList<String> mobileTestCases, ArrayList<Systems> mobileSystems)
	{
		path=path.replace("/target/classes", "");
		configXML = new File(path + "mobiletestng.xml");
		try {
			output = new FileOutputStream(configXML);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		stream = new PrintStream(output);
		stream.println("<?xml version=" + "\"" + "1.0" + "\"" + " encoding="
				+ "\"UTF-8\"?>");
		stream.println("<!DOCTYPE suite SYSTEM"
				+ " \"http://testng.org/testng-1.0.dtd\">");
		stream.println("<suite name=" + "\"Regression Local\"" +" verbose="+"\""+"1"+"\""+" thread-count="+"\""+"10"+"\""+ " parallel=" + "\"false\" >");
		
		if(localSystems.isEmpty())
		{
			try {
				//throw new Exception("Please Select atleast one System Configuration from Grid Config File");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());;
			}
		}
		for(int i=0;i<localSystems.size();i++)
		{
			stream.println("<tests>");
			Systems system = localSystems.get(i);
			stream.println("<test name=" + "\"" + system.getTestType() + "\">");
			stream.println("<parameters>");
			stream.println("<parameter name="+"\"platform\""+" value="+"\""+system.getPlatform()+"\""+" />");
			stream.println("<parameter name="+"\"browser\""+" value="+"\""+system.getBrowser()+"\""+" />");
			stream.println("<parameter name="+"\"version\""+" value="+"\""+system.getVersion()+"\""+" />");
			stream.println("</parameters>");
			stream.println("<classes>");
			if(!(localTestCases.isEmpty()))
			{
				stream.println("<class name=" + "\"" + "test.UI" + "\"" + " >");
				stream.println("<methods>");
				for (int k = 0; k < localTestCases.size(); k++) {
					stream.println("<include name=" + "\""+localTestCases.get(k)+"\""+ " />");
				}
				stream.println("</methods>");
				stream.println("</class>");
			}
			stream.println("</classes>");
			stream.println("</test>");
			stream.println("</tests>");
		}
		for (int j=0;j<cmsSystems.size();j++)
		{
			stream.println("<tests>");
			Systems system = cmsSystems.get(j);
			stream.println("<test name=" + "\"" + system.getTestType() + "\">");
			stream.println("<parameters>");
			stream.println("<parameter name="+"\"platform\""+" value="+"\""+system.getPlatform()+"\""+" />");
			stream.println("<parameter name="+"\"browser\""+" value="+"\""+system.getBrowser()+"\""+" />");
			stream.println("<parameter name="+"\"version\""+" value="+"\""+system.getVersion()+"\""+" />");
			stream.println("</parameters>");
			stream.println("<classes>");
			if(!(cmsTestCases.isEmpty()))
			{
				stream.println("<class name=" + "\"" + "test.CMS" + "\"" + " >");
				stream.println("<methods>");
				for (int k = 0; k < cmsTestCases.size(); k++) {
					stream.println("<include name=" + "\""+cmsTestCases.get(k)+"\""+ " />");
				}
				stream.println("</methods>");
				stream.println("</class>");
			}
			stream.println("</classes>");
			stream.println("</test>");
			stream.println("</tests>");
		}
		for (int m=0;m<mobileSystems.size();m++)
		{
			stream.println("<tests>");
			Systems system = mobileSystems.get(m);
			stream.println("<test name=" + "\"" + system.getTestType() + "\">");
			stream.println("<parameters>");
			stream.println("<parameter name="+"\"platform\""+" value="+"\""+system.getPlatform()+"\""+" />");
			stream.println("<parameter name="+"\"browser\""+" value="+"\""+system.getBrowser()+"\""+" />");
			stream.println("<parameter name="+"\"version\""+" value="+"\""+system.getVersion()+"\""+" />");
			stream.println("</parameters>");
			stream.println("<classes>");
			if(!(mobileTestCases.isEmpty()))
			{
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
		System.out.println("TestNG file is created");
		
	}

}
