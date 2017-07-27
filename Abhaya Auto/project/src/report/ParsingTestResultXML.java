package report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import properties.LoadFrameworkProp;

public class ParsingTestResultXML {
	
	private String str_skipcount;	
	private String str_passcount;
	private String str_failcount;
	private String str_duration;
	private String str_totalcount;
	private String str_startdate;
	private String str_enddate;
	private List<Object> lTestName;
	private List<Object> lClassName;
	private List<Object> lTestmethodname;	
	private List<Object> lTestmethoddescription;
	private List<Object> lStatus;	
	private List<Object> lErrormessage;
	private List<Object> ltestduration;
	private List<Object> lScreenShotlink;
	private List<Object> lbrowserStatus;
	private HashMap<String, String> areaMap; 
	

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	/** 
	   Author Name                       : Vinusha Tanuku
	   Date of Preparation               : 22/05/2014
	   Date of Modified                  : --
	   Methods Called                    : --
	   Purpose of Method                 : Reads the Testng Result XML and Returns Total Count,Pass Count,FailCount,duration,StartDate,EndDate,Class Name,TestName
	   									   Test Status,ErrorMessage,ExceptionMessage,testduration.
	   Dependencies	                     : --
	   Reviewed By                       : --
	**/
	
	public ParsingTestResultXML()  throws IOException, ParserConfigurationException, SAXException {
		areaMap = new HashMap<>();
		str_skipcount="0";
		str_passcount="0";
		str_failcount="0";
		str_duration="0";
		str_totalcount="0";
		str_startdate="0";
		str_enddate="0";
		lClassName=new ArrayList<Object>();
		lTestName=new ArrayList<Object>();
		lTestmethodname=new ArrayList<Object>();	
		lTestmethoddescription=new ArrayList<Object>();
		lStatus=new ArrayList<Object>();	
		ltestduration=new ArrayList<Object>();
		lErrormessage=new ArrayList<Object>();
		lScreenShotlink=new ArrayList<Object>();
		lbrowserStatus = new ArrayList<Object>();
		LoadFrameworkProp frameProp = new LoadFrameworkProp();
		File fXmlFile = new File(frameProp.getTestNgResultsXML());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);			
		// Read and assign Total test,pass,fail skipped test cases count.
		NodeList nList = doc.getElementsByTagName("testng-results");
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;
		str_passcount=(eElement.getAttribute("passed"));
		str_failcount=(eElement.getAttribute("failed"));
		str_skipcount=(eElement.getAttribute("skipped"));	
		str_totalcount=(eElement.getAttribute("total"));
	// Suite Duration
		nList = doc.getElementsByTagName("suite");
		nNode = nList.item(0);
		eElement = (Element) nNode;
		str_duration=(eElement.getAttribute("duration-ms"));	
		str_startdate=(eElement.getAttribute("started-at"));
		str_enddate=(eElement.getAttribute("finished-at"));
	//  Areas dataArray Creation
		NodeList groups = doc.getElementsByTagName("group");
		for(int i=0;i<groups.getLength();i++)
		{
			Node groupNode = groups.item(i);
			Element groupElement=(Element)groupNode;
			String groupName=groupElement.getAttribute("name");
			NodeList methods = groupElement.getElementsByTagName("method");
			for(int j=0;j<methods.getLength();j++)
			{
				Node method = methods.item(j);
				Element methodElement=(Element)method;
				String methodName=methodElement.getAttribute("name");
				if(areaMap.isEmpty())
				{
					areaMap.put(methodName, groupName);
				}
				else if(!(areaMap.containsKey(methodName)))
				{
					areaMap.put(methodName, groupName);
				}
				
			}
		}		
	// Reading the Test Results and adding them to list 
		NodeList testNodelist =doc.getElementsByTagName("test");
		for(int k=0;k<testNodelist.getLength();k++)
		{
			Node testNode=testNodelist.item(k);
			Element eTestElement= (Element) testNode;
			String str_testname=eTestElement.getAttribute("name");
		
			
		    NodeList classNodelist= eTestElement.getElementsByTagName("class");
			for(int i=0;i< classNodelist.getLength();i++)
		    {
		        Node classNode=classNodelist.item(i);
		        Element eClassElement= (Element) classNode;
		        String str_classname=eClassElement.getAttribute("name");
		        NodeList testmethodNodeList =eClassElement.getElementsByTagName("test-method");
		        String str_errormessage = null;
		        for(int j=0;j<testmethodNodeList.getLength();j++)
		        {
			        	Node testMethodNode=testmethodNodeList.item(j);
				        Element eTestMethodElement= (Element) testMethodNode;
				        		        	
				        if((eTestMethodElement.getAttribute("name").equals("setup") && eTestMethodElement.getAttribute("status").equals("FAIL")))
		        			{
			        		 if(eTestMethodElement.getElementsByTagName("message").getLength()>0)
			        		 {
		        				str_errormessage=(eTestMethodElement.getElementsByTagName("message").item(0).getTextContent().toString());
			        		 }
			        		 else
			        		 {
			        			 str_errormessage=eTestMethodElement.getElementsByTagName("full-stacktrace").item(0).getTextContent().toString();
			        		 }
		        							      					        		
				        	}
			        	else if((!eTestMethodElement.getAttribute("name").equals("setup")&&(!eTestMethodElement.getAttribute("name").equals("teardown"))&&(!eTestMethodElement.getAttribute("name").equals("beforeTest"))&&(!eTestMethodElement.getAttribute("name").equals("beforeClass"))
			        			&&(!eTestMethodElement.getAttribute("name").equals("beforeSuite"))&&(!eTestMethodElement.getAttribute("name").equals("afterSuite"))&&(!eTestMethodElement.getAttribute("name").equals("afterTest"))&&(!eTestMethodElement.getAttribute("name").equals("afterClass"))))	
			        		{
		        		     	if(eTestMethodElement.getAttribute("status").equals("PASS"))
		        		     	{
		        		     		lTestName.add(str_testname);
		        		     		lClassName.add(str_classname);
		        		     		lTestmethodname.add(eTestMethodElement.getAttribute("name"));
		        		     		lStatus.add(eTestMethodElement.getAttribute("status"));
		        		     		ltestduration.add(eTestMethodElement.getAttribute("duration-ms"));
		        		     		if(eTestMethodElement.getAttribute("description").length()>0)
		        		     		{
		        		     			lTestmethoddescription.add(eTestMethodElement.getAttribute("description"));
		        		     		}
		        		     		else
		        		     		{
		        		     			lTestmethoddescription.add("No Description Added");
		        		     		}
		        		     		lErrormessage.add("NILL");
		        		     		lScreenShotlink.add("No Screen Shot");
		        		     	}
		        		     	else   if(eTestMethodElement.getAttribute("status").equals("SKIP"))
		        		     	{
		        		     		lTestName.add(str_testname);
		        		     		lClassName.add(str_classname);
		        		     		lTestmethodname.add(eTestMethodElement.getAttribute("name"));
		        		     		lStatus.add(eTestMethodElement.getAttribute("status"));
		        		     		ltestduration.add(eTestMethodElement.getAttribute("duration-ms"));
		        		     		if(eTestMethodElement.getAttribute("description").length()>0)
		        		     		{
		        		     			lTestmethoddescription.add(eTestMethodElement.getAttribute("description"));
		        		     		}
		        		     		else
		        		     		{
		        		     			lTestmethoddescription.add("No Description Added");
		        		     		}
		        		     		lErrormessage.add(str_errormessage);
		        		     		lScreenShotlink.add("No Screen Shot");
		        		     		
		        		     		
		        		     	}
		        		     	else   if(eTestMethodElement.getAttribute("status").equals("FAIL"))
		        		     	{
		        		     		lTestName.add(str_testname);
		        		     		lClassName.add(str_classname);
		        		     		lTestmethodname.add(eTestMethodElement.getAttribute("name"));
		        		     		lStatus.add(eTestMethodElement.getAttribute("status"));
		        		     		ltestduration.add(eTestMethodElement.getAttribute("duration-ms"));
		        		     		if(eTestMethodElement.getAttribute("description").length()>0)
		        		     		{
		        		     			lTestmethoddescription.add(eTestMethodElement.getAttribute("description"));
		        		     		}
		        		     		else
		        		     		{
		        		     			lTestmethoddescription.add("No Description Added");
		        		     		}
		        		     		if((eTestMethodElement.getElementsByTagName("message").getLength()>0))
	        		     			{
	        		     				lErrormessage.add(eTestMethodElement.getElementsByTagName("message").item(0).getTextContent().toString());
	        		     			}
		        		     		else
		        		     		{
		        		     			lErrormessage.add(eTestMethodElement.getElementsByTagName("full-stacktrace").item(0).getTextContent().toString());
		        		     		}
		        		     		if((eTestMethodElement.getElementsByTagName("line").getLength()>0))
		        		     		{
		        		     			lScreenShotlink.add(eTestMethodElement.getElementsByTagName("line").item(0).getTextContent().toString());
		        		     		}
		        		     		else
		        		     		{
		        		     			lScreenShotlink.add("No Screen Shot");
		        		     		}
		        		     		
		        		     	}
		        			}
			        }
		        }
		    }
		
		

		
	// Get Browser specific Test Status
		
		Set<Object> browsers = new HashSet<>(lTestName);
		List<Object> lstbrowsers = new ArrayList<>(browsers);		
		int ipass = 0;
		int ifail = 0;
		int iskip = 0;
		for(int y=0;y<lstbrowsers.size();y++)
		{
			 ipass = 0;
			 ifail = 0;
			 iskip = 0;
			for(int z=0;z<lTestName.size();z++)
			{ 
				if(lstbrowsers.get(y).equals(lTestName.get(z)))
				{
					if(lStatus.get(z).equals("PASS"))
					{
						ipass++;
					}
					if(lStatus.get(z).equals("FAIL"))
					{
						ifail++;
					}
					if(lStatus.get(z).equals("SKIP"))
					{
						iskip++;
					}
						
				}
				
			}
			int itotal=ipass+ifail+iskip;
			lbrowserStatus.add(lstbrowsers.get(y).toString());
			lbrowserStatus.add(itotal);
			lbrowserStatus.add(ipass);
			lbrowserStatus.add(ifail);
			lbrowserStatus.add(iskip);	
		}
		
		
	}
	
	
		
	//Returns Total no of Tests ran
	public String gettotalcount()
	{
		return str_totalcount;
	}
	// Returns Total no of Tests are skipped
	public String getskipcount()
	{
		return str_skipcount;
	}
	// Returns Total no of Tests are Passed
	public  String getpasscount()
	{
		return str_passcount;
	}
	
	// Returns a map that contains TestMethods name with their respective Area 
	public HashMap<String, String> getAreaMap() {
		return areaMap;
	}



	// Returns Total no of Tests are failed
	public String getfailcount()
	{
		return str_failcount;
	}
	// Returns Total Duration Tests ran
	public  String getduration()
	{
		return str_duration;
	}
	// Returns Start Date 
	public  String getStartdate()
	{
		return str_startdate;
	}
	// Returns End Date 
	public  String getEnddate()
	{
		return str_enddate;
	}
	// Returns TestMethod Name
	public  List<Object> gettestname()
	{ 
		return lTestName;
	}
	// Returns Class Name 
	public  List<Object> getclassname()
	{ 
		return lClassName;
	}
	// Returns TestMethod Name
	public  List<Object> gettestmethodname()
	{ 
		return lTestmethodname;
	}
	
	// Returns Status of each Test
	public  List<Object> getStatus()
	{ 
		return lStatus;
	}
	// Returns Error message of Failed Tests
	public  List<Object> geterrormessage()
	{
		return lErrormessage;
	}	
	// Returns Test run duration of each Test
	public  List<Object> gettestrundduration()
	{
		return ltestduration;
	}
	// Returns Test run duration of each Test
	public  List<Object> getscreenshotlinks()
	{
			return lScreenShotlink;
	}
	// Returns Test run duration of each Test
	public  List<Object> getbrowserstatus()
	{
		return lbrowserStatus;
	}
	// Returns Test method description of each Test
		public  List<Object> getTestMethodDesc()
		{
			return lTestmethoddescription;
		}
	

}
